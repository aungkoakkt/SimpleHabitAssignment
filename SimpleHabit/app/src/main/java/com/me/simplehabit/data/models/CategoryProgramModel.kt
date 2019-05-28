package com.me.simplehabit.data.models

import com.me.simplehabit.data.vos.CategoriesProgramVO

interface CategoryProgramModel {

    fun getCategoriesAndProgram(delegate: CategoryProgramModelDelegate, isForce: Boolean): List<CategoriesProgramVO>
    fun getCategoriesAndProgramById(categoryId: String): CategoriesProgramVO

    interface CategoryProgramModelDelegate {

        fun onCurrentProgramFetchFromNetwork(categoriesProgramVOList: List<CategoriesProgramVO>)

        fun onErrorOnProgramFetch(message: String)
    }
}
