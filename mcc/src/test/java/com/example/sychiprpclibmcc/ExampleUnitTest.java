package com.example.sychiprpclibmcc;

import com.example.sychiprpclibmcc.bean.EventParam;
import com.example.sychiprpclibmcc.bean.RepLanIpGw;
import com.example.sychiprpclibmcc.bean.RpcDevice;
import com.example.sychiprpclibmcc.rep.RepCTRSchTaskListGet;
import com.example.sychiprpclibmcc.rep.RepCommonResult;
import com.example.sychiprpclibmcc.rep.RepDMRACGet;
import com.example.sychiprpclibmcc.rep.RepDMRACSpecDataGet;
import com.example.sychiprpclibmcc.rep.RepDMRBatScan;
import com.example.sychiprpclibmcc.rep.RepDMREsGet;
import com.example.sychiprpclibmcc.rep.RepDMRFHGet;
import com.example.sychiprpclibmcc.rep.RepDMRFHSpecDataGet;
import com.example.sychiprpclibmcc.rep.RepDMRIRExFuncListGet;
import com.example.sychiprpclibmcc.rep.RepDMRLevelGet;
import com.example.sychiprpclibmcc.rep.RepDMROnOffGet;
import com.example.sychiprpclibmcc.rep.RepDMRPing;
import com.example.sychiprpclibmcc.rep.RepDMRRoomListGet;
import com.example.sychiprpclibmcc.rep.RepDMRScnCfgListGet;
import com.example.sychiprpclibmcc.rep.RepDMRScnGenListGet;
import com.example.sychiprpclibmcc.rep.RepSYSDdnsInfoGet;
import com.example.sychiprpclibmcc.rep.RepSYSGwInfoGet;
import com.example.sychiprpclibmcc.rep.RepUSMAuth;
import com.example.sychiprpclibmcc.rep.RepUSMGnUserListGet;
import com.example.sychiprpclibmcc.rpc.PlatForm;
import com.example.sychiprpclibmcc.rpc.RpcCallBackIf;
import com.example.sychiprpclibmcc.rpc.RpcCommand;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        RpcCommand.init(PlatForm.PC, callback, 5);
        RpcCommand.getInstance().connect("192.168.110.71", 55700);
        RpcCommand.getInstance().setShowLog(true, null);

        sleep();
        sleep();
        System.out.println("**************************************************");
    }


    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    static RpcCallBackIf callback = new RpcCallBackIf() {

        @Override
        public void ssdpCallBack(RepLanIpGw rep) {
            // TODO Auto-generated method stub

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
        }

        @Override
        public void changeUserCallBack(RepCommonResult rep) {
        }

        @Override
        public void resetUserCallBack(RepCommonResult rep) {
        }

        @Override
        public void delUserCallBack(RepCommonResult rep) {
        }

        @Override
        public void getUserListCallBack(RepUSMGnUserListGet rep) {
        }

        @Override
        public void getRoomListCallBack(List<RepDMRRoomListGet.RpcRoom> list) {
        }


        @Override
        public void getScnCfgListCallBack(int devId, List<RepDMRScnCfgListGet.RpcSceneCfg> list) {
            // TODO Auto-generated method stub

        }

        @Override
        public void eventUSMEVTOffline(EventParam param) {
            // TODO Auto-generated method stub

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
        public void sceneOperateCallBack(RepCommonResult rep) {
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
        public void getIRExFuncListCallBack(int devId, RepDMRIRExFuncListGet rep) {
            // TODO Auto-generated method stub

        }

        @Override
        public void getScnGenListCallBack(List<RepDMRScnGenListGet.RpcSceneGen> list) {
            // TODO Auto-generated method stub

        }

        @Override
        public void eventDMREVTLowBat(EventParam param) {
            // TODO Auto-generated method stub

        }

        @Override
        public void scanBatteryCallBack(RepDMRBatScan rep) {

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
        public void getSchedulerListCallBack(List<RepCTRSchTaskListGet.RpcScheduler> list) {
            // TODO Auto-generated method stub

        }

        @Override
        public void clearSchedulerCallBack(int schTaskId, RepCommonResult scheduler) {
            // TODO Auto-generated method stub

        }

        @Override
        public void setSchedulerParamCallBack(int schTaskId, RepCommonResult scheduler) {
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
        public void getDeviceListCallBack(List<RpcDevice> list) {
            // TODO Auto-generated method stub

        }

        @Override
        public void getDeviceScnNumListCallBack(List<RpcDevice> list) {
            // TODO Auto-generated method stub

        }

        @Override
        public void getEsListCallBack(List<RepDMREsGet.RpcEsData> list, RepDMREsGet rep) {
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
            String a = "";
            a= a+ "";
        }

        @Override
        public void connected(boolean isConnected) {
            System.out.println("connect回调");
            // TODO Auto-generated method stub

            if (RpcCommand.getInstance().isConnected()) {
                RpcCommand.getInstance().authen("installer", "installer", "installer");
            }else{
                RpcCommand.reInit(PlatForm.PC, callback, 5);
                RpcCommand.getInstance().connect("192.168.110.71", 55700);
            }
        }

        @Override
        public void disconnected() {
            // TODO Auto-generated method stub
            if (RpcCommand.getInstance().isConnected()) {
                RpcCommand.getInstance().authen("installer", "installer", "installer");
            }
        }

        @Override
        public void authenCallBack(RepUSMAuth rep) {

//			rpcConfig = ULTIConfigSync.getInstance();
//			rpcConfig.syncConfig(new RpcConfigSyncIf() {
//				@Override
//				public void syncResult(ULTIConfigSync ulti, int code) {
//					if (code == 0) {
//						List<RpcDevice> listDevice = rpcConfig.getAllDevices();
//						List<RpcRoom> listRoom = rpcConfig.getAllRooms();
//						List<RpcSceneGen> listScene = rpcConfig.getAllScenes();
//						System.err.println("syncResult>>> Device:" + listDevice.size() + "   " + "Room:"
//								+ listRoom.size() + "   " + "Scene:" + listScene.size() + "   ");
//						for (RpcSceneGen scene : listScene) {
//							System.err.println(
//									"          listScene>>> " + scene.getScnName() + ":" + scene.getListCfg().size());
//						}
//					}
//				}
//
//			});
        }

    };
}