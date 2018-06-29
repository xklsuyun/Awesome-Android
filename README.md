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
|8|RecyclerView|[sticky-headers-recyclerview](https://github.com/timehop/sticky-headers-recyclerview)|顶部固定|
|9|RecyclerView|[RecyclerViewSnap](https://github.com/rubensousa/RecyclerViewSnap)||
|10|Adapter|[FastAdapter](https://github.com/mikepenz/FastAdapter)||
|11|RecyclerView|[RecyclerViewFastScroller](https://github.com/danoz73/RecyclerViewFastScroller)|快速滑动|
|12|RecyclerView|[RecyclerView-FastScroll](https://github.com/timusus/RecyclerView-FastScroll)||
|13||[]()||
|14||[]()||

### 2.2 开发框架

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|快速开发框架|[FastDev4Android](https://github.com/jiangqqlmj/FastDev4Android)|MVP,EventBus,沉浸式,ORM,网络请求|
|2|快速组件化方案|[ArmsComponent](https://github.com/JessYanCoding/ArmsComponent)|Arms,MVP,组件化|
|3|MVP快速化方案|[MVPArms](https://github.com/JessYanCoding/MVPArms)|Arms,MVP,常用开发模块|
|4|MVVM|[android-mvvm-architecture](https://github.com/MindorksOpenSource/android-mvvm-architecture)|MVVM示例程序|
|5|UI和轻量级开发框架|[RapidView](https://github.com/Tencent/RapidView)|UI和轻量级开发框架|
|6|MVVM|[AndroidArchitecture](https://github.com/iammert/AndroidArchitecture)|LiveData, Room Persistence, Dagger 2, Retrofit, MVVM and DataBinding|
|7|游戏框架|[libgdx](https://github.com/libgdx/libgdx)|跨平台Java游戏开发框架|
|8|谷歌框架示例|[android-architecture-components](https://github.com/googlesamples/android-architecture-components)||
|9|依赖注入|[dagger](https://github.com/square/dagger)||
|10||[]()||
|11||[]()||

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
|13|图片选择器|[ImagePicker](https://github.com/martin90s/ImagePicker)||
|14|工具库|[xUtils3](https://github.com/wyouflf/xUtils3)||
|15|Git|[gitignore](https://github.com/github/gitignore)||
|16||[]()||
|17||[]()||
|18||[]()||

### 2.4 持久化

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|磁盘缓存|[DiskLruCache](https://github.com/JakeWharton/DiskLruCache)||
|2|数据库|[wcdb](https://github.com/Tencent/wcdb)|跨平台数据库框架|
|3|数据库|[greenDAO](https://github.com/greenrobot/greenDAO)||
|4||[]()||
|5||[]()||

### 2.5 网络

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|HTTP客户端|[retrofit](https://github.com/square/retrofit)|Type-safe HTTP client for Android and Java by Square, Inc. |
|2|异步Http库|[android-async-http](https://github.com/loopj/android-async-http)||
|3|封装OKHttp|[OKHttpUtils](https://github.com/duzechao/OKHttpUtils)||
|4|封装OKHttp|[OkGo](https://github.com/jeasonlzy/okhttp-OkGo)|| 
|5|OKHttp|[OKHttp](https://github.com/square/okhttp)||
|6|封装OKHttp|[okhttputils](https://github.com/hongyangAndroid/okhttputils)||
|7||[]()||

### 2.6 图片

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|图片模糊|[StackBlur](https://github.com/kikoso/android-stackblur)||
|2|原型图片|[CircleImageView](https://github.com/hdodenhof/CircleImageView)||
|3|图片模糊|[GaussianBlur](https://github.com/jrvansuita/GaussianBlur)||
|4|图片压缩|[Luban](https://github.com/Curzibn/Luban)||
|5|图片放缩|[subsampling-scale-image-view)](https://github.com/davemorrissey/subsampling-scale-image-view)||
|6|图片选择器|[ImagePicker](https://github.com/martin90s/ImagePicker)||
|7|图片选择器|[ImagePicker](https://github.com/jeasonlzy/ImagePicker)||
|8|图片加载|[Glide](https://github.com/bumptech/glide)||
|9|圆角图片|[RoundedImageView](https://github.com/vinc3m1/RoundedImageView)||
|10|二维码扫描|[barcodescanner](https://github.com/dm77/barcodescanner)||
|11|图片编辑|[PhotoEditDemo](https://github.com/jarlen/PhotoEditDemo)||
|12|图片编辑|[PhotoEdit](https://github.com/jarlen/PhotoEdit)||
|13|图片加载|[Universal-Image-Loader](https://github.com/nostra13/Android-Universal-Image-Loader)||
|14|图片加载|[picasso](https://github.com/square/picasso)||
|15|图片加载|[fresco](https://github.com/facebook/fresco)||
|16|图片放缩|[PhotoView](https://github.com/bm-x/PhotoView)||
|17||[]()||


### 2.7 交互&切换

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|滑动返回|[BGASwipeBackLayout-Android](https://github.com/bingoogolapple/BGASwipeBackLayout-Android)||
|2|切换动画|[Transitions](https://github.com/rubensousa/Transitions)|示例程序|
|3|下拉返回|[pull-back-layout](https://github.com/oxoooo/pull-back-layout)||
|4||[]()||
|5||[]()||

### 2.8 动画&特效

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|水波纹扩散效果|[WaveView](https://github.com/hackware1993/WaveView)||
|2|点赞效果|[LikeAnimation](https://github.com/frogermcs/LikeAnimation)||
|3|动画框架|[Backboard](https://github.com/tumblr/Backboard)||
|4|控件动画|[AndroidViewAnimations](https://github.com/daimajia/AndroidViewAnimations)||
|5|用户提示|[MaterialTapTargetPrompt](https://github.com/sjwall/MaterialTapTargetPrompt)||

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
|12|进度条|[verticalseekbar](https://github.com/h6ah4i/android-verticalseekbar)||
|13|进度条|[BubbleSeekBar](https://github.com/woxingxiao/BubbleSeekBar)||
|14|Markdown预览|[RxMarkdown](https://github.com/yydcdut/RxMarkdown)||
|15|按钮|[RaiflatButton](https://github.com/rubensousa/RaiflatButton)|浮动|
|16|进度条|[PreviewSeekBar](https://github.com/rubensousa/PreviewSeekBar)|视频预览|
|17|搜索|[MaterialSearchView](https://github.com/MiguelCatalan/MaterialSearchView)||
|18|加载状态|[AVLoadingIndicatorView](https://github.com/81813780/AVLoadingIndicatorView)||
|19|Markdown库|[MaterialDesignLibrary](https://github.com/navasmdc/MaterialDesignLibrary)||
|20|Android 控件库整理|[awesome-android-ui](https://github.com/wasabeef/awesome-android-ui)||
|21|语音识别|[SpeechRecognitionView](https://github.com/zagum/SpeechRecognitionView)||
|22|课本点读|[AnchorImageView](https://github.com/jcodeing/AnchorImageView)||
|23|图片涂鸦|[Graffiti](https://github.com/1993hzw/Graffiti)||
|34|进度条|[discreteSeekBar](https://github.com/AnderWeb/discreteSeekBar)||

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|FAB|[FloatingToolbar](https://github.com/rubensousa/FloatingToolbar)|FAB转Toolbar|
|2|FAB|[FloatingActionButton](https://github.com/Clans/FloatingActionButton)||
|3||[]()||
|4||[]()||

### 布局

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|抽屉|[MaterialDrawer](https://github.com/mikepenz/MaterialDrawer)||
|2|分页|[android-vertical-slide-view](https://github.com/xmuSistone/VerticalSlideFragment)|在商品详情页，向上拖动时，可以加载下一页|
|3|ViewPager|[MaterialViewPager](https://github.com/florent37/MaterialViewPager)||
|4|上拉|[AndroidSlidingUpPanel](https://github.com/umano/AndroidSlidingUpPanel)||
|5||[]()||

### 图表

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|多种|[MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)||
|2|多种|[hellocharts](https://github.com/lecho/hellocharts-android)||
|3||[]()||
|4||[]()||
|5||[]()||

### 2.10 调试&开发

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|调试|[Android-Debug-Database](https://github.com/amitshekhariitbhu/Android-Debug-Database)||
|2|调试|[GT](https://github.com/Tencent/GT)|腾讯，APP的随身调试平台|
|3|调试|[stetho](https://github.com/facebook/stetho)||
|4|异常检测|[ACRA](https://github.com/ACRA/acra)||
|5||[]()||

### 2.11 热修复

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|热修复|[AndFix](https://github.com/alibaba/AndFix)|阿里|
|2|热修复|[tinker](https://github.com/Tencent/tinker)||
|3||[]()||
|4||[]()||
|5||[]()||

### 2.12 视频&音频&相机

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|视频播放|[NiceVieoPlayer](https://github.com/xiaoyanger0825/NiceVieoPlayer)||
|2|相机&图片|[MagicCamera](https://github.com/wuhaoyu1990/MagicCamera)|包含美颜等40余种实时滤镜相机，可拍照、录像、图片修改|
|3|相机|[CameraFragment](https://github.com/florent37/CameraFragment)||
|4|视频播放|[VideoPlayerManager](https://github.com/danylovolokh/VideoPlayerManager)||
|5|相机控件|[cameraview](https://github.com/google/cameraview)||
|6|视频录制|[RecordVideoDemo](https://github.com/szitguy/RecordVideoDemo)||
|7||[]()||
|8||[]()||

###

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|地图|[android-maps-utils](https://github.com/googlemaps/android-maps-utils)||
|2||[]()||
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
|6|底部|[BottomSheetBuilder](https://github.com/rubensousa/BottomSheetBuilder)||
|7|颜色选择|[HoloColorPicker](https://github.com/LarsWerkman/HoloColorPicker)||
|8||[]()||

### 2.14 时间&日期

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|时间API|[joda-time](https://github.com/JodaOrg/joda-time)||
|2|日历|[CalendarView](https://github.com/huanghaibin-dev/CalendarView)||
|3|周历|[Android-Week-View](https://github.com/alamkanak/Android-Week-View)|1天，3天，7天|
|4|日历|[Calendar](https://github.com/xiaojianglaile/Calendar)||
|5|日历桌面小部件|[Android-MonthCalendarWidget](https://github.com/romannurik/Android-MonthCalendarWidget)||
|6|日历|[AgendaCalendarView](https://github.com/Tibolte/AgendaCalendarView)||
|7|时钟|[GAHonorClock](https://github.com/Ajian-studio/GAHonorClock)||
|8|日期和时间选择|[datetimepicker](https://github.com/flavienlaurent/datetimepicker)||

### 2.15 资源

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|WebView 全方面的使用|[WebViewStudy](https://github.com/youlookwhat/WebViewStudy)||
|2|Android 讨论|[android-discuss](https://github.com/android-cn/android-discuss)||
|3|Android 内推|[android-jobs](https://github.com/android-cn/android-jobs)||
|4|Android 开源整理|[android-open-project](https://github.com/Trinea/android-open-project)||
|5|Android 开源整理|[android-open-project-analysis](https://github.com/android-cn/android-open-project-analysis)||
|6|Android 开源整理|[open-source-android-apps](https://github.com/pcqpcq/open-source-android-apps)||
|7|Android 开发资源|[Android-Develop-Resources](https://github.com/zmywly8866/Android-Develop-Resources)||
|8|RxJava 学习|[RxJava-Android-Samples](https://github.com/kaushikgopal/RxJava-Android-Samples)||
|9|Android 学习|[AndroidNote](https://github.com/GcsSloop/AndroidNote)||
|10|Android 学习|[CoreLink](https://github.com/lizhangqu/CoreLink)||
|11|Android 学习|[Android_Data](https://github.com/Freelander/Android_Data)||
|12|Android 示例|[android-examples](https://github.com/nisrulz/android-examples)||
|13||[]()||

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
|2|图标|[Android-Iconics](https://github.com/mikepenz/Android-Iconics)||
|3||[]()||
|4||[]()||
|5||[]()||

|编号|分类|名称和地址|备注|
|:-:|:-:|:-:|:-:|
|1|事件总线|[EventBus](https://github.com/greenrobot/EventBus)||
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
|7|天气|[MinimalistWeather](https://github.com/BaronZ88/MinimalistWeather)||
|8|编辑器|[Turbo Editor](https://github.com/vmihalachi/turbo-editor)||
|9|笔记+TODO|[rgzly-android](https://github.com/orgzly/orgzly-android)||
|10|Markdown编辑器|[MarkdownEditors](https://github.com/qinci/MarkdownEditors)||
|11|高仿微信|[wechat](https://github.com/motianhuo/wechat)||
|12|微信小视频+秒拍|[VCameraDemo](https://github.com/motianhuo/VCameraDemo)|微信小视频+秒拍,FFmpeg库封装|
|13|计算器|[DarkCalculator](https://github.com/HK-SHAO/DarkCalculator)|一款支持复数运算和解方程等功能的计算器|
|14|计算器|[ncalc](https://github.com/tranleduy2000/ncalc)||
|15|相册|[LeafPic](https://github.com/HoraApps/LeafPic)||
|16|开眼|[Eyepetizer-in-Kotlin](https://github.com/LRH1993/Eyepetizer-in-Kotlin)||
|17|笔记|[simplenote](https://github.com/Automattic/simplenote-android)||
|19|文件管理|[aFileChooser](https://github.com/iPaulPro/aFileChooser)||
|20|云阅|[CloudReader](https://github.com/youlookwhat/CloudReader)|基于网易云音乐UI，使用GankIo及豆瓣api|
|21|MaterialDesign示例|[LollipopShowcase](https://github.com/mikepenz/LollipopShowcase)|MaterialDesign示例|
|22|天气|[Weather](https://github.com/Mixiaoxiao/Weather)||
|23|音乐播放器|[Shuttle](https://github.com/timusus/Shuttle)||
|24|文件管理|[AnExplorer](https://github.com/1hakr/AnExplorer)||
|25|旅行|[Travel-Mate](https://github.com/project-travel-mate/Travel-Mate)||
|26|新闻 天气|[SuperMvp](https://github.com/liuyanggithub/SuperMvp)||
|27|MaterialDesign示例|[MaterialDesignDemo](https://github.com/Eajy/MaterialDesignDemo)||
|28|音乐播放器|[MusicX-music-player](https://github.com/RajneeshSingh007/MusicX-music-player)||
|29|全民直播|[KingTV](https://github.com/jenly1314/KingTV)||
|30|开眼|[KotlinMvp](https://github.com/git-xuhao/KotlinMvp)||
|31|开眼|[Eyepetizer](https://github.com/kaikaixue/Eyepetizer)||
|32|笔记|[Notes](https://github.com/lguipeng/Notes)||
|33|小米便签社区开源版|[Notes](https://github.com/MiCode/Notes)||
|34|MIUI文件管理器社区开源版|[FileExplorer](https://github.com/MiCode/FileExplorer)||
|35| "任阅" 网络小说阅读器|[BookReader](https://github.com/JustWayward/BookReader)||
|36|音乐播放器|[Phonograph](https://github.com/kabouzeid/Phonograph)||
|37|文件管理|[AmazeFileManager](https://github.com/TeamAmaze/AmazeFileManager)||
|38|新闻阅读|[AndroidFire](https://github.com/jaydenxiao2016/AndroidFire)||
|39|音乐播放器|[MusicDNA](https://github.com/harjot-oberai/MusicDNA)||
|40|新闻阅读|[LookLook](https://github.com/xinghongfei/LookLook)||
|41|新闻阅读|[LookLook](https://github.com/xinghongfei/LookLook)||
|42|BiliBili|[bilibili-android-client](https://github.com/HotBitmapGG/bilibili-android-client)||
|43|豆瓣|[Douya](https://github.com/DreaminginCodeZH/Douya)||
|44|新闻+图片|[Meizhi](https://github.com/drakeet/Meizhi)||
|45|新闻|[rebase](https://github.com/drakeet/rebase-android)||
|46|音乐播放器|[Music-Player](https://github.com/andremion/Music-Player)||
|47|笔记|[Omni-Notes](https://github.com/federicoiosue/Omni-Notes)||
|48|油管|[NewPipe](https://github.com/TeamNewPipe/NewPipe)||
|49|音乐播放器|[UniversalMusicPlayer](https://github.com/googlesamples/android-UniversalMusicPlayer)||
|50|LeetCode|[LeeCo](https://github.com/Nightonke/LeeCo)||
|51|动画|[AnimeTaste](https://github.com/daimajia/AnimeTaste)||
|52|音乐播放器|[Timber](https://github.com/naman14/Timber)||
|53|多媒体|[kotlin-life](https://github.com/Cuieney/kotlin-life)||
|54|事务管理|[Minimal-Todo](https://github.com/avjinder/Minimal-Todo)||
|55|文件管理|[MLManager](https://github.com/javiersantos/MLManager)||
|56|QQ|[QQ](https://github.com/HuTianQi/QQ)||
|57||[]()||
|58||[]()||
|59||[]()||

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
