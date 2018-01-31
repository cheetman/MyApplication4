package com.example.cheatman.myapplication.newcode.model.expand;

/**
 * Created by Cheatman on 2017/12/11.
 */

/**
 * 折叠List用
 */
public class ItemDeviceInfo {
    private String id;
    private String name;
    private String roomName;
    private String type;

    // 开关
    private boolean on;
    // 值
    private float value;

    private boolean visibility;
    private boolean expanded;

    public ItemDeviceInfo(String id, String name, String type, float value, String roomName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.roomName = roomName;
        this.expanded = false;
        this.visibility = true;
    }

    public ItemDeviceInfo(String id, String name, String type, float value, String roomName, boolean expanded) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.roomName = roomName;
        this.expanded = expanded;
        this.visibility = true;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public Boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
