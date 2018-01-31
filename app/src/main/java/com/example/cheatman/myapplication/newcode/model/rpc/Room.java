package com.example.cheatman.myapplication.newcode.model.rpc;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by Cheatman on 2018/1/29.
 */

public class Room {
    public Room() {

    }

    public Room(Attributes atts) {
        this.setName(atts.getValue("name"));
        this.setRoomId(atts.getValue("roomId"));
        //this.setDeviceNum(atts.getValue("Device"));
    }

    private String name;
    private String roomId;
    private String rename;
    //private String deviceNum;
    private List<Device> listDevice = new ArrayList<Device>();
//	private List<AppScene> listScene = new ArrayList<AppScene>();

    public List<Device> getListDevice() {
        return listDevice;
    }

    public void setListDevice(List<Device> listDevice) {
        this.listDevice = listDevice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

	/*public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}*/

//	public List<AppScene> getListScene() {
//		return listScene;
//	}
//
//	public void setListScene(List<AppScene> listScene) {
//		this.listScene = listScene;
//	}
}
