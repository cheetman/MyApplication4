package com.example.cheatman.myapplication.newcode.model.rpc;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by Cheatman on 2018/1/29.
 */

public class AppScene {
    public AppScene(){

    }

    public AppScene(Attributes atts){
        this.setAppScnId(atts.getValue("appScnId"));
        this.setName(atts.getValue("name"));
        this.setImpType(atts.getValue("impType"));
        this.setCtrlType(atts.getValue("ctrlType"));
        this.setDelayOff(atts.getValue("delayOff"));
        this.setGrpId(atts.getValue("grpId"));
        this.setScnOnId(atts.getValue("scnOnId"));
        this.setScnOffId(atts.getValue("scnOffId"));
        this.setOnScnSetLevel(atts.getValue("onScnSetLevel"));
        this.setOffScnSetLevel(atts.getValue("offScnSetLevel"));
        this.setScnTrigId(atts.getValue("scnTrigId"));
    }

    private String appScnId;
    private int scnId;
    private String name;
    private String impType;
    private String ctrlType;
    private String delayOff;
    private String grpId;
    private String scnOnId;
    private String scnOffId;
    private String onScnSetLevel;
    private String offScnSetLevel;
    private String scnTrigId;
    private int devNum;
    private int scnTag;
    private boolean status; //判断Scence是开还是关
    private String rename;
    private List<Device> listDevice =new ArrayList<Device>();

/*    public boolean isStatus() {
        if(SHConstants.Trigger.equals(ctrlType)){
            return true;
        }
        return status;
    }*/

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAppScnId() {
        return appScnId;
    }

    public void setAppScnId(String appScnId) {
        this.appScnId = appScnId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImpType() {
        return impType;
    }

    public void setImpType(String impType) {
        this.impType = impType;
    }

    public String getCtrlType() {
        return ctrlType;
    }

    public void setCtrlType(String ctrlType) {
        this.ctrlType = ctrlType;
    }

    public String getDelayOff() {
        return delayOff;
    }

    public void setDelayOff(String delayOff) {
        this.delayOff = delayOff;
    }

    public String getGrpId() {
        return grpId;
    }

    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }

    public String getScnOnId() {
        return scnOnId;
    }

    public void setScnOnId(String scnOnId) {
        this.scnOnId = scnOnId;
    }

    public List<Device> getListDevice() {
        return listDevice;
    }

    public void setListDevice(List<Device> listDevice) {
        this.listDevice = listDevice;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getScnOffId() {
        return scnOffId;
    }

    public void setScnOffId(String scnOffId) {
        this.scnOffId = scnOffId;
    }

    public String getOnScnSetLevel() {
        return onScnSetLevel;
    }

    public void setOnScnSetLevel(String onScnSetLevel) {
        this.onScnSetLevel = onScnSetLevel;
    }

    public String getOffScnSetLevel() {
        return offScnSetLevel;
    }

    public void setOffScnSetLevel(String offScnSetLevel) {
        this.offScnSetLevel = offScnSetLevel;
    }

    /**
     * @return the scnTrigId
     */
    public String getScnTrigId() {
        return scnTrigId;
    }

    /**
     * @param scnTrigId the scnTrigId to set
     */
    public void setScnTrigId(String scnTrigId) {
        this.scnTrigId = scnTrigId;
    }

    public int getDevNum() {
        return devNum;
    }

    public void setDevNum(int devNum) {
        this.devNum = devNum;
    }

    public int getScnTag() {
        return scnTag;
    }

    public void setScnTag(int scnTag) {
        this.scnTag = scnTag;
    }

    public int getScnId() {
        return scnId;
    }

    public void setScnId(int scnId) {
        this.scnId = scnId;
    }

}
