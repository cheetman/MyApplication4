package com.example.cheatman.myapplication.newcode.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.cheatman.myapplication.BackActivity;
import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;
import com.example.cheatman.myapplication.newcode.adapter.SceneFavoriteListAdapter;
import com.example.cheatman.myapplication.newcode.model.MyProjectInfo;
import com.example.cheatman.myapplication.newcode.model.SceneInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class BackSceneFavoriteListFragment extends BaseFragment {

    @BindView(R.id.rv_scene)
    RecyclerView mRvScene;

    // 绑定数据源
    private List<SceneInfo> mSceneList;

    // adapter
    private SceneFavoriteListAdapter mSceneFavoriteListAdapter;

    public static BackSceneFavoriteListFragment newInstance() {
        BackSceneFavoriteListFragment fragment = new BackSceneFavoriteListFragment();
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        // 取外来数据源
        mSceneList = MyProjectInfo.getInstance().getSceneList();

        mRvScene.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mSceneFavoriteListAdapter = new SceneFavoriteListAdapter(mActivity,mSceneList);
        mRvScene.setAdapter(mSceneFavoriteListAdapter);


        mSceneFavoriteListAdapter.setOnItemClickListener(new SceneFavoriteListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, SceneInfo info, int position) {
                BackSceneItemShowFragment fragment = BackSceneItemShowFragment.newInstance(info.getName());
                ((BackActivity)mActivity).addFragment(fragment);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_back_scene_list;
    }



}