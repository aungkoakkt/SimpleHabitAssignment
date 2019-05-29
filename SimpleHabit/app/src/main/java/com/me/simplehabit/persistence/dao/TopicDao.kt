package com.me.simplehabit.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.me.simplehabit.data.vos.TopicVO

@Dao
interface TopicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTopics(topicList: List<TopicVO>)

    @Query("select * from topic")
    fun retrieveTopics(): LiveData<List<TopicVO>>

    @Query("select count(*) from topic")
    fun retrieveTopicsCount(): Int
}
