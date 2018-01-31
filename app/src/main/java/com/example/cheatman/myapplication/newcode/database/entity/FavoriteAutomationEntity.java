package com.example.cheatman.myapplication.newcode.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Cheatman on 2018/1/29.
 */

@Entity( tableName = "FavoriteAutomation")
public class FavoriteAutomationEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String automationId;
    private String automationName;
    private String userName;
    private String ip;

    public FavoriteAutomationEntity(String automationId, String automationName, String userName) {
        this.automationId = automationId;
        this.automationName = automationName;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAutomationId() {
        return automationId;
    }

    public void setAutomationId(String automationId) {
        this.automationId = automationId;
    }

    public String getAutomationName() {
        return automationName;
    }

    public void setAutomationName(String automationName) {
        this.automationName = automationName;
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
