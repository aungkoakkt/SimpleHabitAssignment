package com.me.simplehabit.network.responses;

import com.google.gson.annotations.SerializedName;
import com.me.simplehabit.data.vos.TopicVO;

import java.util.List;

public class GetTopicResponse extends BaseResponse{

    @SerializedName("page")
    private String page;

    @SerializedName("topics")
    private List<TopicVO> topics = null;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<TopicVO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicVO> topics) {
        this.topics = topics;
    }
}
