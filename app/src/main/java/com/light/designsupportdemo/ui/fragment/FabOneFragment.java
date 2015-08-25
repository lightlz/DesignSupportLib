package com.light.designsupportdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.TextView;

import com.konifar.fab_transformation.FabTransformation;
import com.light.designsupportdemo.R;

/**
 * Created by light on 15/8/25.
 */
public class FabOneFragment extends Fragment implements View.OnClickListener,ViewTreeObserver.OnScrollChangedListener{

    private View rootView;

    private TextView mTitle;
    private TextView mContent;

    private FloatingActionButton mFab;

    private ScrollView mScrollView;

    private View mFooter;

    private boolean isTransforming;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_fab_1, null);
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

        mTitle = (TextView)view.findViewById(R.id.tv_title);
        mContent = (TextView)view.findViewById(R.id.tv_content);

        mTitle.setText(getActivity().getString(R.string.title));
        mContent.setText(getActivity().getString(R.string.content)+getActivity().getString(R.string.content));

        mFab = (FloatingActionButton)view.findViewById(R.id.fab);
        mFab.setOnClickListener(this);
        mScrollView = (ScrollView)view.findViewById(R.id.scrollView);
        mScrollView.getViewTreeObserver().addOnScrollChangedListener(this);

        mFooter = view.findViewById(R.id.toolbar_footer);


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
                    FabTransformation.with(mFab).transformTo(mFooter);
                }
            break;
        }
    }

    @Override
    public void onScrollChanged() {
        if (mFab.getVisibility() != View.VISIBLE && !isTransforming) {
            FabTransformation.with(mFab)
                    .setListener(new FabTransformation.OnTransformListener() {
                        @Override
                        public void onStartTransform() {
                            isTransforming = true;
                        }
                        @Override
                        public void onEndTransform() {
                            isTransforming = false;
                        }
                    })
                    .transformFrom(mFooter);
        }
    }
}
