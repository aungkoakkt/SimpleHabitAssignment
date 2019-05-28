package com.me.simplehabit.delegates

import com.me.simplehabit.data.vos.TopicVO

interface TopicDelegate {

    fun onTapTopicItem(topic: TopicVO)
}
