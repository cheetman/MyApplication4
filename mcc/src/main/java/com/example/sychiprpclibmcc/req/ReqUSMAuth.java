package com.example.sychiprpclibmcc.req;

import java.io.Serializable;

/**
 * 
 * Title: ReqUSMAuth<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class ReqUSMAuth extends ReqBaseRequest {

	private static final long serialVersionUID = 5309923457254491800L;

	public ReqUSMAuth(int transId, String method) {
		this.transId = transId;
		this.method = method;
		this.rpcVer = "3.0";
	}

	public class ParamUSMAuth implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5309923457254491800L;

		/**
		 *userName
		 */
		private String userName;
		/**
		 *User password
		 */
		private String pwd;
		/**
		 *Device Specific ID.
		 */
		private String deviceId;
		/**
		 *"PC", "android", or "iOS"
		 */
		private String platform;
		/**
		 * @return the pwd
		 */
		public String getPwd() {
			return pwd;
		}
		/**
		 * @param pwd the pwd to set
		 */
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		/**
		 * @return the deviceId
		 */
		public String getDeviceId() {
			return deviceId;
		}
		/**
		 * @param deviceId the deviceId to set
		 */
		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}
		/**
		 * @return the platform
		 */
		public String getPlatform() {
			return platform;
		}
		/**
		 * @param platform the platform to set
		 */
		public void setPlatform(String platform) {
			this.platform = platform;
		}
		
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}

		
		
	}
	
	public ParamUSMAuth getSimParam(){
		return new ParamUSMAuth();
	}

	private ParamUSMAuth params;


	public ParamUSMAuth getParams() {
		return params;
	}

	
	public void setParams(ParamUSMAuth params) {
		this.params = params;
	}
}
