package com.me.simplehabit.views.holders

import androidx.recyclerview.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<V>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected var mData: V? = null

    abstract fun bindData(data: V)
}
