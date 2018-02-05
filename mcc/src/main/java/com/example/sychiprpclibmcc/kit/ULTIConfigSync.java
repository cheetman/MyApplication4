package com.example.sychiprpclibmcc.kit;

import java.util.ArrayList;
import java.util.List;

import com.example.sychiprpclibmcc.bean.EventParam;
import com.example.sychiprpclibmcc.bean.RepLanIpGw;
import com.example.sychiprpclibmcc.bean.RpcDevice;
import com.example.sychiprpclibmcc.rep.RepCTRSchTaskListGet;
import com.example.sychiprpclibmcc.rep.RepCTRSchTaskListGet.RpcScheduler;
import com.example.sychiprpclibmcc.rep.RepCommonResult;
import com.example.sychiprpclibmcc.rep.RepDMRACGet;
import com.example.sychiprpclibmcc.rep.RepDMRACSpecDataGet;
import com.example.sychiprpclibmcc.rep.RepDMRBatScan;
import com.example.sychiprpclibmcc.rep.RepDMREsGet;
import com.example.sychiprpclibmcc.rep.RepDMREsGet.RpcEsData;
import com.example.sychiprpclibmcc.rep.RepDMRFHGet;
import com.example.sychiprpclibmcc.rep.RepDMRFHSpecDataGet;
import com.example.sychiprpclibmcc.rep.RepDMRIRExFuncListGet.RpcIRFunc;
import com.example.sychiprpclibmcc.rep.RepDMRIRExFuncListGet;
import com.example.sychiprpclibmcc.rep.RepDMRLevelGet;
import com.example.sychiprpclibmcc.rep.RepDMROnOffGet;
import com.example.sychiprpclibmcc.rep.RepDMRPing;
import com.example.sychiprpclibmcc.rep.RepDMRRoomListGet.RpcRoom;
import com.example.sychiprpclibmcc.rep.RepDMRScnCfgListGet.RpcSceneCfg;
import com.example.sychiprpclibmcc.rep.RepDMRScnGenListGet.RpcSceneGen;
import com.example.sychiprpclibmcc.rep.RepSYSDdnsInfoGet;
import com.example.sychiprpclibmcc.rep.RepSYSGwInfoGet;
import com.example.sychiprpclibmcc.rep.RepUSMAuth;
import com.example.sychiprpclibmcc.rep.RepUSMGnUserListGet;
import com.example.sychiprpclibmcc.rpc.RpcCallBackIf;
import com.example.sychiprpclibmcc.rpc.RpcCommand;
import com.example.sychiprpclibmcc.rpc.RpcJsonParm;

/**
 * Lighting JavaBean
 * 
 * @Copyright:
 * @author
 * @modify
 * 
 * @see com.schneider.electric.smarthome.device.Device
 * @version 1.0
 **/
public class ULTIConfigSync implements RpcCallBackIf {

	public static final int OK_Code = 0;
	private static int Faile_Code = 1;
	public static final int Fail_RPC = ++Faile_Code;
	public static final int Fail_Room = ++Faile_Code;
	public static final int Fail_Device = ++Faile_Code;
	public static final int Fail_Scene = ++Faile_Code;
	public static final int Fail_SceneDeviceNum = ++Faile_Code;
	public static final int Fail_DeviceIRFunc = ++Faile_Code;
	public static final int Fail_SceneDeviceList = ++Faile_Code;
	public static final int Fail_SchedulerList = ++Faile_Code;
	public static final int Fail_Exception = ++Faile_Code;
	public static final int Fail_Disconnect = ++Faile_Code;

	public interface RpcConfigSyncIf {
		void syncResult(ULTIConfigSync ulti, int code);
	}

	public interface RpcEventSyncIf {
		void syncEventResult(EventParam evt);
	}

	RpcConfigSyncIf syncIf;

	private RpcEventSyncIf eventIf;

	public void setEventSyncIf(RpcEventSyncIf eventIf) {
		instance.eventIf = eventIf;
	}

	private static ULTIConfigSync instance;

	public static void clear() {
		if (instance != null) {
			instance.eventIf = null;
			instance.syncIf = null;
			//instance = null;
		}
	}
	public static boolean existInstance() {
		if (instance == null) {
			return false;
		}
		return true;
	}
	
	public static ULTIConfigSync getInstance() {
		if (instance == null) {
			instance = new ULTIConfigSync();
		}
		return instance;
	}

