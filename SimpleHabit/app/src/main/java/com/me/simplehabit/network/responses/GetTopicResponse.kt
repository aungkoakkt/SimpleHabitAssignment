package com.me.simplehabit.network.responses

import com.google.gson.annotations.SerializedName
import com.me.simplehabit.data.vos.TopicVO

class GetTopicResponse : BaseResponse() {

    @SerializedName("page")
    var page: String? = null

    @SerializedName("topics")
    var topics: List<TopicVO>? = null
}
