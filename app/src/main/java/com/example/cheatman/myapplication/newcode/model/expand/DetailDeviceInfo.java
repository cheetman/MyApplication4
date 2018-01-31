package com.example.cheatman.myapplication.newcode.model.expand;

/**
 * Created by Cheatman on 2017/12/11.
 */

/**
 * 折叠List用
 */
public class DetailDeviceInfo {
    private String id;
    private String name;
    private String roomName;
    private String type;
    private float level;
    private boolean visibility;

    public DetailDeviceInfo(String id, String name, String type, float level, String roomName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.roomName = roomName;
        visibility = false;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
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

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }
}
