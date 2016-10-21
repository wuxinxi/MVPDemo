package com.zeno.mvpdemo.presenter;

import com.zeno.mvpdemo.bean.Books;
import com.zeno.mvpdemo.model.BooksModelImplV1;
import com.zeno.mvpdemo.model.IBookModel;
import com.zeno.mvpdemo.view.IBooksView;

import java.util.List;

/**
 * Created by Zeno on 2016/10/18.
 */
public class BooksPresenterV1 extends BasePresenter<IBooksView>{

    /*持有View Model*/

    // View
    IBooksView mBooksView ;

    // model
    IBookModel mBookModel = new BooksModelImplV1();

    /*通过构造方法实现View*/
    public BooksPresenterV1(IBooksView mBooksView) {
        this.mBooksView = mBooksView;
    }

    /*
    * fetch model
    * */
    public void fetch() {
        if (mBookModel != null) {
            mBooksView.showLoading();
            mBookModel.loadDatas(new IBookModel.BooksLoadListener() {
                @Override
                public void onComplate(List<Books.BooksEntity> Books) {
                    /*当View背销毁，则不去显示数据*/
                    if(mBooksView != null) {
                        mBooksView.showBooksList(Books);
                    }
                }

                @Override
                public void onError(String msg) {

                }
            });
        }
    }
}
