package com.example.cheatman.myapplication.newcode.model;

/**
 * Created by Cheatman on 2017/12/11.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 一般Automation模型
 */
public class AutomationInfo implements Serializable {
    private String id;
    private String name;

    //状态 0: disable; 1: enable; 3: modified; 4: deleted
    private int status;

    private List<SceneInfo> sceneList ;

    private List<DeviceInfoAll> deviceList ;

    // favorite
    private boolean favorite;

    public AutomationInfo(String id, String name) {
        this.id = id;
        this.name = name;
        this.status = 0;
        this.deviceList = new ArrayList<>();
        this.sceneList = new ArrayList<>();
    }

    public AutomationInfo(String id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.deviceList = new ArrayList<>();
        this.sceneList = new ArrayList<>();
    }

    public AutomationInfo(String id, String name, int status, List<SceneInfo> sceneList, List<DeviceInfoAll> deviceList) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.sceneList = sceneList;
        this.deviceList = deviceList;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<SceneInfo> getSceneList() {
        return sceneList;
    }

    public void setSceneList(List<SceneInfo> sceneList) {
        this.sceneList = sceneList;
    }

    public List<DeviceInfoAll> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<DeviceInfoAll> deviceList) {
        this.deviceList = deviceList;
    }
}
