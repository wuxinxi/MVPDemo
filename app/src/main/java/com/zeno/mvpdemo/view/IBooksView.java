package com.zeno.mvpdemo.view;

import com.zeno.mvpdemo.bean.Books;

import java.util.List;

/**
 * Created by Zeno on 2016/10/18.
 *
 * Books view interface
 *
 * 显示
 */
public interface IBooksView {

    /*加载进度条*/
    void showLoading();

    /*显示*/
    void showBooksList(List<Books.BooksEntity> Books);

}
