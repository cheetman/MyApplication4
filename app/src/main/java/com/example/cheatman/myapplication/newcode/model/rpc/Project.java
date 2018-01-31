package com.example.cheatman.myapplication.newcode.model.rpc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cheatman on 2018/1/29.
 */

public class Project {

    private List<AppScene> listAppScene = new ArrayList<AppScene>();
    private List<Room> listRoom = new ArrayList<Room>();
    private List<Scheduler> listScheduler = new ArrayList<Scheduler>();
    private List<Device> listDevice = new ArrayList<Device>();
    private List<CustFunc> listCustFunc = new ArrayList<CustFunc>();

    private List<Device> listLight = new ArrayList<Device>();
    private List<Device> listCurtain = new ArrayList<Device>();
    private List<Device> listAc = new ArrayList<Device>();
    private List<Device> listTv = new ArrayList<Device>();
    private List<Device> listAdapter = new ArrayList<Device>();
    private List<Device> listDoublePole = new ArrayList<Device>();
    private List<Device> listIpCamera = new ArrayList<Device>();
    private List<Device> listFloorHeating = new ArrayList<Device>();
    private List<Device> listAirClean = new ArrayList<Device>();
    private List<Device> listMusicPlayer = new ArrayList<Device>();
    private List<Device> listSensor = new ArrayList<Device>();


    public List<Device> getListLight() {
        return listLight;
    }

    public List<Device> getListCurtain() {
        return listCurtain;
    }
    public List<Device> getListAc() {
        return listAc;
    }
    public List<Device> getListTv() {
        return listTv;
    }
    public List<Device> getListAdapter() {
        return listAdapter;
    }
    public List<Device> getListDoublePole() {
        return listDoublePole;
    }
    public List<Device> getListIpCamera() {
        return listIpCamera;
    }


    private static Project project;

    public static Project getInstance(){
        if(project == null){
            project = new Project();
        }
        return project;
    }
}
