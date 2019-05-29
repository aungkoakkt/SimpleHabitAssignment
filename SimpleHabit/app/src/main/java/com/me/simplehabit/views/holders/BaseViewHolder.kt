package com.me.simplehabit.views.holders

import androidx.recyclerview.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<V>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bindData(data: V)
}
