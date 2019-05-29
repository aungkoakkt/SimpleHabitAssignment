package com.me.simplehabit.mvp.presenters

import com.me.simplehabit.delegates.CurrentProgramDelegate
import com.me.simplehabit.delegates.ProgramDelegate
import com.me.simplehabit.delegates.TopicDelegate
import com.me.simplehabit.fragments.BaseFragment

/**
 *Created by Aung Ko Ko Thet on 5/29/19
 */
interface IMainPresenter : CurrentProgramDelegate, TopicDelegate, ProgramDelegate {

    fun onUIReady(activity: BaseFragment)
    fun onRefreshPage(activity: BaseFragment)
}