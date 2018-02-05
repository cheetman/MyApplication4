package com.example.sychiprpclibmcc.rep;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepSYSGwInfoGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepSYSGwInfoGet extends RepBaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	public class ResultSYSGwInfoGet extends ResultBase {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8013491213172000468L;

		private String gwName;
		private String sysName;

		private String gwMode;

		private String ethMac;

		private String hwVersion;
		private String swVersion;

		public String getGwName() {
			return gwName;
		}

		public void setGwName(String gwName) {
			this.gwName = gwName;
		}

		public String getSysName() {
			return sysName;
		}

		public void setSysName(String sysName) {
			this.sysName = sysName;
		}

		public String getGwMode() {
			return gwMode;
		}

		public void setGwMode(String gwMode) {
			this.gwMode = gwMode;
		}

		public String getEthMac() {
			return ethMac;
		}

		public void setEthMac(String ethMac) {
			this.ethMac = ethMac;
		}

		public String getHwVersion() {
			return hwVersion;
		}

		public void setHwVersion(String hwVersion) {
			this.hwVersion = hwVersion;
		}

		public String getSwVersion() {
			return swVersion;
		}

		public void setSwVersion(String swVersion) {
			this.swVersion = swVersion;
		}
	}


	public ResultSYSGwInfoGet getSimResult() {
		return new ResultSYSGwInfoGet();
	}
	
	private ResultSYSGwInfoGet result;

	/**
	 * @return the result
	 */
	public ResultSYSGwInfoGet getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(ResultSYSGwInfoGet result) {
		this.result = result;
	}

}
