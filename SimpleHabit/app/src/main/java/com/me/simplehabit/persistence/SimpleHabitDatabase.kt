package com.me.simplehabit.persistence

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context

import com.me.simplehabit.data.vos.CategoriesProgramVO
import com.me.simplehabit.data.vos.CurrentProgramVO
import com.me.simplehabit.data.vos.TopicVO
import com.me.simplehabit.persistence.dao.CategoryProgramDao
import com.me.simplehabit.persistence.dao.CurrentProgramDao
import com.me.simplehabit.persistence.dao.TopicDao
import com.me.simplehabit.persistence.typeconverters.IntegerListConverter
import com.me.simplehabit.persistence.typeconverters.ProgramListConverter
import com.me.simplehabit.persistence.typeconverters.SessionListConverter

@Database(entities = [
    CurrentProgramVO::class,
    TopicVO::class,
    CategoriesProgramVO::class], version = 3)
@TypeConverters(SessionListConverter::class, IntegerListConverter::class, ProgramListConverter::class)
abstract class SimpleHabitDatabase : RoomDatabase() {

    abstract val currentProgramDao: CurrentProgramDao
    abstract val topicDao: TopicDao
    abstract val categoryProgramDao: CategoryProgramDao

    val isCurrentProgramEmpty: Boolean
        get() {
            val count = currentProgramDao.retrieveCurrentProgramCount()
            return count < 1
        }

    val isTopicEmpty: Boolean
        get() {
            val topicList = topicDao.retrieveTopicsCount()
            return topicList < 1
        }

    val isCategoriesAndProgramsEmpty: Boolean
        get() {
            val list = categoryProgramDao.retrieveCategoriesAndProgramsCount()
            return list < 1
        }

    companion object {

        private var objInstance: SimpleHabitDatabase? = null
        private const val DB_NAME = "simple_habit.db"

        fun getDatabase(context: Context): SimpleHabitDatabase {

            if (objInstance == null) {
                objInstance = Room.databaseBuilder(context, SimpleHabitDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }

            return objInstance as SimpleHabitDatabase
        }
    }
}