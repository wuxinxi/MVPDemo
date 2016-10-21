package tangren.szxb.com.mvptest.model.model;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.CacheMode;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import tangren.szxb.com.mvptest.application.MyApplication;
import tangren.szxb.com.mvptest.httpclient.CallServer;
import tangren.szxb.com.mvptest.httpclient.HttpListener;

/**
 * Created by Administrator on 2016/10/21 0021.
 */
public class BookCompl implements BookModel {

    String url = "http://it-ebooks-api.info/v1/search/php%20mysql";

    public BookCompl() {

    }

    @Override
    public void loadDatas(BooksLoadListener listener) {
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);
        request.setCacheMode(CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);
        CallServer.getHttpclient().add(MyApplication.getIntence(), "请稍后", 1, request, callBack, true, true);
    }

    HttpListener<String> callBack = new HttpListener<String>() {

        private BooksLoadListener listener;

        @Override
        public void success(int what, Response<String> response) {

        }

        @Override
        public void fail(int what, Response<String> response) {

        }
    };
}
