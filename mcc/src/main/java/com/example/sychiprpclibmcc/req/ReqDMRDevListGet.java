package com.example.sychiprpclibmcc.req;

/**
 * 
 * Title: ReqDMRDevListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRDevListGet extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRDevListGet(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRDevListGet extends ParamBaseListGet {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int devType;
		
		public int getDevType() {
			return devType;
		}
		public void setDevType(int devType) {
			this.devType = devType;
		}
		 
	}
	
	public ParamDMRDevListGet getSimParam(){
		return new ParamDMRDevListGet();
	}

	private ParamDMRDevListGet params;


	public ParamDMRDevListGet getParams() {
		return params;
	}

	
	public void setParams(ParamDMRDevListGet params) {
		this.params = params;
	}
}
