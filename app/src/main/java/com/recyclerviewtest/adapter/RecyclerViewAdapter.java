package com.recyclerviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recyclerviewtest.R;

import java.util.List;

/**
 * Created by Administrator on 2016/3/14.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private final List<String> datas;
    private final Context context;

    public RecyclerViewAdapter(Context context, List<String> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent,
                    false);
            return new ItemViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_footer, parent,
                    false);
            return new FootViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ItemViewHolder) {
            //holder.tv.setText(data.get(position));
            final ItemViewHolder itemViewHolder =(ItemViewHolder)holder;


            ViewGroup.LayoutParams layoutParams =  itemViewHolder.mTextView.getLayoutParams();
            layoutParams.height = 100 + (position % 5) * 100;
            itemViewHolder.mTextView.setLayoutParams(layoutParams);
            if(position < datas.size())
            itemViewHolder.mTextView.setText(datas.get(position));

//            if (onItemClickListener != null) {
//                holder.itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        int position = holder.getLayoutPosition();
//                        onItemClickListener.onItemClick(holder.itemView, position);
//                    }
//                });
//
//                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                    @Override
//                    public boolean onLongClick(View v) {
//                        int position = holder.getLayoutPosition();
//                        onItemClickListener.onItemLongClick(holder.itemView, position);
//                        return false;
//                    }
//                });
//            }
        }

    }

    @Override
    public int getItemCount() {
        if(datas == null)
            return 0;
        return datas.size() == 0 ? 0 : datas.size() + 1;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ItemViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.item_txt);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }



    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
