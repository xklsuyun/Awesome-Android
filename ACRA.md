# ACRA

ACRA(Application Crash Report for Android)，一个优秀的Android异常日志收集的开源框架. 利用他可以轻松的实现Android APP 异常日志的收集。

[Github](https://github.com/ACRA/acra).

## 需要依赖：

    compile 'ch.acra:acra:4.6.1'

## 需要权限：

    <uses-permission android:name="android.permission.INTERNET"></uses-permission>           

需要创建一个Application，并使用它：

### 1.创建Application

	// @formatter:off
	@ReportsCrashes(
	        mailTo = "yuriy.kulikov.87@gmail.com",
	        applicationLogFileLines = 150,
	        customReportContent = {
	                ReportField.IS_SILENT,
	                ReportField.APP_VERSION_CODE,
	                ReportField.PHONE_MODEL,
	                ReportField.ANDROID_VERSION,
	                ReportField.CUSTOM_DATA,
	                ReportField.STACK_TRACE,
	                ReportField.SHARED_PREFERENCES })
	// @formatter:on
	public class AlarmApplication extends Application {
	
	    @Override
	    public void onCreate() {
	        // 下面的代码用于初始化ACRA
	        ACRA.init(this);
	    }
	}

### 2.在AndroidManifest.xml中使用

    <application
        android:name=".AlarmApplication"
        android:icon="@mipmap/ic_launcher_alarmclock"
        android:label="@string/simple_alarm_clock" >
        ...
    </application>

这样就可以当发生程序崩溃的时候进行报告了。

## 其他说明：

更多的设置方式：

### 1.使用toast提醒方式

	@ReportsCrashes(formKey="dGVacG0ydVHnaNHjRjVTUTEtb3FPWGc6MQ",
	    mode = ReportingInteractionMode.TOAST,
	    forceCloseDialogAfterToast = false, // optional, default false
	    resToastText = R.string.crash_toast_text)
	public class MyApplication extends Application {
	.......

### 2.对话框提醒方式

	@ReportsCrashes(formKey="dGVacG0ydVHnaNHjRjVTUTEtb3FPWGc6MQ",
	    mode = ReportingInteractionMode.DIALOG,
	    resToastText = R.string.crash_toast_text, // 可选,在数据收集完毕之前弹出一个土司
	    resDialogText = R.string.crash_dialog_text,// 对话框内容
	    resDialogIcon = android.R.drawable.ic_dialog_info, // 可选, 对话框的图片
	    resDialogTitle = R.string.crash_dialog_title, // 可选,对话框的标题
	    // 可选,提示用户输入异常产生的原因等
	    resDialogCommentPrompt = R.string.crash_dialog_comment_prompt,
	    /* optional. When defined, adds a user email text entry with this text resource as label. The email address will be populated from SharedPreferences and will be provided as an ACRA field if configured */
	    resDialogEmailPrompt = R.string.crash_user_email_label,                 
	    resDialogOkToast = R.string.crash_dialog_ok_toast // 可选,提交后弹出土司
	)
	public class MyApplication extends Application {
	......

### 3.状态栏提醒方式

	@ReportsCrashes(
	    resNotifTickerText = R.string.crash_notif_ticker_text,
	    resNotifTitle = R.string.crash_notif_title,
	    resNotifText = R.string.crash_notif_text,
	    resNotifIcon = android.R.drawable.stat_notify_error // optional. default is a warning sign
	)
	public class MyApplication extends Application {
	......

### 4.提交到服务器

	@ReportsCrashes(formKey = "", // will not be used
	    formUri = "http://yourserver.com/yourscript",
	    formUriBasicAuthLogin = "yourlogin", // 可选
	    formUriBasicAuthPassword = "y0uRpa$$w0rd", // 可选
	    mode = ReportingInteractionMode.TOAST,
	    resToastText = R.string.crash_toast_text)
	public class MyApplication extends Application {
	......

### 5.提交到邮箱

	@ReportsCrashes(formKey = "", // will not be used
	    mailTo = "reports@yourdomain.com",
	    mode = ReportingInteractionMode.TOAST,
	    resToastText = R.string.crash_toast_text)
	public class MyApplication extends Application {
	......

在初始化完成之后要完成的操作：

	ACRA.getErrorReporter().setExceptionHandlerInitializer(new ExceptionHandlerInitializer() {
	    @Override
	    public void initializeExceptionHandler(ErrorReporter reporter) {
	        reporter.putCustomData("STARTUP_LOG", 内容);
	    }
	});
显然这里使用了键值对的形式进行存储，可以使用`getCustomData(“myVariable”)`或者 `removeCustomData(“myVariable”)`来获得或者移除某个信息

如果只想选择需要的异常日志,这样配置:

    @ReportsCrashes(customReportContent = { 需要的字段 }) 

比如:

	customReportContent = { 
		APP_VERSION, 
		ANDROID_VERSION, 
		PHONE_MODEL, 
		CUSTOM_DATA, 
		STACK_TRACE, 
		LOGCAT 
	}

如果要获取手机信息的话，不要忘记使用权限：

    uses-permissionandroid:name=android.permission.READ_PHONE_STATE
