package com.me.simplehabit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import com.me.simplehabit.R
import com.me.simplehabit.data.vos.CategoriesProgramVO
import com.me.simplehabit.delegates.ProgramDelegate
import com.me.simplehabit.views.holders.CategoryViewHolder

class CategoryProgramAdapter(private val programDelegate: ProgramDelegate) : BaseRecyclerAdapter<CategoryViewHolder, CategoriesProgramVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.view_item_category, viewGroup, false)
        return CategoryViewHolder(itemView, programDelegate)
    }

}
