package com.example.sychiprpclibmcc.rep;

import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepSYSDdnsInfoGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepSYSDdnsInfoGet extends RepBaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	public class ResultSYSDdnsInfoGet extends ResultBase {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8013491213172000468L;

		private String domainAddr;
		private Integer port;
		private Integer dataUsed;
		private Integer dataRemaining ;
		
		public String getDomainAddr() {
			return domainAddr;
		}
		public void setDomainAddr(String domainAddr) {
			this.domainAddr = domainAddr;
		}
		public Integer getPort() {
			return port;
		}
		public void setPort(Integer port) {
			this.port = port;
		}
		public Integer getDataUsed() {
			return dataUsed;
		}
		public void setDataUsed(Integer dataUsed) {
			this.dataUsed = dataUsed;
		}
		public Integer getDataRemaining() {
			return dataRemaining;
		}
		public void setDataRemaining(Integer dataRemaining) {
			this.dataRemaining = dataRemaining;
		}

		
	}


	public ResultSYSDdnsInfoGet getSimResult() {
		return new ResultSYSDdnsInfoGet();
	}
	
	private ResultSYSDdnsInfoGet result;

	/**
	 * @return the result
	 */
	public ResultSYSDdnsInfoGet getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(ResultSYSDdnsInfoGet result) {
		this.result = result;
	}

}
