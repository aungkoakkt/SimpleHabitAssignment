package com.me.simplehabit.data.models;

import android.content.Context;

import com.me.simplehabit.network.NetworkDataAgent;
import com.me.simplehabit.network.SimpleHabitDataAgent;
import com.me.simplehabit.persistence.SimpleHabitDatabase;

abstract class BaseModel {

    SimpleHabitDataAgent mDataAgent;
    SimpleHabitDatabase mDatabase;

    BaseModel(Context context){
        mDataAgent= NetworkDataAgent.getInstance();
        mDatabase=SimpleHabitDatabase.getDatabase(context);
    }

}
