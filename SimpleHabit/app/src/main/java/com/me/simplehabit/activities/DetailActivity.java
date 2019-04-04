package com.me.simplehabit.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.me.simplehabit.R;
import com.me.simplehabit.adapters.SessionAdapter;
import com.me.simplehabit.data.models.CategoryProgramModel;
import com.me.simplehabit.data.models.CategoryProgramModelImpl;
import com.me.simplehabit.data.models.CurrentProgramModel;
import com.me.simplehabit.data.models.CurrentProgramModelImpl;
import com.me.simplehabit.data.vos.CategoriesProgramVO;
import com.me.simplehabit.data.vos.CurrentProgramVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.tb_activity_detail) Toolbar toolbar;
    @BindView(R.id.colp_activity_detail) CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.tv_activity_detail_description) TextView tvDescription;
    @BindView(R.id.rv_activity_detail_session) RecyclerView rvSession;

    public static final String PROGRAM = "program";
    public static final String POSITION = "position";
    public static final String CATEGORY_ID="category_id";

    private CurrentProgramModel currentProgramModel;
    private CategoryProgramModel categoryProgramModel;
    private SessionAdapter sessionAdapter;

    public static Intent newIntent(Context context) {
        return new Intent(context, DetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        rvSession.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        sessionAdapter = new SessionAdapter();
        rvSession.setAdapter(sessionAdapter);

        Intent intent = getIntent();
        String program = intent.getStringExtra(PROGRAM);

        if (program.equals("current")) {

            currentProgramModel = CurrentProgramModelImpl.getInstance();

            CurrentProgramVO currentProgram = currentProgramModel.getCurrentProgram();

            if (currentProgram != null) {
                tvDescription.setText(currentProgram.getDescription());
                collapsingToolbarLayout.setTitle(currentProgram.getTitle());
                sessionAdapter.setNewData(currentProgram.getSessions());
            }

        } else {

            int position = intent.getIntExtra(POSITION, 0);
            String categoryId=intent.getStringExtra(CATEGORY_ID);

            categoryProgramModel = CategoryProgramModelImpl.getInstance();

            CategoriesProgramVO categoryList = categoryProgramModel.getCategoriesAndProgramById(categoryId);

            tvDescription.setText(categoryList.getPrograms().get(position).getDescription());
            collapsingToolbarLayout.setTitle(categoryList.getPrograms().get(position).getTitle());

            sessionAdapter.setNewData(categoryList.getPrograms().get(position).getSessions());

        }

    }
}
