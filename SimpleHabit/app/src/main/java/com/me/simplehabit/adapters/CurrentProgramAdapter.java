package com.me.simplehabit.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.simplehabit.R;
import com.me.simplehabit.data.vos.CurrentProgramVO;
import com.me.simplehabit.delegates.CurrentProgramDelegate;
import com.me.simplehabit.views.holders.CurrentProgramViewHolder;

public class CurrentProgramAdapter extends BaseRecyclerAdapter<CurrentProgramViewHolder, CurrentProgramVO> {

    private CurrentProgramDelegate mDelegate;

    public CurrentProgramAdapter(CurrentProgramDelegate mDelegate) {
        this.mDelegate = mDelegate;
    }

    @NonNull
    @Override
    public CurrentProgramViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_current_program,viewGroup,false);

        return new CurrentProgramViewHolder(itemView,mDelegate);
    }
}
