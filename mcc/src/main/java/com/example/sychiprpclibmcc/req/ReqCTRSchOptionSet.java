package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqCTRSchOptionSet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqCTRSchOptionSet extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqCTRSchOptionSet(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}
	
	public class ParamCTRSchOptionSet implements Serializable {
		private static final long serialVersionUID = 5309923457254491800L;

		private int schTaskId;
		private int option;
		public int getSchTaskId() {
			return schTaskId;
		}
		public void setSchTaskId(int schTaskId) {
			this.schTaskId = schTaskId;
		}
		public int getOption() {
			return option;
		}
		public void setOption(int option) {
			this.option = option;
		}
	}
	public ParamCTRSchOptionSet getSimParam(){
		return new ParamCTRSchOptionSet();
	}

	private ParamCTRSchOptionSet params;


	public ParamCTRSchOptionSet getParams() {
		return params;
	}

	
	public void setParams(ParamCTRSchOptionSet params) {
		this.params = params;
	}
}
