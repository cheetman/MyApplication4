package com.example.sychiprpclibmcc.rpc;
/**
 * 
 * Title: DeviceType<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public enum DeviceType {
	DeviceULTI(1), DeviceIPCamera(2), DeviceAC(3), DeviceFH(4), DeviceAirC(5);
   private int deviceType ;

   /*
    * 
    */
   private DeviceType( int _deviceType) {
       this.deviceType = _deviceType;
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Enum#toString()
    */
   @Override
   public String toString() {
	   if(this.deviceType == 1){
		   return "DeviceULTI";
	   }else if(this.deviceType == 2){
		   return "DeviceIPCamera";
	   }else if(this.deviceType == 3){
		   return "DeviceAC";
	   }else if(this.deviceType == 4){
		   return "DeviceFH";
	   }else if(this.deviceType == 5){
		   return "DeviceAirC";
	   }else{
		   return "";
	   }
   }
   
}