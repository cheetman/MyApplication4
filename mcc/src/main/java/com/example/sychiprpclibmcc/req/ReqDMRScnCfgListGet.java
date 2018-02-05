package com.example.sychiprpclibmcc.req;

/**
 * 
 * Title: ReqDMRScnCfgListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRScnCfgListGet extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRScnCfgListGet(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRScnCfgListGet extends ParamBaseListGet {
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

	
	public ParamDMRScnCfgListGet getSimParam(){
		return new ParamDMRScnCfgListGet();
	}

	private ParamDMRScnCfgListGet params;


	public ParamDMRScnCfgListGet getParams() {
		return params;
	}

	
	public void setParams(ParamDMRScnCfgListGet params) {
		this.params = params;
	}
}
