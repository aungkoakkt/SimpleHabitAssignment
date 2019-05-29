package com.me.simplehabit.data.models

import androidx.lifecycle.LiveData
import com.me.simplehabit.data.vos.CategoriesProgramVO

interface CategoryProgramModel {

    fun loadCategoriesAndProgram(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<List<CategoriesProgramVO>>
    fun getCategoriesAndProgramById(categoryId: String): LiveData<CategoriesProgramVO>

}
