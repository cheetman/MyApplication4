package com.example.sychiprpclibmcc.rep;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepDMRFHGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMRFHGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	public class RepDMRFHGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int devId;
		private int onOff;
		private float temp;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}
		public float getTemp() {
			return temp;
		}
		public void setTemp(float temp) {
			this.temp = temp;
		}
		public int getOnOff() {
			return onOff;
		}
		public void setOnOff(int onOff) {
			this.onOff = onOff;
		}
		public boolean isOn() {
			return 2==onOff;
		}

	}
	

	public RepDMRFHGetResult getSimResult(){
		return new RepDMRFHGetResult();
	}
	
	private RepDMRFHGetResult result;

	/**
	 * @return the result
	 */
	public RepDMRFHGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRFHGetResult result) {
		this.result = result;
	}

	
}
