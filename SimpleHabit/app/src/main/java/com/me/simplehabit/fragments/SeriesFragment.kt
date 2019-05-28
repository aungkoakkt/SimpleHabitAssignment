package com.me.simplehabit.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.me.simplehabit.R
import com.me.simplehabit.activities.DetailActivity
import com.me.simplehabit.adapters.CategoryProgramAdapter
import com.me.simplehabit.adapters.CurrentProgramAdapter
import com.me.simplehabit.adapters.TopicsAdapter
import com.me.simplehabit.data.models.CategoryProgramModel
import com.me.simplehabit.data.models.CategoryProgramModelImpl
import com.me.simplehabit.data.models.CurrentProgramModel
import com.me.simplehabit.data.models.CurrentProgramModelImpl
import com.me.simplehabit.data.models.TopicModel
import com.me.simplehabit.data.models.TopicModelImpl
import com.me.simplehabit.data.vos.CategoriesProgramVO
import com.me.simplehabit.data.vos.CurrentProgramVO
import com.me.simplehabit.data.vos.ProgramVO
import com.me.simplehabit.data.vos.TopicVO
import com.me.simplehabit.delegates.CurrentProgramDelegate
import com.me.simplehabit.delegates.ProgramDelegate
import com.me.simplehabit.delegates.TopicDelegate
import kotlinx.android.synthetic.main.fragment_series.*

import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class SeriesFragment : Fragment(), CurrentProgramDelegate, TopicDelegate, ProgramDelegate {

/*    @BindView(R.id.rvFragmentSeriesCurrentProgram)
    internal var rvCurrentProgram: RecyclerView? = null
    @BindView(R.id.rvFragmentSeriesTopic)
    internal var rvTopic: RecyclerView? = null
    @BindView(R.id.rvFragmentSeriesCategories)
    internal var rvCategories: RecyclerView? = null*/

    private var currentProgramAdapter: CurrentProgramAdapter? = null
    private var topicsAdapter: TopicsAdapter? = null
    private var categoryProgramAdapter: CategoryProgramAdapter? = null

    private var currentProgramModel: CurrentProgramModel? = null
    private var topicModel: TopicModel? = null
    private var categoryProgramModel: CategoryProgramModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_series, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvFragmentSeriesCurrentProgram.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        rvFragmentSeriesTopic.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvFragmentSeriesCategories.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        currentProgramAdapter = CurrentProgramAdapter(this)
        rvFragmentSeriesCurrentProgram.adapter = currentProgramAdapter

        topicsAdapter = TopicsAdapter(this)
        rvFragmentSeriesTopic.adapter = topicsAdapter

        categoryProgramAdapter = CategoryProgramAdapter(this)
        rvFragmentSeriesCategories.adapter = categoryProgramAdapter

        currentProgramModel = CurrentProgramModelImpl.instance
        topicModel = TopicModelImpl.instance
        categoryProgramModel = CategoryProgramModelImpl.instance

        getCurrentProgram(false)
        getTopic(false)
        getCategoriesAndPrograms(false)

    }

    override fun onTapCurrentProgramItem(currentProgramVO: CurrentProgramVO) {
        val intent = DetailActivity.newIntent(activity!!)
        intent.putExtra("program", "current")
        startActivity(intent)
    }


    override fun onTapProgramItem(programVO: ProgramVO, categoryId: String, position: Int) {
        val intent = DetailActivity.newIntent(activity!!)
        intent.putExtra(DetailActivity.PROGRAM, "default")
        intent.putExtra(DetailActivity.POSITION, position)
        intent.putExtra(DetailActivity.CATEGORY_ID, categoryId)
        startActivity(intent)
    }

    override fun onTapTopicItem(topic: TopicVO) {

    }

    private fun getCurrentProgram(isForce: Boolean) {
        val currentProgram = currentProgramModel!!.getCurrentProgram(object : CurrentProgramModel.CurrentProgramDelegate {

            override fun onCurrentProgramFetchFromNetwork(currentProgramVO: CurrentProgramVO) {
                val programList = ArrayList<CurrentProgramVO>()
                programList.add(currentProgramVO)

                currentProgramAdapter!!.setNewData(programList)
            }

            override fun onErrorOnProgramFetch(message: String) {
                Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
            }

        }, isForce)

        if (currentProgram != null) {
            val programList = ArrayList<CurrentProgramVO>()
            programList.add(currentProgram)
            currentProgramAdapter!!.setNewData(programList)
        }
    }

    private fun getTopic(isForce: Boolean) {
        val topicList = topicModel!!.getTopics(isForce, object : TopicModel.TopicModelDelegate {

            override fun onTopicFetchFromNetwork(topicList: List<TopicVO>) {
                topicsAdapter!!.setNewData(topicList as MutableList<TopicVO>)
            }

            override fun onErrorTopicFetchFromNetwork(message: String) {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
            }
        })

        if (topicList != null) {
            topicsAdapter!!.setNewData(topicList as MutableList<TopicVO>)
        }
    }

    private fun getCategoriesAndPrograms(isForce: Boolean) {

        val programList = categoryProgramModel!!.getCategoriesAndProgram(object : CategoryProgramModel.CategoryProgramModelDelegate {
            override fun onCurrentProgramFetchFromNetwork(categoriesProgramVOList: List<CategoriesProgramVO>) {
                categoryProgramAdapter!!.setNewData(categoriesProgramVOList as MutableList<CategoriesProgramVO>)
            }

            override fun onErrorOnProgramFetch(message: String) {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
            }

        }, isForce)

        if (programList != null) {
            categoryProgramAdapter!!.setNewData(programList as MutableList<CategoriesProgramVO>)
        }
    }

    companion object {

        fun newInstance()=SeriesFragment()
    }

}
