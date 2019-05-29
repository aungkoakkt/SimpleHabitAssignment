package com.me.simplehabit.data.models

import androidx.lifecycle.LiveData
import com.me.simplehabit.data.vos.CurrentProgramVO
import com.me.simplehabit.delegates.CurrentProgramResponseDelegate
import com.me.simplehabit.utils.CommonInstances

object CurrentProgramModelImpl : BaseModel(), CurrentProgramModel {
    override fun loadCurrentProgram(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<CurrentProgramVO> {

        if (mDatabase.isCurrentProgramEmpty || isForce) {
            mDataAgent.getCurrentProgram(CommonInstances.TOKEN, CommonInstances.PAGE, object : CurrentProgramResponseDelegate {
                override fun onSuccess(currentProgramVO: CurrentProgramVO) {
                    mDatabase.currentProgramDao.saveCurrentProgram(currentProgramVO)
                }

                override fun onFail(message: String) {
                    networkFailure(message)
                }
            })
        }

        return mDatabase.currentProgramDao.retrieveCurrentProgram()
    }

    override fun getCurrentProgram(): LiveData<CurrentProgramVO> {

        return mDatabase.currentProgramDao.retrieveCurrentProgram()
    }
}
