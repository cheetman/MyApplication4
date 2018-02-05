package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqDMROnOffSet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMROnOffSet extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMROnOffSet(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMROnOffSet implements Serializable {
		/**
		 * 
		 */
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
		
	}
	
	public ParamDMROnOffSet getSimParam(){
		return new ParamDMROnOffSet();
	}

	private ParamDMROnOffSet params;


	public ParamDMROnOffSet getParams() {
		return params;
	}

	
	public void setParams(ParamDMROnOffSet params) {
		this.params = params;
	}
}
