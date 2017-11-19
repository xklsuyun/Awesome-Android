## 1、MVC：

1. View：对应于布局文件
2. Model：业务逻辑和实体模型
3. Controllor：对应于Activity

造成了Activity既像View又像Controller

## 2、MVP：

1. View 对应于Activity，负责View的绘制以及与用户交互
2. Model 依然是业务逻辑和实体模型
3. Presenter 负责完成View于Model间的交互

## 3、MVC和MVP的区别：

![](http://img.blog.csdn.net/20150622212916054)

MVC中是允许Model和View进行交互的，而MVP中很明显，Model与View之间的交互由Presenter完成。

MVP模式就是将P定义成一个接口，然后在每个触发的事件中调用接口的方法来处理，也就是将逻辑放进了P中，需要执行某些操作的时候调用P的方法就行了。

## 4、MVP的优缺点：

优点：

1. 降低耦合度，实现了Model和View真正的完全分离，可以修改View而不影响Modle
2. 模块职责划分明显，层次清晰
3. 隐藏数据
4. Presenter可以复用，一个Presenter可以用于多个View，而不需要更改Presenter的逻辑
5. 利于测试驱动开发。以前的Android开发是难以进行单元测试的
6. iew可以进行组件化。在MVP当中，View不依赖Model。

缺点：

1. Presenter中除了应用逻辑以外，还有大量的View->Model，Model->View的手动同步逻辑，造成Presenter比较笨重，维护起来会比较困难。
2. 由于对视图的渲染放在了Presenter中，所以视图和Presenter的交互会过于频繁。
3. 如果Presenter过多地渲染了视图，往往会使得它与特定的视图的联系过于紧密。一旦视图需要变更，那么Presenter也需要变更了。

