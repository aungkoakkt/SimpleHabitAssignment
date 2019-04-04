package com.me.simplehabit.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.simplehabit.R;
import com.me.simplehabit.data.vos.ProgramVO;
import com.me.simplehabit.delegates.ProgramDelegate;
import com.me.simplehabit.views.holders.ProgramViewHolder;

public class ProgramAdapter extends BaseRecyclerAdapter<ProgramViewHolder, ProgramVO> {

    private ProgramDelegate programDelegate;
    private String categoryId;

    public ProgramAdapter(ProgramDelegate programDelegate,String categoryId) {
        this.programDelegate = programDelegate;
        this.categoryId=categoryId;
    }

    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_program,viewGroup,false);

        return new ProgramViewHolder(itemView, programDelegate,categoryId);
    }
}
