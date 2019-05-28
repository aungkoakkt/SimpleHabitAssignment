package com.me.simplehabit.data.models

import com.me.simplehabit.data.vos.TopicVO

interface TopicModel {

    fun getTopics(isForce: Boolean, delegate: TopicModelDelegate): List<TopicVO>

    interface TopicModelDelegate {
        fun onTopicFetchFromNetwork(topicList: List<TopicVO>)
        fun onErrorTopicFetchFromNetwork(message: String)
    }
}
