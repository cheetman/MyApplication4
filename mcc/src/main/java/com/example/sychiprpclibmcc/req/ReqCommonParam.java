package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqCommonParam<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqCommonParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	public class Param implements Serializable {
		private static final long serialVersionUID = 5309923457254491800L;

	}
	public ReqCommonParam() {

	}

	public ReqCommonParam(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
		this.params = new Param();
	}


	private Param params;


	public Param getParams() {
		return params;
	}

	
	public void setParams(Param params) {
		this.params = params;
	}
	
	/**
	 * Fixed to be "2.0"
	 */
	private String rpcVer;

	/**
	 * An integer generated at client side and included in corresponding
	 * response.
	 */
	private Integer transId;

	/**
	 * Request name. As defined in this document for each API.
	 */
	private String method;


	/**
	 * @return the jsonrpc
	 */
	public String getRpcVer() {
		return rpcVer;
	}

	/**
	 * @param jsonrpc
	 *            the jsonrpc to set
	 */
	public void setRpcVer(String rpcVer) {
		this.rpcVer = rpcVer;
	}

	/**
	 * @return the transId
	 */
	public Integer getTransId() {
		return transId;
	}

	/**
	 * @param transId
	 *            the transId to set
	 */
	public void setTransId(Integer transId) {
		this.transId = transId;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

}
