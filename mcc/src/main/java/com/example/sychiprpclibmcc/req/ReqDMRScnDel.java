package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqDMRScnDel<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRScnDel extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRScnDel(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRScnDel implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int devId;
		private int scnId;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}
		public int getScnId() {
			return scnId;
		}
		public void setScnId(int scnId) {
			this.scnId = scnId;
		}
		
	}
	
	public ParamDMRScnDel getSimParam(){
		return new ParamDMRScnDel();
	}

	private ParamDMRScnDel params;


	public ParamDMRScnDel getParams() {
		return params;
	}

	
	public void setParams(ParamDMRScnDel params) {
		this.params = params;
	}
}
