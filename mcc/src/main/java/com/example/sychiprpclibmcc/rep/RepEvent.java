package com.example.sychiprpclibmcc.rep;

import java.io.Serializable;

import com.example.sychiprpclibmcc.bean.EventParam;

/**
 * 
 * Title: RepEvent<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepEvent implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
 
  
	private String rpcVer;
	public String getRpcVer() {
		return rpcVer;
	}

	public void setRpcVer(String rpcVer) {
		this.rpcVer = rpcVer;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public EventParam getParams() {
		return params;
	}

	public void setParams(EventParam params) {
		this.params = params;
	}

	private String method;

	private EventParam  params;
 

}
