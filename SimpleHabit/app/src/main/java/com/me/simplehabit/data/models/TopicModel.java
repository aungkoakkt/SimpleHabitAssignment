package com.me.simplehabit.data.models;

import com.me.simplehabit.data.vos.TopicVO;

import java.util.List;

public interface TopicModel {

    List<TopicVO> getTopics(boolean isForce,TopicModelDelegate delegate);

    interface TopicModelDelegate{
        void onTopicFetchFromNetwork(List<TopicVO> topicList);
        void onErrorTopicFetchFromNetwork(String message);
    }
}
