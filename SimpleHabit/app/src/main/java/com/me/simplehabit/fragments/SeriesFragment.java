package com.me.simplehabit.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.me.simplehabit.R;
import com.me.simplehabit.activities.DetailActivity;
import com.me.simplehabit.adapters.CategoryProgramAdapter;
import com.me.simplehabit.adapters.CurrentProgramAdapter;
import com.me.simplehabit.adapters.TopicsAdapter;
import com.me.simplehabit.data.models.CategoryProgramModel;
import com.me.simplehabit.data.models.CategoryProgramModelImpl;
import com.me.simplehabit.data.models.CurrentProgramModel;
import com.me.simplehabit.data.models.CurrentProgramModelImpl;
import com.me.simplehabit.data.models.TopicModel;
import com.me.simplehabit.data.models.TopicModelImpl;
import com.me.simplehabit.data.vos.CategoriesProgramVO;
import com.me.simplehabit.data.vos.CurrentProgramVO;
import com.me.simplehabit.data.vos.ProgramVO;
import com.me.simplehabit.data.vos.TopicVO;
import com.me.simplehabit.delegates.CurrentProgramDelegate;
import com.me.simplehabit.delegates.ProgramDelegate;
import com.me.simplehabit.delegates.TopicDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesFragment extends Fragment implements CurrentProgramDelegate, TopicDelegate, ProgramDelegate {

    @BindView(R.id.rv_fragment_series_current_program) RecyclerView rvCurrentProgram;
    @BindView(R.id.rv_fragment_series_topic) RecyclerView rvTopic;
    @BindView(R.id.rv_fragment_series_categories) RecyclerView rvCategories;

    private static SeriesFragment objectInstance = null;

    private CurrentProgramAdapter currentProgramAdapter;
    private TopicsAdapter topicsAdapter;
    private CategoryProgramAdapter categoryProgramAdapter;

    private CurrentProgramModel currentProgramModel;
    private TopicModel topicModel;
    private CategoryProgramModel categoryProgramModel;

    public static SeriesFragment getInstance() {
        return (objectInstance == null) ? objectInstance = new SeriesFragment() : objectInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCurrentProgram.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvTopic.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvCategories.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        currentProgramAdapter = new CurrentProgramAdapter(this);
        rvCurrentProgram.setAdapter(currentProgramAdapter);

        topicsAdapter = new TopicsAdapter(this);
        rvTopic.setAdapter(topicsAdapter);

        categoryProgramAdapter = new CategoryProgramAdapter(this);
        rvCategories.setAdapter(categoryProgramAdapter);

        currentProgramModel = CurrentProgramModelImpl.getInstance();
        topicModel = TopicModelImpl.getInstance();
        categoryProgramModel = CategoryProgramModelImpl.getInstance();

        getCurrentProgram(false);
        getTopic(false);
        getCategoriesAndPrograms(false);

    }

    @Override
    public void onTapCurrentProgramItem(CurrentProgramVO currentProgramVO) {
        Intent intent = DetailActivity.newIntent(getActivity());
        intent.putExtra("program", "current");
        startActivity(intent);
    }


    @Override
    public void onTapProgramItem(ProgramVO programVO, String categoryId, int position) {
        Intent intent = DetailActivity.newIntent(getActivity());
        intent.putExtra(DetailActivity.PROGRAM, "default");
        intent.putExtra(DetailActivity.POSITION, position);
        intent.putExtra(DetailActivity.CATEGORY_ID, categoryId);
        startActivity(intent);
    }

    @Override
    public void onTapTopicItem(TopicVO topic) {

    }

    private void getCurrentProgram(boolean isForce) {
        CurrentProgramVO currentProgram = currentProgramModel.getCurrentProgram(new CurrentProgramModel.CurrentProgramDelegate() {

            @Override
            public void onCurrentProgramFetchFromNetwork(CurrentProgramVO currentProgramVO) {
                List<CurrentProgramVO> programList = new ArrayList<>();
                programList.add(currentProgramVO);

                currentProgramAdapter.setNewData(programList);
            }

            @Override
            public void onErrorOnProgramFetch(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }

        }, isForce);

        if (currentProgram != null) {
            List<CurrentProgramVO> programList = new ArrayList<>();
            programList.add(currentProgram);
            currentProgramAdapter.setNewData(programList);
        }
    }

    private void getTopic(boolean isForce) {
        List<TopicVO> topicList = topicModel.getTopics(isForce, new TopicModel.TopicModelDelegate() {

            @Override
            public void onTopicFetchFromNetwork(List<TopicVO> topicList) {
                topicsAdapter.setNewData(topicList);
            }

            @Override
            public void onErrorTopicFetchFromNetwork(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });

        if (topicList != null) {
            topicsAdapter.setNewData(topicList);
        }
    }

    private void getCategoriesAndPrograms(boolean isForce) {

        List<CategoriesProgramVO> programList = categoryProgramModel.getCategoriesAndProgram(new CategoryProgramModel.CategoryProgramModelDelegate() {
            @Override
            public void onCurrentProgramFetchFromNetwork(List<CategoriesProgramVO> categoriesProgramVOList) {
                categoryProgramAdapter.setNewData(categoriesProgramVOList);
            }

            @Override
            public void onErrorOnProgramFetch(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }

        }, isForce);

        if (programList != null) {
            categoryProgramAdapter.setNewData(programList);
        }
    }

}
