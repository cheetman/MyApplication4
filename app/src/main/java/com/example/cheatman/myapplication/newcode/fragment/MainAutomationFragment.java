package com.example.cheatman.myapplication.newcode.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.example.cheatman.myapplication.BackActivity;
import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;
import com.example.cheatman.myapplication.newcode.constant.ProjectConstants;
import com.example.cheatman.myapplication.newcode.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class MainAutomationFragment extends BaseFragment {

    public static MainAutomationFragment newInstance() {
        MainAutomationFragment fragment = new MainAutomationFragment();
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_automation;
    }

    @OnClick(R.id.btn_add)
    public void showFavoriteView(Button button) {
        Intent intent =new Intent(mActivity,BackActivity.class);
        // Bundle携带数据
        Bundle bundle=new Bundle();
        bundle.putString(ProjectConstants.BUNDLE_KEY_FRAGMENT, BackAutomationFavoriteListFragment.class.getName());
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
