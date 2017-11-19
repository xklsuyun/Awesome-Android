# 关于Activity

以下是Activity的生命周期：

![](http://upload-images.jianshu.io/upload_images/1467278-3a28d45b96ce5745.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

从另一个角度来看生命周期：

![](http://upload-images.jianshu.io/upload_images/1467278-21c8544f417e6713.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

常见的一些操作中对Activity生命周期的回调总结：

1. 当程序内存不足的时候，会将处于**onPause()和onStop()**状态的Activity杀死，回到该Activity的时候会从**onCreate()**开始执行一遍流程；
2. 当其他Activity处于当前Activity上方的时候，会调用当前Activity的**onPause()**方法，当完全不可见的时候调用**onStop()**方法，从其他Activity返回当前Activity的时候又会调用**onRestart()**方法，并从**onStart()**开始执行一遍流程；
3. 总结下来整个流程可以被理解为：**创建->可见->可编辑->不可编辑->不可见->销毁**
4. **onCreate()**方法只在Activity创建时执行一次，而**onStart()**方法在Activity的切换以及按Home键返回桌面再切回应用的过程中被多次调用。
5. **onStart()**方法中Activity可见但不在前台，不可交互，而在**onResume()**中在前台，可交互。
6. **onStart()**方法中主要还是进行初始化工作，而**onResume()**方法，根据官方的建议，可以做开启动画和独占设备的操作。
7. **onStop()**阶段Activity还没有被销毁，对象还在内存中，此时可以通过切换Activity再次回到该Activity，而**onDestroy()**阶段Acivity被销毁。
8. 事件回调相关：
	1. 当用户点击A中按钮来到B时，假设B全部遮挡住了A，将依次执行：**A.onPause()->B.onCreate()->B.onStart()->B.onResume->A.onStop()**。
	2. 此时如果点击Back键，将依次执行：**B.onPause()->A.onRestart()->A.onStart()->A.onResume()->B.onStop()->B.onDestroy()**。
	3. 接2，此时如果按下Back键，系统返回到桌面，并依次执行**A.onPause()->A.onStop()->A.onDestroy()。
	4. 接2，此时如果按下Home键（非长按），系统返回到桌面，并依次执行**A.onPause()->A.onStop()**。由此可见，Back键和Home键主要区别在于是否会执行onDestroy。
	5. 接2，此时如果长按Home键，不同手机可能弹出不同内容，Activity生命周期未发生变化。
9. 横竖屏切换时候Activity的生命周期：
	1. 不设置Activity的`android:configChanges`时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次。
	2. 设置Activity的`android:configChanges=“orientation”`时，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次。
	3. 设置Activity的`android:configChanges=“orientation|keyboardHidden”`时，切屏不会重新调用各个生命周期，只会执行onConfiguration方法。

参考:

1. [深入理解Activity的生命周期](http://www.jianshu.com/p/fb44584daee3)
2. [Android总结篇系列：Activity生命周期](https://www.cnblogs.com/lwbqqyumidi/p/3769113.html)
