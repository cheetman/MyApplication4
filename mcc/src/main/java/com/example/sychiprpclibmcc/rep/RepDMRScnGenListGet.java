package com.example.sychiprpclibmcc.rep;


import java.io.Serializable;
import java.util.List;
import com.example.sychiprpclibmcc.bean.ResultBase;
import com.example.sychiprpclibmcc.rep.RepDMRScnCfgListGet.RpcSceneCfg;

/**
 * 
 * Title: RepDMRScnGenListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMRScnGenListGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	
	public class RpcSceneGen implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		private int scnId;
		private String scnName;
		private int devNum;
		private int scnTag;
		private List<RpcSceneCfg> listCfg;
		public int getScnId() {
			return scnId;
		}
		public void setScnId(int scnId) {
			this.scnId = scnId;
		}
		public String getScnName() {
			return scnName;
		}
		public void setScnName(String scnName) {
			this.scnName = scnName;
		}
		public int getDevNum() {
			return devNum;
		}
		public void setDevNum(int devNum) {
			this.devNum = devNum;
		}
		public int getScnTag() {
			return scnTag;
		}
		public void setScnTag(int scnTag) {
			this.scnTag = scnTag;
		}
		public List<RpcSceneCfg> getListCfg() {
			return listCfg;
		}
		public void setListCfg(List<RpcSceneCfg> listCfg) {
			this.listCfg = listCfg;
		}
	
		
	}
	
	
	public class RepDMRScnGenListGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int totalNumber;
		private List<RpcSceneGen> scnGenObjList;
		public int getTotalNumber() {
			return totalNumber;
		}
		public void setTotalNumber(int totalNumber) {
			this.totalNumber = totalNumber;
		}
		public List<RpcSceneGen> getScnGenObjList() {
			return scnGenObjList;
		}
		public void setScnGenObjList(List<RpcSceneGen> scnGenObjList) {
			this.scnGenObjList = scnGenObjList;
		}
	

	}
	
	


	public RpcSceneGen getSimRpcRoom(){
		return new RpcSceneGen();
	}
	
	public RepDMRScnGenListGetResult getSimResult(){
		return new RepDMRScnGenListGetResult();
	}
	/**
	 * Network object defined in 3.1.1.
	 */
	private RepDMRScnGenListGetResult result;

	/**
	 * @return the result
	 */
	public RepDMRScnGenListGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRScnGenListGetResult result) {
		this.result = result;
	}

	
}
