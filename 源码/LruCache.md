# LruCache

## ������ʹ��ʾ��

������LruCache��һ���÷���

    public static Bitmap shotRecyclerView(RecyclerView view) {
        RecyclerView.Adapter adapter = view.getAdapter();
        Bitmap bigBitmap = null;
        if (adapter != null) {
            int size = adapter.getItemCount();
            int height = 0;
            Paint paint = new Paint();
            int iHeight = 0;
            final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

            // Use 1/8th of the available memory for this memory cache.
            final int cacheSize = maxMemory / 8;
            LruCache<String, Bitmap> bitmaCache = new LruCache<>(cacheSize);
            for (int i = 0; i < size; i++) {
                RecyclerView.ViewHolder holder = adapter.createViewHolder(view, adapter.getItemViewType(i));
                adapter.onBindViewHolder(holder, i);
                holder.itemView.measure(
                        View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.EXACTLY),
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                holder.itemView.layout(0, 0, holder.itemView.getMeasuredWidth(),
                        holder.itemView.getMeasuredHeight());
                holder.itemView.setDrawingCacheEnabled(true);
                holder.itemView.buildDrawingCache();
                Bitmap drawingCache = holder.itemView.getDrawingCache();
                if (drawingCache != null) {
                    bitmaCache.put(String.valueOf(i), drawingCache);
                }
                height += holder.itemView.getMeasuredHeight();
            }

            bigBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), height, Bitmap.Config.ARGB_8888);
            Canvas bigCanvas = new Canvas(bigBitmap);
            Drawable lBackground = view.getBackground();
            if (lBackground instanceof ColorDrawable) {
                ColorDrawable lColorDrawable = (ColorDrawable) lBackground;
                int lColor = lColorDrawable.getColor();
                bigCanvas.drawColor(lColor);
            }

            for (int i = 0; i < size; i++) {
                Bitmap bitmap = bitmaCache.get(String.valueOf(i));
                bigCanvas.drawBitmap(bitmap, 0f, iHeight, paint);
                iHeight += bitmap.getHeight();
                bitmap.recycle();
            }
        }

        return bigBitmap;
    }

������Ĵ����У����ǿ����ܽ��LruCahce�Ļ����÷����£�

���ȣ���Ҫ����һ������ռ�Ĵ�С��������������������ʱ�ڴ��8��֮1��Ϊ����ռ�Ĵ�С

    LruCache<String, Bitmap> bitmaCache = new LruCache<>(cacheSize);

Ȼ�����ǿ�������ͨ��Mapһ����������put()��get()�����򻺴��в���ʹӻ�����ȡ�����ݡ�
	
    bitmaCache.put(String.valueOf(i), drawingCache);
    Bitmap bitmap = bitmaCache.get(String.valueOf(i));

## �������Լ�ʵ��һ��LruCache��ʱ��������Ҫ����ʲô

### ���ݽṹ

��Ϊ������Ҫ�����ݽ��д洢���������ܹ�����ָ����id�����ݴӻ�����ȡ��������������Ҫʹ��Hash��

���⣬���ǻ�Ҫ�Բ����Ԫ�ؽ���������Ϊ������Ҫ�Ƴ���Щʹ��Ƶ����С��Ԫ�ء����ǿ���ʹ���������ﵽ���Ŀ�ģ�ÿ��һ�����ݱ��õ���ʱ�����ǿ��Խ������������ͷ�ڵ㡣������Ҫ�����Ԫ�ش��ڻ�������ռ��ʱ�����Ǿͽ�����ĩλ��Ԫ���Ƴ������ڻ������ڳ��ռ䡣

�ۺ������㣬������Ҫһ������Hash���ܣ����ж��й��ܵ����ݽṹ����Java�ļ����У��Ѿ�Ϊ�����ṩ��LinkedHashMap��

ʵ������Android�е�LruCacheҲ����ʹ����LinkedHashMap��ʵ�ֵģ�����չ��HashMap��������HashMap�Ļ�������Դ��Ͳ����Ķ�����������HashMap�Ļ���֮�ϣ��ֽ������ڵ�Ž���һ��˫�������С�ÿ�����Ӻ�ɾ��һ��Ԫ�ص�ʱ�򣬱�������Ԫ�ػᱻ�Ƶ��������ĩβ��Android�е�LruCahce�������������֮�Ͻ�����һ����չ��

## LruԴ�������

������ķ���������֪����ѡ��LinkedHashMap��Ϊ�ײ����ݽṹ��ԭ���������Ƿ������е�һЩ������������ʵ�ֻ�������ϸ�ڿ��ǵ÷ǳ��ܵ����ǳ�ֵ�����ǽ����ѧϰ��

