package com.example.sychiprpclibmcc.req;

/**
 * 
 * Title: ReqCommonListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqCommonListGet extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqCommonListGet(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

 
	
	public ParamBaseListGet getSimParam(){
		return new ParamBaseListGet();
	}

	private ParamBaseListGet params;


	public ParamBaseListGet getParams() {
		return params;
	}

	
	public void setParams(ParamBaseListGet params) {
		this.params = params;
	}
}