	/**
	 * 
	 */
	public void syncConfig(RpcConfigSyncIf syncIf) {
		instance.syncIf = syncIf;
		isSyncScene = false;
		if (RpcCommand.getInstance() == null
				|| !RpcCommand.getInstance().isConnected()) {
			if (instance.syncIf != null) {
				instance.syncIf.syncResult(instance, Fail_RPC);
			}
		}
		// 1.获取所有room，方便device设置room
		// 2.获取所有device
		// 3.获取Ac,TV的func
		// 4.获取scene
		// 5.获取scene的device
		RpcCommand.getInstance().setULTIConfigCallback(instance);
		RpcCommand.getInstance().getRoomList();
	}

	boolean isSyncScene = false;

	public void reSyncScene(RpcConfigSyncIf syncIf) {
		isSyncScene = true;
		instance.syncIf = syncIf;
		RpcCommand.getInstance().getAllScnGenList();
	}

	public void reSyncScheduler(RpcConfigSyncIf syncIf) {
		instance.syncIf = syncIf;
		RpcCommand.getInstance().getSchedulerList();
	}
	
	public void reSyncScnCfgList(int scnId,RpcConfigSyncIf syncIf) {
		instance.syncIf = syncIf;
		RpcCommand.getInstance().getScnAllCfgList(scnId);
	}

	public List<RpcDevice> getAllDevices() {
		return listDevice;
	}

	public List<RpcSceneGen> getAllScenes() {
		return listScene;
	}

	public List<RpcRoom> getAllRooms() {
		return listRoom;
	}

	public List<RpcScheduler> getAllSchedulers() {
		return listScheduler;
	}

	public void onEventUpdate(EventParam evt) {
		if (eventIf != null) {
			eventIf.syncEventResult(evt);
		}

		 if(RpcJsonParm.EVENT_USM_EVT_Offline.equals(evt.getMethod())){
			syncIf.syncResult(instance, Fail_Disconnect);
			 instance = null;
		 }else if(RpcJsonParm.EVENT_DMR_EVT_LowBat.equals(evt.getMethod())){
//			 int devId = evt.getDevId();
//			 String sysTime = evt.getSysTime();
		 }else if(RpcJsonParm.EVENT_DMR_EVT_Level.equals(evt.getMethod())){
			 int devId = evt.getDevId();
			 int level = evt.getLevel();	
			 for(RpcDevice device : listDevice ){
					if(devId == device.getDevId()){
						device.setLevel(level);
						break;
					} 
			 }
		 }else if(RpcJsonParm.EVENT_DMR_EVT_OnOff.equals(evt.getMethod())){
			 int devId = evt.getDevId();
			 for(RpcDevice device : listDevice ){
					if(devId == device.getDevId()){
						device.setOn(evt.isOn());
						break;
					} 
			 }
		 }else if(RpcJsonParm.EVENT_CTR_EVT_SchStat.equals(evt.getMethod())){
			 int schTaskId = evt.getSchTaskId();
			 int schStatus = evt.getSchStatus();
			 for(RpcScheduler scheduler : listScheduler ){
					if(schTaskId == scheduler.getSchTaskId()){
						scheduler.setSchTaskStatus(schStatus);
						break;
					} 
			 }
		 }
	}

	@Override
	public void ssdpCallBack(RepLanIpGw rep) {
	}

	@Override
	public void connected(boolean isConnected) {
	}

	@Override
	public void disconnected() {
		if (syncIf != null) {
		syncIf.syncResult(instance, Fail_Disconnect);
		}
	}

	@Override
	public void authenCallBack(RepUSMAuth rep) {
	}

