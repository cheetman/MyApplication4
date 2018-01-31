package com.example.cheatman.myapplication.newcode.model;

/**
 * Created by Cheatman on 2017/12/11.
 */

/**
 * 一般DeviceType模型
 */
public class DeviceTypeInfo {
    private String id;
    private String name;

    public DeviceTypeInfo(String id, String name) {
        this.id = id;
        this.name = name;

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

}
