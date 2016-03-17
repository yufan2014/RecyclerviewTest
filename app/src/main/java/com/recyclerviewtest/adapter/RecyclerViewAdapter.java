package com.recyclerviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recyclerviewtest.R;

import java.util.List;

/**
 * Created by Administrator on 2016/3/14.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private final List<String> datas;
    private final Context context;

    public RecyclerViewAdapter(Context context, List<String> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams =  holder.mTextView.getLayoutParams();
        layoutParams.height = 100 + (position % 5) * 100;
        holder.mTextView.setLayoutParams(layoutParams);
        holder.mTextView.setText(datas.get(position));

    }

    @Override
    public int getItemCount() {
        if(datas == null)
            return 0;
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.item_txt);
        }
    }

}
