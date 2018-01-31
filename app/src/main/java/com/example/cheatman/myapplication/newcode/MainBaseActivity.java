package com.example.cheatman.myapplication.newcode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.control.MainToolbar;
import com.example.cheatman.myapplication.newcode.fragment.SettingMainFragment;

import butterknife.BindView;

/**
 * Created by Cheatman on 2017/12/6.
 */

public abstract class MainBaseActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    protected MainToolbar mToolbar;

    private final String mPackageNameUmeng = this.getClass().getName();
    // 当前SettingFragment
    private Fragment mSettingFragmentNow;


    @Override
    protected void initWidget(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            for(Fragment item : getSupportFragmentManager().getFragments()){
                if(!item.isHidden() && item.getTag().indexOf("android:switcher:") == -1){
                    mSettingFragmentNow = item;
                }
            }
        }else{
            setSupportActionBar(mToolbar);
        }
    }

    /**
     *  打开SettingFragment
     * @param fragment
     */
    public void  addSettingFragment (Fragment fragment) {
        int frameLayoutId = R.id.fl_setting_content;
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            // 设置首页
            if(fragment instanceof SettingMainFragment){
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
                    if (mSettingFragmentNow != null) {
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
                    if (mSettingFragmentNow != null) {
                        transaction.hide(mSettingFragmentNow).add(frameLayoutId, fragment,fragment.getClass().getSimpleName());
                        // 入栈
                        transaction.addToBackStack(null);
                        onEnterSettingNext();
                    }
                    // 不会发生 至少有首页fragment
                    else {
                        //transaction.add(frameLayoutId, fragment,fragment.getClass().getSimpleName());
                    }
                }
            }
            mSettingFragmentNow = fragment;
            transaction.commit();
        }
    }


    /**
     * 弹出SettingFragment
     */
    public void popSettingFragment() {
        getSupportFragmentManager().popBackStackImmediate();
        if(getSupportFragmentManager().getBackStackEntryCount() == 0){
            mSettingFragmentNow = getSupportFragmentManager().findFragmentByTag(SettingMainFragment.class.getSimpleName());
            onBackSettingMain();
        }else {
            for (Fragment item : getSupportFragmentManager().getFragments()) {
                if (!item.isHidden() && item.getTag().indexOf("android:switcher:") == -1) {
                    mSettingFragmentNow = item;
                }
            }
        }
    }

    /**
     * 存在SettingFragment(Main不算)
     */
    public boolean existSettingFragment() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 0){
return false;
        }else {
return true;
        }
    }

    /**
     * 返回设置首页
     */
    protected void onBackSettingMain(){

    }



    protected void onEnterSettingNext(){

    }




}
