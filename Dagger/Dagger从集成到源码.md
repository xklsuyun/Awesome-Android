# Dagger����ָ�ϣ��Ӽ��ɵ�Դ������������ע����

> ���Ĵ����ӵ�Դ����������ѧϰ�����Dagger�ļ��ɣ���Ϊֻ������û��Դ��Ĳ��Ŀ���֮�󾭳�����һͷ��ˮ��
> ѧ����ص�������⣬����������Ӳ��ÿ��ע�����ôʹ�ã�
> ���ԣ���������һ�����ӽ���Dagger�Ļ������ɷ�ʽ��Ȼ�������ٿ�һ��ÿ��������Դ�������ʵ�ֵġ�

## ɶ������ע�룿

����ע�����ȡ�������ǳ��õ�setter��getter������Ҳ�����㲻��ÿ�ε���ĳ��ʾ���ķ���Ϊ����һ��������ֵ��
�����ʹ������ע��ֱ�ӽ�ֵע���ȥ��Ҳ����ʹ������ע��Ϊʵ���ı�����ֵ��

����ע���ڷ���˱Ƚϳ������������Spring����Dagger��һ��С�͵�����ע���ܣ��Ͼ��������ƶ��˵Ĵ���Ҫ���ǳ�������֮��ġ�

���˽�������ע��ĸ�����ǿ���Dagger�Ļ���ʹ�÷���������Դ�롣
��ʵ��Activity��Service��ʵ���߼���ͬС�죬����û�б�Ҫ����㵽�����ԣ���������ֻ��Activity�ļ��ɺ�Դ��Ϊ����

## ��Activity�ļ���Ϊ��

������Activity�ļ���Ϊ�������������Զ���һ��Application���������õ�Manifest�ļ��У�

```
  public class MyApplication extends Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().application(this).build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
  }
```

����������Զ����Applicationʵ��HasActivityInjector�ӿڣ��ýӿ���ֻ��һ��`public AndroidInjector<Activity> activityInjector()`������
����������ʾ������ʵ���˸ýӿڣ�����ע�뵽Application�е�`activityInjector`��Ϊֵ���ء�

�Ȳ���`activityInjector`�����ע�뵽Application�еģ������ȿ�һ�����������Activity�н���ע�롣

```
public abstract class CommonDaggerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
}
```

���Ƕ���һ����ΪCommonDaggerActivity�ĳ����࣬��������`onCreate`������ʹ��`AndroidInjection.inject(this);`����ע�롣
���ǽ��뿴����Դ�룬��һ�£��Ƴ�û���õĴ���֮��

```
  public static void inject(Activity activity) {
    Application application = activity.getApplication();
    if (!(application instanceof HasActivityInjector)) { throw new RuntimeException(...) }
    AndroidInjector<Activity> activityInjector = ((HasActivityInjector) application).activityInjector();
    activityInjector.inject(activity);
  }
```

���ԣ������Ͼ��ǻ�ȡ��ǰActivity��Ӧ��Application��Ȼ�󽫸�Application����ת��ΪHasActivityInjector��
��Ϊ���ǵ�Application��ʵ����HasActivityInjector�ӿڵģ����Կ��Գɹ�����ת�ͣ�����ȡ��AndroidInjector<Activity>��
�ڻ�ȡ��AndroidInjector<Activity>֮�󣬲�����ǰ��Activityע���ȥ��

��ô��������������һЩ˼·�ˡ��������м������⣺

1. Application�е�`activityInjector`����α�ע���ȥ�ģ��Լ�������α���ʼ���ģ�
2. ����Activity�е�����`AndroidInjection.inject(this)`֮������ʲô��

## ��������ʾ��

������Ѿ�ע�⵽��ʵ������`MyApplication`�л�������һ�д��룺

```
DaggerAppComponent.builder().application(this).build().inject(this)
```

���ǵ�DaggerAppComponent����AppComponent�ڱ���ʱ�Զ����ɵġ���������ڴ������֮�󣬴�`Android`�л���`Project`���鿴���ɵĴ��롣��

�����`AppComponent`�Ķ������£�

