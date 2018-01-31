package com.example.cheatman.myapplication.newcode;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.View;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.constant.ProjectConstants;
import com.example.cheatman.myapplication.newcode.control.BackToolbar;
import com.example.cheatman.myapplication.newcode.temp.DialogHelper;

import butterknife.BindView;

/**
 * Created by Cheatman on 2017/12/6.
 */

public abstract class BackBaseActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    protected BackToolbar mToolbar;

    private ProgressDialog mWaitDialog;
    // 当前Fragment
    protected Fragment mFragmentNow;
    // 主占位Fragment
    protected Fragment mMainBackFragment;
    protected String mMainBackFragmentName;
    protected String mMainBackFragmentFullName;
    protected Class mMainBackFragmentClass;

    @Override
    protected void initWidget(Bundle savedInstanceState) {
        Bundle bundle = this.getIntent().getExtras();
        //接收name值
        mMainBackFragmentFullName = bundle.getString(ProjectConstants.BUNDLE_KEY_FRAGMENT);
        try {
            mMainBackFragmentClass = Class.forName(mMainBackFragmentFullName);
            mMainBackFragmentName = mMainBackFragmentClass.getSimpleName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(savedInstanceState != null){
            for(Fragment item : getSupportFragmentManager().getFragments()){
                if(!item.isHidden()){
                    mFragmentNow = item;
                }
            }
        }else{
            setSupportActionBar(mToolbar);
        }

        // 返回键
        mToolbar.setMainTitleRightOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popFragmentOrBack();
            }
        });

        // 入出栈监听
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Log.w("addOnBackStack","触发");
                // 出栈情况 更新mFragmentNow
                if(getSupportFragmentManager().getBackStackEntryCount() == 0){
                    mFragmentNow = getSupportFragmentManager().findFragmentByTag(mMainBackFragmentName);
                }else {
                    for (Fragment item : getSupportFragmentManager().getFragments()) {
                        if (!item.isHidden()) {
                            mFragmentNow = item;
                        }
                    }
                }
                modifyToolBarTitle();
            }
        });

    }

    /**
     *  增加并打开Fragment
     * @param fragment
     */
    public void  addFragment (Fragment fragment) {
        int frameLayoutId = R.id.fl_content;
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            // 设置首页
            if(fragment.getClass().getSimpleName().equals(mMainBackFragmentName)){
                // 不会发生 这个fragment一开始就创建
                if (fragment.isAdded()) {
                    /*if (mFragment != null) {
                        transaction.hide(mFragment).show(fragment);
                    } else {
                        transaction.show(fragment);
                    }*/
                }
                else {
                    // 栈里面应该是空的
                    // 不会发生 这个fragment一开始就创建
                    if (mFragmentNow != null) {
                        // transaction.hide(mFragment).add(frameLayoutId, fragment,fragment.getClass().getSimpleName());
                    } else {
                        transaction.add(frameLayoutId, fragment,fragment.getClass().getSimpleName());
                    }
                }
            }
            // 设置其他页
            else{
                // 不会发生 只有上一个画面能打开他
                if (fragment.isAdded()) {
                    /*if (mFragment != null) {
                        transaction.hide(mFragment).show(fragment);
                    } else {
                        transaction.show(fragment);
                    }*/
                }
                // 放入栈 显示
                else {
                    if (mFragmentNow != null) {
                        transaction.hide(mFragmentNow).add(frameLayoutId, fragment,fragment.getClass().getSimpleName());
                        // 入栈
                        transaction.addToBackStack(null);
                    }
                    // 不会发生 至少有首页fragment
                    else {
                        //transaction.add(frameLayoutId, fragment,fragment.getClass().getSimpleName());
                    }
                }
            }
            mFragmentNow = fragment;
            transaction.commit();
        }
    }


    /**
     * 弹出Fragment
     */
    public void popFragment() {
        getSupportFragmentManager().popBackStackImmediate();
    }

    /**
     *  判断Fragment是否存在
     */
    public boolean existFragment() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 0){
            return false;
        }else {
            return true;
        }
    }

    /**
     *  弹出Fragment或退出Activity
     */
    public void popFragmentOrBack() {
        if(existFragment()){
            popFragment();
        }else{
            finish();
        }
    }


    protected void modifyToolBarTitle(){}

    /**
     *  物理返回键事件
     */
    @Override
    public void onBackPressed() {
        popFragmentOrBack();
    }

    /**
     *  更新Toolbar标题
     */
    protected void modifyToolbarTitle(){

    }

    protected void showLoadingDialog(String message) {
        if (mWaitDialog == null) {
            mWaitDialog = DialogHelper.getProgressDialog(this, true);
        }
        mWaitDialog.setMessage(message);
        mWaitDialog.show();
    }

    protected void dismissLoadingDialog() {
        if (mWaitDialog == null) return;
        mWaitDialog.dismiss();
    }
}
