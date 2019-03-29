package com.me.simplehabit.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.me.simplehabit.R;
import com.me.simplehabit.adapters.MainViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tv_activity_main_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.tl_activity_main) TabLayout tabLayout;
    @BindView(R.id.vp_activity_main) ViewPager viewPager;

    private MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainViewPagerAdapter =new MainViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainViewPagerAdapter);
        viewPager.setCurrentItem(1);
        tabLayout.setupWithViewPager(viewPager);
    }
}
