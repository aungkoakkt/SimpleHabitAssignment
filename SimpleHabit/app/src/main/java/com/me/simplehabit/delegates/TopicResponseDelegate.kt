package com.me.simplehabit.delegates

import com.me.simplehabit.data.vos.TopicVO

interface TopicResponseDelegate {

    fun onSuccess(topicList: List<TopicVO>)
    fun onFail(message: String)
}
