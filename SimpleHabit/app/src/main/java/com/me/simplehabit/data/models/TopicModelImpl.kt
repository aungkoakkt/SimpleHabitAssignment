package com.me.simplehabit.data.models

import androidx.lifecycle.LiveData
import com.me.simplehabit.data.vos.TopicVO
import com.me.simplehabit.delegates.TopicResponseDelegate
import com.me.simplehabit.utils.CommonInstances

object TopicModelImpl : BaseModel(), TopicModel {

    override fun getTopics(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<List<TopicVO>> {

        if (mDatabase.isTopicEmpty || isForce) {

            mDataAgent.getTopics(CommonInstances.TOKEN, CommonInstances.PAGE, object : TopicResponseDelegate {

                override fun onSuccess(topicList: List<TopicVO>) {
                    mDatabase.topicDao.saveTopics(topicList)
                }

                override fun onFail(message: String) {
                    networkFailure(message)
                }
            })
        }

        return mDatabase.topicDao.retrieveTopics()
    }
}
