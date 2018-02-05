package com.example.sychiprpclibmcc.rep;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepDMRLevelGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMRLevelGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	public class RepDMRLevelGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int devId;
		private int level;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}
		
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}

	}
	

	public RepDMRLevelGetResult getSimResult(){
		return new RepDMRLevelGetResult();
	}
	

	private RepDMRLevelGetResult result;

	/**
	 * @return the result
	 */
	public RepDMRLevelGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRLevelGetResult result) {
		this.result = result;
	}

	
}
