# MVPDemo
A simple MVPDemo

### 前言
很早以前就听说过MVP模式 ， 也在网上找过很多文章去学习 ， 但始终不得其法 ， 如果只是码代码 ， 很容易陷入其中不得其真意 。只有跳出来 ， 从全局去看 ， MVP模式比以往写的模式好得太多了 。Android的项目的结构虽然叫MVC结构， 但从我接手的几个项目来看 ， 远远没有达到如WEB般的MVC ， 我们往往把Activity即当Controller又当View，我现接手的项目就是如此 ，今天我用UML来画MVP模式 ， 豁然开朗 ， 以致第二个例子，首先用UML画好，然后才写代码，写得非常顺畅 。

### 用UML学MVP

> ~ 效果图

![mvpdemo.gif](http://upload-images.jianshu.io/upload_images/643851-2f2f3bc3f82c4372.gif?imageMogr2/auto-orient/strip)

> 基本概念

不管是MVC还是MVP ， 都是为了将数据，处理逻辑，与界面分离 ， 以达到低耦合的效果  。MVP模式，主要是面向接口编程 ， 将Model与View都抽象成一个接口，用一个Presenter来关联View与Model，Presenter做到一个绑定数据控制界面的中间者 。

MVC：M（Model）V（View）C（Controller）

MVP：M（Model）V（View）P（Presenter）

MVC模式首先提出应用是在web开发的时代，并滋生出一系列的框架，Java的`SpringMVC`，`SSH组合`，PHP的`ThinkPHP`，`YII`等等。Android MVC模式下M与C与V都有关联，目前很多项目都是这样做的。

![MVC](http://upload-images.jianshu.io/upload_images/643851-4f5919f4ba4500ba.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

目前接手的项目大多都是这个结构 ， 这种结构使得Activity引用乱传，很容易造成内存泄漏 。


MVP模式，这个模式首先是微软提出的，在微软很多技术里面都有体现，并且还推出了MVVM的模式 。MVP模式 ， 很好的将View与Model分离，使用Presenter这个中间者来组合Model与View之间的关系 ，而隔绝了View与Model直接产生关系 。

![MVP](http://upload-images.jianshu.io/upload_images/643851-02aced78f9a57102.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

Presenter作为一个中间者，持有Model与View的两个引用，将Model与View关联起来 ， 在MVP中将Model与View的操作接口化 ， 通过接口回调来完成数据的传递 。


> 分析

上图是一个书籍列表的程序，程序本身并不复杂，就是一个书籍列表。如果我们用MVP模式去写 ， 应该怎么写呢 ？首先看一下UML图

![BooksList_UML](http://upload-images.jianshu.io/upload_images/643851-ff5d5edef1d7f345.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

① 编写IModel接口 ， 定义获取数据的方法以及显示时需要的数据对象 ， 这里是一个列表，所以是一个List集合。具体实现 ， 则需要创建一个Class来实现IModel接口。

② 编写IView接口，定义View显示的方法，首先定义一个加载数据进度的方法，还可以加一个加载完成的方法来显示View，接着定义一个显示列表的方法。

③ 编写实现类 ， 首先编写IModel的实现类 。IModel的实现类 ， 其主要功能就是获取网络数据 ， 并将数据处理成对象，返回给BookLoadListener监听接口。

④ 编写Presenter ， 定一个两个接口的引用，Model在创建类的时候就创建 ， 而View则是通过创建Presenter对象进行传递 。在Presenter里面 ， 写一个`fetch()`将Model与View关联起来 。

⑤ 编写IView的实现 , Activity实现IView接口 ， 进行View的显示与控制。

### 代码分析 

> Model 

```java
/**
 * Created by Zeno on 2016/10/18.
 *
 * books model interface
 *
 * 主要用来加载数据 , 并进行数据处理
 */
public interface IBookModel {

    /*加载数据*/
    void loadDatas(BooksLoadListener listener);

    /*数据加载完将数据回调给调用者*/
    interface BooksLoadListener {
        void onComplate(List<Books.BooksEntity> Books);
        void onError(String msg);
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------

/**
 * Created by Zeno on 2016/10/18.
 *
 * books model impl
 */
public class BooksModelImplV1 implements IBookModel {

    private static final String TAG = BooksModelImplV1.class.getSimpleName();
    /*请求队列*/
    private RequestQueue requestQueue;

    private static final String URL = "http://it-ebooks-api.info/v1/search/php%20mysql";

    public BooksModelImplV1() {
        requestQueue = NoHttp.newRequestQueue();
    }

    /**
     * 加载数据
     * @param listener
     */
    @Override
    public void loadDatas(BooksLoadListener listener) {
        /*创建一个请求对象*/
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.GET);
        requestQueue.add(1,request,new BooksResponseListener(listener));
    }

    private class BooksResponseListener implements OnResponseListener<String> {

        private BooksLoadListener listener;

        public BooksResponseListener(BooksLoadListener listener) {
            this.listener = listener;
        }

        @Override
        public void onStart(int what) {

        }

        @Override
        public void onSucceed(int what, Response<String> response) {
                if (what == 1) {
                    Gson gson = new Gson();
                    Books books = gson.fromJson(response.get(), Books.class);
                    /*将请求到的数据，解析并处理，回调给Presenter*/
                    listener.onComplate(books.getBooks());
                    Log.e(TAG, "onSucceed: "+response.get() );
                }
        }

        @Override
        public void onFailed(int what, Response response) {
                listener.onError("失败");
        }

        @Override
        public void onFinish(int what) {

        }
    }
}
```

> View

```java
/**
 * Created by Zeno on 2016/10/18.
 *
 * Books view interface
 *
 * 显示
 */
public interface IBooksView {

    /*加载进度条*/
    void showLoading();

    /*显示*/
    void showBooksList(List<Books.BooksEntity> Books);

}


--------------------------------------------------------------------------------------------------------------------------------------------------------------

public class MainActivity extends BaseActivity<IBooksView,BooksPresenterV1> implements IBooksView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @InjectView(R.id.rvList)
    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initView();

        /*中间者 , 让中间者触发加载数据*/
        /*为了防止内存泄漏，做了一些优化，将Model与View的生命周期关联起来，不懂的可以下载源码看一下*/
        mPresneter.fetch();
    }

    private void initView() {
        rvList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showLoading() {
        Toast.makeText(MainActivity.this, "加载中....", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBooksList(List<Books.BooksEntity> Books) {
        Log.e(TAG, "showBooksList: "+Books.toString() );
        Toast.makeText(MainActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
        /*Model请求的数据，通过Presenter回调到View*/
        rvList.setAdapter(new BooksListAdapter(Books,this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected BooksPresenterV1 createPresenter() {

        return new BooksPresenterV1(this);
    }
}
```

> Presenter

```java
/**
 * Created by Zeno on 2016/10/18.
 */
public class BooksPresenterV1 extends BasePresenter<IBooksView>{

    /*持有View Model*/

    // View
    IBooksView mBooksView ;

    // model
    IBookModel mBookModel = new BooksModelImplV1();

    /*通过构造方法实现View*/
    public BooksPresenterV1(IBooksView mBooksView) {
        this.mBooksView = mBooksView;
    }

    /*
    * fetch model
    * */
    public void fetch() {
        if (mBookModel != null) {
            mBooksView.showLoading();
            mBookModel.loadDatas(new IBookModel.BooksLoadListener() {
                @Override
                public void onComplate(List<Books.BooksEntity> Books) {
                    /*当View背销毁，则不去显示数据*/
                    if(mBooksView != null) {
                        mBooksView.showBooksList(Books);
                    }
                }

                @Override
                public void onError(String msg) {

                }
            });
        }
    }
}
```

由上述可以看出 ， MVP，将M与V分隔开来 ， 使得代码与逻辑都比较清晰 ， 不会出现你引用了我 ， 我又引用了你 ， 最后不知道谁引用了谁 ， 导致对象占据内存，或出现对象空指针等问题 。

MVP模式 ， 虽然项目文件会比较多 ， 但是结构清晰 ， 不仅小型项目可以直接使用MVP作为项目架构 ， 大型项目也可以在模块或组件中使用MVP模式 。

### 用户登录MVP UML
因为MVP涉及的类与接口比较多 ， 所以我比较喜欢先用UML图画出关系结构 ， 再进行编码 ，这样即清晰明了 ， 又不会对彼此之间的关系弄混 ， 所以算是我目前比较喜欢的方式 。在编写完上面的例子之后 ，我接着又画了用户登录的MVP UML图。

![UserLogin UML](http://upload-images.jianshu.io/upload_images/643851-bbeabe1df5ff9925.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

当我画完这个UML图之后 ， 基本上整个流程结构也就清晰了 ， 按照上述的编写步骤很快就编写出了代码 ， 不至于一开始就写就懵逼 。


### 结语
MVP现在在Android中应用越来越广泛了 ， 所以弄清楚什么是MVP，以及怎样编写MVP ， 已经是没个Android程序员所必备知识了 ， 希望我的UML方式能让你有所收获 。

### 源码地址



