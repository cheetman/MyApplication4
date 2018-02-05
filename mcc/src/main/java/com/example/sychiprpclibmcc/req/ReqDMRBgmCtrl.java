package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqDMRBgmCtrl<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRBgmCtrl extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRBgmCtrl(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRBgmCtrl implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int devId;
		private int ctrlCmd;
		private int param;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}
		public int getCtrlCmd() {
			return ctrlCmd;
		}
		public void setCtrlCmd(int ctrlCmd) {
			this.ctrlCmd = ctrlCmd;
		}
		public int getParam() {
			return param;
		}
		public void setParam(int param) {
			this.param = param;
		}
		
	}
	
	public ParamDMRBgmCtrl getSimParam(){
		return new ParamDMRBgmCtrl();
	}

	private ParamDMRBgmCtrl params;


	public ParamDMRBgmCtrl getParams() {
		return params;
	}

	
	public void setParams(ParamDMRBgmCtrl params) {
		this.params = params;
	}
}
