package com.me.simplehabit.mvp.presenters

import com.me.simplehabit.activities.BaseActivity

/**
 *Created by Aung Ko Ko Thet on 5/29/19
 */
interface IDetailPresenter {

    fun onUIReady(activity: BaseActivity,type: String,categoryId: String = "")
    fun onTapBackButton()
}