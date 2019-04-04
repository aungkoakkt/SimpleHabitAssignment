package com.me.simplehabit.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.me.simplehabit.data.vos.CategoriesProgramVO;
import com.me.simplehabit.data.vos.CurrentProgramVO;
import com.me.simplehabit.data.vos.TopicVO;
import com.me.simplehabit.persistence.dao.CategoryProgramDao;
import com.me.simplehabit.persistence.dao.CurrentProgramDao;
import com.me.simplehabit.persistence.dao.TopicDao;
import com.me.simplehabit.persistence.typeconverters.IntegerListConverter;
import com.me.simplehabit.persistence.typeconverters.ProgramListConverter;
import com.me.simplehabit.persistence.typeconverters.SessionListConverter;

import java.util.List;

@Database(entities = {CurrentProgramVO.class,TopicVO.class, CategoriesProgramVO.class},version = 3)
@TypeConverters({SessionListConverter.class, IntegerListConverter.class, ProgramListConverter.class})
public abstract class SimpleHabitDatabase extends RoomDatabase {

    private static SimpleHabitDatabase objInstance;
    private static final String DB_NAME="simple_habit.db";

    public abstract CurrentProgramDao getCurrentProgramDao();
    public abstract TopicDao getTopicDao();
    public abstract CategoryProgramDao getCategoryProgramDao();

    public static SimpleHabitDatabase getDatabase(Context context){

        if (objInstance==null){
            objInstance= Room.databaseBuilder(context,SimpleHabitDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return objInstance;
    }

    public boolean isCurrentProgramEmpty() {
        CurrentProgramVO currentProgram = getCurrentProgramDao().retrieveCurrentProgram();
        return currentProgram == null;
    }

    public boolean isTopicEmpty(){
        List<TopicVO> topicList=getTopicDao().retrieveTopics();
        return topicList.isEmpty();
    }

    public boolean isCategoiresAndProgramsEmpty(){
        List<CategoriesProgramVO> list=getCategoryProgramDao().retrieveCategoriesAndPrograms();
        return list.isEmpty();
    }
}