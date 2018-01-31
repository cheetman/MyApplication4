package com.example.cheatman.myapplication.newcode.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cheatman.myapplication.MainActivityV;
import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;
import com.example.cheatman.myapplication.newcode.adapter.SettingDetailAdapter;
import com.example.cheatman.myapplication.newcode.application.MainApplication;
import com.example.cheatman.myapplication.newcode.control.CustomDialog;
import com.example.cheatman.myapplication.newcode.model.SettingInfo;
import com.example.cheatman.myapplication.newcode.utils.ToastUtils;

import butterknife.BindView;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class SettingMainFragment extends BaseFragment {

    @BindView(R.id.rv_setting_detail)
    RecyclerView mRvSettingDetail;


    public static SettingMainFragment newInstance() {
        SettingMainFragment fragment = new SettingMainFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mRvSettingDetail.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        SettingDetailAdapter settingDetailAdapter = new SettingDetailAdapter(mActivity);
        settingDetailAdapter.setOnItemClickListener(new SettingDetailAdapter.OnItemClickListener() {
            @Override
            public void onDetailItemClick(View view, SettingInfo model, int position) {

            }
            @Override
            public void onManageItemClick(View view, SettingInfo model, int position) {
                MainActivityV activity =  (MainActivityV)mActivity;

                switch (model.getName()){
                    case "User":
                        showConfirmChgPwDialog("");
                        break;
                    case "Network":
                        SettingNetWorkFragment mSettingNetWorkFragment = SettingNetWorkFragment.newInstance();
                        activity.addSettingFragment(mSettingNetWorkFragment);
                        break;
                    case "Rooms":
                        SettingRoomFragment mSettingRoomFragment = SettingRoomFragment.newInstance();
                        activity.addSettingFragment(mSettingRoomFragment);
                        break;
                    case "Devices":
                        SettingDeviceFragment mSettingDeviceFragment = SettingDeviceFragment.newInstance();
                        activity.addSettingFragment(mSettingDeviceFragment);
                        break;
                    case "Scene":
                        SettingSceneFragment mSettingSceneFragment = SettingSceneFragment.newInstance();
                        activity.addSettingFragment(mSettingSceneFragment);
                        break;
                    case "Automation":
                        SettingAutomationFragment mSettingAutomationFragment = SettingAutomationFragment.newInstance();
                        activity.addSettingFragment(mSettingAutomationFragment);
                        break;
                    case "Users":
                        SettingUserFragment mSettingUserFragment = SettingUserFragment.newInstance();
                        activity.addSettingFragment(mSettingUserFragment);
                        break;
                    case "Gateway Firmware":
                        SettingGatewayFirmFragment mSettingGatewayFirmFragment = SettingGatewayFirmFragment.newInstance();
                        activity.addSettingFragment(mSettingGatewayFirmFragment);
                        break;
                    case "EZVIZ":

                        break;
                    default:
                        break;
            }
            }
        });
        mRvSettingDetail.setAdapter(settingDetailAdapter);
    }



    public void showConfirmChgPwDialog(String message){
        final MainActivityV aty =  (MainActivityV)mActivity;
        if(!aty.existDialog()){
            CustomDialog.OnClickListener listener = new CustomDialog.OnClickListener() {
                @Override
                public void onClick(View view, View dialogView) {
                    switch (view.getId()){
                        case R.id.btn_ok :
                            EditText et = (EditText)dialogView.findViewById(R.id.et_old_password);
                            ToastUtils.showLong(et.getText());
                            aty.dismissDialog();
                            break;
                        case R.id.btn_cancel:
                            EditText etnew = (EditText)dialogView.findViewById(R.id.et_new_password);
                            ToastUtils.showLong(etnew.getText());
                            aty.dismissDialog();
                    }
                }
            };


            CustomDialog.InitViewListener initViewListener = new CustomDialog.InitViewListener() {
                @Override
                public void InitView(View dialogView) {
                    EditText etnew = (EditText)dialogView.findViewById(R.id.et_new_password);
                    etnew.setText("ddfsdfdf");
                }
            };

            CustomDialog.Builder builder = new CustomDialog.Builder(aty);

            aty.dialog = builder.cancelTouchout(false)
                            .view(R.layout.dialog_confirm_change_password)
                            .heightDimenRes(R.dimen.dialog_confirm_change_password_height)
                            .widthDimenRes(R.dimen.dialog_confirm_change_password_width)
                            .style(R.style.Dialog)
                            .initView(initViewListener)
                            .addViewOnclick(R.id.btn_ok,listener)
                            .addViewOnclick(R.id.btn_cancel,listener)
                            .build();

            aty.setDialogOnDismissListener();
            aty.showDialog();
        }
    }

}
