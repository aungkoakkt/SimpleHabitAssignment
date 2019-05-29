package com.me.simplehabit.data.models

import androidx.lifecycle.LiveData
import com.me.simplehabit.data.vos.CategoriesProgramVO
import com.me.simplehabit.delegates.CategoryProgramDelegate
import com.me.simplehabit.utils.CommonInstances

object CategoryProgramModelImpl : BaseModel(), CategoryProgramModel {

    override fun loadCategoriesAndProgram(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<List<CategoriesProgramVO>> {

        if (mDatabase.isCategoriesAndProgramsEmpty || isForce) {

            mDataAgent.getCategoriesAndPrograms(CommonInstances.TOKEN, CommonInstances.PAGE, object : CategoryProgramDelegate {
                override fun onSuccess(categoriesProgramVOList: List<CategoriesProgramVO>) {

                    mDatabase.categoryProgramDao.saveCategoriesAndPrograms(categoriesProgramVOList)
                }

                override fun onFail(message: String) {
                    networkFailure(message)
                }
            })
        }

        return mDatabase.categoryProgramDao.retrieveCategoriesAndPrograms()
    }

    override fun getCategoriesAndProgramById(categoryId: String): LiveData<CategoriesProgramVO> {
        return mDatabase.categoryProgramDao.retrieveCategoryById(categoryId)
    }

}
