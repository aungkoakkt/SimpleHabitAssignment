package com.me.simplehabit.network

import com.me.simplehabit.delegates.CategoryProgramDelegate
import com.me.simplehabit.delegates.CurrentProgramResponseDelegate
import com.me.simplehabit.delegates.TopicResponseDelegate

interface SimpleHabitDataAgent {

    fun getCurrentProgram(token: String, page: Int, delegate: CurrentProgramResponseDelegate)
    fun getTopics(token: String, page: Int, delegate: TopicResponseDelegate)
    fun getCategoriesAndPrograms(token: String, page: Int, delegate: CategoryProgramDelegate)
}
