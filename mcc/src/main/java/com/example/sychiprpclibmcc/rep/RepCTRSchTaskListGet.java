package com.example.sychiprpclibmcc.rep;

import java.io.Serializable;
import java.util.List;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepCTRSchTaskListGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepCTRSchTaskListGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	
	public class RpcScheduler  implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;
	
		private Integer schTaskId;
		private String schTaskName;
		private boolean mon;
		private boolean tue;
		private boolean wed;
		private boolean thu;
		private boolean fri;
		private boolean sat;
		private boolean sun;
		private Integer hour;
		private Integer min;
		private Integer scnId;
		private Integer schTaskStatus;
		public Integer getSchTaskId() {
			return schTaskId;
		}
		public void setSchTaskId(Integer schTaskId) {
			this.schTaskId = schTaskId;
		}
		public String getSchTaskName() {
			return schTaskName;
		}
		public void setSchTaskName(String schTaskName) {
			this.schTaskName = schTaskName;
		}
		public boolean isMon() {
			return mon;
		}
		public void setMon(boolean mon) {
			this.mon = mon;
		}
		public boolean isTue() {
			return tue;
		}
		public void setTue(boolean tue) {
			this.tue = tue;
		}
		public boolean isWed() {
			return wed;
		}
		public void setWed(boolean wed) {
			this.wed = wed;
		}
		public boolean isThu() {
			return thu;
		}
		public void setThu(boolean thu) {
			this.thu = thu;
		}
		public boolean isFri() {
			return fri;
		}
		public void setFri(boolean fri) {
			this.fri = fri;
		}
		public boolean isSat() {
			return sat;
		}
		public void setSat(boolean sat) {
			this.sat = sat;
		}
		public boolean isSun() {
			return sun;
		}
		public void setSun(boolean sun) {
			this.sun = sun;
		}
		public Integer getHour() {
			return hour;
		}
		public void setHour(Integer hour) {
			this.hour = hour;
		}
		public Integer getMin() {
			return min;
		}
		public void setMin(Integer min) {
			this.min = min;
		}
		public Integer getScnId() {
			return scnId;
		}
		public void setScnId(Integer scnId) {
			this.scnId = scnId;
		}
		public Integer getSchTaskStatus() {
			return schTaskStatus;
		}
		public void setSchTaskStatus(Integer schTaskStatus) {
			this.schTaskStatus = schTaskStatus;
		}

	}
	
	
	public class RepCTRSchTaskListGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int totalNumber;
		private List<RpcScheduler> schTaskSimpObjList;
		public List<RpcScheduler> getSchTaskSimpObjList() {
			return schTaskSimpObjList;
		}
		public void setSchTaskSimpObjList(List<RpcScheduler> schTaskSimpObjList) {
			this.schTaskSimpObjList = schTaskSimpObjList;
		}
		public int getTotalNumber() {
			return totalNumber;
		}
		public void setTotalNumber(int totalNumber) {
			this.totalNumber = totalNumber;
		}

	}
	

	public RpcScheduler getSimRpcScheduler(){
		return new RpcScheduler();
	}
	
	public RepCTRSchTaskListGetResult getSimResult(){
		return new RepCTRSchTaskListGetResult();
	}
	
	/**
	 * Network object defined in 3.1.1.
	 */
	private RepCTRSchTaskListGetResult result;

	/**
	 * @return the result
	 */
	public RepCTRSchTaskListGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepCTRSchTaskListGetResult result) {
		this.result = result;
	}

	
}
