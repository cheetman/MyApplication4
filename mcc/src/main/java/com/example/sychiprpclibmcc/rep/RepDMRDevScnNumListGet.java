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
public class RepDMRDevScnNumListGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	
	
	
	
	public class RepDMRDevScnNumListGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int totalNumber;
		private List<RpcDevice> dmrDevScnNumObjList;
		public int getTotalNumber() {
			return totalNumber;
		}
		public void setTotalNumber(int totalNumber) {
			this.totalNumber = totalNumber;
		}
		public List<RpcDevice> getDmrDevScnNumObjList() {
			return dmrDevScnNumObjList;
		}
		public void setDmrDevScnNumObjList(List<RpcDevice> dmrDevObjList) {
			this.dmrDevScnNumObjList = dmrDevObjList;
		}

	}
	

	public RpcDevice getSimRpcDevice(){
		return new RpcDevice();
	}
	
	public RepDMRDevScnNumListGetResult getSimResult(){
		return new RepDMRDevScnNumListGetResult();
	}

	private RepDMRDevScnNumListGetResult result;

	/**
	 * @return the result
	 */
	public RepDMRDevScnNumListGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRDevScnNumListGetResult result) {
		this.result = result;
	}

	
}
