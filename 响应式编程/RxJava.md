# RxJava

看了许多讲解RxJava的文章，有些文章讲解的内容是基于第一个版本的，有些文章的讲解是通过比较常用的一些API和基础的概念进行讲解的。但是每次看到RxJava的类中的几十个方法的时候，总是感觉心里没底。不知道你是不是有着与我一样的感受，所以，我打算自己去专门写篇文章来从API的角度系统地梳理一下RxJava的各种方法和用法。

## 1、RxJava 基本

### 1.1 RxJava 简介

RxJava是一个在Java VM上使用可观测的序列来组成异步的、基于事件的程序的库。

虽然，在Android中，我们可以使用AsyncTask来完成异步任务操作，但是当任务的梳理比较多的时候，我们要为每个任务定义一个AsyncTask就变得非常繁琐。RxJava能帮助我们在实现异步执行的前提下保持代码的清晰。它的原理就是创建一个`Observable`来完成异步任务，组合使用各种不同的链式操作，来实现各种复杂的操作，最终将任务的执行结果发射给`Observer`进行处理。当然，RxJava不仅适用于Android，也适用于服务端等各种场景。

我们总结以下RxJava的用途：

1. 简化异步程序的流程；
2. 使用近似于Java8的流的操作进行编程：因为想要在Android中使用Java8的流编程有诸多的限制，所以我们可以使用RxJava来实现这个目的。

在使用RxJava之前，我们需要先在自己的项目中添加如下的依赖：

    compile 'io.reactivex.rxjava2:rxjava:2.2.0'
    compile 'io.reactivex.rxjava2:rxandroid:2.0.2'

这里我们使用的是RxJava2，它与RxJava的第一个版本有些许不同。在本文中，我们所有的关于RxJava的示例都将基于RxJava2. 

