
![](http://upload-images.jianshu.io/upload_images/944365-aa8416fc6d2e5ecd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

Touch事件分发中只有两个主角:ViewGroup和View。Activity的Touch事件事实上是调用它内部的ViewGroup的Touch事件，可以直接当成ViewGroup处理。

ViewGroup的相关事件有三个：dispatchTouchEvent()、onInterceptTouchEvent()和onTouchEvent()。View的相关事件只有两个：dispatchTouchEvent()、onTouchEvent()。

三个方法的用法：

1. dispatchTouchEvent()用来分派事件
    1. 其中调用了onInterceptTouchEvent()和onTouchEvent()，一般不重写该方法
2. onInterceptTouchEvent()用来拦截事件
    1. ViewGroup类中的源码实现就是{return false;}表示不拦截该事件，事件将向下传递（传递给其子View）;
    2. 若手动重写该方法，使其返回true则表示拦截，事件将终止向下传递，事件由当前ViewGroup类来处理，就是调用该类的onTouchEvent()方法
3. onTouchEvent()用来处理事件
    1. 返回true则表示该View能处理该事件，事件将终止向上传递（传递给其父View）；
    2. 返回false表示不能处理，则把事件传递给其父View的onTouchEvent()方法来处理


