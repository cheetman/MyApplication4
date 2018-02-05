package com.example.sychiprpclibmcc.bean;

import java.io.Serializable;
/**
 * 
 * Title: RepLanIpGw<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepLanIpGw implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;
 
	private String uniqueId;
	private String ip;
	private String port;
	private String ethMac;
	private String systemName;
	public String getEthMac() {
		return ethMac;
	}
	public void setEthMac(String ethMac) {
		this.ethMac = ethMac;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	/**
	 * @return the uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	
	
}
