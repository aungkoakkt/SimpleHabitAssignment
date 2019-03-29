package com.me.simplehabit.data.models;

import com.me.simplehabit.data.vos.TopicVO;
import com.me.simplehabit.delegates.TopicResponseDelegate;
import com.me.simplehabit.network.NetworkDataAgent;
import com.me.simplehabit.network.SimpleHabitDataAgent;
import com.me.simplehabit.utils.CommonInstances;

import java.util.ArrayList;
import java.util.List;

public class TopicModelImpl extends BaseModel implements TopicModel {

    private static TopicModelImpl objInstance=null;
    private SimpleHabitDataAgent dataAgent;
    private List<TopicVO> topicList;

    public TopicModelImpl() {
        topicList=new ArrayList<>();
        dataAgent= NetworkDataAgent.getInstance();
    }

    public static TopicModelImpl getInstance(){
        return (objInstance==null)? objInstance=new TopicModelImpl():objInstance;
    }

    @Override
    public List<TopicVO> getTopics(boolean isForce, final TopicModelDelegate delegate) {

        if (topicList.isEmpty() || isForce){
            dataAgent.getTopics(CommonInstances.TOKEN, CommonInstances.PAGE, new TopicResponseDelegate() {

                @Override
                public void onSuccess(List<TopicVO> topicList) {
                    delegate.onTopicFetchFromNetwork(topicList);
                }

                @Override
                public void onFail(String message) {
                    delegate.onErrorTopicFetchFromNetwork(message);
                }
            });
        }else{
            return topicList;
        }
        return topicList;
    }
}
