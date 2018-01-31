package com.example.cheatman.myapplication.newcode.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.cheatman.myapplication.BackActivity;
import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;
import com.example.cheatman.myapplication.newcode.adapter.AutomationFavoriteListAdapter;
import com.example.cheatman.myapplication.newcode.adapter.SceneFavoriteListAdapter;
import com.example.cheatman.myapplication.newcode.database.AppDatabase;
import com.example.cheatman.myapplication.newcode.database.dao.FavoriteAutomationDao;
import com.example.cheatman.myapplication.newcode.database.entity.FavoriteAutomationEntity;
import com.example.cheatman.myapplication.newcode.database.entity.FavoriteSceneEntity;
import com.example.cheatman.myapplication.newcode.model.AutomationInfo;
import com.example.cheatman.myapplication.newcode.model.MyProjectInfo;
import com.example.cheatman.myapplication.newcode.model.SceneInfo;
import com.example.cheatman.myapplication.newcode.utils.Utils;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class BackAutomationFavoriteListFragment extends BaseFragment {

    @BindView(R.id.rv_automation)
    RecyclerView mRvAutomation;

    private List<AutomationInfo> mAutomationList;

    private AutomationFavoriteListAdapter mAutomationFavoriteListAdapter;

    public static BackAutomationFavoriteListFragment newInstance() {
        BackAutomationFavoriteListFragment fragment = new BackAutomationFavoriteListFragment();
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        // 取外来数据源
        mAutomationList = MyProjectInfo.getInstance().getAutomationList();

        mRvAutomation.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mAutomationFavoriteListAdapter = new AutomationFavoriteListAdapter(mActivity,mAutomationList);
        mRvAutomation.setAdapter(mAutomationFavoriteListAdapter);

        mAutomationFavoriteListAdapter.setOnItemClickListener(new AutomationFavoriteListAdapter.OnItemListener() {
            @Override
            public void onItemClick(View view, AutomationInfo info, int position) {
                BackAutomationItemShowFragment fragment = BackAutomationItemShowFragment.newInstance(info.getName());
                ((BackActivity)mActivity).addFragment(fragment);
            }

            @Override
            public void onToggleButtonCheckedChange(View view, AutomationInfo info, int position, boolean b) {
                String userName = "Admin";
                AppDatabase db = AppDatabase.getDatabase(Utils.getApp());
                FavoriteAutomationDao dao = db.favoriteAutomationDao();
                FavoriteAutomationEntity entity = dao.queryFirstByUser(userName, info.getName());
                if(b){
                    if(entity == null)
                        dao.insert(new FavoriteAutomationEntity("1",info.getName(),userName));
                }else{
                    if(entity != null)
                        dao.delete(entity);
                }
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_back_automation_list;
    }



}
