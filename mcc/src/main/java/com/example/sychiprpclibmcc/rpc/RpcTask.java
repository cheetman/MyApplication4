package com.example.sychiprpclibmcc.rpc;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Title: RpcTask<br>
 * Description: Rpc Commond's Task Manager<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 * 
 */
public class RpcTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	/**
	 * RpcTask
	 * @param transId unique ID
	 * @param requestId request Id
	 * @param nwkAddr nwkAddr
	 * @param epId epId
	 * @param reqInfo request Object
	 * @param timeout  timeout
	 */
	public RpcTask(int transId, int requestId,
			Object reqInfo, int timeout) {
		this.transId = transId;
		this.requestId = requestId;
		this.timeout = timeout;
		this.reqInfo = reqInfo;
		this.startTime = new Date(System.currentTimeMillis());// 当前时间
	}
	/**
	 * RpcTask
	 * @param transId unique ID
	 * @param requestId request Id
	 * @param reqInfo request Object
	 */
	public RpcTask(int transId, int requestId, Object reqInfo) {
		this.transId = transId;
		this.requestId = requestId;
		this.timeout = RpcJsonParm.TimeoutTenSeconds;
		this.reqInfo = reqInfo;
		this.startTime = new Date(System.currentTimeMillis());// 当前时间
	}

	/**
	 * RpcTask isTimeOut
	 * @return true or false
	 */
	public boolean isTimeOut() {
		Date now = new Date(System.currentTimeMillis());
		Boolean istimeout = (now.getTime() - startTime.getTime()) > this.timeout;
		if (istimeout) {

//			System.err.println(now.getTime() + "    " + startTime.getTime()
//					+ "     " + this.timeout);
		}
		return istimeout;
	}

	private boolean taskOver = false;

	/**
	 * request Info
	 */
	private Object reqInfo;

	/**
	 * @return the reqInfo
	 */
	public Object getReqInfo() {
		return reqInfo;
	}

	/**
	 * @param reqInfo
	 *            the reqInfo to set
	 */
	public void setReqInfo(Object reqInfo) {
		this.reqInfo = reqInfo;
	}

	/**
	 * request id
	 */
	private int requestId;

	/**
	 * request id
	 */
	private int transId;


	/**
	 * startTime
	 */
	private Date startTime;

	/**
	 * timeout
	 */
	private int timeout;

	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout
	 *            the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * @return the id
	 */
	public int getRequestId() {
		return requestId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setRequestId(int id) {
		this.requestId = id;
	}


	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the transId
	 */
	public int getTransId() {
		return transId;
	}

	/**
	 * @param transId
	 *            the transId to set
	 */
	public void setTransId(int transId) {
		this.transId = transId;
	}

	/**
	 * @return the taskOver
	 */
	public boolean isTaskOver() {
		return taskOver;
	}

	/**
	 * @param taskOver
	 *            the taskOver to set
	 */
	public void setTaskOver(boolean taskOver) {
		this.taskOver = taskOver;
	}

}
