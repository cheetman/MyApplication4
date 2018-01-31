package com.example.cheatman.myapplication.newcode.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cheatman.myapplication.newcode.database.entity.HistoryUserEntity;

import java.util.List;

/**
 * Created by Cheatman on 2018/1/29.
 */

@Dao
public interface HistoryUserDao {

    @Query("SELECT * FROM HistoryUser")
    List<HistoryUserEntity> getAll();

    @Query("SELECT * FROM HistoryUser WHERE id IN (:ids)")
    List<HistoryUserEntity> getAllByIds(long[] ids);

    @Insert
    void insert(HistoryUserEntity... entities);

    @Delete
    void delete(HistoryUserEntity entity);

    @Update
    void update(HistoryUserEntity entity);

}
