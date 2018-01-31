package com.example.cheatman.myapplication.newcode.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Cheatman on 2018/1/29.
 */

@Entity( tableName = "HistoryUser")
public class HistoryUserEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String ethMac;
    private String ip;
    private String sysName;
    private String aliasName;
    private String lastLoginDate;
    private String password;
    private String rememberMe;
    private String lowBatteryWarning;
    private String loginTimes;
    private String hostName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEthMac() {
        return ethMac;
    }

    public void setEthMac(String ethMac) {
        this.ethMac = ethMac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getLowBatteryWarning() {
        return lowBatteryWarning;
    }

    public void setLowBatteryWarning(String lowBatteryWarning) {
        this.lowBatteryWarning = lowBatteryWarning;
    }

    public String getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(String loginTimes) {
        this.loginTimes = loginTimes;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
