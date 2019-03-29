package com.me.simplehabit.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.simplehabit.R;
import com.me.simplehabit.data.vos.TopicVO;
import com.me.simplehabit.delegates.TopicDelegate;
import com.me.simplehabit.views.holders.TopicViewHolder;

public class TopicsAdapter extends BaseRecyclerAdapter<TopicViewHolder,TopicVO> {

    private TopicDelegate mDelegate;

    public TopicsAdapter(TopicDelegate delegate) {
        this.mDelegate = delegate;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_topic,viewGroup,false);
        return new TopicViewHolder(view,mDelegate);
    }
}
