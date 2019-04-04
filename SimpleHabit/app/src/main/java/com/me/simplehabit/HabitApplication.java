package com.me.simplehabit;

import android.app.Application;

import com.me.simplehabit.data.models.CategoryProgramModelImpl;
import com.me.simplehabit.data.models.CurrentProgramModelImpl;
import com.me.simplehabit.data.models.TopicModelImpl;

public class HabitApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CurrentProgramModelImpl.initCurrentProgramModel(getApplicationContext());
        TopicModelImpl.initTopicModel(getApplicationContext());
        CategoryProgramModelImpl.initCategoryProgramModel(getApplicationContext());
    }
}
