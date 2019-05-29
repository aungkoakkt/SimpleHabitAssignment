package com.me.simplehabit.views.holders

import android.view.View
import com.me.simplehabit.data.vos.TopicVO
import com.me.simplehabit.delegates.TopicDelegate
import kotlinx.android.synthetic.main.view_item_topic.view.*


class TopicViewHolder(itemView: View, private val mDelegate: TopicDelegate) : BaseViewHolder<TopicVO>(itemView) {

    override fun bindData(data: TopicVO) {
        itemView.tvItemTopicTitle.text = data.topicName
        itemView.tvItemTopicDescription.text = data.topicDesc

        itemView.cvItemTopic.setOnClickListener { mDelegate.onTapTopicItem(data) }
    }

}
