package com.example.sychiprpclibmcc.rpc;
/**
 * 
 * Title: PlatForm<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public enum PlatForm {
	Android(1), PC(2);

   private int platForm ;
   /*
    * 
    */
   private PlatForm( int _platForm) {
       this.platForm = _platForm;
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Enum#toString()
    */
   @Override
   public String toString() {
	   if(this.platForm == 1){
		   return "android";
	   }else if(this.platForm == 2){
		   return "PC";
	   }else{
		   return "";
	   }
   }
   
}