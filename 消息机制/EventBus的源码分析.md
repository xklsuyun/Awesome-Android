# Android EventBus 的源码解析

## 1、源码分析

### 1.1 获取实例

在创建EventBus实例的时候，一种方式是按照我们上面的形式，通过EventBus的静态方法`getDefault`来获取一个实例。`getDefault`本身会调用其内部的构造方法，通过传入一个默认的`EventBusBuilder`来创建EventBus。此外，我们还可以直接通过EventBus的`builder()`方法获取一个`EventBusBuilder`的实例，然后通过该构建者模式来个性化地定制自己的EventBus。即：

    // 静态的单例实例
    static volatile EventBus defaultInstance;

    // 默认的构建者
    private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();

    // 实际上使用了DCL双检锁机制，这里简化了一下
    public static EventBus getDefault() {
        if (defaultInstance == null) defaultInstance = new EventBus();
        return defaultInstance;
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    // 调用getDefault的时候，最终会调用该方法，使用DEFAULT_BUILDER创建一个实例
    EventBus(EventBusBuilder builder) {
        // ...
    }

    // 也可以使用下面的方法获取一个构建者，然后使用它来个性化定制EventBus
    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

### 1.2 注册



### 1.3 取消

### 1.4 通知

## 总结


