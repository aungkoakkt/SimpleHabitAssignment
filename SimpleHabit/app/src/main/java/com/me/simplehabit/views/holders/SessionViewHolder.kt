package com.me.simplehabit.views.holders

import android.view.View
import com.me.simplehabit.data.vos.SessionVO
import kotlinx.android.synthetic.main.view_item_session.view.*
import java.text.SimpleDateFormat
import java.util.*

class SessionViewHolder(itemView: View) : BaseViewHolder<SessionVO>(itemView) {

    override fun bindData(data: SessionVO) {
        itemView.tvItemSessionNo.text = (adapterPosition + 1).toString()
        itemView.tvItemSessionName.text = data.title
        itemView.tvItemSessionDuration.text = setDuration(data.lengthInSeconds)

    }

    private fun setDuration(second: Int): String {
        val d = Date(second * 1000L)
        val df = SimpleDateFormat("mm:ss")
        df.timeZone = TimeZone.getTimeZone("GMT")
        return df.format(d)
    }
}
