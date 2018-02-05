package com.example.sychiprpclibmcc.rpc;/** *  * Title: RpcJsonParm<br> * Description: Rpc Request's param and id  <br> * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of muRata. All Rights Reserved. <br> *  * @author SyChip * @version 0.0.01 *  */public class RpcJsonParm {	public static final String Project = "project";	public static final String Scheduler = "schedule";	public static final String RpcVer = "3.0";	public static final int Blocked = 0;	public static final int Permitted = 1;	public static final int TV = 0;	public static final int AC = 1;	// 所有时间加2秒，因为这个超时是控制硬件的超时,加2秒是为了网络延时//    public static final int Timeout120Seconds = 120 * 1000;    public static final int Timeout300Seconds = 300 * 1000 + 2 * 1000;    public static final int Timeout100Seconds = 100 * 1000 + 2 * 1000;    public static final int Timeout20Seconds = 20 * 1000 + 2 * 1000;//    public static final int TimeoutThirtySeconds = 30 * 1000 + 2 * 1000;    public static final int TimeoutTenSeconds = 10 * 1000 + 2 * 1000;	/**	 * Scheduler Item Status Change	 */	public static final String EVENT_CTR_EVT_SchStat = "CTR_EVT_SchStat";	/**	 * low battery report	 */	public static final String EVENT_DMR_EVT_LowBat = "DMR_EVT_LowBat"; 	/**	 * white list change event	 */	public static final String EVENT_USM_EVT_Offline = "USM_EVT_Offline";	/**	 * On/Off report event	 */	public static final String EVENT_DMR_EVT_OnOff = "DMR_EVT_OnOff";	/**	 * level event	 */	public static final String EVENT_DMR_EVT_Level = "DMR_EVT_Level";	public static final String EVENT_DMR_EVT_FH = "DMR_EVT_FH";	public static final String EVENT_DMR_EVT_AC = "DMR_EVT_AC";	public static final String EVENT_DMR_EVT_ES = "DMR_EVT_ES";	/**	 * scene event	 */	public static final String EVENT_SCENE = "RPC_APPSCN_EVT_Status";		public static final int IdException = -1;	public static final int IdNetWorkConnected = 1;	public static final int IdNetWorkDisConnected = 2;	    	private static int iNo = 100;	public static final int Id_EVENT_DMR_EVT_Level = ++iNo;	public static final int Id_EVENT_DMR_EVT_LowBat = ++iNo;	public static final int Id_Event_DMR_EVT_OnOff = ++iNo;	public static final int Id_EVENT_USM_EVT_Offline = ++iNo;	public static final int Id_Event_CTR_EVT_SchStat = ++iNo;	public static final int Id_Event_DMR_EVT_FH = ++iNo;	public static final int Id_Event_DMR_EVT_AC = ++iNo;	public static final int Id_Event_DMR_EVT_ES = ++iNo;	public static final int IdConnected = ++iNo;		public static final int IdSsdp = ++iNo;					/**	 * USM_Auth request ID	 */	public static final int Id_USMAuth = ++iNo;		public static final String Md_USMAuth = "USM_Auth";	/**	 * USM_Ec_Option_Set ID	 */	public static final int Id_USMEcOptionSet = ++iNo;	public static final String Md_USMEcOptionSet = "USM_Ec_Option_Set";		/**	 * USM_GnUser_Add ID	 */	public static final int Id_USMGnUserAdd = ++iNo;	public static final String Md_USMGnUserAdd = "USM_GnUser_Add";		/**	 * USM_User_Change ID	 */	public static final int Id_USMUserChange = ++iNo;	public static final String Md_USMUserChange = "USM_User_Change";	/**	 * USM_GnUser_Del ID	 */	public static final int Id_USMGnUserDel = ++iNo;	public static final String Md_USMGnUserDel = "USM_GnUser_Del";	/**	 * USM_GnUserList_Get ID	 */	public static final int Id_USMGnUserListGet = ++iNo;	public static final String Md_USMGnUserListGet = "USM_GnUserList_Get";		/**	 * USM_User_Reset ID	 */	public static final int Id_USMUserReset = ++iNo;	public static final String Md_USMUserReset = "USM_User_Reset";	/**	 * SYS_GwInfo_Get ID	 */	public static final int Id_SYSGwInfoGet = ++iNo;	public static final String Md_SYSGwInfoGet = "SYS_GwInfo_Get";	/**	 * SYS_DDNSInfo_Get ID	 */	public static final int Id_SYSDdnsInfoGet = ++iNo;	public static final String Md_SYSDdnsInfoGet = "SYS_DDNS_Info_Get";	/**	 * DMR_RoomList_Get ID	 */	public static final int Id_DMRRoomListGet = ++iNo;	public static final String Md_DMRRoomListGet = "DMR_RoomList_Get";	/**	 * DMR_DevList_Get ID	 */	public static final int Id_DMRDevListGet = ++iNo;	public static final String Md_DMRDevListGet = "DMR_DevList_Get";	/**	 * DMR_DevList_Get ID	 */	public static final int Id_DMRDevScnNumListGet = ++iNo;	public static final String Md_DMRDevScnNumListGet = "DMR_DevScnNumList_Get";	/**	 * DMR_Bat_Scan request ID	 */	public static final int Id_USMCancelLast = ++iNo;	public static final String Md_USMCancelLast = "USM_Cancel_Last";	/**	 * DMR_Ping request ID	 */	public static final int Id_DMRPing = ++iNo;	public static final String Md_DMRPing = "DMR_Ping";	/**	 * DMR_Bat_Scan request ID	 */	public static final int Id_DMRBatScan = ++iNo;	public static final String Md_DMRBatScan = "DMR_Bat_Scan";	/**	 * DMR_ScnGenList_Get request ID	 */	public static final int Id_DMRScnGenListGet = ++iNo;	public static final String Md_DMRScnGenListGet = "DMR_ScnGenList_Get";	/**	 * DMR_ScnCfgList_Get request ID	 */	public static final int Id_DMRScnCfgListGet = ++iNo;	public static final String Md_DMRScnCfgListGet = "DMR_ScnCfgList_Get";				/**	 * DMR_OnOff_Get request ID	 */	public static final int Id_DMROnOffGet = ++iNo;	public static final String Md_DMROnOffGet = "DMR_OnOff_Get";	/**	 * DMR_OnOff_Set request ID	 */	public static final int Id_DMROnOffSet = ++iNo;	public static final String Md_DMROnOffSet = "DMR_OnOff_Set";	/**	 * DMR_AC_Get request ID	 */	public static final int Id_DMRACGet = ++iNo;	public static final String Md_DMRACGet = "DMR_AC_Get";	/**	 * DMR_AC_SpecData_Get request ID	 */	public static final int Id_DMRACSpecDataGet = ++iNo;	public static final String Md_DMRACSpecDataGet = "DMR_AC_SpecData_Get";	/**	 * DMR_AC_Ctrl request ID	 */	public static final int Id_DMRACCtrl = ++iNo;	public static final String Md_DMRACCtrl = "DMR_AC_Ctrl";	/**	 * DMR_BGM_Ctrl request ID	 */	public static final int Id_DMRBGMCtrl = ++iNo;	public static final String Md_DMRBGMCtrl = "DMR_BGM_Ctrl";	/**	 * DMR_ES_Get request ID	 */	public static final int Id_DMRESGet = ++iNo;	public static final String Md_DMRESGet = "DMR_ES_Get";	/**	 * DMR_FH_Get request ID	 */	public static final int Id_DMRFHGet = ++iNo;	public static final String Md_DMRFHGet = "DMR_FH_Get";	/**	 * DMR_FH_SpecData_Get request ID	 */	public static final int Id_DMRFHSpecDataGet = ++iNo;	public static final String Md_DMRFHSpecDataGet = "DMR_FH_SpecData_Get";	/**	 * DMR_FH_Ctrl request ID	 */	public static final int Id_DMRFHCtrl = ++iNo;	public static final String Md_DMRFHCtrl = "DMR_FH_Ctrl";	/**	 * DMR_Level_Get request ID	 */	public static final int Id_DMRLevelGet = ++iNo;	public static final String Md_DMRLevelGet = "DMR_Level_Get";	/**	 * DMR_Level_Set request ID	 */	public static final int Id_DMRLevelSet = ++iNo;	public static final String Md_DMRLevelSet = "DMR_Level_Set";			/**	 * DMR_Level_Move request ID	 */	public static final int Id_DMRLevelMove = ++iNo;	public static final String Md_DMRLevelMove = "DMR_Level_Move";		/**	 * DMR_Level_Stop request ID	 */	public static final int Id_DMRLevelStop = ++iNo;	public static final String Md_DMRLevelStop = "DMR_Level_Stop";		 		public static final int Id_DMRDevNameSet = ++iNo;	public static final String Md_DMRDevNameSet = "DMR_DevName_Set";	/**	 * DMR_ScnName_Set request ID	 */	public static final int Id_DMRScnNameSet = ++iNo;	public static final String Md_DMRScnNameSet = "DMR_ScnName_Set";		public static final int Id_DMRScnAdd = ++iNo;	public static final String Md_DMRScnAdd = "DMR_Scn_Add";	public static final int Id_DMRScnDel = ++iNo;	public static final String Md_DMRScnDel = "DMR_Scn_Del";	public static final int Id_DMRScnRecall = ++iNo;	public static final String Md_DMRScnRecall = "DMR_Scn_Recall";		/**	 * USM_HeartBeat request ID	 */	public static final String Md_USMHeartBeat = "USM_Heartbeat";		/**	 * DMR_IR_Send request ID	 */	public static final int Id_DMRIRSend = ++iNo;	public static final String Md_DMRIRSend = "DMR_IR_Send";	/**	 * DMR_IR_ExFuncList_Get request ID	 */	public static final int Id_DMRIRExFuncListGet = ++iNo;	public static final String Md_DMRIRExFuncListGet = "DMR_IR_ExFuncList_Get";		/**	 * CTR_Sch_TaskList_Get request ID	 */	public static final int Id_CTRSchTaskListGet = ++iNo;	public static final String Md_CTRSchTaskListGet = "CTR_Sch_TaskList_Get";		/**	 * CTR_Sch_Task_Clear request ID	 */	public static final int Id_CTRSchTaskClear = ++iNo;	public static final String Md_CTRSchTaskClear = "CTR_Sch_Task_Clear";		/**	 * CTR_Sch_Task_Param_Set request ID	 */	public static final int Id_CTRSchTaskParamSet = ++iNo;	public static final String Md_CTRSchTaskParamSet = "CTR_Sch_Task_Param_Set";		/**	 * CTR_Sch_Option_Set request ID	 */	public static final int Id_CTRSchOptionSet = ++iNo;	public static final String Md_CTRSchOptionSet = "CTR_Sch_Option_Set";	}