package com.example.cheatman.myapplication.newcode.model;

/**
 * Created by Cheatman on 2017/12/11.
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 一般Room模型
 */
public class RoomInfo  implements Serializable {
    private String id;
    private String name;
    private List<DeviceInfoAll> deviceList ;


    public RoomInfo(String id, String name) {
        this.id = id;
        this.name = name;
        this.deviceList = new ArrayList<>();
    }

    public RoomInfo(String id, String name, List deviceList) {
        this.id = id;
        this.name = name;
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

    public List<DeviceInfoAll> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<DeviceInfoAll> deviceList) {
        this.deviceList = deviceList;
    }
}
