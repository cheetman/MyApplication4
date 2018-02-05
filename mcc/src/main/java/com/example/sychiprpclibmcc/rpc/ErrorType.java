package com.example.sychiprpclibmcc.rpc;

/**
 * 
 * Title: ErrorType<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.0.01
 *
 */
public enum ErrorType {
	DisConnected(0),SocketRecieve(1),SocketSend(2),SsdpSearch(3),RpcCmdNotInit(4);
	   private int type ;

	   /*
	    * 
	    */
	   private ErrorType( int _type) {
	       this.type = _type;
	   }
	   
	   /*
	    * (non-Javadoc)
	    * @see java.lang.Enum#toString()
	    */
	 @Override
	   public String toString() {
		   if(this.type == 0){
			   return "DisConnected";
		   }else if(this.type == 1){
			   return "SocketRecieve";
		   }else if(this.type == 2){
			   return "SocketSend";
		   }else if(this.type == 3){
			   return "SsdpSearch";
		   }else if(this.type == 4){
			   return "RpcCmdNotInit";
		   }else{
			   return "Unknow";
		   }
	   }
	   
}
