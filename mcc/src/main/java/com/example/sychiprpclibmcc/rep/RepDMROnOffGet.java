package com.example.sychiprpclibmcc.rep;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepDMROnOffGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMROnOffGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	public class RepDMROnOffGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int devId;
		private int onOff;
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
		
		public boolean isOn() {
			return 2 == onOff;
		}

	}
	

	public RepDMROnOffGetResult getSimResult(){
		return new RepDMROnOffGetResult();
	}
	
	private RepDMROnOffGetResult result;

	/**
	 * @return the result
	 */
	public RepDMROnOffGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMROnOffGetResult result) {
		this.result = result;
	}

	
}
