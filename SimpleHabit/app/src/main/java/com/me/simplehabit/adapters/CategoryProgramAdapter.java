package com.me.simplehabit.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.simplehabit.R;
import com.me.simplehabit.data.vos.CategoriesProgramVO;
import com.me.simplehabit.delegates.ProgramDelegate;
import com.me.simplehabit.views.holders.CategoryViewHolder;

public class CategoryProgramAdapter extends BaseRecyclerAdapter<CategoryViewHolder, CategoriesProgramVO> {

    private ProgramDelegate programDelegate;

    public CategoryProgramAdapter(ProgramDelegate programDelegate) {
        this.programDelegate = programDelegate;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int position) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_category,viewGroup,false);
        return new CategoryViewHolder(itemView, programDelegate);
    }

}
