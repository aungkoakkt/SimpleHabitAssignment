package com.me.simplehabit.data.models

import android.content.Context

import com.me.simplehabit.data.vos.CurrentProgramVO
import com.me.simplehabit.delegates.CurrentProgramResponseDelegate
import com.me.simplehabit.utils.CommonInstances

class CurrentProgramModelImpl private constructor(context: Context) : BaseModel(context), CurrentProgramModel {

    override fun getCurrentProgram(delegate: CurrentProgramModel.CurrentProgramDelegate, isForce: Boolean): CurrentProgramVO {

        if (mDatabase.isCurrentProgramEmpty || isForce) {
            mDataAgent.getCurrentProgram(CommonInstances.TOKEN, CommonInstances.PAGE, object : CurrentProgramResponseDelegate {
                override fun onSuccess(currentProgramVO: CurrentProgramVO) {
                    mDatabase.currentProgramDao.saveCurrentProgram(currentProgramVO)
                    delegate.onCurrentProgramFetchFromNetwork(currentProgramVO)
                }

                override fun onFail(message: String) {
                    delegate.onErrorOnProgramFetch(message)
                }
            })
        } else {
            return mDatabase.currentProgramDao.retrieveCurrentProgram()
        }

        return mDatabase.currentProgramDao.retrieveCurrentProgram()
    }

    override fun getCurrentProgram(): CurrentProgramVO {
        return if (!mDatabase.isCurrentProgramEmpty) {
            mDatabase.currentProgramDao.retrieveCurrentProgram()
        } else mDatabase.currentProgramDao.retrieveCurrentProgram()
    }

    companion object {

        private var objInstance: CurrentProgramModelImpl? = null

        fun initCurrentProgramModel(context: Context) {
            objInstance = CurrentProgramModelImpl(context)
        }

        val instance: CurrentProgramModelImpl
            get() {
                if (objInstance == null) {
                    throw RuntimeException("CurrentProgramModel should have been initialized before using it")
                }
                return objInstance as CurrentProgramModelImpl
            }
    }
}
