package com.me.simplehabit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import com.me.simplehabit.R
import com.me.simplehabit.data.vos.SessionVO
import com.me.simplehabit.views.holders.SessionViewHolder

class SessionAdapter : BaseRecyclerAdapter<SessionViewHolder, SessionVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SessionViewHolder {
        val itemview = LayoutInflater.from(viewGroup.context).inflate(R.layout.view_item_session, viewGroup, false)
        return SessionViewHolder(itemview)
    }
}
