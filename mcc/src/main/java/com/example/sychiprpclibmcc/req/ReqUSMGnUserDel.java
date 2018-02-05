package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqUSMGnUserDel<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqUSMGnUserDel extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;

	public ReqUSMGnUserDel(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamUSMGnUserDel implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private String userName;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		 
		
		
	}
	
	public ParamUSMGnUserDel getSimParam(){
		return new ParamUSMGnUserDel();
	}

	private ParamUSMGnUserDel params;


	public ParamUSMGnUserDel getParams() {
		return params;
	}

	
	public void setParams(ParamUSMGnUserDel params) {
		this.params = params;
	}
}
