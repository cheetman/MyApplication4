package com.example.sychiprpclibmcc.rep;

import java.util.List;

import com.example.sychiprpclibmcc.bean.ResultBase;
import com.example.sychiprpclibmcc.bean.RpcDevice;

/**
 * 
 * Title: RepDMRDevListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMRDevListGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	
	
	
	public class RepDMRDevListGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int totalNumber;
		private List<RpcDevice> dmrDevObjList;
		public int getTotalNumber() {
			return totalNumber;
		}
		public void setTotalNumber(int totalNumber) {
			this.totalNumber = totalNumber;
		}
		public List<RpcDevice> getDmrDevObjList() {
			return dmrDevObjList;
		}
		public void setDmrDevObjList(List<RpcDevice> dmrDevObjList) {
			this.dmrDevObjList = dmrDevObjList;
		}

	}
	

	public RpcDevice getSimRpcDevice(){
		return new RpcDevice();
	}
	
	public RepDMRDevListGetResult getSimResult(){
		return new RepDMRDevListGetResult();
	}

	private RepDMRDevListGetResult result;

	/**
	 * @return the result
	 */
	public RepDMRDevListGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRDevListGetResult result) {
		this.result = result;
	}

	
}
