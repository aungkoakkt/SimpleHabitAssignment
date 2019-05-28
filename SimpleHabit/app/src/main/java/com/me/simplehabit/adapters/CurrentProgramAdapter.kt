package com.me.simplehabit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import com.me.simplehabit.R
import com.me.simplehabit.data.vos.CurrentProgramVO
import com.me.simplehabit.delegates.CurrentProgramDelegate
import com.me.simplehabit.views.holders.CurrentProgramViewHolder

class CurrentProgramAdapter(private val mDelegate: CurrentProgramDelegate) : BaseRecyclerAdapter<CurrentProgramViewHolder, CurrentProgramVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CurrentProgramViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.view_item_current_program, viewGroup, false)

        return CurrentProgramViewHolder(itemView, mDelegate)
    }
}
