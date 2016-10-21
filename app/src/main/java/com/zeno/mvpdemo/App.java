package com.zeno.mvpdemo;

import android.app.Application;

import com.yolanda.nohttp.NoHttp;

/**
 * Created by Zeno on 2016/10/18.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this);
    }
}
