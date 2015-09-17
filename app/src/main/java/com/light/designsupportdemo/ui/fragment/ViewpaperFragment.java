package com.light.designsupportdemo.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

import com.light.designsupportdemo.R;

public class ViewpaperFragment extends Fragment  {

    private TextView tvViewpager;

    private static final String INDEX = "index";

    private int mPage;

    public static ViewpaperFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(INDEX, page);
        ViewpaperFragment fragment = new ViewpaperFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(INDEX);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.viewpaper, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvViewpager = (TextView) view.findViewById(R.id.tv_viewpager);
        tvViewpager.setText("Tab " + mPage);
    }

}
