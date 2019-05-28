package com.me.simplehabit.persistence.dao

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
    fun retrieveCategoriesAndPrograms(): List<CategoriesProgramVO>

    @Query("select * from category_program where category_id=:categoryId")
    fun retrieveCategoryById(categoryId: String): CategoriesProgramVO
}
