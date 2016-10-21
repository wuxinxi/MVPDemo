package com.zeno.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.zeno.mvpdemo.R;
import com.zeno.mvpdemo.adapter.BooksListAdapter;
import com.zeno.mvpdemo.bean.Books;
import com.zeno.mvpdemo.presenter.BooksPresenterV1;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

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
