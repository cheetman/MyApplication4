package com.example.cheatman.myapplication.newcode.model;

/**
 * Created by Cheatman on 2017/12/11.
 */

/**
 * 设置页模型
 */
public class SettingInfo {
    private String id;
    private String name;
    private String detailName;
    private String manageName;
    private boolean nameDisable;
    private boolean detailDisable;
    private boolean manageDisable;


    public SettingInfo(String name, String detailName, String manageName) {
        this.name = name;
        this.detailName = detailName;
        this.manageName = manageName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public boolean isNameDisable() {
        return nameDisable;
    }

    public void setNameDisable(boolean nameDisable) {
        this.nameDisable = nameDisable;
    }

    public boolean isDetailDisable() {
        return detailDisable;
    }

    public void setDetailDisable(boolean detailDisable) {
        this.detailDisable = detailDisable;
    }

    public boolean isManageDisable() {
        return manageDisable;
    }

    public void setManageDisable(boolean manageDisable) {
        this.manageDisable = manageDisable;
    }
}
