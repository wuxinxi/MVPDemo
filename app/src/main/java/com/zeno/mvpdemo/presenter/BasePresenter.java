package com.zeno.mvpdemo.presenter;

import java.lang.ref.WeakReference;

/**
 * Created by Zeno on 2016/10/18.
 */
public abstract class BasePresenter<T> {

    protected WeakReference<T> mViewRef ;

    /**
     * bind presenter with view
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    /**
     * unbind presenter with view
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null ;
        }
    }
}
