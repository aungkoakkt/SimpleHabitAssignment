package com.me.simplehabit.data.models

import com.me.simplehabit.data.vos.CurrentProgramVO

interface CurrentProgramModel {

    fun getCurrentProgram(): CurrentProgramVO

    fun getCurrentProgram(delegate: CurrentProgramDelegate, isForce: Boolean): CurrentProgramVO

    interface CurrentProgramDelegate {

        fun onCurrentProgramFetchFromNetwork(currentProgramVO: CurrentProgramVO)

        fun onErrorOnProgramFetch(message: String)
    }
}
