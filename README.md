## RecyclerView_Gallery
使用recyclerView实现画廊滑动效果！
相对于viewpager，使用recyclerView的滑动性更流畅！两种方法任君选择。

![image](https://github.com/FollowExcellence/RecyclerView_Gallery/blob/master/GIF.gif)


#### Use
1.activity.calss
```Java
  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter(this, mPics));

        // mRecyclerView绑定scale效果
        mCardScaleHelper = new CardScaleHelper();
        mCardScaleHelper.setCurrentItemPos(1);

        mCardScaleHelper.attachToRecyclerView(mRecyclerView);
```
2.adapter
```Java

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        mCardAdapterHelper.onCreateViewHolder(parent, itemView);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        mCardAdapterHelper.onBindViewHolder(holder.itemView, position, getItemCount());
    }
```
