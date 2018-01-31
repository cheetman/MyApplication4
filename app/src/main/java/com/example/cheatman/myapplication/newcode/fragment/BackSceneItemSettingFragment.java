package com.example.cheatman.myapplication.newcode.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class BackSceneItemSettingFragment extends BaseFragment {


    public static BackSceneItemSettingFragment newInstance() {
        BackSceneItemSettingFragment fragment = new BackSceneItemSettingFragment();
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_automation;
    }



}
