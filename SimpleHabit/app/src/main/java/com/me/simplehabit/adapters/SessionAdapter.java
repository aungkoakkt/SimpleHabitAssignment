package com.me.simplehabit.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.simplehabit.R;
import com.me.simplehabit.data.vos.SessionVO;
import com.me.simplehabit.views.holders.SessionViewHolder;

public class SessionAdapter extends BaseRecyclerAdapter<SessionViewHolder, SessionVO> {

    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_session,viewGroup,false);
        return new SessionViewHolder(itemview);
    }
}
