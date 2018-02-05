package com.example.sychiprpclibmcc.rep;


import com.example.sychiprpclibmcc.bean.ResultBase;

/**
 * 
 * Title: RepDMRACSpecDataGet<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public class RepDMRACSpecDataGet extends RepBaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309923457254491800L;

	public class RepDMRACSpecDataGetResult extends ResultBase {
		private static final long serialVersionUID = 5309923457254491800L;
		
		private int lowTemp;
		private int highTemp;
		private boolean halfTemp;
		private int windMode;
		public int getLowTemp() {
			return lowTemp;
		}
		public void setLowTemp(int lowTemp) {
			this.lowTemp = lowTemp;
		}
		public int getHighTemp() {
			return highTemp;
		}
		public void setHighTemp(int highTemp) {
			this.highTemp = highTemp;
		}
		public boolean isHalfTemp() {
			return halfTemp;
		}
		public void setHalfTemp(boolean halfTemp) {
			this.halfTemp = halfTemp;
		}
		public int getWindMode() {
			return windMode;
		}
		public void setWindMode(int windMode) {
			this.windMode = windMode;
		}

	}
	

	public RepDMRACSpecDataGetResult getSimResult(){
		return new RepDMRACSpecDataGetResult();
	}
	

	private RepDMRACSpecDataGetResult result;

	/**
	 * @return the result
	 */
	public RepDMRACSpecDataGetResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(RepDMRACSpecDataGetResult result) {
		this.result = result;
	}

	
}
