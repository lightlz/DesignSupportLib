package com.light.designsupportdemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.light.designsupportdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ViewpaperFragment extends Fragment  {

    private TextView tvViewpager;

    private static final String INDEX = "index";

    private int mPage;

    private ListView listView;

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

//        tvViewpager = (TextView) view.findViewById(R.id.tv_viewpager);
//        tvViewpager.setText("Tab " + mPage);

//        listView = (ListView)view.findViewById(R.id.lv);
//        listView.setAdapter(new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, getData()));

    }

    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        for(int i=0;i<30;i++){
            data.add("Tab " + mPage);
        }
        return  data;
    }

}