	@Override
	public void getIpGwInfoCallBack(RepSYSGwInfoGet rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEcOptionCallBack(RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUserCallBack(RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeUserCallBack(RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetUserCallBack(RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delUserCallBack(RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getUserListCallBack(RepUSMGnUserListGet rep) {
		// TODO Auto-generated method stub

	}

	List<RpcDevice> listDevice = new ArrayList<RpcDevice>();
	List<RpcSceneGen> listScene = new ArrayList<RpcSceneGen>();
	List<RpcRoom> listRoom = new ArrayList<RpcRoom>();
	List<RpcScheduler> listScheduler = new ArrayList<RpcScheduler>();

	List<Integer> listAcTvDevIds = new ArrayList<Integer>();

	@Override
	public void getRoomListCallBack(List<RpcRoom> list) {
		try {
			if (list.size() > 0) {
				listRoom = list;
				listDevice = new ArrayList<RpcDevice>();
				RpcCommand.getInstance().getDeviceList();
			} else {
				if (syncIf != null) {
					syncIf.syncResult(instance, Fail_Room);
				}
			}
		} catch (Exception e) {
			if (syncIf != null) {
				syncIf.syncResult(instance, Fail_Exception);
			}
		}
	}

	@Override
	public void getDeviceListCallBack(List<RpcDevice> list) {
		try {
			if (list.size() > 0) {
				listDevice = list;
				listAcTvDevIds.clear();
				for(RpcDevice dev : listDevice){
					if(dev.getDevType() == 1 && (dev.getUltiType() == 9 || dev.getUltiType() == 10)){
						listAcTvDevIds.add(dev.getDevId());
					}
				}
				if (listAcTvDevIds.size() > 0) {
					RpcCommand.getInstance().getIRExFuncList(
							listAcTvDevIds.get(0));
				} else {
					RpcCommand.getInstance().getAllScnGenList();
				}
			} else {
				if (syncIf != null) {
					syncIf.syncResult(instance, Fail_Device);
				}
			}
		} catch (Exception e) {
			if (syncIf != null) {
				syncIf.syncResult(instance, Fail_Exception);
			}
		}
	}

	@Override
	public void getIRExFuncListCallBack(int devId, RepDMRIRExFuncListGet rep) {
		try {
			if (rep.getRetCode() == 0) {
				List<RpcIRFunc> list = rep.getResult().getFuncObjList();
				if(list == null){
					list = new ArrayList<RpcIRFunc>();
				}
				RpcDevice devNow = null;
				for (RpcDevice dev : listDevice) {
					if (dev.getDevId() == devId) {
						devNow = dev;
						break;
					}
				}

				String naFuncId = "";
				String suppFuncId = "";
				List<RpcIRFunc> listCustFunc = new ArrayList<RpcIRFunc>();
				for (RpcIRFunc func : list) {
					if (func.getFuncType() == 1) {// 1: N/A; 2: Cust; 3:Supp
						if (naFuncId.length() == 0) {
							naFuncId = func.getFuncId() + "";
						} else {
							naFuncId = naFuncId + "," + func.getFuncId();
						}
					} else if (func.getFuncType() == 2) {
						listCustFunc.add(func);
					} else if (func.getFuncType() == 3) {
						if (suppFuncId.length() == 0) {
							suppFuncId = func.getFuncId() + "";
						} else {
							suppFuncId = suppFuncId + "," + func.getFuncId();
						}
					}
				}
				devNow.setNaFuncId(naFuncId);
				devNow.setSuppFuncId(suppFuncId);
				devNow.setListCustFunc(listCustFunc);
				listAcTvDevIds.remove(0);
				if (listAcTvDevIds.size() > 0) {
					RpcCommand.getInstance().getIRExFuncList(
							listAcTvDevIds.get(0));
				} else {
					RpcCommand.getInstance().getAllScnGenList();
				}
			} else {
				if (syncIf != null) {
					syncIf.syncResult(instance, Fail_DeviceIRFunc);
				}
			}
		} catch (Exception e) {
			if (syncIf != null) {
				syncIf.syncResult(instance, Fail_Exception);
			}
		}
	}

	List<Integer> listSceneId = new ArrayList<Integer>();

	@Override
	public void getScnGenListCallBack(List<RpcSceneGen> list) {
		try {
			if (list.size() > 0) {
				listSceneId = new ArrayList<Integer>();
				listScene = list;
//				if (!RpcCommand.getInstance().isAdmin) {
//					for (int i = listScene.size() - 1; i >= 0; i--) {
//						RpcSceneGen scn = listScene.get(i);
//						if (scn.getDevNum() == 0) {
//							listScene.remove(i);
//						}
//					}
//				}
				for (RpcSceneGen scn : list) {
					if (scn.getDevNum() > 0) {
						listSceneId.add(scn.getScnId());
					} else {
						scn.setListCfg(new ArrayList<RpcSceneCfg>());
					}
				}
				if (listSceneId.size() > 0) {
					RpcCommand.getInstance().getScnAllCfgList(
							listSceneId.get(0));
				} else {
					if (syncIf != null) {
						if (isSyncScene) {
							syncIf.syncResult(instance, OK_Code);
						} else {
							RpcCommand.getInstance().getSchedulerList();
						}
					}
				}
			} else {
				if (syncIf != null) {
					syncIf.syncResult(instance, Fail_Scene);
				}
			}
		} catch (Exception e) {
			if (syncIf != null) {
				syncIf.syncResult(instance, Fail_Exception);
			}
		}
	}

	@Override
	public void getScnCfgListCallBack(int scnId, List<RpcSceneCfg> list) {
		try {
			if (list.size() > 0) {
				for (RpcSceneGen scn : listScene) {
					if (scn.getScnId() == scnId) {
						scn.setListCfg(list);
						if (list.size() != scn.getDevNum()) {
							if (syncIf != null) {
								syncIf.syncResult(instance, Fail_SceneDeviceNum);
							}
						}
						break;
					}
				}

				listSceneId.remove(0);
				if (listSceneId.size() > 0) {
					RpcCommand.getInstance().getScnAllCfgList(
							listSceneId.get(0));
				} else {
					if (syncIf != null) {
						if (isSyncScene) {
							syncIf.syncResult(instance, OK_Code);
						} else {
							RpcCommand.getInstance().getSchedulerList();
						}
					}
				}
			} else {
				if (syncIf != null) {
					syncIf.syncResult(instance, Fail_SceneDeviceList);
				}
			}
		} catch (Exception e) {
			if (syncIf != null) {
				syncIf.syncResult(instance, Fail_Exception);
			}
		}
	}

	@Override
	public void getSchedulerListCallBack(List<RpcScheduler> list) {
		try {
			if (list.size() > 0) {
				listScheduler = list;
//				if (!RpcCommand.getInstance().isAdmin) {
//					for (int i = listScheduler.size() - 1; i >= 0; i--) {
//						RpcScheduler sch = listScheduler.get(i);
//						if (sch.getSchTaskStatus() == 0) {
//							listScheduler.remove(i);
//						}
//					}
//				}

				if (syncIf != null) {
					syncIf.syncResult(instance, OK_Code);
				}
			} else {
				if (syncIf != null) {
					syncIf.syncResult(instance, Fail_SchedulerList);
				}
			}
		} catch (Exception e) {
			if (syncIf != null) {
				syncIf.syncResult(instance, Fail_Exception);
			}
		}
	}

	@Override
	public void eventUSMEVTOffline(EventParam param) {
		syncIf.syncResult(instance, Fail_Disconnect);
		clear();
		 instance = null;
	}

	@Override
	public void discoverNetworkCallBack(RepCTRSchTaskListGet rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pingCallBack(RepDMRPing rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sceneOperateCallBack(RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearSchedulerCallBack(int schTaskId, RepCommonResult scheduler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSchedulerParamCallBack(int schTaskId,
			RepCommonResult scheduler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void operSchedulerCallBack(int schTaskId, RepCommonResult scheduler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exceptionCallBack(Exception ex, EventParam param) {
		// TODO Auto-generated method stub

	}

	@Override
	public void networkConnectedCallBack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eventDMREVTLowBat(EventParam param) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnOffCallBack(int devId, RepDMROnOffGet rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOnOffTogCallBack(int devId, RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getLevelCallBack(int devId, RepDMRLevelGet rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLevelCallBack(int devId, RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveCallBack(int devId, RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopCallBack(int devId, RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendIrCodeCallBack(RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scanBatteryCallBack(RepDMRBatScan rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSceneDeviceCallBack(int scnId, int devId, RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delSceneDeviceCallBack(int scnId, int devId, RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recallSceneCallBack(int scnId, RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eventDMREVTLevel(EventParam param) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eventDMREVTOnOff(EventParam param) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eventCTREVTSchStat(EventParam evtParam) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getACCallBack(int devId, RepDMRACGet rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ctrlACCallBack(int devId, RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getFHCallBack(int devId, RepDMRFHGet rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ctrlFHCallBack(int devId, RepCommonResult rep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSceneNameCallBack(int scnId, RepCommonResult rep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getACSpecDataCallBack(int devId, RepDMRACSpecDataGet rep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFHSpecDataCallBack(int devId, RepDMRFHSpecDataGet rep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDeviceNameCallBack(int devId, RepCommonResult rep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventDMREVTFH(EventParam evtParam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventDMREVTAC(EventParam evtParam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDeviceScnNumListCallBack(List<RpcDevice> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEsListCallBack(List<RpcEsData> list, RepDMREsGet rep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bgmCtrlCallBack(int devId, RepCommonResult rep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventDMREVTES(EventParam evtParam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getDdnsInfoCallBack(RepSYSDdnsInfoGet rep) {
		// TODO Auto-generated method stub
		
	}

}
