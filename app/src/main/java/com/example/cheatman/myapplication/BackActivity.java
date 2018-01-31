package com.example.cheatman.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.cheatman.myapplication.newcode.BackBaseActivity;
import com.example.cheatman.myapplication.newcode.fragment.BackAutomationFavoriteListFragment;
import com.example.cheatman.myapplication.newcode.fragment.BackAutomationItemShowFragment;
import com.example.cheatman.myapplication.newcode.fragment.BackSceneFavoriteListFragment;
import com.example.cheatman.myapplication.newcode.fragment.BackSceneItemShowFragment;
import com.example.cheatman.myapplication.newcode.utils.ToastUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BackActivity extends BackBaseActivity {


    @Override
    protected int getContentView() {
        return R.layout.activity_back;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        if(getSupportFragmentManager().getFragments().size() == 0){
            try {
                Method method = mMainBackFragmentClass.getMethod("newInstance");
                Object obj = method.invoke(null);
                mMainBackFragment = (Fragment) obj;
            } catch (NoSuchMethodException e) {
                // 不应该进入
                ToastUtils.showLong("请先在Fragment中定义newInstance静态方法。");
                e.printStackTrace();
            } catch (InvocationTargetException | IllegalAccessException e) {
                // 不应该进入
                e.printStackTrace();
            }
            addFragment(mMainBackFragment);
        }else{
            mMainBackFragment = findFragmentByTag(mMainBackFragmentName);
        }

        // 初始化更新标题
        modifyToolBarTitle();
    }

    /**
     * 修改Toolbar标题
     */
    @Override
    public void modifyToolBarTitle(){
            if(mFragmentNow instanceof BackAutomationFavoriteListFragment){
                mToolbar.setMainTitle(R.string.title_automation);
            }else if(mFragmentNow instanceof BackSceneFavoriteListFragment){
                mToolbar.setMainTitle(R.string.title_scene);
            }else if(mFragmentNow instanceof BackSceneItemShowFragment){
                mToolbar.setMainTitle(mFragmentNow.getArguments().getString("sceneName"));
            }else if(mFragmentNow instanceof BackAutomationItemShowFragment){
                mToolbar.setMainTitle(mFragmentNow.getArguments().getString("automationName"));
            }else{

            }
    }


        public  <T> T getFragment(){
            return (T)mMainBackFragment;
        }

}
