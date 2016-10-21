package tangren.szxb.com.mvptest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import tangren.szxb.com.mvptest.presenter.BasePresenter;

/**
 * Created by Administrator on 2016/10/21 0021.
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //创建Presenter
        mPresenter = createPresenter();

        //内存泄露，关联View
        mPresenter.attachView((V) this);
    }

    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
