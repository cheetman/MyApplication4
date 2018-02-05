package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqUSMGnUserAdd<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqUSMGnUserAdd extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;

	public ReqUSMGnUserAdd(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamUSMGnUserAdd implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private String userName;
		private String pwd;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		 
		
		
	}
	
	public ParamUSMGnUserAdd getSimParam(){
		return new ParamUSMGnUserAdd();
	}

	private ParamUSMGnUserAdd params;


	public ParamUSMGnUserAdd getParams() {
		return params;
	}

	
	public void setParams(ParamUSMGnUserAdd params) {
		this.params = params;
	}
}
