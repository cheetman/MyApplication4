package com.example.cheatman.myapplication.newcode;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheatman.myapplication.R;

import butterknife.ButterKnife;

/**
 * Created by Cheatman on 2017/12/6.
 */

public abstract  class BaseFragment extends Fragment {

    protected Activity mActivity;
    protected LayoutInflater mInflater;

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected abstract int getLayoutId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity)context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mInflater = inflater;
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    protected  <T> T getActivity(Class<T> c){
        return (T)mActivity;
    }


}