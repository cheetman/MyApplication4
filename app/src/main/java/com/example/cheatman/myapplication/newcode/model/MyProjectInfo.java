package com.example.cheatman.myapplication.newcode.model;


import com.example.cheatman.myapplication.newcode.utils.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by Cheatman on 2018/1/30.
 * 模拟数据
 */

public class MyProjectInfo {
    private static MyProjectInfo project;

    private List<SceneInfo> sceneList = new ArrayList<>();
    private List<RoomInfo> roomList = new ArrayList<>();
    private List<AutomationInfo> automationList = new ArrayList<>();
    private List<DeviceInfoAll> deviceList = new ArrayList<>();

    /*private List<CustFunc> listCustFunc = new ArrayList<>();*/
    private List<DeviceInfoAll> lightList = new ArrayList<>();
    private List<DeviceInfoAll> curtainList = new ArrayList<>();
    private List<DeviceInfoAll> acList = new ArrayList<>();
    private List<DeviceInfoAll> tvList = new ArrayList<>();
    private List<DeviceInfoAll> adapterList = new ArrayList<>();
    private List<DeviceInfoAll> doublePoleList = new ArrayList<>();
    private List<DeviceInfoAll> ipCameraList = new ArrayList<>();
    private List<DeviceInfoAll> floorHeatingList = new ArrayList<>();
    private List<DeviceInfoAll> airCleanList = new ArrayList<>();
    private List<DeviceInfoAll> musicPlayerList = new ArrayList<>();
    private List<DeviceInfoAll> sensorList = new ArrayList<>();


    public static MyProjectInfo getInstance(){
        if(project == null){
            project = new MyProjectInfo();
            // 设置测试数据
            project.updateData();
        }
        return project;
    }


    public List<SceneInfo> getSceneList() {
        return sceneList;
    }

    public void setSceneList(List<SceneInfo> sceneList) {
        this.sceneList = sceneList;
    }

