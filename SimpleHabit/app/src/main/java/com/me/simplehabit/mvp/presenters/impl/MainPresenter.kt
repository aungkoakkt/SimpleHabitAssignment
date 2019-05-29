package com.me.simplehabit.mvp.presenters.impl

import androidx.lifecycle.Observer
import com.me.simplehabit.data.models.*
import com.me.simplehabit.data.vos.CurrentProgramVO
import com.me.simplehabit.data.vos.ProgramVO
import com.me.simplehabit.data.vos.TopicVO
import com.me.simplehabit.fragments.BaseFragment
import com.me.simplehabit.mvp.presenters.IMainPresenter
import com.me.simplehabit.mvp.views.MainView

/**
 *Created by Aung Ko Ko Thet on 5/29/19
 */
class MainPresenter : BasePresenter<MainView>(), IMainPresenter {

    private val categoryProgramModel: CategoryProgramModel = CategoryProgramModelImpl
    private val currentProgramModel: CurrentProgramModel = CurrentProgramModelImpl
    private val topicModel: TopicModel = TopicModelImpl

    override fun onUIReady(activity: BaseFragment) {

        currentProgramModel.loadCurrentProgram(false) {

            mView.displayFailToLoadDataMessage(it)

        }.observe(activity, Observer {

            if (it!=null){
                mView.displayCurrentProgram(it)
            }else{
                mView.displayNoDataMessage("No Current Program in DB.")
            }

        })

        categoryProgramModel.loadCategoriesAndProgram(false) {

            mView.displayFailToLoadDataMessage(it)

        }.observe(activity, Observer {

            if (it.isEmpty()) {
                mView.displayNoDataMessage("No Category's Program in DB")
            } else {
                mView.displayCategoriesAndPrograms(it)
            }

        })

        topicModel.getTopics(false){

            mView.displayFailToLoadDataMessage(it)

        }.observe(activity, Observer {

            if (it.isEmpty()) {
                mView.displayNoDataMessage("No Topic in DB")
            } else {
                mView.displayTopics(it)
            }

        })
    }

    override fun onRefreshPage(activity: BaseFragment) {

        currentProgramModel.loadCurrentProgram(true) {

            mView.displayFailToLoadDataMessage(it)

        }.observe(activity, Observer {

            if (it!=null){
                mView.displayCurrentProgram(it)
            }else{
                mView.displayNoDataMessage("No Current Program in DB.")
            }

        })

        categoryProgramModel.loadCategoriesAndProgram(true) {

            mView.displayFailToLoadDataMessage(it)

        }.observe(activity, Observer {

            if (it.isEmpty()) {
                mView.displayNoDataMessage("No Category's Program in DB")
            } else {
                mView.displayCategoriesAndPrograms(it)
            }

        })

        topicModel.getTopics(true){

            mView.displayFailToLoadDataMessage(it)

        }.observe(activity, Observer {

            if (it.isEmpty()) {
                mView.displayNoDataMessage("No Topic in DB")
            } else {
                mView.displayTopics(it)
            }

        })

    }

    override fun onTapCurrentProgramItem(currentProgramVO: CurrentProgramVO) {

        mView.navigateToDetail("current")
    }


    override fun onTapProgramItem(programVO: ProgramVO, categoryId: String, position: Int) {

        mView.navigateToDetail("default",position,categoryId)
    }

    override fun onTapTopicItem(topic: TopicVO) {

    }
}