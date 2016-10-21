package tangren.szxb.com.mvptest.presenter;

import tangren.szxb.com.mvptest.model.model.BookModel;
import tangren.szxb.com.mvptest.model.model.BookView;

/**
 * Created by Administrator on 2016/10/21 0021.
 */
public class BookPresenter extends BasePresenter<BookView> {
    BookView bookView;

    BookModel bookModel;
    public BookPresenter(BookView view) {
        this.bookView = view;
    }
}
