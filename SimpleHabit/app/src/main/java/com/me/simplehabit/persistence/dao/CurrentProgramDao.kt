package com.me.simplehabit.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.me.simplehabit.data.vos.CurrentProgramVO

@Dao
interface CurrentProgramDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCurrentProgram(currentProgram: CurrentProgramVO)

    @Query("select * from CurrentProgram")
    fun retrieveCurrentProgram(): CurrentProgramVO

    @Query("select count(*) from CurrentProgram")
    fun retrieveCurrentProgramCount(): Int
}
