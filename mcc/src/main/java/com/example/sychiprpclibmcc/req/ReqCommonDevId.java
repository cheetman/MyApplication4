package com.example.sychiprpclibmcc.req;


/**
 * 
 * Title: ReqCommonDevId<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqCommonDevId extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqCommonDevId(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}
	


	private ParamDevId params;


	public ParamDevId getParams() {
		return params;
	}

	
	public void setParams(ParamDevId params) {
		this.params = params;
	}
}
