package com.me.simplehabit.views.holders;

import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.TextView;

import com.me.simplehabit.R;
import com.me.simplehabit.data.vos.TopicVO;
import com.me.simplehabit.delegates.TopicDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopicViewHolder extends BaseViewHolder<TopicVO> {

    @BindView(R.id.tv_item_topic_description) TextView tvDescription;
    @BindView(R.id.tv_item_topic_title)TextView tvTitle;
    @BindView(R.id.cv_item_topic) MaterialCardView cvTopic;
    @BindView(R.id.iv_item_topic_icon) AppCompatImageView ivIcon;
    @BindView(R.id.iv_item_topic_bg) AppCompatImageView ivBackground;

    private TopicDelegate mDelegate;

    public TopicViewHolder(@NonNull View itemView,TopicDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        mDelegate=delegate;
    }

    @Override
    public void bindData(final TopicVO data) {
        tvTitle.setText(data.getTopicName());
        tvDescription.setText(data.getTopicDesc());

        cvTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapTopicItem(data);
            }
        });
    }


}
