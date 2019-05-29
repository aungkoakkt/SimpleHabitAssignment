package com.me.simplehabit.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.me.simplehabit.R
import com.me.simplehabit.adapters.SessionAdapter
import com.me.simplehabit.data.vos.CategoriesProgramVO
import com.me.simplehabit.data.vos.CurrentProgramVO
import com.me.simplehabit.data.vos.SessionVO
import com.me.simplehabit.mvp.presenters.impl.DetailPresenter
import com.me.simplehabit.mvp.views.DetailView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity(),DetailView {

    private lateinit var mDetailPresenter: DetailPresenter
    private val sessionAdapter: SessionAdapter = SessionAdapter()
    private var position:Int = 0


    companion object {

        const val PROGRAM = "program"
        const val POSITION = "position"
        const val CATEGORY_ID = "category_id"

        fun newIntent(context: Context): Intent {
            return Intent(context, DetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(tbActivityDetail)
        mDetailPresenter=ViewModelProviders.of(this).get(DetailPresenter::class.java)
        mDetailPresenter.initPresenter(this)

        rvActivityDetailSession.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        rvActivityDetailSession.adapter = sessionAdapter

        val intent = intent
        val program = intent.getStringExtra(PROGRAM)

        if (program == "current") {

            mDetailPresenter.onUIReady(this,program)

        } else {

            position = intent.getIntExtra(POSITION, 0)
            val categoryId = intent.getStringExtra(CATEGORY_ID)
            mDetailPresenter.onUIReady(this,program,categoryId)
        }
    }


    override fun displayCurrentProgram(currentProgram: CurrentProgramVO) {

        tvActivityDetailDescription.text = currentProgram.description
        colpActivityDetail.title = currentProgram.title
        sessionAdapter.setNewData(currentProgram.sessions as MutableList<SessionVO>)

    }

    override fun displayCategoryProgram(categoryProgram: CategoriesProgramVO) {

        tvActivityDetailDescription.text = categoryProgram.programs[position].description
        colpActivityDetail.title = categoryProgram.programs[position].title
        sessionAdapter.setNewData(categoryProgram.programs[position].sessions as MutableList<SessionVO>)

    }

    override fun displayNoDataMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun exitFromScreen() {
        finish()
    }

    override fun getMyContext(): Context {
        return this
    }
}
