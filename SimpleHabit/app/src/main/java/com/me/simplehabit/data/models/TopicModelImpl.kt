package com.me.simplehabit.data.models

import com.me.simplehabit.data.vos.TopicVO
import com.me.simplehabit.delegates.TopicResponseDelegate
import com.me.simplehabit.utils.CommonInstances

object TopicModelImpl : BaseModel(), TopicModel {

    override fun getTopics(isForce: Boolean, delegate: TopicModel.TopicModelDelegate): List<TopicVO> {

        if (mDatabase.isTopicEmpty || isForce) {

            mDataAgent.getTopics(CommonInstances.TOKEN, CommonInstances.PAGE, object : TopicResponseDelegate {

                override fun onSuccess(topicList: List<TopicVO>) {
                    delegate.onTopicFetchFromNetwork(topicList)
                    mDatabase.topicDao.saveTopics(topicList)
                }

                override fun onFail(message: String) {
                    delegate.onErrorTopicFetchFromNetwork(message)
                }
            })

        } else {
            return mDatabase.topicDao.retrieveTopics()
        }
        return mDatabase.topicDao.retrieveTopics()
    }
}
