package com.me.simplehabit.mvp.presenters.impl

import androidx.lifecycle.Observer
import com.me.simplehabit.activities.BaseActivity
import com.me.simplehabit.data.models.CategoryProgramModel
import com.me.simplehabit.data.models.CategoryProgramModelImpl
import com.me.simplehabit.data.models.CurrentProgramModel
import com.me.simplehabit.data.models.CurrentProgramModelImpl
import com.me.simplehabit.mvp.presenters.IDetailPresenter
import com.me.simplehabit.mvp.views.DetailView

/**
 *Created by Aung Ko Ko Thet on 5/29/19
 */
class DetailPresenter : BasePresenter<DetailView>(), IDetailPresenter {

    private val categoryProgramModel: CategoryProgramModel = CategoryProgramModelImpl
    private val currentProgramModel: CurrentProgramModel = CurrentProgramModelImpl

    override fun onUIReady(activity: BaseActivity, type: String, categoryId: String) {

        when(type){
            "default"->{
                categoryProgramModel.getCategoriesAndProgramById(categoryId).observe(activity, Observer {
                    mView.displayCategoryProgram(it)
                })
            }
            "current"->{
                currentProgramModel.getCurrentProgram().observe(activity, Observer {
                    mView.displayCurrentProgram(it)
                })
            }
        }
    }

    override fun onTapBackButton() {

    }
}