package com.me.simplehabit.network.responses

import com.google.gson.annotations.SerializedName
import com.me.simplehabit.data.vos.TopicVO

data class GetTopicResponse(

        @SerializedName("page")
        val page: String,

        @SerializedName("topics")
        val topics: List<TopicVO>

) : BaseResponse()
