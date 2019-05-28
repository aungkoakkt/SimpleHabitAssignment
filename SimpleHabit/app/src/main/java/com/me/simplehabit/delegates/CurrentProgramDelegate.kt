package com.me.simplehabit.delegates

import com.me.simplehabit.data.vos.CurrentProgramVO

interface CurrentProgramDelegate {

    fun onTapCurrentProgramItem(currentProgramVO: CurrentProgramVO)
}
