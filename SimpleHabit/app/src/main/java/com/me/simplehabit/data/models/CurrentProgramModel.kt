package com.me.simplehabit.data.models

import androidx.lifecycle.LiveData
import com.me.simplehabit.data.vos.CurrentProgramVO

interface CurrentProgramModel {

    fun getCurrentProgram(): LiveData<CurrentProgramVO>

    fun loadCurrentProgram(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<CurrentProgramVO>

}
