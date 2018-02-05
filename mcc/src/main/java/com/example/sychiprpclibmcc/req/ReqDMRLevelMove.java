package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqDMRLevelMove<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRLevelMove extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRLevelMove(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRLevelMove implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int devId;
		private int mode;
		private int rate;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}

		public int getMode() {
			return mode;
		}
		public void setMode(int mode) {
			this.mode = mode;
		}

		public int getRate() {
			return rate;
		}
		public void setRate(int rate) {
			this.rate = rate;
		}
		
	}
	
	public ParamDMRLevelMove getSimParam(){
		return new ParamDMRLevelMove();
	}

	private ParamDMRLevelMove params;


	public ParamDMRLevelMove getParams() {
		return params;
	}

	
	public void setParams(ParamDMRLevelMove params) {
		this.params = params;
	}
}
