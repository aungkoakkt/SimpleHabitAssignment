package com.me.simplehabit.views.holders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.me.simplehabit.adapters.ProgramAdapter
import com.me.simplehabit.data.vos.CategoriesProgramVO
import com.me.simplehabit.data.vos.ProgramVO
import com.me.simplehabit.delegates.ProgramDelegate
import kotlinx.android.synthetic.main.view_item_category.view.*


class CategoryViewHolder(itemView: View, private val mDelegate: ProgramDelegate) : BaseViewHolder<CategoriesProgramVO>(itemView) {

    private lateinit var mProgramAdapter: ProgramAdapter

    override fun bindData(data: CategoriesProgramVO) {

        mProgramAdapter = ProgramAdapter(mDelegate, data.categoryId)

        itemView.tvItemCategory.text = data.title
        itemView.rvItemCategory.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        itemView.rvItemCategory.adapter = mProgramAdapter

        mProgramAdapter.setNewData(data.programs as MutableList<ProgramVO>)
    }
}
