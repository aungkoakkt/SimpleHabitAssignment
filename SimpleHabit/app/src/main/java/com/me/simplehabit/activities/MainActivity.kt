package com.me.simplehabit.activities

import android.os.Bundle
import com.me.simplehabit.R
import com.me.simplehabit.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var mainViewPagerAdapter: MainViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        vpActivityMain!!.adapter = mainViewPagerAdapter
        vpActivityMain!!.currentItem = 1
        tlActivityMain!!.setupWithViewPager(vpActivityMain)
    }
}
