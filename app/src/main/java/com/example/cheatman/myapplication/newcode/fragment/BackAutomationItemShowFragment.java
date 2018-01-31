package com.example.cheatman.myapplication.newcode.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;
import com.example.cheatman.myapplication.newcode.adapter.AutomationItemShowWhatAdapter;
import com.example.cheatman.myapplication.newcode.adapter.SceneItemShowAdapter;
import com.example.cheatman.myapplication.newcode.model.AutomationInfo;
import com.example.cheatman.myapplication.newcode.model.DeviceInfoAll;
import com.example.cheatman.myapplication.newcode.model.MyProjectInfo;
import com.example.cheatman.myapplication.newcode.model.SceneInfo;
import com.example.cheatman.myapplication.newcode.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class BackAutomationItemShowFragment extends BaseFragment {

    @BindView(R.id.rv_automation_what)
    RecyclerView mRvAutomationWhat;

    @BindView(R.id.tv_automation_name)
    TextView mTvAutomationName;

    @BindView(R.id.tb_item_automation_when)
    ToggleButton mTbItemAutomationWhen;

    @BindView(R.id.tb_item_automation_what)
    ToggleButton mTbItemAutomationWhat;

    // 对应AutomationInfo
    private AutomationInfo mAutomationInfo;
    // list用数据源
    private List<Object> mInfoList;
    // adapter
    private AutomationItemShowWhatAdapter mAutomationItemShowWhatAdapter;

    public static BackAutomationItemShowFragment newInstance(String automationName) {
        Bundle bundle = new Bundle();
        bundle.putString("automationName", automationName);
        BackAutomationItemShowFragment fragment = new BackAutomationItemShowFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        String automationName = this.getArguments().getString("automationName");
        mTvAutomationName.setText( automationName );
        for(AutomationInfo item : MyProjectInfo.getInstance().getAutomationList()){
            if(item.getName().equals(automationName)){
                mAutomationInfo = item;break;
            }
        }
        // 设置数据源
        mInfoList = new ArrayList<>();
        mInfoList.addAll(mAutomationInfo.getDeviceList());
        mInfoList.addAll(mAutomationInfo.getSceneList());
        /*for(DeviceInfoAll item : mAutomationInfo.getDeviceList())
            mInfoList.add(item);
        for(SceneInfo item : mAutomationInfo.getSceneList())
            mInfoList.add(item);*/

        mRvAutomationWhat.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mAutomationItemShowWhatAdapter = new AutomationItemShowWhatAdapter(mActivity,mInfoList);
        mRvAutomationWhat.setAdapter(mAutomationItemShowWhatAdapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_back_automation_show;
    }


    @OnCheckedChanged({ R.id.tb_item_automation_what, R.id.tb_item_automation_when})
    public void showWhenOrWhat(ToggleButton button,boolean checked) {
        ToastUtils.showLong(String.valueOf(checked) + button.getId());

        switch (button.getId()) {
            case R.id.tb_item_automation_what:
                if(checked){
                    mTbItemAutomationWhat.setClickable(false);
                    mTbItemAutomationWhen.setClickable(true);
                    mTbItemAutomationWhen.setChecked(false);
                }
                break;
            case R.id.tb_item_automation_when:
                if(checked){
                    mTbItemAutomationWhat.setClickable(true);
                    mTbItemAutomationWhen.setClickable(false);
                    mTbItemAutomationWhat.setChecked(false);
                }
                break;

            default:
                break;
        }
    }



}
