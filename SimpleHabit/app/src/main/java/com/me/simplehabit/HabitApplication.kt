package com.me.simplehabit

import android.app.Application

import com.me.simplehabit.data.models.CategoryProgramModelImpl
import com.me.simplehabit.data.models.CurrentProgramModelImpl
import com.me.simplehabit.data.models.TopicModelImpl

class HabitApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CurrentProgramModelImpl.initCurrentProgramModel(applicationContext)
        TopicModelImpl.initTopicModel(applicationContext)
        CategoryProgramModelImpl.initCategoryProgramModel(applicationContext)
    }
}
