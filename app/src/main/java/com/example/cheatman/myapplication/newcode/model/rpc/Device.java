package com.example.cheatman.myapplication.newcode.model.rpc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cheatman on 2018/1/29.
 */

public class Device {

    public Device(){

    }


    private String name;
    private int devId;
    private int devType;
    private int level;
    private String typeId;
    private String type;
    private String onScnIsOn;
    private String onScnSetLevel;
    private String roomId;
    private String roomName;
    private String useTimes;
    private List<CustFunc> listCustFunc = new ArrayList<CustFunc>();
    private String ctrlType;
//	private String trigScnIsOn;
//	private String trigScnSetLevel;//<!--Dimmer or Curtain control -->
//	private String trigScnExpr;//for TV
//	private String trigScnPower;//for AC
//	private String trigScnMode;//for AC
//	private String trigScnTemp;//for AC
//	private String trigScnFan;//for AC

    //
//	private String offScnIsOn;
//	private String offScnSetLevel;
//	private String offScnPower;//for AC
//	private String offScnMode;//for AC
//	private String offScnTemp;//for AC
//	private String offScnFan;//for AC
    private boolean onOff; // if on is true,off is false
    private String naFuncId;
    private String suppFuncId;

    private boolean sceneStaus1st;


    public boolean getSceneStaus1st() {
        return sceneStaus1st;
    }

    public void setSceneStaus1st(boolean sceneStaus1st) {
        this.sceneStaus1st = sceneStaus1st;
    }


    //场景明细中对应不同状态使用 Add Del Edit
    private String sceneStausType;

    public String getSceneStausType() {
        if(sceneStausType==null){
            return "";
        }
        return sceneStausType;
    }

    public void setSceneStausType(String sceneStausType) {
        this.sceneStausType = sceneStausType;
    }

    public String getNaFuncId() {
        return naFuncId;
    }

