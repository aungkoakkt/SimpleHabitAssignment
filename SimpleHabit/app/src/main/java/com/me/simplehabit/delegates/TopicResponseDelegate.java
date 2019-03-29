package com.me.simplehabit.delegates;

import com.me.simplehabit.data.vos.TopicVO;

import java.util.List;

public interface TopicResponseDelegate {

    void onSuccess(List<TopicVO> topicList);
    void onFail(String message);
}
