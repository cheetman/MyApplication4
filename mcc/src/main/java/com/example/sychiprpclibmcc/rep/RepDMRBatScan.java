package com.example.sychiprpclibmcc.rep;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepDMRBatScan<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMRBatScan extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	 
	
	
	public class RepDMRBatScanResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int devId;
		private int batStatus;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}
		public int getBatStatus() {
			return batStatus;
		}
		public void setBatStatus(int batStatus) {
			this.batStatus = batStatus;
		}

	}
	
	
	public RepDMRBatScanResult getSimResult(){
		return new RepDMRBatScanResult();
	}

	private RepDMRBatScanResult result;

	/**
	 * @return the result
	 */
	public RepDMRBatScanResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRBatScanResult result) {
		this.result = result;
	}

	
}
