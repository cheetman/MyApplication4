package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ParamBaseListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ParamBaseListGet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	private int startIndex = 1;
	private int maxItems = 50;
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getMaxItems() {
		return maxItems;
	}
	public void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}
	
}
