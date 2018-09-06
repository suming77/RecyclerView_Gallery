package com.suming.recyclerview_gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @创建者 mingyan.su
 * @创建时间 2018/9/5 14:13
 * @类描述 ${TODO}适配器
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private int[] mList;
    private Context mContext;

    private AdapterMeasureHelper mCardAdapterHelper = new AdapterMeasureHelper();

    public MyAdapter(Context ctx, int[] mList) {
        this.mList = mList;
        this.mContext = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        mCardAdapterHelper.onCreateViewHolder(parent, itemView);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        mCardAdapterHelper.onBindViewHolder(holder.itemView, position, getItemCount());

        holder.iv_big.setImageResource(mList[position]);
        holder.iv_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "当前条目：" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_big;

        public ViewHolder(final View view) {
            super(view);
            iv_big = (ImageView) view.findViewById(R.id.iv_big);
        }
    }
}
