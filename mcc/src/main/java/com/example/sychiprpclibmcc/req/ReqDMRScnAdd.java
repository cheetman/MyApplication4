package com.example.sychiprpclibmcc.req;

import com.example.sychiprpclibmcc.bean.ObjScene;

/**
 * 
 * Title: ReqDMRScnAdd<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRScnAdd extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRScnAdd(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}


	private ObjScene params;


	public ObjScene getParams() {
		return params;
	}

	
	public void setParams(ObjScene params) {
		this.params = params;
	}
}
