package com.example.cheatman.myapplication.newcode.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cheatman.myapplication.BackActivity;
import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;
import com.example.cheatman.myapplication.newcode.adapter.AutomationFavoriteListAdapter;
import com.example.cheatman.myapplication.newcode.adapter.AutomationSettingListAdapter;
import com.example.cheatman.myapplication.newcode.adapter.SettingDetailAdapter;
import com.example.cheatman.myapplication.newcode.database.AppDatabase;
import com.example.cheatman.myapplication.newcode.database.dao.FavoriteAutomationDao;
import com.example.cheatman.myapplication.newcode.database.entity.FavoriteAutomationEntity;
import com.example.cheatman.myapplication.newcode.model.AutomationInfo;
import com.example.cheatman.myapplication.newcode.model.MyProjectInfo;
import com.example.cheatman.myapplication.newcode.utils.Utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class SettingAutomationFragment extends BaseFragment {

    public static SettingAutomationFragment newInstance() {
        SettingAutomationFragment fragment = new SettingAutomationFragment();
        return fragment;
    }
    @BindView(R.id.rv_automation)
    RecyclerView mRvAutomation;

    private List<AutomationInfo> mAutomationList;

    private AutomationSettingListAdapter mAutomationSettingListAdapter;


    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        // 取外来数据源
        mAutomationList = MyProjectInfo.getInstance().getAutomationList();


        mRvAutomation.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mAutomationSettingListAdapter = new AutomationSettingListAdapter(mActivity,mAutomationList);
        mRvAutomation.setAdapter(mAutomationSettingListAdapter);

        mAutomationSettingListAdapter.setOnItemClickListener(new AutomationSettingListAdapter.OnItemListener() {
            @Override
            public void onItemClick(View view, AutomationInfo info, int position) {
                BackAutomationItemShowFragment fragment = BackAutomationItemShowFragment.newInstance(info.getName());
                ((BackActivity)mActivity).addFragment(fragment);
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting_automation;
    }


}
