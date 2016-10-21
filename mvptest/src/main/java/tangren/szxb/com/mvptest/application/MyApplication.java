package tangren.szxb.com.mvptest.application;

import android.app.Application;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

/**
 * Created by Administrator on 2016/10/21 0021.
 */
public class MyApplication extends Application {

    public static MyApplication application;

    public static MyApplication getIntence() {
        if (application == null)
            application = new MyApplication();
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.application = this;
        NoHttp.initialize(this);
        Logger.setDebug(true);
    }
}
