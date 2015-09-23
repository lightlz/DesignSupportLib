package com.light.designsupportdemo.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.light.designsupportdemo.R;

/**
 * Created by light on 15/8/16.
 */
public class ThirdFragment extends Fragment {

    private View rootView;

    private TextInputLayout textInputLayout;
    private TextInputLayout textInputLayout1;

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_third, null);
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

        textInputLayout = (TextInputLayout)view.findViewById(R.id.layout_textinput);
        textInputLayout1 = (TextInputLayout)view.findViewById(R.id.layout_textinput1);
        textView = (TextView)view.findViewById(R.id.tv_count);
        setupTextChangeListener();
        setupTextChangeListener1();
    }

    private void setupTextChangeListener(){

        textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int count) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                if (!charSequence.toString().contains("@")) {
                    textInputLayout.setError("Please fill in the email");
                    textInputLayout.setErrorEnabled(true);
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void setupTextChangeListener1(){

        textInputLayout1.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int count) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                int maxCount = 3;
                int sum = charSequence.toString().length();
                textView.setText(sum+"/"+maxCount);
                if (sum > maxCount){
                    textInputLayout1.setErrorEnabled(true);
                    textView.setTextColor(Color.RED);
                }else{
                    textView.setTextColor(getActivity().getResources().getColor(R.color.secondary_text));
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
