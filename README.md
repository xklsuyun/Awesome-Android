# Android笔记

> 该项目用于整理Android开发和学习过程中遇到的问题、资料和资源等等，以便于快速查找相关的内容。

## 1、安卓系统

### 1.1 四大组件

Android上面的四大组件是:Activity, Service, ContentProvider和BroadcastReceiver。这里我加入了Fragment用于和Activity形成对比。

|编号|名称|
|:-:|:-:|
|1|[Activity](四大组件/Activity.md)|
|2|[Service](四大组件/Service.md)|
|3|[ContentProvider 内容提供者](四大组件/ContentProvider.md)|
|4|[BroadcastReceiver 广播接收器](四大组件/BroadcastReceiver.md)|
|5|[Fragment](四大组件/Fragment.md)|

### 1.3 源码分析

|编号|名称|
|:-:|:-:|
|1|[LruCache源码分析](源码/LruCache.md)|

## 2、三方库整理

### 2.1 RecyelerView

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|Adapter|[BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)|通用Adapter封装，大幅度降低代码量|
|2|RecyclerView|[XRecyclerView](https://github.com/XRecyclerView/XRecyclerView)|下拉刷新和加载更多|
|3|RecyclerView|[SwipeRecyclerView](https://github.com/yanzhenjie/SwipeRecyclerView)|侧滑菜单|
|4|RecyclerView|[android-advancedrecyclerview](https://github.com/h6ah4i/android-advancedrecyclerview)|融合了多种RecyclerView功能|
|5|LayoutManager|[vlayout](https://github.com/alibaba/vlayout)|阿里,LayoutManager|
|6|RecyclerView|[EasyRecyclerView](https://github.com/Jude95/EasyRecyclerView)|More,Header/Footer,EmptyView,ProgressView,ErrorView|
|7|RecyclerView|[MaterialScrollBar](https://github.com/turing-tech/MaterialScrollBar)|快速滑动|
|8||[]()||
|9||[]()||
|10||[]()||

### 2.2 开发框架

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|快速开发框架|[FastDev4Android](https://github.com/jiangqqlmj/FastDev4Android)|MVP,EventBus,沉浸式,ORM,网络请求|
|2|快速组件化方案|[ArmsComponent](https://github.com/JessYanCoding/ArmsComponent)|Arms,MVP,组件化|
|3|MVP快速化方案|[MVPArms](https://github.com/JessYanCoding/MVPArms)|Arms,MVP,常用开发模块|
|4|MVVM|[android-mvvm-architecture](https://github.com/MindorksOpenSource/android-mvvm-architecture)|MVVM示例程序|
|5|UI和轻量级开发框架|[RapidView](https://github.com/Tencent/RapidView)|UI和轻量级开发框架|
|6|MVVM|[AndroidArchitecture](https://github.com/iammert/AndroidArchitecture)|LiveData, Room Persistence, Dagger 2, Retrofit, MVVM and DataBinding|
|7||[]()||
|8||[]()||

### 2.3 工具库

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|工具库|[RxTool](https://github.com/vondear/RxTool)|Android开发人员不得不收集的工具类集合|
|2|工具库|[AndroidUtils](https://github.com/Blizzard-liu/AndroidUtils)|安卓攻城狮必备神器|
|3|Java库|[guava](https://github.com/google/guava)|Google Java 核心库|
|4|Java算法库|[TheAlgorithms-Java](https://github.com/TheAlgorithms/Java)||
|5|加密|[Encrypt](https://github.com/GcsSloop/encrypt)||
|6|Markdown解析|[flexmark-java](https://github.com/vsch/flexmark-java)||
|7|数学计算|[Calci-kernel](https://github.com/Iraka-C/Calci-kernel)|A complex calculation kernel in Java (for Calci calculator)|
|8|设计模式|[java-design-patterns](https://github.com/iluwatar/java-design-patterns)||
|9|混淆|[android-proguards](https://github.com/yongjhih/android-proguards)||
|10|截屏|[WebviewCapture](https://github.com/hsk256/WebviewCapture)|关于Webview的几种截屏方式|
|11|设备名|[AndroidDeviceNames](https://github.com/jaredrummler/AndroidDeviceNames)||
|12|汉字转拼音|[TinyPinyin](https://github.com/promeG/TinyPinyin)||
|13||[]()||

### 2.4 持久化

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|磁盘缓存|[DiskLruCache](https://github.com/JakeWharton/DiskLruCache)||
|2|数据库|[wcdb](https://github.com/Tencent/wcdb)|跨平台数据库框架|
|3||[]()||
|4||[]()||
|5||[]()||

### 2.5 网络

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|HTTP客户端|[retrofit](https://github.com/square/retrofit)|Type-safe HTTP client for Android and Java by Square, Inc. |
|2||[]()||
|3||[]()||
|4||[]()||
|5||[]()||

### 2.6 图片

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|图片模糊|[StackBlur](https://github.com/kikoso/android-stackblur)||
|2|原型图片|[CircleImageView](https://github.com/hdodenhof/CircleImageView)||
|3|图片模糊|[GaussianBlur](https://github.com/jrvansuita/GaussianBlur)||
|4|图片压缩|[Luban](https://github.com/Curzibn/Luban)||
|5||[]()||

### 2.7 交互&切换

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|Activity 滑动返回|[BGASwipeBackLayout-Android](https://github.com/bingoogolapple/BGASwipeBackLayout-Android)||
|2||[]()||
|3||[]()||
|4||[]()||
|5||[]()||

### 2.8 动画&特效

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|水波纹扩散效果|[WaveView](https://github.com/hackware1993/WaveView)||
|2||[]()||
|3||[]()||
|4||[]()||
|5||[]()||

### 2.9 控件

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|工具栏|[ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock)||
|2|欢迎页|[AppIntro](https://github.com/apl-devs/AppIntro)||
|3|进度条|[MaterialProgressBar](https://github.com/DreaminginCodeZH/MaterialProgressBar)||
|4|ViewPager指示器|[ViewPagerIndicator](https://github.com/JakeWharton/ViewPagerIndicator)||
|5|关于页|[MaterialAbout](https://github.com/jrvansuita/MaterialAbout)||
|6|Markdown预览|[MarkdownView](https://github.com/tiagohm/MarkdownView)||
|7|ViewPager指示器|[MagicIndicator](https://github.com/hackware1993/MagicIndicator)||
|8|质感控件合集|[material-components-android](https://github.com/material-components/material-components-android)||
|9|进度条|[ProgressWheel](https://github.com/Todd-Davies/ProgressWheel)||
|10|列表控件，类似ViewPager|[DiscreteScrollView](https://github.com/yarolegovich/DiscreteScrollView)||
|11|密码|[PinLockView](https://github.com/aritraroy/PinLockView)||
|12||[]()||

### 布局

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|抽屉|[MaterialDrawer](https://github.com/mikepenz/MaterialDrawer)||
|2|分页|[android-vertical-slide-view](https://github.com/xmuSistone/VerticalSlideFragment)|在商品详情页，向上拖动时，可以加载下一页|
|3||[]()||
|4||[]()||
|5||[]()||

### 图表

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|多种|[MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)||
|2||[]()||
|3||[]()||
|4||[]()||
|5||[]()||

### 2.10 调试&开发

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|调试|[Android-Debug-Database](https://github.com/amitshekhariitbhu/Android-Debug-Database)||
|2|调试|[GT](https://github.com/Tencent/GT)|腾讯，APP的随身调试平台|
|3|调试|[stetho](https://github.com/facebook/stetho)||
|4||[]()||
|5||[]()||

### 2.11 热修复

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|AndFix|[AndFix](https://github.com/alibaba/AndFix)|阿里|
|2||[]()||
|3||[]()||
|4||[]()||
|5||[]()||

### 2.12 视频&音频&相机

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|视频播放|[NiceVieoPlayer](https://github.com/xiaoyanger0825/NiceVieoPlayer)||
|2|相机&图片|[MagicCamera](https://github.com/wuhaoyu1990/MagicCamera)|包含美颜等40余种实时滤镜相机，可拍照、录像、图片修改|
|3||[]()||
|4||[]()||
|5||[]()||

### 2.13 对话框

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|底部|[BottomDialog](https://github.com/shaohui10086/BottomDialog)||
|2|底部|[bottomsheet](https://github.com/Flipboard/bottomsheet)||
|3|选择器类库|[AndroidPicker](https://github.com/gzu-liyujiang/AndroidPicker)||
|4|各种对话框|[material-dialogs](https://github.com/afollestad/material-dialogs)||
|5|底部|[BottomSheet](https://github.com/Kennyc1012/BottomSheet)||

### 2.14 时间&日期

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|时间API|[joda-time](https://github.com/JodaOrg/joda-time)||
|2|日历|[CalendarView](https://github.com/huanghaibin-dev/CalendarView)||
|3|周历|[Android-Week-View](https://github.com/alamkanak/Android-Week-View)|1天，3天，7天|
|4|日历|[Calendar](https://github.com/xiaojianglaile/Calendar)||
|5|日历桌面小部件|[Android-MonthCalendarWidget](https://github.com/romannurik/Android-MonthCalendarWidget)||
|6||[]()||
|7||[]()||
|8||[]()||

### 2.15 资源

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|WebView 全方面的使用|[WebViewStudy](https://github.com/youlookwhat/WebViewStudy)||
|2||[]()||
|3||[]()||
|4||[]()||
|5||[]()||

### 2.16 其他

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|权限|[AndPermission](https://github.com/yanzhenjie/AndPermission)||
|2|反编译|[dex2jar](https://github.com/pxb1988/dex2jar)||
|3|lambda|[retrolambda](https://github.com/orfjackal/retrolambda)|Backport of Java 8's lambda expressions to Java 7, 6 and 5|
|4|滑动越界效果|[OverScroll-Everywhere](https://github.com/Mixiaoxiao/OverScroll-Everywhere)|滑动到顶部或者底部的时候会有下拉或上拉的效果|
|5|快速滑动|[FastScroll-Everywhere](https://github.com/Mixiaoxiao/FastScroll-Everywhere)|为任意可滑动的View添加快速滑动|
|6|lambda|[gradle-retrolambda](https://github.com/evant/gradle-retrolambda)|A gradle plugin for getting java lambda support in java 6, 7 and android|
|7||[]()||
|8||[]()||

## 3、UI资源整理

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|设计|[awesome-design-cn](https://github.com/jobbole/awesome-design-cn)|设计师资源|
|2||[]()||
|3||[]()||
|4||[]()||
|5||[]()||

## 4、开源APP

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|笔记|[EverMemo](https://github.com/daimajia/EverMemo)||
|2|掘金|[MVVM-JueJin](https://github.com/fashare2015/MVVM-JueJin)||
|3|纸飞机|[PaperPlane](https://github.com/TonnyL/PaperPlane)|kotlin|
|4|诗词|[Android-poetry](https://github.com/VinsonGuo/android-poetry)|客户端+服务器|
|5|微Yue电子书|[微Yue电子书](https://github.com/LiangLuDev/WeYueReader)||
|6|简阅|[SimplifyReader](https://github.com/chentao0707/SimplifyReader)||
|7|Android 平台开源天气 App|[MinimalistWeather](https://github.com/BaronZ88/MinimalistWeather)||
|8|编辑器|[Turbo Editor](https://github.com/vmihalachi/turbo-editor)||
|9|笔记+TODO|[rgzly-android](https://github.com/orgzly/orgzly-android)||
|10|Markdown编辑器|[MarkdownEditors](https://github.com/qinci/MarkdownEditors)||
|11|高仿微信|[wechat](https://github.com/motianhuo/wechat)||
|12|微信小视频+秒拍|[VCameraDemo](https://github.com/motianhuo/VCameraDemo)|微信小视频+秒拍,FFmpeg库封装|
|13|计算器|[DarkCalculator](https://github.com/HK-SHAO/DarkCalculator)|一款支持复数运算和解方程等功能的计算器|
|14|计算器|[ncalc](https://github.com/tranleduy2000/ncalc)||
|15|相册|[LeafPic](https://github.com/HoraApps/LeafPic)||
|16|Eyepetizer|[Eyepetizer-in-Kotlin](https://github.com/LRH1993/Eyepetizer-in-Kotlin)||
|17|笔记|[simplenote](https://github.com/Automattic/simplenote-android)||
|19|文件管理|[aFileChooser](https://github.com/iPaulPro/aFileChooser)||
|20|云阅|[CloudReader](https://github.com/youlookwhat/CloudReader)|基于网易云音乐UI，使用GankIo及豆瓣api|
|21||[]()||
|22||[]()||
|23||[]()||

## 5、面试题整理

## 6、学习资料整理

|编号|书名|关键词|
|:-:|:-:|:-:|
|1|《Java编程思想》|Java|
|2|《Effect Java》|Java|
|3|《深入理解Java虚拟机》|JVM|
|4|《代码大全》||
|5|《算法4》|数据结构|
|6|《计算机网络自顶向下》|网络|
|7|《算法导论》|算法|
|8|《大话数据结构》|数据结构|
|9|《大话设计模式》|设计模式|
|10|《Head first design pattern》|设计模式|
|11|《高性能MySQL》|数据库|
|12|《Java并发编程实践》|Java|
