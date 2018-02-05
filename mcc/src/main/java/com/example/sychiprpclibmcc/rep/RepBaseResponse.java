package com.example.sychiprpclibmcc.rep;

import java.io.Serializable;

import com.example.sychiprpclibmcc.bean.ResultError;
import com.example.sychiprpclibmcc.rpc.RetCode;
/**
 * 
 * Title: RepBaseResponse<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepBaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	
	/**
 * Fixed to be "2.0"
 */
	private String rpcVer;
	/**
 * timeout
 */
	private boolean timeout;
	/**
 * request Object
 */
	private Object request;
	
	/**
	 * Defined in 2.4.3.1. Required when the API call failure
	 */
	private ResultError error;
	/**
	 * Must be same with the request.
	 */
	private Integer transId;
	/**
	 * If the response is the end.
	 */
	private boolean hasContinue;
	
	/**
	 * Only for event,event name. As defined in this document for each API.
	 */
	private String method;


	/**
	 *  The code and meaning are defined in 2.4.3.2.1
	 *  -1	General operation failure. It means the request is handled by the target device or module but the operation is failed.<p>
     *  -2	Need Authentication<p>
     *  -3	Invalid parameters.<p>
     *  -4	Destination Device not available.<p>
     *  -5	Server Busy. The client should send the request later.<p>
     *  -6	Transaction in process. The client sends a request when the previous request in same type is pending.<p>
     *  -7	Timeout.<p>
     *  -8	User Cancelled.<p>
     * -9	Internal error<p>
     *  -10~--99	reserved<p>
     *  &lt;= -100	API-specific error.
	 */
	private int retCode;
	

	/**
	 * get retCode
	 * @return the retCode
	 */
	public int getRetCode() {
		return retCode;
	}

	/**
	 * set retCode
	 * @param retCode the retCode to set
	 */
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	
	/**
	 * get rpcVer
	 * @return the rpcVer
	 */
	public String getRpcVer() {
		return rpcVer;
	}

	/**
	 * set rpcVer
	 * @param rpcVer the rpcVer to set
	 */
	public void setRpcVer(String rpcVer) {
		this.rpcVer = rpcVer;
	}

	/**
	 * get error
	 * @return the error
	 */
	public ResultError getError() {
		return error;
	}

	/**
	 * set error
	 * @param error the error to set
	 */
	public void setError(ResultError error) {
		this.error = error;
	}

	

	/**
	 * @return the transId
	 */
	public Integer getTransId() {
		return transId;
	}

	/**
	 * @param transId the transId to set
	 */
	public void setTransId(Integer transId) {
		this.transId = transId;
	}

	/**
	 * get hasContinue
	 * @return the hasContinue
	 */
	public boolean isHasContinue() {
		return hasContinue;
	}

	/**
	 * set hasContinue
	 * @param hasContinue the hasContinue to set
	 */
	public void setHasContinue(boolean hasContinue) {
		this.hasContinue = hasContinue;
	}

	/**
	 * get method
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * set method
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the timeout
	 */
	public boolean isTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
		if(timeout){
			this.retCode = RetCode.TIMEOUT;
		}
	}

	/**
	 * @return the request
	 */
	public Object getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(Object request) {
		this.request = request;
	}
	


}
