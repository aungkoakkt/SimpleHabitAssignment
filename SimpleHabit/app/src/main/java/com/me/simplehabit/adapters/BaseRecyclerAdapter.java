package com.me.simplehabit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.me.simplehabit.views.holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<W>,W> extends RecyclerView.Adapter<T> {

    private List<W> mData;

    public BaseRecyclerAdapter() {
        mData=new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<W> newData) {
        mData = newData;
        notifyDataSetChanged();
    }

    public void appendNewData(List<W> newData) {
        mData.addAll(newData);
        notifyDataSetChanged();
    }

    public W getItemAt(int position) {
        if (position < mData.size() - 1)
            return mData.get(position);

        return null;
    }

    public List<W> getItems() {
        if (mData == null)
            return new ArrayList<>();

        return mData;
    }

    public void removeData(W data) {
        mData.remove(data);
        notifyDataSetChanged();
    }

    public void addNewData(W data) {
        mData.add(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        mData = new ArrayList<>();
        notifyDataSetChanged();
    }
}
