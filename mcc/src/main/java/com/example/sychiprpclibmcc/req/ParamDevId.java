package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ParamDevId<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ParamDevId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	private int devId;

	public int getDevId() {
		return devId;
	}

	public void setDevId(int devId) {
		this.devId = devId;
	}
	
}
