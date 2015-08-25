package com.light.designsupportdemo.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.TextView;

import com.light.designsupportdemo.R;

/**
 * Created by light on 15/8/16.
 */
public class FirstFragment extends Fragment implements ViewTreeObserver.OnScrollChangedListener{

    private View rootView;

    private TextView mTitle;
    private TextView mContent;

    private FloatingActionButton mFab;

    private ScrollView mScrollView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_first, null);
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
        mScrollView = (ScrollView)view.findViewById(R.id.scrollView);

//        mScrollView.setOnTouchListener(new View.OnTouchListener() {
//            private int lastY = 0;
//            private int touchEventId = -9983761;
//            Handler handler = new Handler() {
//                @Override
//                public void handleMessage(Message msg) {
//                    super.handleMessage(msg);
//                    Log.v("aaaaa    ","aaaa");
//                    mFab.show();
//                    if (msg.what == touchEventId) {
//                      //  mFab.show();
//                    }
//                }
//            };
//
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    handler.sendEmptyMessage(touchEventId);
//                    mFab.hide();
//                }
//                return false;
//            }
//
//        });
        mScrollView.setOnTouchListener(new View.OnTouchListener() {
            private int lastY = 0;
            private int touchEventId = -9983761;
            Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    View scroller = (View) msg.obj;
                    mFab.show();
                    if (msg.what == touchEventId) {

                        if (lastY == scroller.getScrollY()) {
                            mFab.show();
                        } else {
                            handler.sendMessageDelayed(handler.obtainMessage(touchEventId, scroller), 5);
                            lastY = scroller.getScrollY();
                        }
                    }
                }
            };


            public boolean onTouch(View v, MotionEvent event) {
                mFab.hide();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.sendMessageDelayed(handler.obtainMessage(touchEventId, v), 5);
                }
                return false;
            }
        });

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onScrollChanged() {

    }
}
