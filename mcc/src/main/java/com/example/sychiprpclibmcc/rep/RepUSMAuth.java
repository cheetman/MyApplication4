package com.example.sychiprpclibmcc.rep;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepUSMAuth<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepUSMAuth extends RepBaseResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
 
 
	public class ResultUSMAuth extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;

		private int type;

	 
		public int getType() {
			return type;
		}
 
		public void setType(int type) {
			this.type = type;
		}
	}

	public ResultUSMAuth getSimResult() {
		return new ResultUSMAuth();
	}
	
	

	private ResultUSMAuth  result;

	/**
	 * @return the result
	 */
	public ResultUSMAuth getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(ResultUSMAuth result) {
		this.result = result;
	}
	

}
