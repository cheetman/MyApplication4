package com.example.cheatman.myapplication.newcode.control;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cheatman.myapplication.R;

/**
 * Created by Cheatman on 2018/1/24.
 */

public class MainToolbar extends Toolbar {

    public MainToolbar(Context context) {
        super(context);
    }

    public MainToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MainToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private TextView mTvMainTitle;
    private View mIvMainTitleRight;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTvMainTitle = (TextView) findViewById(R.id.tv_main_title);
        mIvMainTitleRight = (View) findViewById(R.id.btn_main_title_right);
        this.setTitle(" ");
    }

    //设置主title的内容
    public void setMainTitle(String text) {
        this.setTitle(" ");
        mTvMainTitle.setVisibility(View.VISIBLE);
        mTvMainTitle.setText(text);
    }

    //设置主title的内容
    public void setMainTitle(int resid) {
        this.setTitle(" ");
        mTvMainTitle.setVisibility(View.VISIBLE);
        mTvMainTitle.setText(resid);
    }

    //设置主title的内容文字的颜色
    public void setMainTitleColor(int color) {
        mTvMainTitle.setTextColor(color);
    }

    //设置title右边文字
    public void setMainTitleRightOnClickListener(OnClickListener listener) {
        mIvMainTitleRight.setOnClickListener(listener);
    }

    //设置toolbar状态栏颜色
    public void setToolbarBackground(int res) {
        this.setBackgroundResource(res);
    }

    //设置toolbar左边图标
    public void setToolbarLeftBackImageRes(int res) {
        this.setNavigationIcon(res);
    }

    //设置toolbar左边文字
    public void setToolbarLeftText(String text) {
        this.setNavigationContentDescription(text);
    }

    //设置toolbar的标题
    public void setToolbarTitle(String text) {
        this.setTitle(text);
    }

    //设置toolbar标题的颜色
    public void setToolbarTitleColor(int color) {
        this.setTitleTextColor(color);
    }

    //设置toolbar子标题
    public void setToolbarSubTitleText(String text) {
        this.setSubtitle(text);
    }

    //设置toolbar子标题颜色
    public void setToolbarSubTitleTextColor(int color) {
        this.setSubtitleTextColor(color);
    }



}
