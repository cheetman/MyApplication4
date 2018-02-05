package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqDMRFHCtrl<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRFHCtrl extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRFHCtrl(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRFHCtrl implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int devId;
		private int onOff;
//		private int mode;
//		private int wind;
		private int temp;
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
//		public int getMode() {
//			return mode;
//		}
//		public void setMode(int mode) {
//			this.mode = mode;
//		}
//		public int getWind() {
//			return wind;
//		}
//		public void setWind(int wind) {
//			this.wind = wind;
//		}
		public int getTemp() {
			return temp;
		}
		public void setTemp(int temp) {
			this.temp = temp;
		}
		
	}
	
	public ParamDMRFHCtrl getSimParam(){
		return new ParamDMRFHCtrl();
	}

	private ParamDMRFHCtrl params;


	public ParamDMRFHCtrl getParams() {
		return params;
	}

	
	public void setParams(ParamDMRFHCtrl params) {
		this.params = params;
	}
}
