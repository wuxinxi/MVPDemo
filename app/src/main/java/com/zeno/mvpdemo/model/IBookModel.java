package com.zeno.mvpdemo.model;

import com.zeno.mvpdemo.bean.Books;

import java.util.List;

/**
 * Created by Zeno on 2016/10/18.
 *
 * books model interface
 *
 * 主要用来加载数据
 */
public interface IBookModel {

    /*加载数据*/
    void loadDatas(BooksLoadListener listener);

    /*数据加载完将数据回调给调用者*/
    interface BooksLoadListener {
        void onComplate(List<Books.BooksEntity> Books);
        void onError(String msg);
    }
}
