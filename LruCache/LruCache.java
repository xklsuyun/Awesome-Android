package android.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
    
    // �ڲ�ʹ��LinkedHashMap��ʵ��
    private final LinkedHashMap<K, V> map;

    // ����������ֶ��ǻ���Ĵ�С�����Ĵ�С��Ĭ��ÿ���һ��Ԫ����size��1
    // ʵ�����ڸ������ṩ��sizeOf()�������û�ʹ�ã�Ŀ�ľ��������û��Լ�ȥ����һ��Ԫ�صĴ�С
    private int size;
    private int maxSize;

    private int putCount;
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private int missCount;

    // �������Ŀռ�Ϊ��������ʵ��
    public LruCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
    }

    public void resize(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }

        synchronized (this) {
            this.maxSize = maxSize;
        }
        trimToSize(maxSize);
    }
    
    // ��ȡָ��key��Ӧ��Ԫ�أ���������ڵĻ�����craete()��������һ����
    // ������һ��Ԫ�ص�ʱ�򣬸�Ԫ�ؽ����ƶ������е���λ��
    // ����ڻ����в������ֲ��ܴ������ͷ���null
    public final V get(K key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }

        V mapValue;
        synchronized (this) {
            // ������������ز�Ϊ�յĻ��ͻὫ���ص�Ԫ���ƶ�������ͷ����������LinkedHashMap��ʵ�ֵ�
            mapValue = map.get(key);
            if (mapValue != null) {
                hitCount++;
                return mapValue;
            }
            missCount++;
        }

        
        // ����Ĵ����ǵ��̵߳ģ��ڴ�����ʱ��ָ����key�����Ѿ��������ļ�ֵ��ռ��
        V createdValue = create(key);
        if (createdValue == null) {
            return null;
        }

        // ������Ƶ�Ŀ���Ƿ�ֹ������ʱ��ָ����key�Ѿ���������valueռ�ã������ͻ�ͳ�������
        synchronized (this) {
            createCount++;
            // ����в���һ���µ����ݵ�ʱ��᷵�ظ�key֮ǰ��Ӧ��ֵ�����û�еĻ��ͷ���null
            mapValue = map.put(key, createdValue);

            if (mapValue != null) {
                // ��ͻ�ˣ���Ҫ����֮ǰ�Ĳ������
                map.put(key, mapValue);
            } else {
                size += safeSizeOf(key, createdValue);
            }
        }

        if (mapValue != null) {
            entryRemoved(false, key, createdValue, mapValue);
            return mapValue;
        } else {
            trimToSize(maxSize);
            return createdValue;
        }
    }

    public final V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }

        V previous;
        synchronized (this) {
            putCount++;
            size += safeSizeOf(key, value);
            previous = map.put(key, value);
            if (previous != null) {
                size -= safeSizeOf(key, previous);
            }
        }

        if (previous != null) {
            entryRemoved(false, key, previous, value);
        }

        trimToSize(maxSize);
        return previous;
    }

    // ���ݴ���Ĵ�С���������е�Ԫ�أ������Ҫ�Ļ����Ƴ�����β����Ԫ��
    // �����������ÿ�β�����Ƴ�Ԫ�ص�ʱ�����
    public void trimToSize(int maxSize) {
        while (true) {
            K key;
            V value;
            synchronized (this) {
                if (size < 0 || (map.isEmpty() && size != 0)) {
                    throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
                }

                if (size <= maxSize) {
                    break;
                }

                Map.Entry<K, V> toEvict = map.eldest();
                if (toEvict == null) {
                    break;
                }

                key = toEvict.getKey();
                value = toEvict.getValue();
                map.remove(key);
                size -= safeSizeOf(key, value);
                evictionCount++;
            }

            entryRemoved(true, key, value, null);
        }
    }

    public final V remove(K key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }

        V previous;
        synchronized (this) {
            previous = map.remove(key);
            if (previous != null) {
                size -= safeSizeOf(key, previous);
            }
        }

        if (previous != null) {
            entryRemoved(false, key, previous, null);
        }

        return previous;
    }

    // �������������൱�ڸ��û��ṩ�˿����Լ�ʵ�ֵ�һЩ�߼��ġ��ӿڡ�����Ϊ���Ƴ������Ҳ�����������Ϊ����ռ�����ⱻ�Ӷ������Ƴ�������
    // Ӧ�����Ƴ������Ҳ�����ʱ����û�һ���Լ�ʵ��һЩ�߼��Ļ���
    
    // ����Ԫ�ر��Ƴ���ʱ��ᱻ�ص��ķ��������̵߳ġ��������Ĭ���ǿյģ����뽻���û���ʵ�֣��൱�ڸ��û��ṩ��һ�������Լ�ʵ�ֵġ��ӿڡ�
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {}

    // �������������ķ���һ�������̣߳�������Ĭ�ϵ�ʵ�֣�Ҳ�Ǹ��û��ṩ��һ���ӿڣ�ֻ��get�����б�����
    protected V create(K key) {
        return null;
    }

    // ��sizeOf()����������������һ��������������ƿ��Ǻ��ܵ�����ΪsizeOf()�����û���ʵ�ֵ�
    private int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        if (result < 0) {
            throw new IllegalStateException("Negative size: " + key + "=" + value);
        }
        return result;
    }

    // ����Ԫ�ص���ռ�Ŀռ��С�����Խ����û��Լ���ʵ��
    protected int sizeOf(K key, V value) {
        return 1;
    }

    // �������
    public final void evictAll() {
        trimToSize(-1); // -1 will evict 0-sized elements
    }
}