��LruCache���������ֶ�size��maxSize������������˵��һ�����ǵ����ã�

    int cacheSize = 4 * 1024 * 1024; // 4MiB
    LruCache<String, Bitmap> bitmapCache = new LruCache<String, Bitmap>(cacheSize) {
        protected int sizeOf(String key, Bitmap value) {
            return value.getByteCount();
        }
    }};
	
��������ʹ��4MB�����û���ռ�Ĵ�С������֪����������ԭ����ָ���˿ռ�Ĵ�С֮�������������Ԫ��ʱ���ռ䳬����ָ���Ĵ�С�ͻὫ��Щ�����Ա��Ƴ�����Ԫ���Ƴ�������Ϊ�µ�Ԫ���ڳ��ռ䡣��ô����Ϊ���������ʱ��ȷ���ģ����Ծ��屻����Ķ�����μ����С��Ӧ�ý����û���ʵ�֡����ǣ�LruCahce��Ϊ�����ṩ��һ���ܱ����ķ�����

    protected int sizeOf(K key, V value) {
        return 1;
    }
	
������������ṩ���û��������Լ�ָ����Value�Ĵ�С�ķ�����Ĭ��ֵ��1��ʵ�ʵ�����ȡ����maxSize�������ԣ������ʼ��ʾ����ÿ����һ��Bitmap�ͻᱻ����ռ����1KB�Ŀռ䣬�����Լ�����һ�¡���

���ң�������΢�ἰһ�£���Ȼ������������û���ʵ�֣�������LruCache��Դ���У�ÿ�ζ�������������������

    private int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        if (result < 0) {
            throw new IllegalStateException("Negative size: " + key + "=" + value);
        }
        return result;
    }
	
Ϊʲô�أ���Ϊ�������¡����ԣ�������������һ����飬��ֹ����������ʵ����������Ƿǳ��ܵ��ģ��������������һ���Ƿ��Ĳ���������������Ĵ�����ô����ĵط��ͺ��Ѹ����ˡ���������Լ������API�������ò����ṩ�������Լ����Ը�д�ķ�����ʱ�򣬲������һ�������ơ�

�������Ƿ�������get��������ʵput��remove���������������࣬����ֻ����һ�������ͺ��ˣ�

    public final V get(K key) {
        if (key == null) throw new NullPointerException("key == null");

        V mapValue;
        synchronized (this) {
            mapValue = map.get(key);
            if (mapValue != null) {
                hitCount++;
                return mapValue;
            }
            missCount++;
        }

        V createdValue = create(key);
        if (createdValue == null) {
            return null;
        }

        synchronized (this) {
            createCount++;
            mapValue = map.put(key, createdValue);

            if (mapValue != null) {
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

����ʵ�ʻ�ȡֵ��ʱ��Ե�ǰ��ʵ�������˼������Ᵽ֤���̵߳İ�ȫ������map��get������ȡ�������ݵ�ʱ������create()�������ṩ��������������ǣ���Ϊ�����治����ʱ�����Ԫ�ر��Ƴ�����ЩûҪ�Ҳ�����Ԫ�ؿ���ȷʵ�������û����뵽��ϣ���У����Ե��Ҳ�����ʱ�����Ǹ��û��ṩһ�������������ǿ��Դ����������Ρ�

Ȼ�����create()������ȡ���˷�null��ֵ���ͽ�ֵ���뵽map�С�������߼�Ҳ��ͬ��������н��С���Ϊ�������Ĳ������ܹ��������Ҵ����Ƿ�ͬ���ġ��������ٴβ����ʱ��ָ����key�����Ѿ���ֵ�ˡ����Ե�����map��put��ʱ��������ز�Ϊnull���ͱ���ָ����key�Ѿ��ж�Ӧ��value�ˣ�����Ҫ���������������󣬵�mapValue��null����Ҫ����entryRemoved����������ʵҲ�ǰѳ������������εĴ������û�ϸ��ʵ�֡�

��������trimToSize()�������������ÿ��������Ƴ�Ԫ�ص�ʱ�򶼻ᱻ���ã�Ŀ���ǶԶ��н��е��������ڳ�����Ŀռ�����������size<maxSize����
	
���ǻ�Ҫע���£���������������ֽ��м������⿼���൱�ܵ��ġ�����create()������ʱ����ܺ�ʱ̫�������������Ϳ����������̻߳����еĲ���Ч����

���Ͼ��Ƕ�LruCache�ķ�����Դ���ע����[����](LruCache.java)	