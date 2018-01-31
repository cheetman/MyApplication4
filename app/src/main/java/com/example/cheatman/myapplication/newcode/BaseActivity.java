package com.example.cheatman.myapplication.newcode;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.application.MainApplication;
import com.example.cheatman.myapplication.newcode.control.CustomDialog;

import butterknife.ButterKnife;

/**
 * Created by Cheatman on 2017/12/6.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected RequestManager mImageLoader;
    private boolean mIsDestroy;

    protected abstract int getContentView();

    protected abstract void initWidget(Bundle savedInstanceState) ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        initWidget(savedInstanceState);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mIsDestroy = true;
        super.onDestroy();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        //拦截返回键
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            //判断触摸UP事件才会进行返回事件处理
            if (event.getAction() == KeyEvent.ACTION_UP) {
                onBackPressed();
            }
            //只要是返回事件，直接返回true，表示消费掉
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    protected Fragment findFragmentByTag(String tag){
        return  getSupportFragmentManager().findFragmentByTag(tag);
    }

    public boolean isDestroy() {
        return mIsDestroy;
    }

    public synchronized RequestManager getImageLoader() {
        if (mImageLoader == null)
            mImageLoader = Glide.with(this);
        return mImageLoader;
    }

    public CustomDialog dialog;

    public void dismissDialog(){
        if(dialog != null){
            dialog.dismiss();
        }
        dialog = null;
    }

    public boolean existDialog(){
        return dialog==null?false:true;
    }

    public void setDialogOnDismissListener(){
        if(dialog != null){
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    dialog = null;
                }
            });
        }
    }

    public void showDialog(){
        if(dialog != null){
            dialog.show();
        }
    }


    public void showAlertDialog(String message){
        if(!existDialog()){
            CustomDialog.Builder builder = new CustomDialog.Builder(this);
            dialog =
                    builder.cancelTouchout(false)
                            .view(R.layout.dialog_alert)
                            .heightDimenRes(R.dimen.dialog_alert_error_height)
                            .widthDimenRes(R.dimen.dialog_alert_error_width)
                            .style(R.style.Dialog)
                            .addViewOnclick(R.id.btn_ok,new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                    dialog = null;
                                }
                            })
                            .build();
            showDialog();
        }
    }

}
