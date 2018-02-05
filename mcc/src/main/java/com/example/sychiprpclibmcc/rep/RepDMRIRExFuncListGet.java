package com.example.sychiprpclibmcc.rep;

import java.io.Serializable;
import java.util.List;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepDMRIRExFuncListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMRIRExFuncListGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	
	public class RpcIRFunc implements Serializable {
		
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int funcType;
		private int funcId;
		private String funcName;
		public int getFuncType() {
			return funcType;
		}
		public void setFuncType(int funcType) {
			this.funcType = funcType;
		}
		public int getFuncId() {
			return funcId;
		}
		public void setFuncId(int funcId) {
			this.funcId = funcId;
		}
		public String getFuncName() {
			return funcName;
		}
		public void setFuncName(String funcName) {
			this.funcName = funcName;
		}
	}
	
	
	public class ResultRepDMRIRExFuncListGet extends ResultBase {

		
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int naFuncNum;
		private int custFuncNum;
		private int suppFuncNum;
		private List<RpcIRFunc> funcObjList;
		public int getNaFuncNum() {
			return naFuncNum;
		}
		public void setNaFuncNum(int naFuncNum) {
			this.naFuncNum = naFuncNum;
		}
		public int getCustFuncNum() {
			return custFuncNum;
		}
		public void setCustFuncNum(int custFuncNum) {
			this.custFuncNum = custFuncNum;
		}
		public int getSuppFuncNum() {
			return suppFuncNum;
		}
		public void setSuppFuncNum(int suppFuncNum) {
			this.suppFuncNum = suppFuncNum;
		}
		public List<RpcIRFunc> getFuncObjList() {
			return funcObjList;
		}
		public void setFuncObjList(List<RpcIRFunc> funcObjList) {
			this.funcObjList = funcObjList;
		}
	
	}

	public RpcIRFunc getRpcIRFunc() {
		return new RpcIRFunc();
	}
	
	
	public ResultRepDMRIRExFuncListGet getSimResult() {
		return new ResultRepDMRIRExFuncListGet();
	}
	
	
	private ResultRepDMRIRExFuncListGet  result;

	/**
	 * @return the result
	 */
	public ResultRepDMRIRExFuncListGet getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(ResultRepDMRIRExFuncListGet result) {
		this.result = result;
	}
}
