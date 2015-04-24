package com.android5learn.adapter;

import com.myapp.android5Learn.R;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeRecyclerAdapter extends Adapter<HomeRecyclerAdapter.MyViewHolder> {

    private String[] mName;

    public HomeRecyclerAdapter(String[] name) {
        mName = name;
    }

    @Override
    public int getItemCount() {
        return mName.length;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_home_recycle,
                        viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        viewHolder.setInfo(mName[position]);
    }

    /**
     * @className: MyViewHolder
     */
    public static class MyViewHolder extends ViewHolder {
        private TextView nameTextView;

        public MyViewHolder(View v) {
            super(v);
            nameTextView = (TextView) v.findViewById(R.id.textView);
            v.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {}
            });
        }

        public void setInfo(String name) {
            nameTextView.setText(name);
        }
    }
}
