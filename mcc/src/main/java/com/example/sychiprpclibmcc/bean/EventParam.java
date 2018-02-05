package com.example.sychiprpclibmcc.bean;


import java.util.List;

import com.example.sychiprpclibmcc.rep.RepBaseResponse;
import com.example.sychiprpclibmcc.rep.RepDMREsGet.RpcEsData;
import com.example.sychiprpclibmcc.rpc.ErrorType;


/**
 * 
 * Title: EventParam<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class EventParam extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	public EventParam(ErrorType errType){
		this.setErrType(errType);
	}
	public EventParam(String method){
		this.setMethod(method);
	}
	private Integer devId;
	private Integer scnId;
	private Integer level;
	private Float temp;
	private Integer mode;
	private Integer wind;
	private Integer onOff;
	private List<RpcEsData> esDataObjList;
	private Integer reason;
	private Integer schTaskId;
	private Integer schStatus;
	private String sysTime;
	private ErrorType errType;
	public Integer getDevId() {
		return devId;
	}
	public void setDevId(Integer devId) {
		this.devId = devId;
	}

	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getScnId() {
		return scnId;
	}
	public void setScnId(Integer scnId) {
		this.scnId = scnId;
	}
	public boolean isOn() {
		return onOff == 2;
	}
 
	public Integer getReason() {
		return reason;
	}
	public void setReason(Integer reason) {
		this.reason = reason;
	}
	public String getSysTime() {
		return sysTime;
	}
	public void setSysTime(String sysTime) {
		this.sysTime = sysTime;
	}

	public ErrorType getErrType() {
		return errType;
	}
	public void setErrType(ErrorType errType) {
		this.errType = errType;
	}
	public Integer getSchTaskId() {
		return schTaskId;
	}
	public void setSchTaskId(Integer schTaskId) {
		this.schTaskId = schTaskId;
	}
	public Integer getSchStatus() {
		return schStatus;
	}
	public void setSchStatus(Integer schStatus) {
		this.schStatus = schStatus;
	}
	public Float getTemp() {
		return temp;
	}
	public void setTemp(Float temp) {
		this.temp = temp;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public Integer getWind() {
		return wind;
	}
	public void setWind(Integer wind) {
		this.wind = wind;
	}
	public Integer getOnOff() {
		return onOff;
	}
	public void setOnOff(Integer onOff) {
		this.onOff = onOff;
	}
	public List<RpcEsData> getEsDataObjList() {
		return esDataObjList;
	}
	public void setEsDataObjList(List<RpcEsData> esDataObjList) {
		this.esDataObjList = esDataObjList;
	}

}
