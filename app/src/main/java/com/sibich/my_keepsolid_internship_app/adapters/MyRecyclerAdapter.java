package com.sibich.my_keepsolid_internship_app.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sibich.my_keepsolid_internship_app.R;
import com.sibich.my_keepsolid_internship_app.listeners.OnUserRecyclerItemClickListener;
import com.sibich.my_keepsolid_internship_app.models.User;

import java.util.ArrayList;

/**
 * Created by Sibic_000 on 24.07.2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {



        private ArrayList<User> items;

        private Context ctx;

        private OnUserRecyclerItemClickListener listener;



        public MyRecyclerAdapter(ArrayList<User> items, Context ctx) {

            this.items = items;

            this.ctx = ctx;

        }



        public MyRecyclerAdapter(ArrayList<User> items, Context ctx, OnUserRecyclerItemClickListener listener) {

            this.items = items;

            this.ctx = ctx;

            this.listener = listener;

        }



        @Override

        public MyRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);

            final ViewHolder viewHolder = new ViewHolder(view);



            view.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {

                    if (listener != null) {

                        listener.onItemClick(view, viewHolder.getAdapterPosition());

                    }

                }

            });





            return viewHolder;

        }



        @Override

        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.userName.setText(items.get(position).getUserName());

            if(items.get(position).isOnline()) {
                holder.iconOnlineImage.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.ic_online_green));
            } else {
                holder.iconOnlineImage.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.ic_online_grey));
            }

            switch (items.get(position).getCategory()) {
                case FRIENDS:
                    holder.categoryTypeImage.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.ic_frends_black_24dp));
                    break;
                case FAMILY:
                    holder.categoryTypeImage.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.ic_family_black_24dp));
                    break;
                case JOB:
                    holder.categoryTypeImage.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.ic_job_black_24dp));
                    break;
                case OTHER:
                    holder.categoryTypeImage.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.ic_other_black_24dp));
                    break;

            }



        }


        @Override
        public int getItemCount() {
            return items.size();

        }

        public ArrayList<User> getItems() {
            return items;

        }

        public void setItems(ArrayList<User> items) {
            this.items = items;
        }


        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView userName;
            ImageView categoryTypeImage, iconOnlineImage;



            public ViewHolder(View itemView) {
                super(itemView);

                Log.e("MyRecyclerAdapter", "finding views!");

                userName = (TextView) itemView.findViewById(R.id.item_tv_user_name);

                categoryTypeImage = (ImageView) itemView.findViewById(R.id.item_category_type_icon);
                iconOnlineImage = (ImageView) itemView.findViewById(R.id.item_iv_is_online);



            }

        }



}
