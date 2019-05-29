package com.me.simplehabit.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.me.simplehabit.data.vos.CategoriesProgramVO

@Dao
interface CategoryProgramDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategoriesAndPrograms(programList: List<CategoriesProgramVO>)

    @Query("select * from category_program")
    fun retrieveCategoriesAndPrograms(): LiveData<List<CategoriesProgramVO>>

    @Query("select count(*) from category_program")
    fun retrieveCategoriesAndProgramsCount(): Int

    @Query("select * from category_program where category_id=:categoryId")
    fun retrieveCategoryById(categoryId: String): LiveData<CategoriesProgramVO>
}
