package com.me.simplehabit.data.models;

import android.content.Context;

import com.me.simplehabit.data.vos.TopicVO;
import com.me.simplehabit.delegates.TopicResponseDelegate;
import com.me.simplehabit.utils.CommonInstances;

import java.util.List;

public class TopicModelImpl extends BaseModel implements TopicModel {

    private static TopicModelImpl objInstance=null;

    private TopicModelImpl(Context context) {
        super(context);
    }

    public static void initTopicModel(Context context){
        objInstance=new TopicModelImpl(context);
    }

    public static TopicModelImpl getInstance(){
        if (objInstance == null) {
            throw  new RuntimeException("TopicModel should have been initialized before using it");
        }
        return objInstance;
    }

    @Override
    public List<TopicVO> getTopics(boolean isForce, final TopicModelDelegate delegate) {

        if (mDatabase.isTopicEmpty() || isForce){

            mDataAgent.getTopics(CommonInstances.TOKEN, CommonInstances.PAGE, new TopicResponseDelegate() {

                @Override
                public void onSuccess(List<TopicVO> topicList) {
                    delegate.onTopicFetchFromNetwork(topicList);
                    mDatabase.getTopicDao().saveTopics(topicList);
                }

                @Override
                public void onFail(String message) {
                    delegate.onErrorTopicFetchFromNetwork(message);
                }
            });

        }else {
            return mDatabase.getTopicDao().retrieveTopics();
        }
        return null;
    }
}
