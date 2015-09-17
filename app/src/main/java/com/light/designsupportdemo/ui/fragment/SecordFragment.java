package com.light.designsupportdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.light.designsupportdemo.R;
import com.light.designsupportdemo.ViewPagerAdapter;

/**
 * Created by light on 15/8/16.
 */
public class SecordFragment extends Fragment {

    private View rootView;

    private ViewPager mViewPager;

    private TabLayout mTabLayout;

    private ViewPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_secord, null);
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

        mViewPager = (ViewPager)view.findViewById(R.id.viewpager);
        mTabLayout = (TabLayout)view.findViewById(R.id.layout_tab);
        adapter = new ViewPagerAdapter(
                getActivity().getSupportFragmentManager(), getActivity());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for(int i=0;i<mTabLayout.getTabCount();i++){
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i,tab));
        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
