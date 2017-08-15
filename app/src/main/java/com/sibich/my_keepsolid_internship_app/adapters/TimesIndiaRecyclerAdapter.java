package com.sibich.my_keepsolid_internship_app.adapters;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sibich.my_keepsolid_internship_app.FullArticleActivity;
import com.sibich.my_keepsolid_internship_app.R;
import com.sibich.my_keepsolid_internship_app.models.TimesIndiaItem;
import com.sibich.my_keepsolid_internship_app.utils.Consts;
import com.sibich.my_keepsolid_internship_app.listeners.OnTimesIndiaRecyclerItemClickListener;
import com.squareup.picasso.Picasso;

public class TimesIndiaRecyclerAdapter extends CursorRecyclerViewAdapter<TimesIndiaRecyclerAdapter.ViewHolder> {
    private Context ctx;
    private OnTimesIndiaRecyclerItemClickListener listener;

    public TimesIndiaRecyclerAdapter(Cursor cursor, Context ctx) {
        super(ctx, cursor);
        this.ctx = ctx;
    }

    public TimesIndiaRecyclerAdapter(Cursor cursor, Context ctx, OnTimesIndiaRecyclerItemClickListener listener) {
        super(ctx, cursor);
        this.ctx = ctx;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.times_india_list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                  //  listener.onItemClick(view, viewHolder.getAdapterPosition(), getItem(viewHolder.getAdapterPosition()).getWebUrl());
                }
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, Cursor cursor) {
        holder.title.setText(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_TITLE)));

        if (cursor.getString(cursor.getColumnIndex(Consts.DB_COL_AUTHOR)) == null) {
            holder.author.setText("No author");
        } else {
            holder.author.setText(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_AUTHOR)));
        }

        Picasso.with(ctx)
                .load(Uri.parse(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_URL_IMAGE))))
                .error(R.drawable.news_image)
                .into(holder.image);

        holder.description.setText(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_DESCRIPTION)));

        final String url = cursor.getString(cursor.getColumnIndex(Consts.DB_COL_URL));
        holder.learnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = FullArticleActivity.newIntent(ctx, url);
                ctx.startActivity(i);
            }
        });

    }

    public TimesIndiaItem getItem(int position) {
        Cursor cursor = getCursor();
        TimesIndiaItem item = new TimesIndiaItem();

        if(cursor.moveToPosition(position)) {

         //   item.setDesc(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_DESCRIPTION)));
        //    item.setNewsId(cursor.getInt(cursor.getColumnIndex(Consts.DB_COL_ID)));
        //    item.setAuthor(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_AUTHOR)));
     //       item.setWebUrl(Uri.parse(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_URL))));
        }

        return item;

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView author;
        ImageView image;
        TextView description;
        Button learnMore;


        public ViewHolder(View itemView) {
            super(itemView);

            Log.e("TaskRecyclerAdapter", "finding views!");

            title = (TextView) itemView.findViewById(R.id.tv_title);
            author = (TextView) itemView.findViewById(R.id.tv_author);
            image = (ImageView) itemView.findViewById(R.id.iv_image);
            description = (TextView) itemView.findViewById(R.id.tv_desc);
            learnMore = (Button) itemView.findViewById(R.id.btn_list_item_learn_more);
        }
    }

}
