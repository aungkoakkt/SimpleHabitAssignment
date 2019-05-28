package com.me.simplehabit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import com.me.simplehabit.R
import com.me.simplehabit.data.vos.TopicVO
import com.me.simplehabit.delegates.TopicDelegate
import com.me.simplehabit.views.holders.TopicViewHolder

class TopicsAdapter(private val mDelegate: TopicDelegate) : BaseRecyclerAdapter<TopicViewHolder, TopicVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): TopicViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.view_item_topic, viewGroup, false)
        return TopicViewHolder(view, mDelegate)
    }
}