    public void setNaFuncId(String naFuncId) {
        this.naFuncId = naFuncId;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        if(type == null){
            return "";
        }
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOnScnIsOn() {
        return onScnIsOn;
    }

    public void setOnScnIsOn(String onScnIsOn) {
        this.onScnIsOn = onScnIsOn;
    }

    public String getOnScnSetLevel() {
        return onScnSetLevel;
    }

    public void setOnScnSetLevel(String onScnSetLevel) {
        this.onScnSetLevel = onScnSetLevel;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(String useTimes) {
        this.useTimes = useTimes;
    }

    public List<CustFunc> getListCustFunc() {
        return listCustFunc;
    }

    public void setListCustFunc(List<CustFunc> listCustFunc) {
        this.listCustFunc = listCustFunc;
    }

    public String getCtrlType() {
        if(ctrlType == null){
            return "";
        }
        return ctrlType;
    }

    public void setCtrlType(String ctrlType) {
        this.ctrlType = ctrlType;
    }

    // 2017-8-11 为ipCamera 添加EZCameraInfo、EZCameraStatus、cameraNo
    private int cameraNo;
    public int getCameraNo() {
        return cameraNo;
    }
    public void setCameraNo(int cameraNo) {
        this.cameraNo = cameraNo;
    }


    private int EZCameraStatus;
    public int getEZCameraStatus() {
        return EZCameraStatus;
    }
    public void setEZCameraStatus(int eZCameraStatus) {
        EZCameraStatus = eZCameraStatus;
    }

//	public String getOffScnIsOn() {
//		return offScnIsOn;
//	}
//
//	public void setOffScnIsOn(String offScnIsOn) {
//		this.offScnIsOn = offScnIsOn;
//	}
//
//	public String getOffScnSetLevel() {
//		return offScnSetLevel;
//	}
//
//	public void setOffScnSetLevel(String offScnSetLevel) {
//		this.offScnSetLevel = offScnSetLevel;
//	}



    /**
     * @return the roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @param roomName the roomName to set
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

//	/**
//	 * @return the trigScnIsOn
//	 */
//	public String getTrigScnIsOn() {
//		return trigScnIsOn;
//	}
//
//	/**
//	 * @param trigScnIsOn the trigScnIsOn to set
//	 */
//	public void setTrigScnIsOn(String trigScnIsOn) {
//		this.trigScnIsOn = trigScnIsOn;
//	}
//
//	/**
//	 * @return the trigScnSetLevel
//	 */
//	public String getTrigScnSetLevel() {
//		return trigScnSetLevel;
//	}
//
//	/**
//	 * @param trigScnSetLevel the trigScnSetLevel to set
//	 */
//	public void setTrigScnSetLevel(String trigScnSetLevel) {
//		this.trigScnSetLevel = trigScnSetLevel;
//	}
//
//	/**
//	 * @return the trigScnExpr
//	 */
//	public String getTrigScnExpr() {
//		return trigScnExpr;
//	}
//
//	/**
//	 * @param trigScnExpr the trigScnExpr to set
//	 */
//	public void setTrigScnExpr(String trigScnExpr) {
//		this.trigScnExpr = trigScnExpr;
//	}
//
//	/**
//	 * @return the trigScnPower
//	 */
//	public String getTrigScnPower() {
//		return trigScnPower;
//	}
//
//	/**
//	 * @param trigScnPower the trigScnPower to set
//	 */
//	public void setTrigScnPower(String trigScnPower) {
//		this.trigScnPower = trigScnPower;
//	}
//
//	/**
//	 * @return the trigScnMode
//	 */
//	public String getTrigScnMode() {
//		return trigScnMode;
//	}
//
//	/**
//	 * @param trigScnMode the trigScnMode to set
//	 */
//	public void setTrigScnMode(String trigScnMode) {
//		this.trigScnMode = trigScnMode;
//	}
//
//	/**
//	 * @return the trigScnTemp
//	 */
//	public String getTrigScnTemp() {
//		return trigScnTemp;
//	}
//
//	/**
//	 * @param trigScnTemp the trigScnTemp to set
//	 */
//	public void setTrigScnTemp(String trigScnTemp) {
//		this.trigScnTemp = trigScnTemp;
//	}
//
//	/**
//	 * @return the trigScnFan
//	 */
//	public String getTrigScnFan() {
//		if(trigScnFan != null){
//			return trigScnFan.replace("FAN ", "");
//		}
//		return trigScnFan;
//	}
//
//	/**
//	 * @param trigScnFan the trigScnFan to set
//	 */
//	public void setTrigScnFan(String trigScnFan) {
//		this.trigScnFan = trigScnFan;
//	}

//	/**
//	 * @return the offScnPower
//	 */
//	public String getOffScnPower() {
//		return offScnPower;
//	}
//
//	/**
//	 * @param offScnPower the offScnPower to set
//	 */
//	public void setOffScnPower(String offScnPower) {
//		this.offScnPower = offScnPower;
//	}
//
//	/**
//	 * @return the offScnMode
//	 */
//	public String getOffScnMode() {
//		return offScnMode;
//	}
//
//	/**
//	 * @param offScnMode the offScnMode to set
//	 */
//	public void setOffScnMode(String offScnMode) {
//		this.offScnMode = offScnMode;
//	}
//
//	/**
//	 * @return the offScnTemp
//	 */
//	public String getOffScnTemp() {
//		return offScnTemp;
//	}
//
//	/**
//	 * @param offScnTemp the offScnTemp to set
//	 */
//	public void setOffScnTemp(String offScnTemp) {
//		this.offScnTemp = offScnTemp;
//	}
//
//	/**
//	 * @return the offScnFan
//	 */
//	public String getOffScnFan() {
//		if(offScnFan != null){
//			return offScnFan.replace("FAN ", "");
//		}
//		return offScnFan;
//	}
//
//	/**
//	 * @param offScnFan the offScnFan to set
//	 */
//	public void setOffScnFan(String offScnFan) {
//		this.offScnFan = offScnFan;
//	}

    /**
     * @return the suppFunc
     */
    public String getSuppFuncId() {
        return suppFuncId;
    }

    /**
     * @param suppFuncId the suppFunc to set
     */
    public void setSuppFuncId(String suppFuncId) {
        this.suppFuncId = suppFuncId;
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDevType() {
        return devType;
    }

    public void setDevType(int devType) {
        this.devType = devType;
    }


    //devType: 2
    private String vSAddr;
    private String ipcModel;
    private String ipcBrand;

    //devType: 3
    private String uid;
    private String acBrand;
    private String acModel;
    private String acUnitAddr;


    //devType: 4
    private String fhBrand;
    private String fhModel;
    private String fhUnitAddr;


    //devType: 5
    private String aclBrand;
    private String aclModel;
    private String aclUnitAddr;

    public String getvSAddr() {
        return vSAddr;
    }
    public void setvSAddr(String vSAddr) {
        this.vSAddr = vSAddr;
    }




    public String getIpcBrand() {
        return ipcBrand;
    }

    public void setIpcBrand(String ipcBrand) {
        this.ipcBrand = ipcBrand;
    }

    public String getIpcModel() {
        return ipcModel;
    }

    public void setIpcModel(String ipcModel) {
        this.ipcModel = ipcModel;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAcBrand() {
        return acBrand;
    }

    public void setAcBrand(String acBrand) {
        this.acBrand = acBrand;
    }

    public String getAcModel() {
        return acModel;
    }

    public void setAcModel(String acModel) {
        this.acModel = acModel;
    }

    public String getAcUnitAddr() {
        return acUnitAddr;
    }

    public void setAcUnitAddr(String acUnitAddr) {
        this.acUnitAddr = acUnitAddr;
    }

    public String getFhBrand() {
        return fhBrand;
    }

    public void setFhBrand(String fhBrand) {
        this.fhBrand = fhBrand;
    }

    public String getFhModel() {
        return fhModel;
    }

    public void setFhModel(String fhModel) {
        this.fhModel = fhModel;
    }

    public String getFhUnitAddr() {
        return fhUnitAddr;
    }

    public void setFhUnitAddr(String fhUnitAddr) {
        this.fhUnitAddr = fhUnitAddr;
    }

    public String getAclBrand() {
        return aclBrand;
    }

    public void setAclBrand(String aclBrand) {
        this.aclBrand = aclBrand;
    }

    public String getAclModel() {
        return aclModel;
    }

    public void setAclModel(String aclModel) {
        this.aclModel = aclModel;
    }

    public String getAclUnitAddr() {
        return aclUnitAddr;
    }

    public void setAclUnitAddr(String aclUnitAddr) {
        this.aclUnitAddr = aclUnitAddr;
    }




    private int scnId;
    private int scnType;
    private Integer scnOnOff;//1: off; 2 On
    private Integer scnLevel;
    private Integer scnTt;
    private Integer scnMode;//1: dehumidify; 2: Cool; 3: Wind; 4 Heat
    private Integer scnWind;//1: low; 2 Medium;3 High
    private Integer scnSpeed;
    private Float scnTemp;
    private int scnTag;

    private Integer scnOnOff2;
    private Integer scnLevel2;
    private Integer scnMode2;
    private Integer scnWind2;
    private Float scnTemp2;


    public Integer getScnOnOff2() {
        if(scnOnOff2 == null){
            return scnOnOff;
        }else{
            return scnOnOff2;
        }
    }

    public void setScnOnOff2(Integer scnOnOff2) {
        this.scnOnOff2 = scnOnOff2;
    }

    public Integer getScnLevel2() {
        if(scnLevel2 == null){
            return scnLevel;
        }else{
            return scnLevel2;
        }
    }

    public void setScnLevel2(Integer scnLevel2) {
        this.scnLevel2 = scnLevel2;
    }

    public Integer getScnMode2() {
        if(scnMode2 == null){
            return scnMode;
        }else{
            return scnMode2;
        }
    }

    public void setScnMode2(Integer scnMode2) {
        this.scnMode2 = scnMode2;
    }

    public Integer getScnWind2() {
        if(scnWind2 == null){
            return scnWind;
        }else{
            return scnWind2;
        }
    }

    public void setScnWind2(Integer scnWind2) {
        this.scnWind2 = scnWind2;
    }

    public Float getScnTemp2() {
        if(scnTemp2 == null){
            return scnTemp;
        }else{
            return scnTemp2;
        }
    }

    public void setScnTemp2(Float scnTemp2) {
        this.scnTemp2 = scnTemp2;
    }


    public boolean isScnOnOff2() {
        //修改 保证代码正常运行 2017/3/16
        if(scnOnOff2 == null){
            return isScnOnOff();
        }else if(scnOnOff2 == 1){
            return false;
        }else if(scnOnOff2 == 2){
            return true;
        }else{
            return false;
        }
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

    public int getScnType() {
        return scnType;
    }

    public void setScnType(int scnType) {
        this.scnType = scnType;
    }

    public Integer getScnOnOff() {
        return scnOnOff;
    }

    public void setScnOnOff(Integer scnOnOff) {
        this.scnOnOff = scnOnOff;
    }

    public Integer getScnLevel() {
        return scnLevel;
    }

    public void setScnLevel(Integer scnLevel) {
        this.scnLevel = scnLevel;
    }

    public Integer getScnTt() {
        return scnTt;
    }

    public void setScnTt(Integer scnTt) {
        this.scnTt = scnTt;
    }

    public boolean isScnOnOff() {
        //修改 保证代码正常运行 2017/3/16
        if(scnOnOff == null){
            return false;
        }else if(scnOnOff == 1){
            return false;
        }else if(scnOnOff == 2){
            return true;
        }else{
            return false;
        }
    }



    public Integer getScnMode() {
        return scnMode;
    }

    public void setScnMode(Integer scnMode) {
        this.scnMode = scnMode;
    }

    public Integer getScnWind() {
        return scnWind;
    }

    public String getScnModeText() {
        if(scnMode == 1){
            return "Dehumidify";
        }else if(scnMode == 2){
            return "Cool";
        }else if(scnMode == 3){
            return "Wind";
        }else if(scnMode == 4){
            return "Heat";
        }
        return "";
    }

    public String getScnWindText() {
        if(scnWind == 1){
            return "Low";
        }else if(scnWind == 2){
            return "Medium";
        }else if(scnWind == 3){
            return "High";
        }
        return "";
    }

    public void setScnWind(Integer scnWind) {
        this.scnWind = scnWind;
    }

    public Integer getScnSpeed() {
        return scnSpeed;
    }

    public void setScnSpeed(Integer scnSpeed) {
        this.scnSpeed = scnSpeed;
    }

    public Float getScnTemp() {
        return scnTemp;
    }

    public void setScnTemp(Float scnTemp) {
        this.scnTemp = scnTemp;
    }

    //用来在home界面保存地暖温度
    private float temp ;


    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

}
