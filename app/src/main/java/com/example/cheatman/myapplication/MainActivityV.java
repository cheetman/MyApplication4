package com.example.cheatman.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.cheatman.myapplication.newcode.MainBaseActivity;
import com.example.cheatman.myapplication.newcode.adapter.HomeFragmentPageAdapter;
import com.example.cheatman.myapplication.newcode.constant.ProjectConstants;
import com.example.cheatman.myapplication.newcode.fragment.MainAutomationFragment;
import com.example.cheatman.myapplication.newcode.fragment.MainHomeFragment;
import com.example.cheatman.myapplication.newcode.fragment.MainSceneFragment;
import com.example.cheatman.myapplication.newcode.fragment.MainScheduleFragment;
import com.example.cheatman.myapplication.newcode.fragment.SettingMainFragment;
import com.xuhao.android.libsocket.sdk.ConnectionInfo;
import com.xuhao.android.libsocket.sdk.OkSocket;
import com.xuhao.android.libsocket.sdk.OkSocketOptions;
import com.xuhao.android.libsocket.sdk.SocketActionAdapter;
import com.xuhao.android.libsocket.sdk.bean.ISendable;
import com.xuhao.android.libsocket.sdk.bean.OriginalData;
import com.xuhao.android.libsocket.sdk.connection.IConnectionManager;
import com.xuhao.android.libsocket.sdk.protocol.IHeaderProtocol;

import java.nio.ByteOrder;

import butterknife.BindView;

import static android.widget.Toast.LENGTH_SHORT;


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

    IConnectionManager mManager = null;


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


        //连接参数设置(IP,端口号),这也是一个连接的唯一标识,不同连接,该参数中的两个值至少有其一不一样
        ConnectionInfo info = new ConnectionInfo("192.168.40.109", 8080);
        //调用OkSocket,开启这次连接的通道,拿到通道Manager
        mManager = OkSocket.open(info);
        //注册Socket行为监听器,SocketActionAdapter是回调的Simple类,其他回调方法请参阅类文档
        mManager.registerReceiver(new SocketActionAdapter() {
            @Override
            public void onSocketConnectionSuccess(Context context, ConnectionInfo info, String action) {
                Toast.makeText(context, "连接成功", LENGTH_SHORT).show();
                //此处也可将ConnectManager保存成成员变量使用.
                if(mManager != null){
                    mManager.send(new TestSendData());
                }
                //以上两种方法选择其一,成员变量的方式请注意判空

            }

            @Override
            public void onSocketReadResponse(Context context, ConnectionInfo info, String action, OriginalData data) {
                super.onSocketReadResponse(context, info, action, data);
            }

            @Override
            public void onSocketWriteResponse(Context context, ConnectionInfo info, String action, ISendable data) {
                super.onSocketWriteResponse(context, info, action, data);
            }
        });



//设置自定义解析头
        OkSocketOptions.Builder okOptionsBuilder = new OkSocketOptions.Builder(mManager.getOption());
        okOptionsBuilder.setHeaderProtocol(new IHeaderProtocol() {
            @Override
            public int getHeaderLength() {
                //返回自定义的包头长度,框架会解析该长度的包头
                return 0;
            }

            @Override
            public int getBodyLength(byte[] header, ByteOrder byteOrder) {
                //从header(包头数据)中解析出包体的长度,byteOrder是你在参配中配置的字节序,可以使用ByteBuffer比较方便解析
                return 0;
            }
        });
//将新的修改后的参配设置给连接管理器
        mManager.option(okOptionsBuilder.build());

        //调用通道进行连接
        mManager.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

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
