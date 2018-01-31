package com.example.cheatman.myapplication.newcode.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;
import com.example.cheatman.myapplication.newcode.adapter.SettingDetailAdapter;

import butterknife.BindView;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class SettingDeviceFragment extends BaseFragment {


    @BindView(R.id.tv_oscsite)
    TextView mTvVersionName;


    public static SettingDeviceFragment newInstance() {
        SettingDeviceFragment fragment = new SettingDeviceFragment();
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTvVersionName.setText("33333333333333333");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }


}
