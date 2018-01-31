package com.example.cheatman.myapplication.newcode.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cheatman.myapplication.newcode.database.entity.FavoriteSceneEntity;
import com.example.cheatman.myapplication.newcode.database.entity.HistoryUserEntity;

import java.util.List;

/**
 * Created by Cheatman on 2018/1/29.
 */

@Dao
public interface FavoriteSceneDao {

    @Query("SELECT * FROM FavoriteScene")
    List<FavoriteSceneEntity> getAll();

    @Query("SELECT * FROM FavoriteScene WHERE id IN (:ids)")
    List<FavoriteSceneEntity> getAllByIds(long[] ids);

    @Query("SELECT * FROM FavoriteScene WHERE userName = :userName")
    List<FavoriteSceneEntity> queryByUser(String userName);

    @Query("SELECT * FROM FavoriteScene WHERE userName = :userName AND sceneName = :sceneName LIMIT 0,1")
    FavoriteSceneEntity queryFirstByUser(String userName,String sceneName);

    @Insert
    void insert(FavoriteSceneEntity... entities);

    @Delete
    void delete(FavoriteSceneEntity entity);

    @Update
    void update(FavoriteSceneEntity entity);

}
