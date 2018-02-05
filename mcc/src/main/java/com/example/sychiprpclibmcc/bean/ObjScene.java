package com.example.sychiprpclibmcc.bean;

import java.io.Serializable;

/**
 * 
 * Title: ObjScene<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ObjScene implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	private int devId;
	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public int getScnId() {
		return scnId;
	}
	public void setScnId(int scnId) {
		this.scnId = scnId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Integer getOnOff() {
		return onOff;
	}
	public void setOnOff(Integer onOff) {
		this.onOff = onOff;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getTt() {
		return tt;
	}
	public void setTt(Integer tt) {
		this.tt = tt;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
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
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public Float getTemp() {
		return temp;
	}
	public void setTemp(Float temp) {
		this.temp = temp;
	}
	private int scnId;
	private int type;
	private Integer onOff;
	private Integer level;
	private Integer tt;
	private Integer power;
	private Integer mode;
	private Integer wind;
	private Integer speed;
	private Float temp;
	


}
