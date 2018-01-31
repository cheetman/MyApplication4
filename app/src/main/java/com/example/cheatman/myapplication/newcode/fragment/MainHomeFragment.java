package com.example.cheatman.myapplication.newcode.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class MainHomeFragment extends BaseFragment {


    public static MainHomeFragment newInstance() {
        MainHomeFragment fragment = new MainHomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_home;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {



    }

    private  void initData(){

    }


}