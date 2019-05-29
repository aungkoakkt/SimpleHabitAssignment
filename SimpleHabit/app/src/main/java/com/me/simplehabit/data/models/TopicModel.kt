package com.me.simplehabit.data.models

import androidx.lifecycle.LiveData
import com.me.simplehabit.data.vos.TopicVO

interface TopicModel {

    fun getTopics(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<List<TopicVO>>
}
