package com.example.cheatman.myapplication.newcode.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cheatman.myapplication.BackActivity;
import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;
import com.example.cheatman.myapplication.newcode.constant.ProjectConstants;

import butterknife.BindView;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class MainAutomationFragment extends BaseFragment {

    @BindView(R.id.btn_add)
    Button mBtnAdd;


    public static MainAutomationFragment newInstance() {
        MainAutomationFragment fragment = new MainAutomationFragment();
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mActivity,BackActivity.class);
                // Bundle携带数据
                Bundle bundle=new Bundle();
                bundle.putString(ProjectConstants.BUNDLE_KEY_FRAGMENT, BackAutomationFavoriteListFragment.class.getName());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_automation;
    }



}
