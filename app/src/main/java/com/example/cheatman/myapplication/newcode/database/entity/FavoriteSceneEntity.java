package com.example.cheatman.myapplication.newcode.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Cheatman on 2018/1/29.
 */

@Entity( tableName = "FavoriteScene")
public class FavoriteSceneEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String sceneId;
    private String sceneName;
    private String userName;
    private String ip;

    public FavoriteSceneEntity(String sceneId, String sceneName, String userName) {
        this.sceneId = sceneId;
        this.sceneName = sceneName;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