```
@Singleton
@Component(modules = {ActivityModule.class, ViewModelModule.class})
public interface AppComponent extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }
}
```

������`@Component`ע�⣬��ע���л�������`@Builder`ע�⣬�����������Ĵ��뿴���ġ�
����Զ��������������ɵ�DaggerAppComponent����ᷢ����ʵ����ʹ�õ��ǹ�����ģʽ������˵��

**ʹ��@Componentע�ⶨ����������DaggerComponent��ʹ��@Component.Builderע�ⶨ����ڲ������Ϊ��������ʹ�á������ͨ����@Component.Builderע��Ľӿ��а�����Ҫ����Լ��ķ�����**

Ȼ��������ע��`@Component`�л�ͨ��modules������`ActivityModule.class`��`ViewModelModule.class`��
�����Ƕ����ģ�飬���������������Լ���Ҫʹ�õı����ȡ�����������ǵĶ��壺

```
@Module
public abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);
}
```

�����õ��������Զ���ע�⣺

```
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScoped { }

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
```

�����`MainViewModel`�����Ƕ����ViewModel��������ʾע�뵽Activity��֮������ʲô��

```
public class MainViewModel  extends AndroidViewModel {
    private static final String TAG = "MainViewModel";

    @Inject
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void log() {
        Log.d(TAG, "log: ");
    }
}
```

���ﻹ�и�MainActivity�����������Ķ��壺

```
public class MainActivity extends CommonDaggerActivity {

    @Inject
    public MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel.log();
    }
}
```

��Ȼ����������ϣ��ͨ��ע����ΪMainActivity�ľֲ�����`mainViewModel`��ֵ������`onCreate()`�����������ķ�����

�����Ǳ��벢ִ�г���֮��һ�и�����Ԥ�ڵ�һ����MainActivity��ִ�У�MainActivity��ע���ȥ�����ɹ��������־��

## ���build֮������ʲô

��������ͨ��һЩ�򵥵ķ�����֪������Activity�е���`AndroidInjection.inject(this)`��ʵ���ϵ�����`MyApplication`��`activityInjector`��`inject(activity)`������
Ȼ�󣬽�MainActivity���ֶ�ע���ȥ�����������ǻ�����һЩ���ʣ��������ǾͶ���Щ������н��

������AS����ִ��cleanȻ����ִ��build����build����ȥ���£�������һЩ���룬���оͰ�����DaggerComponent���ƺ�һ�е�ħ���ͷ������⼸���ӵ�ʱ���

�����Ѿ�֪������Activity�е���`AndroidInjection.inject(this)`��ʵ���ϵ�����`MyApplication`��`activityInjector`��`inject(activity)`������
����Ҫ֪��`MyApplication`�е�`activityInjector`����α�������ע��ġ�

��DaggerComponent������Ϊ��������㣬��������`inject(MyApplication)`֮�����յ����ˣ�

```
MyApplication_MembersInjector.injectActivityInjector(instance, getDispatchingAndroidInjectorOfActivity());
```

��`activityInjector`���Ǵ����ﴫ�벢��ʼ���ġ����ԣ�`activityInjector`�Ĵ�������`getDispatchingAndroidInjectorOfActivity()`����ɵġ�

��Ȼ�������`getDispatchingAndroidInjectorOfActivity()`ͨ������Ĵ��봴��`activityInjector`�����䷵�أ�

```
DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(getMapOfClassOfAndProviderOfFactoryOf())
```

�������`getMapOfClassOfAndProviderOfFactoryOf()`�������ص���һ��ӳ������������õ�Activityͨ���ֵ���Provider����������

��`newDispatchingAndroidInjector()`����������ʲô�أ���ʹ�������ֵ���Ϊ������`new`һ��`DispatchingAndroidInjector`ʵ����

���ˣ�����һ�£�ʵ���ϣ������ǵ���`AndroidInjection.inject(this)`��ʱ�򣬵�����`new`����`DispatchingAndroidInjector`ʵ����`inject(Activity)`������

��ô������������һ��`DispatchingAndroidInjector`�е�`inject(Activity)`��������ʲô��

