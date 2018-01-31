package com.example.cheatman.myapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.cheatman.myapplication.newcode.MainBaseActivity;
import com.example.cheatman.myapplication.newcode.adapter.HomeFragmentPageAdapter;
import com.example.cheatman.myapplication.newcode.application.MainApplication;
import com.example.cheatman.myapplication.newcode.constant.ProjectConstants;
import com.example.cheatman.myapplication.newcode.control.CustomDialog;
import com.example.cheatman.myapplication.newcode.fragment.MainAutomationFragment;
import com.example.cheatman.myapplication.newcode.fragment.MainHomeFragment;
import com.example.cheatman.myapplication.newcode.fragment.MainSceneFragment;
import com.example.cheatman.myapplication.newcode.fragment.MainScheduleFragment;
import com.example.cheatman.myapplication.newcode.fragment.SettingMainFragment;
import com.example.cheatman.myapplication.newcode.utils.ImageUtils;

import butterknife.BindView;


// 记录： 1 翻转/回收后activity重建，dialog消失后未重建。
//           2 翻转之后当currentpage大于1时会进入onPageSelected，不确定内存回收的情况是否一致。
//          3 翻转/回收后 Adaper变量仍然保留。



public class MainActivityV extends MainBaseActivity {

    @BindView(R.id.vp_content)
    ViewPager mViewPager;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.ll_nav_back)
    LinearLayout mLlNavBack;

    @BindView(R.id.tv_setting_back)
    Button tvSettingBack;

    // 当前页
    private int currentPage = 0;
    // Fragment：主页
    private MainHomeFragment mMainHomeFragment;
    // Fragment：主页-日程
    private MainScheduleFragment mMainScheduleFragment;
    // Fragment：主页-场景
    private MainSceneFragment mMainSceneFragment;
    // Fragment：主页-自动化
    private MainAutomationFragment mMainAutomationFragment;
    // Fragment：设置菜单-主页
    public SettingMainFragment mSettingMainFragment;

    // 以下fragment如果没有打开过则为null

    // Fragment：设置菜单-网络
    //private SettingNetWorkFragment mSettingNetWorkFragment;
    // Fragment：设置菜单-场景
    //private SettingSceneFragment mSettingSceneFragment;
    // Fragment：设置菜单-自动化
    //private SettingAutomationFragment mSettingAutomationFragment;
    // Fragment：设置菜单-设备
    //private SettingDeviceFragment mSettingDeviceFragment;
    // Fragment：设置菜单-房间
    //public SettingRoomFragment mSettingRoomFragment;
    // Fragment：设置菜单-用户权限
    //private SettingUserFragment mSettingUserFragment;
    // Fragment：设置菜单-固件升级
    //private SettingGatewayFirmFragment mSettingGatewayFirmFragment;



    @Override
    protected int getContentView() {
        return R.layout.activity_main_v;
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        // 第一次打开的情况
        if(getSupportFragmentManager().getFragments().size() == 0){

            mMainHomeFragment = MainHomeFragment.newInstance();
            mMainScheduleFragment = MainScheduleFragment.newInstance();
            mMainSceneFragment = MainSceneFragment.newInstance();
            mMainAutomationFragment = MainAutomationFragment.newInstance();
            mSettingMainFragment = SettingMainFragment.newInstance();
            addSettingFragment(mSettingMainFragment);
        }else{
            mSettingMainFragment = (SettingMainFragment)findFragmentByTag(SettingMainFragment.class.getSimpleName());
            Fragment fragment1= findFragmentByTag(ProjectConstants.FRAGMENT_DEFAULT_TAG_PREFIX+R.id.vp_content+":"+ 0);
            Fragment fragment2 = findFragmentByTag(ProjectConstants.FRAGMENT_DEFAULT_TAG_PREFIX+R.id.vp_content+":"+ 1);
            Fragment fragment3 = findFragmentByTag(ProjectConstants.FRAGMENT_DEFAULT_TAG_PREFIX+R.id.vp_content+":"+ 2);
            Fragment fragment4 = findFragmentByTag(ProjectConstants.FRAGMENT_DEFAULT_TAG_PREFIX+R.id.vp_content+":"+ 3);
            mMainHomeFragment = fragment1 == null ? MainHomeFragment.newInstance() : (MainHomeFragment) fragment1;
            mMainScheduleFragment = fragment2 == null ? MainScheduleFragment.newInstance() : (MainScheduleFragment) fragment2;
            mMainSceneFragment = fragment3 == null ? MainSceneFragment.newInstance() : (MainSceneFragment) fragment3;
            mMainAutomationFragment = fragment4 == null ? MainAutomationFragment.newInstance() : (MainAutomationFragment) fragment4;
            if(existSettingFragment()){
                mLlNavBack.setVisibility(View.VISIBLE);
            }
        }
        HomeFragmentPageAdapter adapter = new HomeFragmentPageAdapter(getSupportFragmentManager(), null,mMainHomeFragment,mMainScheduleFragment,mMainSceneFragment,mMainAutomationFragment);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);

        // 设置ViewPager滑动事件
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                currentPage = position;
                switch (currentPage){
                    case 0:
                        mToolbar.setMainTitle(R.string.title_home);
                        break;
                    case 1:
                        mToolbar.setMainTitle(R.string.title_main_schedule);
                        break;
                    case 2:
                        mToolbar.setMainTitle(R.string.title_scene);
                        break;
                    case 3:
                        mToolbar.setMainTitle(R.string.title_automation);
                        break;
                    default:
                        mToolbar.setMainTitle(R.string.title_home);
                }
            }
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
        });

        // 设置标题右上角按钮事件
        mToolbar.setMainTitleRightOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
                    mDrawerLayout.closeDrawer(GravityCompat.END);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.END);
                }
            }
        });


        // 设置设置菜单返回事件
        tvSettingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popSettingFragment();
            }
        });

        // 设置侧拉菜单展开/收起事件
        mDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        });



        /*Bitmap bmp = ImageUtils.getBitmap(R.drawable.bitmap_background_default);*/
        //bmp =ImageUtils.renderScriptBlur(bmp,25);
        //bmp =ImageUtils.stackBlur(bmp,25);
        /*bmp =ImageUtils.fastBlur(bmp,1,25);
        Drawable drawable = ImageUtils.bitmap2Drawable(bmp);
        mDrawerLayout.setBackground(drawable);*/
    };

    // 点击手机返回键事件
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            if(existSettingFragment()){
                popSettingFragment();
            }else{
                mDrawerLayout.closeDrawer(GravityCompat.END);
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onBackSettingMain(){
        mLlNavBack.setVisibility(View.GONE);
    }

    @Override
    protected void onEnterSettingNext(){
        mLlNavBack.setVisibility(View.VISIBLE);
    }


}
