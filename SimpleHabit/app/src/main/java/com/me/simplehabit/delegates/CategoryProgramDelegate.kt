package com.me.simplehabit.delegates

import com.me.simplehabit.data.vos.CategoriesProgramVO

interface CategoryProgramDelegate {

    fun onSuccess(categoriesProgramVOList: List<CategoriesProgramVO>)
    fun onFail(message: String)
}