```
  public void inject(T instance) {
    // ʵ�ʵ���inject������ʱ������maybeInject����
    boolean wasInjected = maybeInject(instance);
    if (!wasInjected) {
      throw new IllegalArgumentException(errorMessageSuggestions(instance));
    }
  }

  public boolean maybeInject(T instance) {
    // �����ȴ������������ֵ���ȡ��Provider
    Provider<AndroidInjector.Factory<? extends T>> factoryProvider = injectorFactories.get(instance.getClass());
    if (factoryProvider == null) {
      return false;
    }

	// Ȼ���Provider��ȡ��AndroidInjector.Factory����
    AndroidInjector.Factory<T> factory = (AndroidInjector.Factory<T>) factoryProvider.get();
    try {
	  // ������AndroidInjector.Factory��create()��������ȡһ����ע������
      AndroidInjector<T> injector = factory.create(instance);
	  // ����"ע����"����ע��
      injector.inject(instance);
      return true;
    } catch (ClassCastException e) {
      throw new InvalidInjectorBindingException(...);
    }
  }
```

��Ӧ����Ĵ��������

���Ȼ�ȡ����������Class�������ֵ��л�ȡProvider��������ʹ��`MainActivity.class`��ȡ��`mainActivitySubcomponentBuilderProvider`��
`mainActivitySubcomponentBuilderProvider`����DaggerComponent�д����ģ����ǿ��Ե�DaggerComponent�п������߼���

����Provider��`get`����������������һ��`MainActivitySubcomponentBuilder`ʵ����`MainActivitySubcomponentBuilder`���յļ̳���`AndroidInjector.Factory<T>`����

Ȼ�����ǵ�����`MainActivitySubcomponentBuilder`��`create()`����������ִ����`seedInstance(instance)`��Ȼ��ִ����`build()`����������һ����ע��������
��󣬾���ʹ�ø�"ע����"��`inject()`������MainActivity�е��ֶθ�ֵ�ġ�

�����`seedInstance(instance)`��`build()`������ģ�巽����������`MainActivitySubcomponentBuilder`��ʵ�ֲ�����"ע����"��
��"ע������ʵ������`MainActivitySubcomponentImpl`��һ��ʵ������Ҳ����˵��ʵ������ʹ����`MainActivitySubcomponentImpl`��`inject()`�������ֵ��ע��ġ�

���ǿ������`inject()`�����Ķ��壬�����ջ�ִ�������⴮���룺

```
MainActivity_MembersInjector.injectMainViewModel(instance, getMainViewModel());
```

�����`getMainViewModel()`����Ҳ������`MainActivitySubcomponentImpl`�У�

```
    private MainViewModel getMainViewModel() {
      return new MainViewModel(DaggerAppComponent.this.application);
    }
```

���Կ��������Ķ��巽ʽ�����Ƕ���Ĺ��췽��һ�¡�

����������ǻ�ִ��MainActivity_MembersInjector�ķ������ע�룺

```
  public static void injectMainViewModel(MainActivity instance, MainViewModel mainViewModel) {
    instance.mainViewModel = mainViewModel;
  }
```

## �ܽ�

�������У�����ͨ���������ɵĴ�������ǵ�Դ���Dagger��ע���ԭ������˼򵥷���. ��Ȼ,���������ǲ�û������ȥ����Dagger�Ŀ�ܵ�ʵ��ԭ��. 
��Ϊ��Щ���ɵĴ��������ǳ����淶,����Ҳ�������Ƿ����Ĺ��̲���ô���.

�������򵥵��ܽ�����:
1. `@Component`ʹ���˹�����ģʽ,���ǿ��ԶԹ����Ĺ�����Ҫ���ֶν����Զ���;
2. ��Ҫע�����������ڱ����ڼ�����һ����Ϊ`����_MembersInjector`��ע����,����ʹ����Ϊ`inject������`�ľ�̬�������б���ע��;

�����Ѿ�������Dagger�����õ�ԭ��, ����ͨ����Щ�򵥵ķ���, �������Ѿ������Dagger��ôİ����, �Ժ������л�������ķ�������ʵ�ֵ�ԭ��. 
