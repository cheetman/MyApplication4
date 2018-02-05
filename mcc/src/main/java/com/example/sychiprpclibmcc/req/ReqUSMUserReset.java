package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqUSMUserReset<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqUSMUserReset extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;

	public ReqUSMUserReset(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamUSMUserReset implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private String userName;
		private String newPwd;
		public String getNewPwd() {
			return newPwd;
		}
		public void setNewPwd(String newPwd) {
			this.newPwd = newPwd;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
	}
	
	public ParamUSMUserReset getSimParam(){
		return new ParamUSMUserReset();
	}

	private ParamUSMUserReset params;


	public ParamUSMUserReset getParams() {
		return params;
	}

	
	public void setParams(ParamUSMUserReset params) {
		this.params = params;
	}
}
