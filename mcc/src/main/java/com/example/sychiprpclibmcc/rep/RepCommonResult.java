package com.example.sychiprpclibmcc.rep;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepCommonResult<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepCommonResult extends RepBaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
 
	private ResultBase  result;

	/**
	 * @return the result
	 */
	public ResultBase getResult() {
		if(result == null ){
			result = new ResultBase();
		}
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(ResultBase result) {
		this.result = result;
	}

}
