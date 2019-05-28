package com.me.simplehabit.views.holders

import android.view.View
import com.me.simplehabit.data.vos.CurrentProgramVO
import com.me.simplehabit.delegates.CurrentProgramDelegate
import kotlinx.android.synthetic.main.view_item_current_program.view.*

class CurrentProgramViewHolder(itemView: View, private val currentProgramDelegate: CurrentProgramDelegate) : BaseViewHolder<CurrentProgramVO>(itemView) {

    override fun bindData(data: CurrentProgramVO) {
        itemView.tvItemCurrentProgramDuration.text = data.averageLengths!![adapterPosition].toString() + " mins"
        itemView.tvItemCurrentProgramTitle.text = data.title
        itemView.btnItemCurrentProgramPlay.text = data.currentPeriod

        itemView.rlItemCurrentProgram.setOnClickListener { currentProgramDelegate.onTapCurrentProgramItem(data) }
    }
}
