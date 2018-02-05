package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqDMRACCtrl<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRACCtrl extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRACCtrl(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRACCtrl implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int devId;
		private int onOff;
		private int temp;
		private int mode;
		private int wind;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}
		public int getOnOff() {
			return onOff;
		}
		public void setOnOff(int onOff) {
			this.onOff = onOff;
		}
		public int getTemp() {
			return temp;
		}
		public void setTemp(int temp) {
			this.temp = temp;
		}
		public int getMode() {
			return mode;
		}
		public void setMode(int mode) {
			this.mode = mode;
		}
		public int getWind() {
			return wind;
		}
		public void setWind(int wind) {
			this.wind = wind;
		}
		
	}
	
	public ParamDMRACCtrl getSimParam(){
		return new ParamDMRACCtrl();
	}

	private ParamDMRACCtrl params;


	public ParamDMRACCtrl getParams() {
		return params;
	}

	
	public void setParams(ParamDMRACCtrl params) {
		this.params = params;
	}
}
