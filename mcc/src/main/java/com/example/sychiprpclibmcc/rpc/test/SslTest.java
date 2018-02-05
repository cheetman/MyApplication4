package com.example.sychiprpclibmcc.rpc.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.stream.JsonReader;
import com.example.sychiprpclibmcc.bean.RepLanIpGw;
import com.example.sychiprpclibmcc.bean.ResultBase;
import com.example.sychiprpclibmcc.bean.RpcDevice;
import com.example.sychiprpclibmcc.rep.RepCTRSchTaskListGet;
import com.example.sychiprpclibmcc.rep.RepCTRSchTaskListGet.RepCTRSchTaskListGetResult;
import com.example.sychiprpclibmcc.rep.RepCTRSchTaskListGet.RpcScheduler;
import com.example.sychiprpclibmcc.rep.RepCommonResult;
import com.example.sychiprpclibmcc.rep.RepDMRDevListGet;
import com.example.sychiprpclibmcc.rep.RepDMRIRExFuncListGet;
import com.example.sychiprpclibmcc.rep.RepDMRLevelGet;
import com.example.sychiprpclibmcc.rep.RepDMROnOffGet;
import com.example.sychiprpclibmcc.rep.RepDMRRoomListGet;
import com.example.sychiprpclibmcc.rep.RepSYSGwInfoGet;
import com.example.sychiprpclibmcc.rep.RepUSMAuth;
import com.example.sychiprpclibmcc.rep.RepUSMGnUserListGet;
import com.example.sychiprpclibmcc.rep.RepDMRIRExFuncListGet.ResultRepDMRIRExFuncListGet;
import com.example.sychiprpclibmcc.rep.RepDMRIRExFuncListGet.RpcIRFunc;
import com.example.sychiprpclibmcc.rep.RepDMRLevelGet.RepDMRLevelGetResult;
import com.example.sychiprpclibmcc.rep.RepDMROnOffGet.RepDMROnOffGetResult;
import com.example.sychiprpclibmcc.rep.RepDMRRoomListGet.RepDMRRoomListGetResult;
import com.example.sychiprpclibmcc.rep.RepDMRRoomListGet.RpcRoom;
import com.example.sychiprpclibmcc.rep.RepSYSGwInfoGet.ResultSYSGwInfoGet;
import com.example.sychiprpclibmcc.rep.RepUSMAuth.ResultUSMAuth;
import com.example.sychiprpclibmcc.rep.RepUSMGnUserListGet.ResultUSMGnUserListGet;
import com.example.sychiprpclibmcc.rep.RepUSMGnUserListGet.RpcUserName;
import com.example.sychiprpclibmcc.req.ReqBaseRequest;
import com.example.sychiprpclibmcc.req.ReqCommonParam;
import com.example.sychiprpclibmcc.req.ReqUSMEcOptionSet;
import com.example.sychiprpclibmcc.rpc.RpcJsonParm;

/**
 * 
 * Title: SslTest<br>
 * Description:<br>
 * Copyright: SyChip Electronic Technology (Shanghai) Ltd.A subsidiary of
 * muRata. All Rights Reserved. <br>
 * 
 * @author SyChip
 * @version 0.2.03
 *
 */
public class SslTest {

	public static Gson gson = getDoubleGson();

