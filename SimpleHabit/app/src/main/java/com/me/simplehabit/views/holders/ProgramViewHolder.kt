package com.me.simplehabit.views.holders

import android.view.View
import com.me.simplehabit.data.vos.ProgramVO
import com.me.simplehabit.delegates.ProgramDelegate
import kotlinx.android.synthetic.main.view_item_program.view.*


class ProgramViewHolder(itemView: View, private val mProgramDelegate: ProgramDelegate, private val mCategoryId: String) : BaseViewHolder<ProgramVO>(itemView) {

    override fun bindData(data: ProgramVO) {
        itemView.tvItemProgramTitle.text = data.title
        itemView.tvItemProgramDuration.text = data.averageLengths[0].toString() + " mins"

        itemView.cvItemProgram.setOnClickListener { mProgramDelegate.onTapProgramItem(data, mCategoryId, adapterPosition) }
    }
}
