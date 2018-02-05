package com.example.sychiprpclibmcc.rep;


import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepDMRACGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMRACGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	public class RepDMRACGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int devId;
		private int onOff;
		private int wind;
		private int mode;
		private int temp;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}
		public int getOnoff() {
			return onOff;
		}
		public void setOnoff(int onoff) {
			this.onOff = onoff;
		}
		public int getWind() {
			return wind;
		}
		public void setWind(int wind) {
			this.wind = wind;
		}
		public int getMode() {
			return mode;
		}
		public void setMode(int mode) {
			this.mode = mode;
		}
		public int getTemp() {
			return temp;
		}
		public void setTemp(int temp) {
			this.temp = temp;
		}

	}
	

	public RepDMRACGetResult getSimResult(){
		return new RepDMRACGetResult();
	}
	

	private RepDMRACGetResult result;

	/**
	 * @return the result
	 */
	public RepDMRACGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRACGetResult result) {
		this.result = result;
	}

	
}
