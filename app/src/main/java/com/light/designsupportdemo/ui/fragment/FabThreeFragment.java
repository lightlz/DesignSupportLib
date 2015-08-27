package com.light.designsupportdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.konifar.fab_transformation.FabTransformation;
import com.light.designsupportdemo.R;

/**
 * Created by light on 15/8/25.
 */
public class FabThreeFragment extends Fragment implements View.OnClickListener{

    private View rootView;

    private FloatingActionButton mFab;

    private View mLayout;

    private RelativeLayout mAddLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_fab_3, null);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(rootView);
    }

    private void initView(View view){


        mFab = (FloatingActionButton)view.findViewById(R.id.fab);
        mFab.setOnClickListener(this);

        mLayout = view.findViewById(R.id.layout);
        mLayout.setOnClickListener(this);

        mAddLayout = (RelativeLayout)view.findViewById(R.id.addLayout);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.fab:
                if (mFab.getVisibility() == View.VISIBLE) {
                    FabTransformation.with(mFab).transformTo(mAddLayout);
                }
                break;
            case R.id.layout:
                if (mFab.getVisibility() != View.VISIBLE) {
                    FabTransformation.with(mFab).transformFrom(mAddLayout);
                }
                break;
        }
    }

}
