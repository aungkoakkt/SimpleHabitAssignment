package com.me.simplehabit.delegates

import com.me.simplehabit.data.vos.ProgramVO

interface ProgramDelegate {

    fun onTapProgramItem(programVO: ProgramVO, categoryId: String, position: Int)
}
