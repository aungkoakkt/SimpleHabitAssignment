package com.me.simplehabit.data.models

import android.content.Context

import com.me.simplehabit.network.NetworkDataAgent
import com.me.simplehabit.network.SimpleHabitDataAgent
import com.me.simplehabit.persistence.SimpleHabitDatabase

abstract class BaseModel {

    protected val mDataAgent: SimpleHabitDataAgent = NetworkDataAgent
    protected lateinit var mDatabase: SimpleHabitDatabase

    fun initDatabase(context: Context){
       mDatabase = SimpleHabitDatabase.getDatabase(context)
    }

}
