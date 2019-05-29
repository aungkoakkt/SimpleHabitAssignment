package com.me.simplehabit.mvp.views

import com.me.simplehabit.data.vos.CategoriesProgramVO
import com.me.simplehabit.data.vos.CurrentProgramVO

/**
 *Created by Aung Ko Ko Thet on 5/29/19
 */
interface DetailView : BaseView {

    fun displayCurrentProgram(currentProgram: CurrentProgramVO)
    fun displayCategoryProgram(categoryProgram: CategoriesProgramVO)
    fun displayNoDataMessage(message: String)
    fun exitFromScreen()
}