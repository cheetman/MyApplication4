package com.example.sychiprpclibmcc.rpc;
/**
 * 
 * Title: EventType<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public enum EventType {
	System(1), Warning(2), Report(2);

   private int eventType ;

   private EventType( int _eventType) {
       this.eventType = _eventType;
   }

   @Override
   public String toString() {
	   if(this.eventType == 1){
		   return "system";
	   }else if(this.eventType == 2){
		   return "warning";
	   }else if(this.eventType == 3){
		   return "report";
	   }else{
		   return "";
	   }
   }
   
}