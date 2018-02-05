package com.example.sychiprpclibmcc.rep;

import java.io.Serializable;
import java.util.List;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepDMRRoomListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMREsGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	
	public class RpcEsData  implements Serializable {
		private static final long serialVersionUID = 5309923457254491800L;
	
		private Integer esType;//1: temperature; 2: humidity; 3: formaldehyde; 4: pm2.5; 5: co2; 6: noise; 7 ambient light
		private Integer esData;
		public Integer getEsType() {
			return esType;
		}
		public void setEsType(Integer esType) {
			this.esType = esType;
		}
		public Integer getEsData() {
			return esData;
		}
		public void setEsData(Integer esData) {
			this.esData = esData;
		}
	}
	
	
	public class RepDMREsGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int totalNumber;
		private List<RpcEsData> esDataObjList;
		public int getTotalNumber() {
			return totalNumber;
		}
		public void setTotalNumber(int totalNumber) {
			this.totalNumber = totalNumber;
		}
		public List<RpcEsData> getEsDataObjList() {
			return esDataObjList;
		}
		public void setEsDataObjList(List<RpcEsData> esDataObjList) {
			this.esDataObjList = esDataObjList;
		}

	}
	
	


	public RpcEsData getSimRpcEsData(){
		return new RpcEsData();
	}
	
	public RepDMREsGetResult getSimResult(){
		return new RepDMREsGetResult();
	}
	/**
	 * Network object defined in 3.1.1.
	 */
	private RepDMREsGetResult result;

	/**
	 * @return the result
	 */
	public RepDMREsGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMREsGetResult result) {
		this.result = result;
	}

	
}
