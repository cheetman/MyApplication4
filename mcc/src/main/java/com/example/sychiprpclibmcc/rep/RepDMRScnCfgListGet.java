package com.example.sychiprpclibmcc.rep;


import java.util.List;

import com.example.sychiprpclibmcc.bean.ObjScene;
import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepDMRScnCfgListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMRScnCfgListGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	
	public class RpcSceneCfg extends ObjScene {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int scnTag;

		public int getScnTag() {
			return scnTag;
		}

		public void setScnTag(int scnTag) {
			this.scnTag = scnTag;
		}
		
	}
	
	
	public class RepDMRScnCfgListGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int totalNumber;
		private List<RpcSceneCfg> scnCfgObjList;
		public int getTotalNumber() {
			return totalNumber;
		}
		public void setTotalNumber(int totalNumber) {
			this.totalNumber = totalNumber;
		}
		public List<RpcSceneCfg> getScnCfgObjList() {
			return scnCfgObjList;
		}
		public void setScnCfgObjList(List<RpcSceneCfg> scnCfgObjList) {
			this.scnCfgObjList = scnCfgObjList;
		}
	

	}
	
	


	public RpcSceneCfg getSimRpcRoom(){
		return new RpcSceneCfg();
	}
	
	public RepDMRScnCfgListGetResult getSimResult(){
		return new RepDMRScnCfgListGetResult();
	}
	/**
	 * Network object defined in 3.1.1.
	 */
	private RepDMRScnCfgListGetResult result;

	/**
	 * @return the result
	 */
	public RepDMRScnCfgListGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRScnCfgListGetResult result) {
		this.result = result;
	}

	
}
