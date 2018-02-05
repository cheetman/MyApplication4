package com.example.sychiprpclibmcc.bean;

import java.io.Serializable;
/**
 * 
 * Title: ResultError<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ResultError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	/**
	 * An integer to indicate the error type
	 * <p>-32700	Parse error	Invalid JSON was received by the server. An error occurred on the server while parsing the JSON text.
	 * <p>-32600	Invalid Request	The JSON sent is not a valid Request object.
	 * <p>-32601	Method not found	The method does not exist / is not available.
	 * <p>-32602	Invalid params	Invalid method parameter(s).
	 * <p>-32603	Internal error	Internal JSON-RPC error.
	 * <p>-32000	Need Authentication
	 * <p>-32001	Server Busy
	 * <p>-32002	Timeout
	 * <p>-32003	User Cancelled
	 * <p>-32004	Destination Device NA
	 * <p>-32005	Command unsupported
	 */
	private int code;
	
	/**
	 * A string to describe the error shortly.
	 */
	private String message;

	/**
	 * get code
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * set code
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * get message
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * set message
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	

}
