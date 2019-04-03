package com.me.simplehabit.views.holders;

import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.view.View;
import android.widget.TextView;

import com.me.simplehabit.R;
import com.me.simplehabit.data.vos.ProgramVO;
import com.me.simplehabit.delegates.ProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgramViewHolder extends BaseViewHolder<ProgramVO> {

    @BindView(R.id.tv_item_program_title) TextView tvTitle;
    @BindView(R.id.tv_item_program_duration) TextView tvDuration;
    @BindView(R.id.cv_item_program) MaterialCardView cvProgram;

    private ProgramDelegate mProgramDelegate;

    public ProgramViewHolder(@NonNull View itemView, ProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        mProgramDelegate =delegate;
    }

    @Override
    public void bindData(final ProgramVO data) {
        tvTitle.setText(data.getTitle());
        tvDuration.setText(data.getAverageLengths().get(0)+" mins");

        cvProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgramDelegate.onTapProgramItem(data);
            }
        });
    }
}
