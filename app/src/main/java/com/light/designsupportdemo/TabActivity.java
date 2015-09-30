package com.light.designsupportdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by light on 15/9/29.
 */
public class TabActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private TabLayout mTabLayout;

    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        initView();
    }

    private void initView(){

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Tab");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mTabLayout = (TabLayout)findViewById(R.id.layout_tab);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);



    }
}
