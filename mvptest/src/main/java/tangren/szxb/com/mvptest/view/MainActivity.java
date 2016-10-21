package tangren.szxb.com.mvptest.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import tangren.szxb.com.mvptest.R;
import tangren.szxb.com.mvptest.model.bean.Books;
import tangren.szxb.com.mvptest.model.model.BookView;
import tangren.szxb.com.mvptest.presenter.BookPresenter;

public class MainActivity extends BaseActivity<BookView, BookPresenter> implements BookView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected BookPresenter createPresenter() {
        return new BookPresenter(this);
    }

    @Override
    public void showData(List<Books.BooksBean> Books) {

    }
}
