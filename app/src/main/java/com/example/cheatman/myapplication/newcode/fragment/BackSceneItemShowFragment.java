package com.example.cheatman.myapplication.newcode.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;
import com.example.cheatman.myapplication.newcode.adapter.DeviceDetail2Adapter;
import com.example.cheatman.myapplication.newcode.adapter.DeviceTypeAdapter;
import com.example.cheatman.myapplication.newcode.adapter.SceneFavoriteListAdapter;
import com.example.cheatman.myapplication.newcode.adapter.SceneItemShowAdapter;
import com.example.cheatman.myapplication.newcode.model.AutomationInfo;
import com.example.cheatman.myapplication.newcode.model.DeviceInfoAll;
import com.example.cheatman.myapplication.newcode.model.MyProjectInfo;
import com.example.cheatman.myapplication.newcode.model.SceneInfo;
import com.example.cheatman.myapplication.newcode.model.expand.DetailDeviceInfo;
import com.example.cheatman.myapplication.newcode.model.expand.ItemDeviceInfo;
import com.example.cheatman.myapplication.newcode.model.expand.TitleInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;

/**
 * Created by Cheatman on 2017/12/6.
 */

public class BackSceneItemShowFragment extends BaseFragment {

    @BindView(R.id.rv_scene)
    RecyclerView mRvScene;

    @BindView(R.id.tv_scene_name)
    TextView mTvSceneName;

    // 对应SceneInfo
    private SceneInfo mSceneInfo;

    // list用数据源
    private List<Object> mInfoList;

    // adapter
    private SceneItemShowAdapter mSceneItemShowAdapter;

    public static BackSceneItemShowFragment newInstance(String sceneName) {
        Bundle bundle = new Bundle();
        bundle.putString("sceneName", sceneName);
        BackSceneItemShowFragment fragment = new BackSceneItemShowFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_back_scene_show;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        String sceneName = this.getArguments().getString("sceneName");
        mTvSceneName.setText( sceneName );
        for(SceneInfo item : MyProjectInfo.getInstance().getSceneList()){
            if(item.getName().equals(sceneName)){
                mSceneInfo = item;break;
            }
        }

        // 设置数据源
        List<DeviceInfoAll> list = new ArrayList<>(mSceneInfo.getDeviceList());
        // 转换l成配置ist
        mInfoList = buildInfoList(list);

        mRvScene.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mSceneItemShowAdapter = new SceneItemShowAdapter(mActivity,mInfoList);
        mRvScene.setAdapter(mSceneItemShowAdapter);



        mSceneItemShowAdapter.setOnTitleItemCheckedChangeListener(new SceneItemShowAdapter.OnTitleItemCheckedChangeListener() {
            @Override
            public void mOnTitleItemCheckedChangeListener(View view, TitleInfo title, boolean isOpen) {
                boolean exp =!isOpen;
                // 设置折叠
                title.setExpanded( exp);
                int position = 0 ;
                for(Object item :mInfoList){
                    if(item instanceof ItemDeviceInfo){
                        ItemDeviceInfo itemDeviceInfo =(ItemDeviceInfo)item;
                        if(title.getName().equals(itemDeviceInfo.getRoomName())){
                            itemDeviceInfo.setVisibility(exp);
                            // 如果折叠 子菜单也折叠 先不在set中写死，将来可能要改
                            if(!exp){
                                itemDeviceInfo.setExpanded(false);
                            }
                            mSceneItemShowAdapter.notifyItemChanged(position);
                        }
                    }
                    position ++;
                }

            }
        });
    }




    /**
     *  转换生成新list
     * @param list 转换list
     * @return 转换后list
     */
    private List<Object>  buildInfoList(List<DeviceInfoAll> list){

        // 临时缓存用
        //Map<Integer,Object> insertCache = new LinkedHashMap<>();
        // 临时对比用
        Set<String> types = new HashSet<>();
        // 返回结果
        List<Object> result = new ArrayList<>();

        // 排序
        Collections.sort(list,new Comparator<DeviceInfoAll>(){
            public int compare(DeviceInfoAll arg0, DeviceInfoAll arg1) {
                if(arg0.getRoomName().equals(arg1.getRoomName())){
                    return arg0.getName().compareTo(arg1.getName());
                }else{
                    return arg0.getRoomName().compareTo(arg1.getRoomName());
                }
            }
        });

        // 索引
        //int newIndex = 0;
        for( DeviceInfoAll item : list){
            // new 标题item
            if(!types.contains(item.getRoomName())){
                //insertCache.put(newIndex, new TitleInfo("id",item.getRoomName(),true));
                result.add( new TitleInfo("id",item.getRoomName(),true));
                types.add(item.getRoomName());
                //newIndex ++;
            }

            // new 明细控制item
            /*DetailDeviceInfo detailDeviceInfo =new DetailDeviceInfo(item.getId(),item.getName(),item.getType(),"100",item.getRoomName());
            insertCache.put(newIndex+1, detailDeviceInfo);
            newIndex ++;*/

            // 增加明细item
            ItemDeviceInfo itemDeviceInfo =new ItemDeviceInfo(item.getId(),item.getName(),item.getType(),100,item.getRoomName());
            result.add(itemDeviceInfo);
            //newIndex ++;
        }

        //for(Map.Entry<Integer, Object> entry  : insertCache.entrySet()){
            // 增加标题item和明细控制item
            //result.add(entry.getKey(),entry.getValue());
        //}

        return result;
    }
}
