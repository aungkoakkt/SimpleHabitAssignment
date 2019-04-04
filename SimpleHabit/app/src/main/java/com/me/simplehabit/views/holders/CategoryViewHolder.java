package com.me.simplehabit.views.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.me.simplehabit.R;
import com.me.simplehabit.adapters.ProgramAdapter;
import com.me.simplehabit.data.vos.CategoriesProgramVO;
import com.me.simplehabit.delegates.ProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryViewHolder extends BaseViewHolder<CategoriesProgramVO> {

    @BindView(R.id.tv_item_category) TextView tvCategory;
    @BindView(R.id.rv_item_category) RecyclerView rvCategory;

    Context context;
    private ProgramAdapter mProgramAdapter;
    private ProgramDelegate mDelegate;

    public CategoryViewHolder(@NonNull View itemView, ProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        context=itemView.getContext();
        mDelegate=delegate;
    }

    @Override
    public void bindData(CategoriesProgramVO data) {

        mProgramAdapter=new ProgramAdapter(mDelegate,data.getCategoryId());

        tvCategory.setText(data.getTitle());
        rvCategory.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        rvCategory.setAdapter(mProgramAdapter);

        mProgramAdapter.setNewData(data.getPrograms());
    }
}
