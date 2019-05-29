package com.me.simplehabit.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.me.simplehabit.R
import com.me.simplehabit.activities.DetailActivity
import com.me.simplehabit.adapters.CategoryProgramAdapter
import com.me.simplehabit.adapters.CurrentProgramAdapter
import com.me.simplehabit.adapters.TopicsAdapter
import com.me.simplehabit.data.vos.CategoriesProgramVO
import com.me.simplehabit.data.vos.CurrentProgramVO
import com.me.simplehabit.data.vos.TopicVO
import com.me.simplehabit.mvp.presenters.impl.MainPresenter
import com.me.simplehabit.mvp.views.MainView
import kotlinx.android.synthetic.main.fragment_series.*
import java.util.*

class SeriesFragment : BaseFragment(), MainView {

    private lateinit var mMainPresenter: MainPresenter

    private lateinit var currentProgramAdapter: CurrentProgramAdapter
    private lateinit var topicsAdapter: TopicsAdapter
    private lateinit var categoryProgramAdapter: CategoryProgramAdapter

    companion object {

        fun newInstance() = SeriesFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_series, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMainPresenter = ViewModelProviders.of(this).get(MainPresenter::class.java)
        mMainPresenter.initPresenter(this)
        mMainPresenter.onUIReady(this)

        rvFragmentSeriesCurrentProgram.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        rvFragmentSeriesTopic.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvFragmentSeriesCategories.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        currentProgramAdapter = CurrentProgramAdapter(mMainPresenter)
        rvFragmentSeriesCurrentProgram.adapter = currentProgramAdapter

        topicsAdapter = TopicsAdapter(mMainPresenter)
        rvFragmentSeriesTopic.adapter = topicsAdapter

        categoryProgramAdapter = CategoryProgramAdapter(mMainPresenter)
        rvFragmentSeriesCategories.adapter = categoryProgramAdapter

        srlSeriesFragment.setOnRefreshListener { mMainPresenter.onRefreshPage(this) }
    }

    override fun getMyContext(): Context {
        return context!!
    }

    override fun displayCurrentProgram(currentProgram: CurrentProgramVO) {

        if (srlSeriesFragment.isRefreshing){
            srlSeriesFragment.isRefreshing=false
        }

        val programList = ArrayList<CurrentProgramVO>()
        programList.add(currentProgram)
        currentProgramAdapter.setNewData(programList)
    }

    override fun displayCategoriesAndPrograms(categoriesPrograms: List<CategoriesProgramVO>) {

        if (srlSeriesFragment.isRefreshing){
            srlSeriesFragment.isRefreshing=false
        }

        categoryProgramAdapter.setNewData(categoriesPrograms as MutableList<CategoriesProgramVO>)
    }

    override fun displayTopics(topics: List<TopicVO>) {

        if (srlSeriesFragment.isRefreshing){
            srlSeriesFragment.isRefreshing=false
        }

        topicsAdapter.setNewData(topics as MutableList<TopicVO>)
    }

    override fun displayFailToLoadDataMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun displayNoDataMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToDetail(type: String, position: Int, categoryId: String) {
        val intent = DetailActivity.newIntent(context!!)
        intent.putExtra(DetailActivity.PROGRAM, type)
        intent.putExtra(DetailActivity.POSITION, position)
        intent.putExtra(DetailActivity.CATEGORY_ID, categoryId)
        startActivity(intent)
    }
}
