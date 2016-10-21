package com.zeno.mvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zeno.mvpdemo.R;
import com.zeno.mvpdemo.bean.Books;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Zeno on 2016/10/18.
 */
public class BooksListAdapter extends RecyclerView.Adapter {

    private List<Books.BooksEntity> booksEntities;
    private Context context ;

    public BooksListAdapter(List<Books.BooksEntity> booksEntities, Context context) {
        this.booksEntities = booksEntities;
        this.context = context ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Books.BooksEntity entity = booksEntities.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        Picasso.with(context).load(entity.getImage()).into(viewHolder.ivBookPic);
        viewHolder.tvBookDesc.setText(entity.getDescription());
        viewHolder.tvBookIsbn.setText(entity.getIsbn());
        viewHolder.tvBookTitle.setText(entity.getTitle());
    }

    @Override
    public int getItemCount() {
        return booksEntities.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @InjectView(R.id.iv_book_pic)
        ImageView ivBookPic;
        @InjectView(R.id.tv_book_title)
        TextView tvBookTitle;
        @InjectView(R.id.tv_book_isbn)
        TextView tvBookIsbn;
        @InjectView(R.id.tv_book_desc)
        TextView tvBookDesc;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
