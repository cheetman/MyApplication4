package com.example.sychiprpclibmcc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.sychiprpclibmcc.rep.RepDMRIRExFuncListGet.RpcIRFunc;

public class RpcDevice  implements Serializable {
	private static final long serialVersionUID = 5309923457254491800L;

	private boolean on;
	private Integer level;
	private Integer devType;//1: ULTI device; 2: IP Cam; 3: AC Unit; 4:Floor heating unit; 5:Air cleaning unit:
	
	private Integer devId;
	private Integer ultiType;//1: 1G SW; 2 2G SW; 3: 1G Dim; 4: 2G Dim; 5: 1G Cur; 6: 2G Cur; 7: double pole; 8: Plug adapter; 9: IR AC ; 10 IR TV
	private String name;
	private Integer roomId;
	//devType: 2
	private String vSAddr;
	private String ipcBrand;
	private String ipcModel;

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
	
	
	private List<RpcIRFunc> listCustFunc = new ArrayList<RpcIRFunc>();
	private String naFuncId;
	private String suppFuncId;

	private Integer scnNum;
	private Integer affDevId;
	
	public Integer getDevType() {
		return devType;
	}
	public void setDevType(Integer devType) {
		this.devType = devType;
	}
	public Integer getDevId() {
		return devId;
	}
	public void setDevId(Integer devId) {
		this.devId = devId;
	}
	public Integer getUltiType() {
		return ultiType;
	}
	public void setUltiType(Integer ultiType) {
		this.ultiType = ultiType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getvSAddr() {
		return vSAddr;
	}
	public void setvSAddr(String vSAddr) {
		this.vSAddr = vSAddr;
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
	public List<RpcIRFunc> getListCustFunc() {
		return listCustFunc;
	}
	public void setListCustFunc(List<RpcIRFunc> listCustFunc) {
		this.listCustFunc = listCustFunc;
	}
	public String getNaFuncId() {
		return naFuncId;
	}
	public void setNaFuncId(String naFuncId) {
		this.naFuncId = naFuncId;
	}
	public String getSuppFuncId() {
		return suppFuncId;
	}
	public void setSuppFuncId(String suppFuncId) {
		this.suppFuncId = suppFuncId;
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getScnNum() {
		return scnNum;
	}
	public void setScnNum(Integer scnNum) {
		this.scnNum = scnNum;
	}
	public Integer getAffDevId() {
		return affDevId;
	}
	public void setAffDevId(Integer affDevId) {
		this.affDevId = affDevId;
	}

}