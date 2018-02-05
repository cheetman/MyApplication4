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
public class RepDMRRoomListGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
	
	public class RpcRoom  implements Serializable {
		private static final long serialVersionUID = 5309923457254491800L;
	
		private Integer roomId;
		private String roomName;
		public Integer getRoomId() {
			return roomId;
		}
		public void setRoomId(Integer roomId) {
			this.roomId = roomId;
		}
		public String getRoomName() {
			return roomName;
		}
		public void setRoomName(String roomName) {
			this.roomName = roomName;
		}

	}
	
	
	public class RepDMRRoomListGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int totalNumber;
		private List<RpcRoom> roomObjList;
		public int getTotalNumber() {
			return totalNumber;
		}
		public void setTotalNumber(int totalNumber) {
			this.totalNumber = totalNumber;
		}
		public List<RpcRoom> getRoomObjList() {
			return roomObjList;
		}
		public void setRoomObjList(List<RpcRoom> roomObjList) {
			this.roomObjList = roomObjList;
		}

	}
	
	


	public RpcRoom getSimRpcRoom(){
		return new RpcRoom();
	}
	
	public RepDMRRoomListGetResult getSimResult(){
		return new RepDMRRoomListGetResult();
	}
	/**
	 * Network object defined in 3.1.1.
	 */
	private RepDMRRoomListGetResult result;

	/**
	 * @return the result
	 */
	public RepDMRRoomListGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRRoomListGetResult result) {
		this.result = result;
	}

	
}
