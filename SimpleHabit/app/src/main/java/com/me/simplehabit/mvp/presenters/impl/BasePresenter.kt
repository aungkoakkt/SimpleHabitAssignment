package com.me.simplehabit.mvp.presenters.impl

import androidx.lifecycle.ViewModel
import com.me.simplehabit.mvp.views.BaseView

/**
 *Created by Aung Ko Ko Thet on 5/29/19
 */
abstract class BasePresenter<V : BaseView> : ViewModel() {

    protected lateinit var mView: V

    fun initPresenter(view: V) {
        mView = view
    }
}