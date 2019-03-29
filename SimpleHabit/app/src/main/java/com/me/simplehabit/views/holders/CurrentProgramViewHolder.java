package com.me.simplehabit.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.me.simplehabit.R;
import com.me.simplehabit.data.vos.CurrentProgramVO;
import com.me.simplehabit.delegates.CurrentProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentProgramViewHolder extends BaseViewHolder<CurrentProgramVO> {

    @BindView(R.id.tv_item_current_program_duration) TextView tvDuration;
    @BindView(R.id.tv_item_current_program_title) TextView tvTitle;
    @BindView(R.id.btn_item_current_program_play) AppCompatButton btnPlay;
    @BindView(R.id.rl_item_current_program) RelativeLayout rlCurrentProgram;

    private CurrentProgramDelegate currentProgramDelegate;

    public CurrentProgramViewHolder(@NonNull View itemView,CurrentProgramDelegate currentProgramDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        this.currentProgramDelegate=currentProgramDelegate;
    }

    @Override
    public void bindData(final CurrentProgramVO data) {
        tvDuration.setText(data.getAverageLengths().get(getAdapterPosition())+" mins");
        tvTitle.setText(data.getTitle());
        btnPlay.setText(data.getCurrentPeriod());

        rlCurrentProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProgramDelegate.onTapCurrentProgamItem(data);
            }
        });
    }
}
