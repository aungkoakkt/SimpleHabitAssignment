package com.me.simplehabit.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.me.simplehabit.fragments.OnTheGoFragment
import com.me.simplehabit.fragments.SeriesFragment
import com.me.simplehabit.fragments.TeachersFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OnTheGoFragment.newInstance()
            1 -> SeriesFragment.newInstance()
            else -> TeachersFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "ON THE GO"
            1 -> "SERIES"
            else -> "TEACHERS"
        }
    }
}