注：如果想了解关于Java8的流编程的内容的内容，可以参考我之前写过的文章[五分钟学习Java8的流编程](https://juejin.im/post/5b07f4536fb9a07ac90da4e5)。

### 1.2 概要

下面是RxJava的一个基本的用例，这里我们定义了一个`Observable`，然后在它内部使用`emitter`发射了一些数据和信息（其实就相当于调用了被观察对象内部的方法，通知所有的观察者）。然后，我们用`Consumer`接口的实例作为`subscribe()`方法的参数来观察发射的结果。（这里的接口的方法都已经被使用Lambda简化过，应该学着适应它。）

    Observable<Integer> observable = Observable.create(emitter -> {
    emitter.onNext(1);
    emitter.onNext(2);
    emitter.onNext(3);
    });
    observable.subscribe(System.out::println);

这样，我们就完成了一个基本的RxJava的示例。从上面的例子中，你或许没法看出`Observable`中隐藏的流的概念，看下面的例子：

    Observable.range(0, 10).map(String::valueOf).forEach(System.out::println);

这里我们先用`Observable.range()`方法产生一个序列，然后用`map`方法将该整数序列映射成一个字符序列，最后将得到的序列输出来。从上面看出，这种操作和Java8里面的Stream编程很像。但是两者之间是有区别的：

1. 所谓的“推”和“拉”的区别：Stream中是通过从流中读取数据来实现链式操作，而RxJava除了Stream中的功能之外，还可以通过“发射”数据，来实现通知的功能，即RxJava在Stream之上又多了一个观察者的功能。
2. Java8中的Stream可以通过`parall()`来实现并行，即基于分治算法将任务分解并计算得到结果之后将结果合并起来；而RxJava只能通过`subscribeOn()`方法将所有的操作切换到某个线程中去。
3. Stream只能被消费一次，但是`Observable`可以被多次进行订阅；

RxJava除了为我们提供了`Observable`之外，在新的RxJava中还提供了适用于其他场景的基础类，它们之间的功能和主要区别如下：

1. `Flowable`: 多个流，响应式流和背压
2. `Observable`: 多个流，无背压
3. `Single`: 只有一个元素或者错误的流
4. `Completable`: 没有任何元素，只有一个完成和错误信号的流
5. `Maybe`: 没有任何元素或者只有一个元素或者只有一个错误的流

除了上面的几个基础类之外，还有一个`Disposable`。当我们监听某个流的时候，就能获取到一个`Disposable`对象。它提供了两个方法，一个是`isDisposed`，可以被用来判断是否停止了观察指定的流；另一个是`dispose`方法，用来放弃观察指定的流，我们可以使用它在任意的时刻停止观察操作。

### 1.3 总结

上面我们介绍了了关于RxJava的基本的概念和使用方式，在下面的文章中我们会按照以上定义的顺序从API的角度来讲解以下RxJava各个模块的使用方法。

## 2、RxJava 的使用

### 2.1 Observable

`Observable`为我们提供了一些静态的构造方法来创建一个`Observable`对象，这里我们来梳理一下这些方法。这里我们将它的方法按照功能分成各个类别之后进行说明。

#### 2.1.1 创建操作

1.interval

下面的操作可以每个3秒的时间发送一个整数，整数从0开始：

    Observable.interval(3, TimeUnit.SECONDS).subscribe(System.out::println);

如果想要设置从指定的数字开始也是可以的，实际上`interval`提供了许多重载方法供我们是使用。下面我们连同与之功能相近的`intervalRange`方法也一同给出：

1. `public static Observable<Long> interval(long initialDelay, long period, TimeUnit unit)`
2. `public static Observable<Long> interval(long initialDelay, long period, TimeUnit unit, Scheduler scheduler)`
3. `public static Observable<Long> interval(long period, TimeUnit unit)`
4. `public static Observable<Long> interval(long period, TimeUnit unit, Scheduler scheduler)`
5. `public static Observable<Long> intervalRange(long start, long count, long initialDelay, long period, TimeUnit unit)`
6. `public static Observable<Long> intervalRange(long start, long count, long initialDelay, long period, TimeUnit unit, Scheduler scheduler)`

这里的`initialDelay`参数用来指示开始发射第一个整数的之前要停顿的时间，时间的单位与`peroid`一样，都是通过`unit`参数来指定的；`period`参数用来表示每个发射之间停顿多少时间；`unit`表示时间的单位，是`TimeUnit`类型的；`scheduler`参数指定数据发射和等待时所在的线程。

`intervalRange`方法可以用来将发射的整数序列限制在一个范围之内，这里的`start`用来表示发射的数据的起始值，`count`表示总共要发射几个数字，其他参数与上面的`interval`方法一致。

2.range

下面的操作可以产生一个从5开始的连续10个整数构成的序列：

    Observable.range(5, 10).subscribe(i -> System.out.println("1: " + i));

该方法需要传入两个参数，与之有相同功能的方法还有`rangeLong`：

1. `public static Observable<Integer> range(final int start, final int count)`
2. `public static Observable<Long> rangeLong(long start, long count)`

这里的两个参数`start`用来指定用于生成的序列的开始值，`count`用来指示要生成的序列总共包含多少个数字，上面的两个方法的主要区别在于一个是用来生成int型整数的，一个是用来生成long型整数的。

3.create

`create`方法用于从头开始创建一个`Observable`，像下面显示的那样，你需要使用`create`方法并传一个发射器作为参数，在该发射器内部调用`onNext`、`onComplete`和`onError`方法就可以将数据发送给监听者。

    Observable.create((ObservableOnSubscribe<Integer>) observableEmitter -> {
        observableEmitter.onNext(1);
        observableEmitter.onNext(2);
        observableEmitter.onComplete();
    }).subscribe(System.out::println);

#### 2.1.2 变换操作

1.map

下面的操作用于将生成的整数序列转换成一个字符串序列之后并输出：

    Observable.range(1, 5).map(String::valueOf).subscribe(System.out::println);

该方法的定义如下：

1. `public final <R> Observable<R> map(Function<? super T, ? extends R> mapper)`

这里的`mapper`函数接受两个泛型，一个表示原始的数据类型，一个表示要转换之后的数据类型，转换的逻辑写在该接口实现的方法中即可。

2.flatMap和contactMap

`flatMap`将一个发送事件的上游Observable变换为多个发送事件的Observables，然后将它们发射的事件合并后放进一个单独的Observable里。需要注意的是, flatMap并不保证事件的顺序，也就是说转换之后的Observables的顺序不必与转换之前的序列的顺序一致。比如下面的代码用于将一个序列构成的整数转换成多个单个的`Observable`，然后组成一个`OBservable`，并被订阅。下面输出的结果仍将是一个字符串数字序列，只是顺序不一定是增序的。

    Observable.range(1, 5)
            .flatMap((Function<Integer, ObservableSource<String>>) i -> Observable.just(String.valueOf(i)))
            .subscribe(System.out::println);

与`flatMap`对应的方法是`contactMap`，后者能够保证最终输出的顺序与上游发送的顺序一致。下面是这两个方法的定义：

1. `public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> mapper)`
2. `public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> mapper)`

`flatMap`的重载方法数量过多，它们在数据源方面略有不同，有的支持错误等可选参数，具体可以参考源代码。

3.flatMapIterable

`flatMapIterable`可以用来将上流的任意一个元素转换成一个`Iterable`对象，然后我们可以对其进行消费。在下面的代码中，我们先生成一个整数的序列，然后将每个整数映射成一个`Iterable<string>`类型，最后，我们对其进行订阅和消费：

    Observable.range(1, 5)
            .flatMapIterable((Function<Integer, Iterable<String>>) integer -> Collections.singletonList(String.valueOf(integer)))
            .subscribe(s -> System.out.println("flatMapIterable : " + s));

下面是该方法及其重载方法的定义：

1. `public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> mapper)`
2. `public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> mapper, BiFunction<? super T, ? super U, ? extends V> resultSelector)`

4.buffer

该方法用于将整个流进行分组。以下面的程序为例，我们会先生成一个7个整数构成的流，然后使用`buffer`之后，这些整数会被3个作为一组进行输出，所以当我们订阅了`buffer`转换之后的`Observable`之后得到的是一个列表构成的`OBservable`：

    Observable.range(1, 7).buffer(3)
            .subscribe(integers -> System.out.println(Arrays.toString(integers.toArray())));

下面是这个方法及其重载方法的定义，它的重载方法太多，这里我们只给出其中的两个，其他的可以参考RxJava的源码。这里的buffer应该理解为一个缓冲区，当缓冲区满了或者剩余的数据不够一个缓冲区的时候就将数据发射出去。

1. `public final Observable<List<T>> buffer(int count)`
2. `public final Observable<List<T>> buffer(int count, int skip)`
3. ...

5.groupBy

`groupBy`用于分组元素，它可以被用来根据指定的条件将元素分成若干组。它将得到一个`Observable<GroupedObservable<T, M>>`类型的`Observable`。如下面的程序所示，这里我们使用`concat`方法先将两个`Observable`拼接成一个`Observable`，然后对其元素进行分组。这里我们的分组依据是整数的值，这样我们将得到一个`Observable<GroupedObservable<Integer, Integer>>`类型的`Observable`。然后，我们再将得到的序列拼接成一个并进行订阅输出：

    Observable<GroupedObservable<Integer, Integer>> observable = Observable.concat(
            Observable.range(1,4), Observable.range(1,6)).groupBy(integer -> integer);
    Observable.concat(observable).subscribe(integer -> System.out.println("groupBy : " + integer));



#### repeat

该方法用来表示指定的序列要发射多少次，下面的方法会将该序列无限次进行发送：

    Observable.range(5, 10).repeat().subscribe(i -> System.out.println(i));

`repeat`方法有以下几个相似方法：

1. `public final Observable<T> repeat()`
2. `public final Observable<T> repeat(long times)`
3. `public final Observable<T> repeatUntil(BooleanSupplier stop)`
4. `public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> handler)`

第1个无参的方法会无限次地发送指定的序列（实际上内部调用了第2个方法并传入了Long.MAX_VALUE），第2个方法会将指定的序列重复发射指定的次数；第3个方法会在满足指定的要求的时候停止重复发送，否则会一直发送。

// TODO

