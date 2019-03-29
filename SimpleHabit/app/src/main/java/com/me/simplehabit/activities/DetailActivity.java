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
import com.me.simplehabit.data.models.CurrentProgramModel;
import com.me.simplehabit.data.models.CurrentProgramModelImpl;
import com.me.simplehabit.data.vos.CurrentProgramVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.tb_activity_detail) Toolbar toolbar;
    @BindView(R.id.colp_activity_detail) CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.tv_activity_detail_description) TextView tvDescription;
    @BindView(R.id.rv_activity_detail_session) RecyclerView rvSession;

    private CurrentProgramModel currentProgramModel;
    private SessionAdapter sessionAdapter;

    public static Intent newIntent(Context context){
        return new Intent(context,DetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        rvSession.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        currentProgramModel= CurrentProgramModelImpl.getInstance();
        sessionAdapter=new SessionAdapter();
        rvSession.setAdapter(sessionAdapter);

        currentProgramModel.getCurrentProgram(new CurrentProgramModel.CurrentProgramDelegate() {
            @Override
            public void onCurrentProgramFetchFromNetwork(CurrentProgramVO currentProgramVO) {
                tvDescription.setText(currentProgramVO.getDescription());
                collapsingToolbarLayout.setTitle(currentProgramVO.getTitle());

                sessionAdapter.setNewData(currentProgramVO.getSessions());
            }

            @Override
            public void onErrorOnProgramFetch(String message) {
                Toast.makeText(DetailActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        },false);

    }
}
