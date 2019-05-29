package com.me.simplehabit.data.models

import com.me.simplehabit.data.vos.CategoriesProgramVO
import com.me.simplehabit.delegates.CategoryProgramDelegate
import com.me.simplehabit.utils.CommonInstances

object CategoryProgramModelImpl : BaseModel(), CategoryProgramModel {

    override fun getCategoriesAndProgram(delegate: CategoryProgramModel.CategoryProgramModelDelegate, isForce: Boolean): List<CategoriesProgramVO> {

        if (mDatabase.isCategoriesAndProgramsEmpty || isForce) {

            mDataAgent.getCategoriesAndPrograms(CommonInstances.TOKEN, CommonInstances.PAGE, object : CategoryProgramDelegate {
                override fun onSuccess(categoriesProgramVOList: List<CategoriesProgramVO>) {
                    delegate.onCurrentProgramFetchFromNetwork(categoriesProgramVOList)
                    mDatabase.categoryProgramDao.saveCategoriesAndPrograms(categoriesProgramVOList)
                }

                override fun onFail(message: String) {
                    delegate.onErrorOnProgramFetch(message)
                }
            })

        } else {
            return mDatabase.categoryProgramDao.retrieveCategoriesAndPrograms()
        }

        return mDatabase.categoryProgramDao.retrieveCategoriesAndPrograms()
    }

    override fun getCategoriesAndProgramById(categoryId: String): CategoriesProgramVO {
        return if (!mDatabase.isCategoriesAndProgramsEmpty) {
            mDatabase.categoryProgramDao.retrieveCategoryById(categoryId)
        } else mDatabase.categoryProgramDao.retrieveCategoryById(categoryId)
    }

}
