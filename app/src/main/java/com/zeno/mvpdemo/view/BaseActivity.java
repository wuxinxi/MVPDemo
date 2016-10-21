package com.zeno.mvpdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zeno.mvpdemo.presenter.BasePresenter;

/**
 * Created by Zeno on 2016/10/18.
 */
public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresneter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*创建Presenter*/
        mPresneter = createPresenter();

        /*内存泄漏 ， 关联View*/
        mPresneter.attachView((V)this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresneter.detachView();
    }

    /**
     * create presenter
     * @return
     */
    protected abstract T createPresenter();
}
