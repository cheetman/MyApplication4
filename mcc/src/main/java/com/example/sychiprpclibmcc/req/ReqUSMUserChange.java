package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqUSMUserChange<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqUSMUserChange extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;

	public ReqUSMUserChange(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamUSMUserChange implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private String oldPwd;
		private String newPwd;
		public String getNewPwd() {
			return newPwd;
		}
		public void setNewPwd(String newPwd) {
			this.newPwd = newPwd;
		}
		public String getOldPwd() {
			return oldPwd;
		}
		public void setOldPwd(String oldPwd) {
			this.oldPwd = oldPwd;
		}
		 
		
		
	}
	
	public ParamUSMUserChange getSimParam(){
		return new ParamUSMUserChange();
	}

	private ParamUSMUserChange params;


	public ParamUSMUserChange getParams() {
		return params;
	}

	
	public void setParams(ParamUSMUserChange params) {
		this.params = params;
	}
}
