package com.example.cheatman.myapplication.newcode.model;

/**
 * Created by Cheatman on 2017/12/11.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 一般Scene模型
 */
public class SceneInfo  implements Serializable {
    private String id;
    private String name;
    private int type;

    private List<DeviceInfoAll> deviceList ;

    // favorite
    private boolean favorite;

    public SceneInfo(String id, String name, int type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.deviceList = new ArrayList<>();
    }

    public SceneInfo(String id, String name, int type, List deviceList ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.deviceList = deviceList;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<DeviceInfoAll> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<DeviceInfoAll> deviceList) {
        this.deviceList = deviceList;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
