package com.example.cheatman.myapplication.newcode.application;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.example.cheatman.myapplication.newcode.base.CrashHandler;
import com.example.cheatman.myapplication.newcode.database.AppDatabase;
import com.example.cheatman.myapplication.newcode.database.dao.HistoryUserDao;
import com.example.cheatman.myapplication.newcode.utils.Utils;
import com.google.gson.Gson;

/**
 * Created by Cheatman on 2018/1/24.
 */

public class MainApplication extends Application {
    private  static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        // 全局异常处理
        CrashHandler crashHandler = CrashHandler.getInstance();
        // 注册crashHandler
        crashHandler.init(context);
        // 初始化Utils
        Utils.init(this);

    }

    /**
     * 设置登录用户信息
     * @param loginUser
     */
    public void setLoginUser(HistoryUserDao loginUser) {
        Gson gson = new Gson();
        String jsonValue = gson.toJson(loginUser);
        SharedPreferences.Editor shareData  = getSharedPreferences("loginUser", 0).edit();
        shareData.putString("value",jsonValue);
        shareData.commit();
    }

    /**
     * 取得登录用户信息
     */
    public HistoryUserDao getLoginUser() {
        Gson gson = new Gson();
        SharedPreferences sp =getSharedPreferences("loginUser", 0);
        String jsonString = sp.getString("value","");
        HistoryUserDao loginUser = gson.fromJson(jsonString, HistoryUserDao.class);
        return loginUser;
    }







    public static Context getContext() {
        return context;
    }
}