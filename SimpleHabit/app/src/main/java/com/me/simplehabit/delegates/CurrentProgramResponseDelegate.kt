package com.me.simplehabit.delegates

import com.me.simplehabit.data.vos.CurrentProgramVO

interface CurrentProgramResponseDelegate {

    fun onSuccess(currentProgramVO: CurrentProgramVO)
    fun onFail(message: String)
}
