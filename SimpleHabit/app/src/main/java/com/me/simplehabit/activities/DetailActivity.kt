package com.me.simplehabit.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.me.simplehabit.R
import com.me.simplehabit.adapters.SessionAdapter
import com.me.simplehabit.data.models.CategoryProgramModel
import com.me.simplehabit.data.models.CategoryProgramModelImpl
import com.me.simplehabit.data.models.CurrentProgramModel
import com.me.simplehabit.data.models.CurrentProgramModelImpl
import com.me.simplehabit.data.vos.SessionVO
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    private lateinit var currentProgramModel: CurrentProgramModel
    private lateinit var categoryProgramModel: CategoryProgramModel
    private val sessionAdapter: SessionAdapter = SessionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(tbActivityDetail)

        rvActivityDetailSession.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        rvActivityDetailSession.adapter = sessionAdapter

        val intent = intent
        val program = intent.getStringExtra(PROGRAM)

        if (program == "current") {

            currentProgramModel = CurrentProgramModelImpl

            val currentProgram = currentProgramModel.getCurrentProgram()

            tvActivityDetailDescription.text = currentProgram.description
            colpActivityDetail.title = currentProgram.title
            sessionAdapter.setNewData(currentProgram.sessions as MutableList<SessionVO>)

        } else {

            val position = intent.getIntExtra(POSITION, 0)
            val categoryId = intent.getStringExtra(CATEGORY_ID)

            categoryProgramModel = CategoryProgramModelImpl

            val categoryList = categoryProgramModel.getCategoriesAndProgramById(categoryId)

            tvActivityDetailDescription.text = categoryList.programs[position].description
            colpActivityDetail.title = categoryList.programs[position].title

            sessionAdapter.setNewData(categoryList.programs[position].sessions as MutableList<SessionVO>)

        }

    }

    companion object {

        const val PROGRAM = "program"
        const val POSITION = "position"
        const val CATEGORY_ID = "category_id"

        fun newIntent(context: Context): Intent {
            return Intent(context, DetailActivity::class.java)
        }
    }
}
