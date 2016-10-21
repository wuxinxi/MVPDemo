package tangren.szxb.com.mvptest.model.model;

import java.util.List;

import tangren.szxb.com.mvptest.model.bean.Books;

/**
 * Created by Administrator on 2016/10/21 0021.
 */
public interface BookModel {

    void loadDatas(BooksLoadListener listener);

    interface BooksLoadListener {
        void onComplate(List<Books>Books);

        void onError(String msg);
    }
}

