package com.example.sychiprpclibmcc.req;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Title: ReqCommonDevIdList<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqCommonDevIdList extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqCommonDevIdList(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	
	public class ParamCommonDevIdList implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private List<ParamDevId> devIdList;

		public List<ParamDevId> getDevIdList() {
			return devIdList;
		}

		public void setDevIdList(List<ParamDevId> devIdList) {
			this.devIdList = devIdList;
		}
		
	}
	
	public ParamCommonDevIdList getSimParam(){
		return new ParamCommonDevIdList();
	}

	private ParamCommonDevIdList params;


	public ParamCommonDevIdList getParams() {
		return params;
	}

	
	public void setParams(ParamCommonDevIdList params) {
		this.params = params;
	}
}
