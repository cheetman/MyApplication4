package com.example.sychiprpclibmcc.req;

import java.io.Serializable;
/**
 * 
 * Title: ReqBaseRequest<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqBaseRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	public ReqBaseRequest() {

	}

	public ReqBaseRequest(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	/**
	 * Fixed to be "2.0"
	 */
	protected String rpcVer;

	/**
	 * An integer generated at client side and included in corresponding
	 * response.
	 */
	protected Integer transId;

	/**
	 * Request name. As defined in this document for each API.
	 */
	protected String method;


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
