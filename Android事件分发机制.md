


![](http://upload-images.jianshu.io/upload_images/944365-aa8416fc6d2e5ecd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

Touch事件分发中只有两个主角:ViewGroup和View。Activity的Touch事件事实上是调用它内部的ViewGroup的Touch事件，可以直接当成ViewGroup处理。

ViewGroup的相关事件有三个：dispatchTouchEvent()、onInterceptTouchEvent()和onTouchEvent()。View的相关事件只有两个：dispatchTouchEvent()、onTouchEvent()。