    public List<RoomInfo> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<RoomInfo> roomList) {
        this.roomList = roomList;
    }

    public List<AutomationInfo> getAutomationList() {
        return automationList;
    }

    public void setAutomationList(List<AutomationInfo> automationList) {
        this.automationList = automationList;
    }

    public List<DeviceInfoAll> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<DeviceInfoAll> deviceList) {
        this.deviceList = deviceList;
    }

    public List<DeviceInfoAll> getLightList() {
        return lightList;
    }

    public void setLightList(List<DeviceInfoAll> lightList) {
        this.lightList = lightList;
    }

    public List<DeviceInfoAll> getCurtainList() {
        return curtainList;
    }

    public void setCurtainList(List<DeviceInfoAll> curtainList) {
        this.curtainList = curtainList;
    }

    public List<DeviceInfoAll> getAcList() {
        return acList;
    }

    public void setAcList(List<DeviceInfoAll> acList) {
        this.acList = acList;
    }

    public List<DeviceInfoAll> getTvList() {
        return tvList;
    }

    public void setTvList(List<DeviceInfoAll> tvList) {
        this.tvList = tvList;
    }

    public List<DeviceInfoAll> getAdapterList() {
        return adapterList;
    }

    public void setAdapterList(List<DeviceInfoAll> adapterList) {
        this.adapterList = adapterList;
    }

    public List<DeviceInfoAll> getDoublePoleList() {
        return doublePoleList;
    }

    public void setDoublePoleList(List<DeviceInfoAll> doublePoleList) {
        this.doublePoleList = doublePoleList;
    }

    public List<DeviceInfoAll> getIpCameraList() {
        return ipCameraList;
    }

    public void setIpCameraList(List<DeviceInfoAll> ipCameraList) {
        this.ipCameraList = ipCameraList;
    }

    public List<DeviceInfoAll> getFloorHeatingList() {
        return floorHeatingList;
    }

    public void setFloorHeatingList(List<DeviceInfoAll> floorHeatingList) {
        this.floorHeatingList = floorHeatingList;
    }

    public List<DeviceInfoAll> getAirCleanList() {
        return airCleanList;
    }

    public void setAirCleanList(List<DeviceInfoAll> airCleanList) {
        this.airCleanList = airCleanList;
    }

    public List<DeviceInfoAll> getMusicPlayerList() {
        return musicPlayerList;
    }

    public void setMusicPlayerList(List<DeviceInfoAll> musicPlayerList) {
        this.musicPlayerList = musicPlayerList;
    }

    public List<DeviceInfoAll> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<DeviceInfoAll> sensorList) {
        this.sensorList = sensorList;
    }

    public  void updateData(){
        if(project != null){
            // 设置测试数据
            testInitDeviceAndRoom();
            testInitScene();
            testInitAutomation();
        }
    }

    private void testInitDeviceAndRoom (){

        // 所有device
        deviceList.add(new DeviceInfoAll("id","Light1","Light","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Light2","Light","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Light3","Light","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Light4","Light","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Light5","Light","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Light6","Light","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","Light7","Light","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","Light8","Light","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Light9","Light","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Light10","Light","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Light11","Light","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Light12","Light","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Light13","Light","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Plug1","Plug","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Plug2","Plug","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Plug3","Plug","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Plug4","Plug","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Plug5","Plug","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","Plug6","Plug","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Plug7","Plug","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Plug8","Plug","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Plug9","Plug","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","DoublePole1","DoublePole","Living Room"));
        deviceList.add(new DeviceInfoAll("id","DoublePole2","DoublePole","Living Room"));
        deviceList.add(new DeviceInfoAll("id","DoublePole3","DoublePole","Living Room"));
        deviceList.add(new DeviceInfoAll("id","DoublePole4","DoublePole","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","DoublePole5","DoublePole","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","DoublePole6","DoublePole","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","DoublePole7","DoublePole","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","DoublePole8","DoublePole","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","DoublePole9","DoublePole","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Curtain1","Curtain","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Curtain2","Curtain","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Curtain3","Curtain","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","Curtain4","Curtain","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","Curtain5","Curtain","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","Curtain6","Curtain","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","Curtain7","Curtain","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Curtain8","Curtain","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Curtain9","Curtain","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","FloorHeating1","FloorHeating","Living Room"));
        deviceList.add(new DeviceInfoAll("id","FloorHeating2","FloorHeating","Living Room"));
        deviceList.add(new DeviceInfoAll("id","FloorHeating3","FloorHeating","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","FloorHeating4","FloorHeating","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","FloorHeating5","FloorHeating","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","FloorHeating6","FloorHeating","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","TV1","TV","Living Room"));
        deviceList.add(new DeviceInfoAll("id","TV2","TV","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","TV3","TV","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","TV4","TV","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","AC1","AC","Living Room"));
        deviceList.add(new DeviceInfoAll("id","AC2","AC","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","AC3","AC","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","AC4","AC","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Sensor1","Sensor","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Sensor2","Sensor","Living Room"));
        deviceList.add(new DeviceInfoAll("id","Sensor3","Sensor","Bed Room"));
        deviceList.add(new DeviceInfoAll("id","Sensor4","Sensor","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Sensor5","Sensor","Dinner Room"));
        deviceList.add(new DeviceInfoAll("id","Sensor6","Sensor","Dinner Room"));

        // 排序
        Collections.sort(deviceList,new Comparator<DeviceInfoAll>(){
            public int compare(DeviceInfoAll arg0, DeviceInfoAll arg1) {
                if(arg0.getType().equals(arg1.getType())){
                    return arg0.getName().compareTo(arg1.getName());
                }else{
                    return arg0.getType().compareTo(arg1.getType());
                }
            }
        });

        //房间数据
        // 临时缓存用
        Map<String,RoomInfo> roomCache = new LinkedHashMap<>();
        for( DeviceInfoAll item : deviceList){
            // new 标题item
            if(!roomCache.containsKey(item.getRoomName())){
                RoomInfo roomInfo = new RoomInfo("1",item.getRoomName());
                roomInfo.getDeviceList().add(item);
                roomCache.put(item.getRoomName(),roomInfo);
            }else{
                roomCache.get(item.getRoomName()).getDeviceList().add(item);
            }
        }
        for(Map.Entry<String, RoomInfo> entry  : roomCache.entrySet()){
            roomList.add(entry.getValue());
        }

    }

    private void testInitScene(){

        sceneList.add(new SceneInfo("1","Scene1",0));
        sceneList.add(new SceneInfo("1","Scene2",0));
        sceneList.add(new SceneInfo("1","Scene3",0));
        sceneList.add(new SceneInfo("1","Scene4",0));
        sceneList.add(new SceneInfo("1","Scene5",0));
        sceneList.add(new SceneInfo("1","Scene6",0));
        sceneList.add(new SceneInfo("1","Scene7",0));
        sceneList.add(new SceneInfo("1","Scene8",0));
        sceneList.add(new SceneInfo("1","Scene9",0));
        sceneList.add(new SceneInfo("1","Scene10",0));
        sceneList.add(new SceneInfo("1","Scene11",0));
        sceneList.add(new SceneInfo("1","Scene12",0));
        sceneList.add(new SceneInfo("1","Scene13",0));
        sceneList.add(new SceneInfo("1","Scene14",0));
        sceneList.add(new SceneInfo("1","Scene15",0));
        sceneList.add(new SceneInfo("1","Scene16",0));
        sceneList.add(new SceneInfo("1","Scene17",0));
        sceneList.add(new SceneInfo("1","Scene18",0));
        sceneList.add(new SceneInfo("1","Scene19",0));
        sceneList.add(new SceneInfo("1","Scene20",0));
        sceneList.add(new SceneInfo("1","Scene21",0));

        // 排序
        Collections.sort(sceneList,new Comparator<SceneInfo>(){
            public int compare(SceneInfo arg0, SceneInfo arg1) {
                if(arg0.getType() == arg1.getType()){
                    return arg0.getName().compareTo(arg1.getName());
                }else{
                    return  Integer.compare(arg0.getType(),arg1.getType());
                }
            }
        });

        // 设置设备
        Random random = new Random();
        for(SceneInfo item : sceneList){
            int index  = 0;
            while (true){
                index = index + random.nextInt(8);
                if(index >= deviceList.size()) break;
                // 复制
                DeviceInfoAll newModel = BeanUtils.Copy(deviceList.get(index));
                item.getDeviceList().add(newModel);
                index ++ ;
            }
        }
    }


    private void testInitAutomation(){
        automationList.add(new AutomationInfo("1","Automation1",0));
        automationList.add(new AutomationInfo("1","Automation2",0));
        automationList.add(new AutomationInfo("1","Automation3",0));
        automationList.add(new AutomationInfo("1","Automation4",0));
        automationList.add(new AutomationInfo("1","Automation5",0));
        automationList.add(new AutomationInfo("1","Automation6",0));
        automationList.add(new AutomationInfo("1","Automation7",0));
        automationList.add(new AutomationInfo("1","Automation8",0));
        automationList.add(new AutomationInfo("1","Automation9",0));
        automationList.add(new AutomationInfo("1","Automation10",0));
        automationList.add(new AutomationInfo("1","Automation11",0));
        automationList.add(new AutomationInfo("1","Automation12",0));
        automationList.add(new AutomationInfo("1","Automation13",0));
        automationList.add(new AutomationInfo("1","Automation14",0));
        automationList.add(new AutomationInfo("1","Automation15",0));
        automationList.add(new AutomationInfo("1","Automation16",0));
        automationList.add(new AutomationInfo("1","Automation17",0));
        automationList.add(new AutomationInfo("1","Automation18",0));
        automationList.add(new AutomationInfo("1","Automation19",0));
        automationList.add(new AutomationInfo("1","Automation20",0));
        automationList.add(new AutomationInfo("1","Automation21",0));

        // 排序
        Collections.sort(automationList,new Comparator<AutomationInfo>(){
            public int compare(AutomationInfo arg0, AutomationInfo arg1) {
                return arg0.getName().compareTo(arg1.getName());
            }
        });

        // 设置设备
        Random random = new Random();
        for(AutomationInfo item : automationList){
            int index  = 0;
            while (true){
                index = index + random.nextInt(8);
                if(index >= deviceList.size()) break;
                // 复制
                DeviceInfoAll newModel = BeanUtils.Copy(deviceList.get(index));
                item.getDeviceList().add(newModel);
                index ++ ;
            }
        }
        // 设置场景
        for(AutomationInfo item : automationList){
            int index  = 0;
            while (true){
                index = index + random.nextInt(20);
                if(index >= sceneList.size()) break;
                item.getSceneList().add(sceneList.get(index));
                index ++ ;
            }
        }


    }
}
