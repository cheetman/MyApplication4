package com.example.sychiprpclibmcc.rep;

import java.io.Serializable;
import java.util.List;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepUSMGnUserListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepUSMGnUserListGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	
	public class ResultUSMGnUserListGet extends ResultBase {
		
		
		
		private static final long serialVersionUID = 5309923457254491800L;
	
		private List<RpcUserName> accountObjList;
	
		public List<RpcUserName> getAccountObjList() {
			return accountObjList;
		}
	
		public void setAccountObjList(List<RpcUserName> accountObjList) {
			this.accountObjList = accountObjList;
		}
		
		
	}
	
	public class RpcUserName implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;
		
		private String userName;
		 

		/**
		 * get schedulerId
		 * @return the schedulerId
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 *  set schedulerId
		 * @param schedulerId the schedulerId to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
	}


	public RpcUserName getSimUserName() {
		return new RpcUserName();
	}

	public ResultUSMGnUserListGet getSimResult() {
		return new ResultUSMGnUserListGet();
	}
	
	
	private ResultUSMGnUserListGet  result;

	/**
	 * @return the result
	 */
	public ResultUSMGnUserListGet getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(ResultUSMGnUserListGet result) {
		this.result = result;
	}
}
