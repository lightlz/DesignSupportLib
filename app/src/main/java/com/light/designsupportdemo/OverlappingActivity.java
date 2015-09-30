package com.light.designsupportdemo;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by light on 15/9/29.
 */
public class OverlappingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overlapping);

        initView();
    }
    //auto-find view by id
    private void initView(){
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar.setTitle("Overlapping");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Overlapping");

    }



}
