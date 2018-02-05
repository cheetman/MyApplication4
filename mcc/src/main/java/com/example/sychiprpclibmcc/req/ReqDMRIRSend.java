package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqDMRIRSend<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRIRSend extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRIRSend(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRIRSend implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int devId;
		private int funcId;
		private int repeat;
		private int codeType;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}
		public int getFuncId() {
			return funcId;
		}
		public void setFuncId(int funcId) {
			this.funcId = funcId;
		}
		public int getRepeat() {
			return repeat;
		}
		public void setRepeat(int repeat) {
			this.repeat = repeat;
		}
		public int getCodeType() {
			return codeType;
		}
		public void setCodeType(int codeType) {
			this.codeType = codeType;
		}
	
	}
	
	public ParamDMRIRSend getSimParam(){
		return new ParamDMRIRSend();
	}

	private ParamDMRIRSend params;


	public ParamDMRIRSend getParams() {
		return params;
	}

	
	public void setParams(ParamDMRIRSend params) {
		this.params = params;
	}
}
