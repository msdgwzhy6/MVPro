# MVPro
**MVPro**是一款Android上的MVP框架。
**MVPro**的灵感来自
《[一种在android中实现MVP模式的新思路](https://github.com/bboyfeiyu/android-tech-frontier/tree/master/androidweekly/%E4%B8%80%E7%A7%8D%E5%9C%A8android%E4%B8%AD%E5%AE%9E%E7%8E%B0MVP%E6%A8%A1%E5%BC%8F%E7%9A%84%E6%96%B0%E6%80%9D%E8%B7%AF)》
和《[用MVP架构开发Android应用](http://kymjs.com/code/2015/11/09/01/)》两篇文章。

1. Presenter <br />
在**MVPro**中，将Activity，Fragment作为Presenter，并且提供了轻量级的ActivityPresenterImpl、FragmentPresenterImpl、FragmentActivityImpl的实现，
在项目中可以直接继承这些实现去做自己的presenter。<br />
IPresenter作为Presenter必须要实现的接口，提供的方法有：
``` java
/**
 * 获取当前presenter泛型的类型
 * @return
 */
Class<T> getViewClass();

/**
 * View初始化之前可以在此方法做一些操作
 */
void create(Bundle savedInstance);

/**
 * View初始化完毕后调用
 */
void created(Bundle savedInstance);
```
其中getViewClass在Ipresenter的实现类中已经完成了实现，我们的项目中无需考虑.<br />
create方法是在setContentView之前调用的，我们可以在该方法中实现例如：`requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);`等工作。<br />
created方法是在setContentView之后调用，可以根据业务需要做自己的逻辑。

2. View<br />
在**MVPro**中，View层必须要实现IView接口，当然**MVPro**也提供了ViewImpl一个轻量级的实现，在我们的项目中完全可以直接继承ViewImpl。
<br />IView提供的方法有：
``` java
/**
 * 根据 {@link getLayoutId}方法生成生成setContentView需要的根布局
 * @param inflater
 * @param container
 * @return
 */
View create(LayoutInflater inflater, ViewGroup container);

/**
 * 当Activity的onCreate完毕后调用
 */
void created();

/**
 * 返回当前视图需要的layout的id
 * @return
 */
int getLayoutId();

/**
 * 根据id获取view
 * @param id
 * @param <V>
 * @return
 */
<V extends View> V findViewById(int id);

/**
 * 绑定Presenter
 * @param presenter
 */
void bindPresenter(IPresenter presenter);

/**
 * {@link created}后调用，可以调用{@link org.loader.helper.EventHelper.click}
 * 等方法为控件设置点击事件，一般推荐使用{@link org.loader.helper.EventHelper.click(IPresenter presenter, View ...views)}
 * 方法并且让你的Presenter实现相应接口。
 */
void bindEvent();
```
create方法需要我们根据提供的layout设置布局，不过这个工作在ViewImpl已经完成了。<br />
created方法在create之后调用，这里我们可以根据id获取一些view的对象。<br />
getLayoutId需要返回我们关系的布局的id。<br />
findViewById提供了一个无需类型转换的查找方法，让代码更清爽,同样它在ViewImpl已经实现。<br />
bindPresenter设置绑定的Presenter，已经实现。<br />
bindEvent设置view的各种实现，可以通过EventHelper类轻松的为view设置各种常用的事件。<br />

3. Model<br />
在**MVPro**中并没有提供关于Model的代码，这是因为**MVPro**并不关心你的项目的业务层的实现，这样做的目的是为项目提供更加灵活性的实现方式。


<br /><br />关于**MVPro**的详细使用，可以参考源码中提供了test1和test2两个实例项目。

### 声明
**MVPro**是基于其他一些优秀的文章实现，并且在将来会不断完善。





