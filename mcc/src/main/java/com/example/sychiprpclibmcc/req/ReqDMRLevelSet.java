package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqDMRLevelSet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqDMRLevelSet extends ReqBaseRequest {


	private static final long serialVersionUID = 5309923457254491800L;
	
	public ReqDMRLevelSet(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamDMRLevelSet implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;


		private int devId;
		private int level;
		private int tt;
		public int getDevId() {
			return devId;
		}
		public void setDevId(int devId) {
			this.devId = devId;
		}

		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		public int getTt() {
			return tt;
		}
		public void setTt(int tt) {
			this.tt = tt;
		}

	}
	
	public ParamDMRLevelSet getSimParam(){
		return new ParamDMRLevelSet();
	}

	private ParamDMRLevelSet params;


	public ParamDMRLevelSet getParams() {
		return params;
	}

	
	public void setParams(ParamDMRLevelSet params) {
		this.params = params;
	}
}
