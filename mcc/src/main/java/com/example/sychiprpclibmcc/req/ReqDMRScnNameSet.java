package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqDMRScnNameSet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRScnNameSet extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRScnNameSet(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRScnNameSet implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int scnId;
		private String scnName;
		public int getScnId() {
			return scnId;
		}
		public void setScnId(int scnId) {
			this.scnId = scnId;
		}
		public String getScnName() {
			return scnName;
		}
		public void setScnName(String scnName) {
			this.scnName = scnName;
		}
		
	}
	
	public ParamDMRScnNameSet getSimParam(){
		return new ParamDMRScnNameSet();
	}

	private ParamDMRScnNameSet params;


	public ParamDMRScnNameSet getParams() {
		return params;
	}

	
	public void setParams(ParamDMRScnNameSet params) {
		this.params = params;
	}
}
