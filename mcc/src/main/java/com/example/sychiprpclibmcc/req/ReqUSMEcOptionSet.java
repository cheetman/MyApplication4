package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqUSMEcOptionSet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqUSMEcOptionSet extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;

	public ReqUSMEcOptionSet(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamUSMEcOptionSet implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;
		

		private boolean isExclusive;
		
	 
		/**
		 * @return the isExclusive
		 */
		public boolean isIsExclusive() {
			return isExclusive;
		}


		/**
		 * @param isExclusive the bindFlag to set
		 */
		public void setIsExclusive(boolean isExclusive) {
			this.isExclusive = isExclusive;
		}

	}
	
	public ParamUSMEcOptionSet getSimParam(){
		return new ParamUSMEcOptionSet();
	}

	private ParamUSMEcOptionSet params;


	public ParamUSMEcOptionSet getParams() {
		return params;
	}

	
	public void setParams(ParamUSMEcOptionSet params) {
		this.params = params;
	}
}
