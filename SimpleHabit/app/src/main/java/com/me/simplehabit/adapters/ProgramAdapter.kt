package com.me.simplehabit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import com.me.simplehabit.R
import com.me.simplehabit.data.vos.ProgramVO
import com.me.simplehabit.delegates.ProgramDelegate
import com.me.simplehabit.views.holders.ProgramViewHolder

class ProgramAdapter(private val programDelegate: ProgramDelegate, private val categoryId: String) : BaseRecyclerAdapter<ProgramViewHolder, ProgramVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ProgramViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.view_item_program, viewGroup, false)

        return ProgramViewHolder(itemView, programDelegate, categoryId)
    }
}
