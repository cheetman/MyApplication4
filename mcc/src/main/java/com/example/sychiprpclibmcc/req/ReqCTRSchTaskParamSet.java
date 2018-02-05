package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqCTRSchTaskParamSet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqCTRSchTaskParamSet extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqCTRSchTaskParamSet(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public static ParamCTRSchTaskParamSet getParam(){
		ReqCTRSchTaskParamSet aa = new ReqCTRSchTaskParamSet(0,"");
		return aa.getSimParam();
	}
	
	public class ParamCTRSchTaskParamSet implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int schTaskId;
		private String schTaskName;
		private boolean mon;
		private boolean tue;
		private boolean wed;
		private boolean thu;
		private boolean fri;
		private boolean sat;
		private boolean sun;
		private int hour;
		private int min;
		private int scnId;
		public int getSchTaskId() {
			return schTaskId;
		}
		public void setSchTaskId(int schTaskId) {
			this.schTaskId = schTaskId;
		}
		public String getSchTaskName() {
			return schTaskName;
		}
		public void setSchTaskName(String schTaskName) {
			this.schTaskName = schTaskName;
		}
		public boolean isMon() {
			return mon;
		}
		public void setMon(boolean mon) {
			this.mon = mon;
		}
		public boolean isTue() {
			return tue;
		}
		public void setTue(boolean tue) {
			this.tue = tue;
		}
		public boolean isWed() {
			return wed;
		}
		public void setWed(boolean wed) {
			this.wed = wed;
		}
		public boolean isThu() {
			return thu;
		}
		public void setThu(boolean thu) {
			this.thu = thu;
		}
		public boolean isSun() {
			return sun;
		}
		public void setSun(boolean sun) {
			this.sun = sun;
		}
		public int getScnId() {
			return scnId;
		}
		public void setScnId(int schId) {
			this.scnId = schId;
		}
		public boolean isFri() {
			return fri;
		}
		public void setFri(boolean fri) {
			this.fri = fri;
		}
		public boolean isSat() {
			return sat;
		}
		public void setSat(boolean sat) {
			this.sat = sat;
		}
		public int getHour() {
			return hour;
		}
		public void setHour(int hour) {
			this.hour = hour;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		
	}
	
	public ParamCTRSchTaskParamSet getSimParam(){
		return new ParamCTRSchTaskParamSet();
	}

	private ParamCTRSchTaskParamSet params;


	public ParamCTRSchTaskParamSet getParams() {
		return params;
	}

	
	public void setParams(ParamCTRSchTaskParamSet params) {
		this.params = params;
	}
}
