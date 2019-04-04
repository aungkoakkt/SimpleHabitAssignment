package com.me.simplehabit.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.me.simplehabit.data.vos.TopicVO;

import java.util.List;

@Dao
public interface TopicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveTopics(List<TopicVO> topicList);

    @Query("select * from topic")
    List<TopicVO> retrieveTopics();
}
