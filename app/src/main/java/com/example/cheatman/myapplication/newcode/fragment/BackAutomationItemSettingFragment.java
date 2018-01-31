package com.example.cheatman.myapplication.newcode.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class BackAutomationItemSettingFragment extends BaseFragment {


    public static BackAutomationItemSettingFragment newInstance() {
        BackAutomationItemSettingFragment fragment = new BackAutomationItemSettingFragment();
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
