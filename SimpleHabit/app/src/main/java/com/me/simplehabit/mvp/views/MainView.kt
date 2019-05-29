package com.me.simplehabit.mvp.views

import com.me.simplehabit.data.vos.CategoriesProgramVO
import com.me.simplehabit.data.vos.CurrentProgramVO
import com.me.simplehabit.data.vos.TopicVO

/**
 *Created by Aung Ko Ko Thet on 5/29/19
 */
interface MainView : BaseView {

    fun displayCurrentProgram(currentProgram: CurrentProgramVO)
    fun displayCategoriesAndPrograms(categoriesPrograms: List<CategoriesProgramVO>)
    fun displayTopics(topics: List<TopicVO>)
    fun displayFailToLoadDataMessage(message: String)
    fun displayNoDataMessage(message: String)
    fun navigateToDetail(type: String, position: Int = 0, categoryId: String = "")
}