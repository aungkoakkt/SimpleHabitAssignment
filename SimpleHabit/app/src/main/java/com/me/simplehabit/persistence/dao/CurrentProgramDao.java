package com.me.simplehabit.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.me.simplehabit.data.vos.CurrentProgramVO;

@Dao
public interface CurrentProgramDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveCurrentProgram(CurrentProgramVO currentProgram);

    @Query("select * from CurrentProgram")
    CurrentProgramVO retrieveCurrentProgram();
}