	private static Gson getDoubleGson() {
		Gson gson = new GsonBuilder().registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
			@Override
			public JsonElement serialize(Double src, Type arg1, JsonSerializationContext arg2) {
				if (src.isNaN() || src.isInfinite()) {
					return null;
				} else {
					return new JsonPrimitive(new DecimalFormat("#").format(src));
				}
			}
		}).create();
		return gson;
	}
	
	public static List<RepLanIpGw> repDiscoverIpGwInLan() {

		List<RepLanIpGw> listIpGw = new ArrayList<RepLanIpGw>();

		RepLanIpGw rep = new RepLanIpGw();
		rep.setEthMac("ethMac11");
		rep.setIp("192.168.15.251");
		rep.setPort("55700");
		rep.setSystemName("systemName11");
		rep.setUniqueId("uniqueId11");

		listIpGw.add(rep);
		
		rep = new RepLanIpGw();
		rep.setEthMac("ethMac22");
		rep.setIp("192.168.15.253");
		rep.setPort("55700");
		rep.setSystemName("systemName22");
		rep.setUniqueId("uniqueId22");
		listIpGw.add(rep);
		return listIpGw;
	}
	
	public static RepUSMAuth repUSMAuth(String message) {

		JsonReader reader = new JsonReader(new StringReader(message.toString()));
		reader.setLenient(true);
		Map<String, Object> respMap = gson.fromJson(reader, Map.class);

		Integer id = ((Double) respMap.get("transId")).intValue();
		RepUSMAuth rep = new RepUSMAuth();
		ResultUSMAuth result = (ResultUSMAuth)rep.getSimResult();
		result.setType(2);
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setResult(result);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}
		return rep;
	}

	

	public static RepSYSGwInfoGet repGetIpGwInfo(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();

		RepSYSGwInfoGet rep = new RepSYSGwInfoGet();
		ResultSYSGwInfoGet result = rep.getSimResult();
		result.setGwMode("setGwMode");
		result.setGwName("setGwName");
		result.setSysName("setSysName");
		result.setEthMac("setEthMac");
		result.setHwVersion("setHwVersion");
		result.setSwVersion("setSwVersion");
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setResult(result);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}

		return rep;
	}
	

	public static RepCommonResult repSetEcOption(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepCommonResult rep = new RepCommonResult();
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setRetCode(0);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}

		return rep;
	}
	


	public static RepCommonResult repAddUser(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepCommonResult rep = new RepCommonResult();
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setRetCode(0);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}

		return rep;
	}
	

	public static RepCommonResult repChangeUser(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepCommonResult rep = new RepCommonResult();
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setRetCode(0);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}

		return rep;
	}
	

	public static RepCommonResult repResetUser(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepCommonResult rep = new RepCommonResult();
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setRetCode(0);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}

		return rep;
	}

	public static RepCommonResult repDelUser(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepCommonResult rep = new RepCommonResult();
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setRetCode(0);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}

		return rep;
	}

	public static RepUSMGnUserListGet repGetUserList(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepUSMGnUserListGet rep = new RepUSMGnUserListGet();
		ResultUSMGnUserListGet result = rep.getSimResult();
		List<RpcUserName> accountObjList = new ArrayList<RpcUserName>();
		for(int i = 0 ; i < 8; i ++){
			RpcUserName unm = rep.getSimUserName();
			unm.setUserName("userName:"+i);
			accountObjList.add(unm);
		}
		result.setAccountObjList(accountObjList);
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setRetCode(0);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}
		return rep;
	}

	public static List<RpcRoom> repGetRoomList(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepDMRRoomListGet rep = new RepDMRRoomListGet();
		RepDMRRoomListGetResult result = rep.getSimResult();
		List<RpcRoom> roomObjList = new ArrayList<RpcRoom>();
		for(int i = 0 ; i < 8; i ++){
			RpcRoom unm = rep.getSimRpcRoom();
			unm.setRoomName("Room:"+i);
			roomObjList.add(unm);
		}
		result.setRoomObjList(roomObjList);
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setRetCode(0);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}
		return roomObjList;
	}
	


	public static List<RpcScheduler> repGetSchedulerList(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepCTRSchTaskListGet rep = new RepCTRSchTaskListGet();
		RepCTRSchTaskListGetResult result = rep.getSimResult();
		List<RpcScheduler> schTaskSimpObjList = new ArrayList<RpcScheduler>();
		for(int i = 0 ; i < 8; i ++){
			RpcScheduler unm = rep.getSimRpcScheduler();
			unm.setSchTaskId(i);
			unm.setSchTaskName("Nm:"+i);
			schTaskSimpObjList.add(unm);
		}
		result.setSchTaskSimpObjList(schTaskSimpObjList);
		
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setRetCode(0);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}
		return schTaskSimpObjList;
	}
	


	public static List<RpcDevice> repGetDeviceList(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepDMRDevListGet rep = new RepDMRDevListGet();
		List<RpcDevice> devObjList = new ArrayList<RpcDevice>();
		
		for(int iDeviceType = 1; iDeviceType <= 5; iDeviceType ++){
	        int iNum = 10;
	        if(iDeviceType == 1){
	            iNum = 50;
	        }else if(iDeviceType == 5){
	            iNum = 1;
	        }
	        for(int i = 1; i <= iNum; i ++){
				RpcDevice dev = rep.getSimRpcDevice();
	            
	            dev.setDevType(iDeviceType);
				dev.setDevId(iDeviceType * 10 + i);
				
	            if(iDeviceType == 1){
	                dev.setUltiType(i); 
	                if (dev.getUltiType() > 6) {
	                    dev.setUltiType(dev.getUltiType() - 6);
	                }
	            }else if(iDeviceType == 2){
	                dev.setvSAddr("rtsp://admin:sychip1234@192.168.40.205:554/h264/ch1/main/av_stream");
	            }else if(iDeviceType == 3){
	                dev.setUid("uid-"+dev.getDevId());
	                dev.setAcBrand("acBrand"+dev.getDevId());
	                dev.setAcModel("acModel"+dev.getDevId());
	                dev.setAcUnitAddr("acUnitAddr"+dev.getDevId());
	            }else if(iDeviceType == 4){
	                dev.setUid("uid-"+dev.getDevId());
	                dev.setFhBrand("fhBrand+dev"+dev.getDevId());
	                dev.setFhModel("fhModel+dev"+dev.getDevId());
	                dev.setFhUnitAddr("fhUnitAddr+dev"+dev.getDevId());
	            }else if(iDeviceType == 5){
	                dev.setUid("uid-"+dev.getDevId());
	                dev.setAclBrand("aclBrand+dev"+dev.getDevId());
	                dev.setAclModel("aclModel+dev"+dev.getDevId());
	                dev.setAclUnitAddr("aclUnitAddr+dev"+dev.getDevId());
	            }
	            dev.setName(dev.getDevId()+"-name"+dev.getUltiType());
	            dev.setRoomId(iDeviceType);
	            devObjList.add(dev);
	        }
	        
	    }

		
		return devObjList;
	}
	
	public static RepDMRIRExFuncListGet repDMRIRExFuncListGet(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();

		RepDMRIRExFuncListGet rep = new RepDMRIRExFuncListGet();
		ResultRepDMRIRExFuncListGet result = rep.getSimResult();
		List<RpcIRFunc> list = new ArrayList<RpcIRFunc>();
		result.setFuncObjList(list);
		result.setCustFuncNum(3);
		result.setNaFuncNum(2);
		result.setSuppFuncNum(1);
		for(int i = 0 ; i < 20 ; i ++){
			RpcIRFunc  func = rep.getRpcIRFunc();
			func.setFuncId(i);
			func.setFuncName(i+"-Nm");
			if(i < 5){
				func.setFuncType(1);
			}else if(i < 15){
				func.setFuncType(2);
			}else {
				func.setFuncType(3);
			}
			list.add(func);
		}
		
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setResult(result);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}

		return rep;
	}


	public static RepCommonResult repCommonResult(String message) {
		JsonReader reader = new JsonReader(new StringReader(message.toString()));
		reader.setLenient(true);
		Map<String, Object> respMap = gson.fromJson(reader, Map.class);
		if (respMap.get("method") != null) {
			Integer id = ((Double) respMap.get("transId")).intValue();
			String method = (String) respMap.get("method");
			String rpcVer = (String) respMap.get("rpcVer");
			if (RpcJsonParm.Md_DMRLevelMove.equals(method)) {
				RepCommonResult rep = SslTest.repByIdMove(message);
				rep.setTransId(id);
				if (rpcVer.equals("3.0")) {
					rep.setRequest(message);
				} else {
					rep.setRequest(null);
				}
				return rep;

			} else if (RpcJsonParm.Md_DMRLevelStop.equals(method)) {
				RepCommonResult rep = SslTest.repByIdStop(message);
				rep.setTransId(id);
				if (rpcVer.equals("3.0")) {
					rep.setRequest(message);
				} else {
					rep.setRequest(null);
				}
				return rep;

			} 
		}
		return null;
	}

	public static RepCommonResult repByEventOffline() {
		RepCommonResult rcr = new RepCommonResult();
		rcr.setMethod(RpcJsonParm.EVENT_USM_EVT_Offline);
		rcr.setRpcVer("3.0");
		return rcr;
	}


	public static boolean repEventWhileListChange() {

		return true;
	}

  

	public static RepDMROnOffGet repGetOnOff(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepDMROnOffGet rep = new RepDMROnOffGet();
		RepDMROnOffGetResult result = rep.getResult();
		ReqCommonParam req = gson.fromJson(message.toString(), ReqCommonParam.class);
	 
		Random r = new Random();
		result.setOnOff(r.nextInt() % 2 + 1);

		String rpcVer = (String) respMap.get("rpcVer");
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setResult(result);
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}
		return rep;
	}
 

	public static RepCommonResult repByIdMove(String message) {
		RepCommonResult rep = new RepCommonResult();
		ResultBase result = new ResultBase();
		rep.setRpcVer("3.0");
		rep.setTransId(RpcJsonParm.Id_DMRLevelMove);
		rep.setResult(result);
		rep.setRequest(message);
		return rep;
	}

	public static RepCommonResult repByIdStop(String message) {
		RepCommonResult rep = new RepCommonResult();
		ResultBase result = new ResultBase();
		rep.setRpcVer("3.0");
		rep.setTransId(RpcJsonParm.Id_DMRLevelStop);
		rep.setResult(result);
		rep.setRequest(message);
		return rep;
	}
 
	public static ReqBaseRequest reqBaseRequest() {
		ReqBaseRequest req = new ReqBaseRequest();

		return req;
	} 

 
	public static RepDMRLevelGet repOnLevel(String message) {
		@SuppressWarnings("unchecked")
		Map<String, Object> respMap = gson.fromJson(message.toString(), Map.class);
		Integer id = ((Double) respMap.get("transId")).intValue();
		RepDMRLevelGet rep = new RepDMRLevelGet();
		RepDMRLevelGetResult result = rep.getResult();
		ReqCommonParam req = gson.fromJson(message.toString(), ReqCommonParam.class);
	

		result.setLevel(100);
		rep.setRpcVer("3.0");
		rep.setTransId(id);
		rep.setResult(result);
		String rpcVer = (String) respMap.get("rpcVer");
		if (rpcVer.equals("3.0")) {
			rep.setRequest(message);
		} else {
			rep.setRequest(null);
		}
		return rep;
	}
 


}
