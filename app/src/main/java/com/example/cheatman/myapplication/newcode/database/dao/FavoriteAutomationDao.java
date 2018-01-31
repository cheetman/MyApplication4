package com.example.cheatman.myapplication.newcode.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cheatman.myapplication.newcode.database.entity.FavoriteAutomationEntity;
import com.example.cheatman.myapplication.newcode.database.entity.FavoriteSceneEntity;

import java.util.List;

/**
 * Created by Cheatman on 2018/1/29.
 */

@Dao
public interface FavoriteAutomationDao {

    @Query("SELECT * FROM FavoriteAutomation")
    List<FavoriteAutomationEntity> getAll();

    @Query("SELECT * FROM FavoriteAutomation WHERE id IN (:ids)")
    List<FavoriteAutomationEntity> getAllByIds(long[] ids);

    @Query("SELECT * FROM FavoriteAutomation WHERE userName = :userName")
    List<FavoriteAutomationEntity> queryByUser(String userName);

    @Query("SELECT * FROM FavoriteAutomation WHERE userName = :userName AND automationName = :automationName LIMIT 0,1")
    FavoriteAutomationEntity queryFirstByUser(String userName,String automationName);

    @Insert
    void insert(FavoriteAutomationEntity... entities);

    @Delete
    void delete(FavoriteAutomationEntity entity);

    @Update
    void update(FavoriteAutomationEntity entity);

}
