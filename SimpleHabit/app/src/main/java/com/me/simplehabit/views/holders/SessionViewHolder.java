package com.me.simplehabit.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.me.simplehabit.R;
import com.me.simplehabit.data.vos.SessionVO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SessionViewHolder extends BaseViewHolder<SessionVO> {

    @BindView(R.id.tv_item_session_no)TextView tvNumber;
    @BindView(R.id.tv_item_session_name)TextView tvName;
    @BindView(R.id.tv_item_session_duration)TextView tvDuration;

    public SessionViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bindData(SessionVO data) {
        tvNumber.setText(String.valueOf(getAdapterPosition()+1));
        tvName.setText(data.getTitle());
        tvDuration.setText(setDuration(data.getLengthInSeconds()));

    }

    private String setDuration(int second){
        Date d = new Date(second * 1000L);
        SimpleDateFormat df = new SimpleDateFormat("mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.format(d);
    }
}
