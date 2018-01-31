package com.example.cheatman.myapplication.newcode.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.cheatman.myapplication.newcode.database.dao.FavoriteAutomationDao;
import com.example.cheatman.myapplication.newcode.database.dao.FavoriteSceneDao;
import com.example.cheatman.myapplication.newcode.database.dao.HistoryUserDao;
import com.example.cheatman.myapplication.newcode.database.entity.FavoriteAutomationEntity;
import com.example.cheatman.myapplication.newcode.database.entity.FavoriteSceneEntity;
import com.example.cheatman.myapplication.newcode.database.entity.HistoryUserEntity;

/**
 * Created by Cheatman on 2018/1/29.
 */

@Database(entities = {HistoryUserEntity.class,FavoriteSceneEntity.class, FavoriteAutomationEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FavoriteAutomationDao favoriteAutomationDao();

    public abstract FavoriteSceneDao favoriteSceneDao();

    public abstract HistoryUserDao historyUserDao();

    private static AppDatabase sInstance;

    public static AppDatabase getDatabase(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                    "user.db").addCallback(new AppDatabase.Callback() {
                //第一次创建数据库时调用，但是在创建所有表之后调用的
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                }

                //当数据库被打开时调用
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }
            })
                    .allowMainThreadQueries()//允许在主线程查询数据
            //.addMigrations()//迁移数据库使用，下面会单独拿出来讲
            //.fallbackToDestructiveMigration()//迁移数据库如果发生错误，将会重新创建数据库，而不是发生崩溃
            .build();
        }
        return sInstance;
    }

    public static void onDestroy() {
        sInstance = null;
    }
}
