package com.zeno.mvpdemo.model;

import android.util.Log;

import com.google.gson.Gson;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import com.zeno.mvpdemo.bean.Books;

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
