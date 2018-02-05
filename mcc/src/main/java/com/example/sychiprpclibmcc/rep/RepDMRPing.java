package com.example.sychiprpclibmcc.rep;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepDMRPing<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMRPing extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	 
	
	
	public class RepDMRPingResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int devId;
		private int status;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}

	}
	
	
	public RepDMRPingResult getSimResult(){
		return new RepDMRPingResult();
	}

	private RepDMRPingResult result;

	/**
	 * @return the result
	 */
	public RepDMRPingResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRPingResult result) {
		this.result = result;
	}

	
}
