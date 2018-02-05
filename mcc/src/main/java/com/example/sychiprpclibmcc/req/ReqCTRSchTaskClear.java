package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqCTRSchTaskClear<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqCTRSchTaskClear extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqCTRSchTaskClear(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamCTRSchTaskClear implements Serializable {
	
		private static final long serialVersionUID = 5309923457254491800L;

		private int schTaskId;
		public int getSchTaskId() {
			return schTaskId;
		}
		public void setSchTaskId(int schTaskId) {
			this.schTaskId = schTaskId;
		}
		
	}
	
	public ParamCTRSchTaskClear getSimParam(){
		return new ParamCTRSchTaskClear();
	}

	private ParamCTRSchTaskClear params;


	public ParamCTRSchTaskClear getParams() {
		return params;
	}

	
	public void setParams(ParamCTRSchTaskClear params) {
		this.params = params;
	}
}
