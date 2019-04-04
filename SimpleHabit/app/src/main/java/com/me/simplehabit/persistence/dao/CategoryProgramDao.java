package com.me.simplehabit.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.me.simplehabit.data.vos.CategoriesProgramVO;

import java.util.List;

@Dao
public interface CategoryProgramDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void savecategoriesAndPrograms(List<CategoriesProgramVO> programList);

    @Query("select * from category_program")
    List<CategoriesProgramVO> retrieveCategoriesAndPrograms();

    @Query("select * from category_program where category_id=:categoryId")
    CategoriesProgramVO retrieveCategoryById(String categoryId);
}
