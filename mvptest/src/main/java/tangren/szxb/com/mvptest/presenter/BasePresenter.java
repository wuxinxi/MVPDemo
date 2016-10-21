package tangren.szxb.com.mvptest.presenter;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/10/21 0021.
 */
public abstract class BasePresenter<T> {
    protected WeakReference<T> mViewRef;

    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
