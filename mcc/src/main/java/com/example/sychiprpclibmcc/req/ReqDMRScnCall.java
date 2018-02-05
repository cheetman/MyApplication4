package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqDMRScnCall<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRScnCall extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRScnCall(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRScnCall implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int scnId;
		public int getScnId() {
			return scnId;
		}
		public void setScnId(int scnId) {
			this.scnId = scnId;
		}
		
	}
	
	public ParamDMRScnCall getSimParam(){
		return new ParamDMRScnCall();
	}

	private ParamDMRScnCall params;


	public ParamDMRScnCall getParams() {
		return params;
	}

	
	public void setParams(ParamDMRScnCall params) {
		this.params = params;
	}
}
