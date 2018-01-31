package com.example.cheatman.myapplication.newcode.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.BaseFragment;
import com.example.cheatman.myapplication.newcode.adapter.DeviceDetail2Adapter;
import com.example.cheatman.myapplication.newcode.adapter.DeviceTypeAdapter;
import com.example.cheatman.myapplication.newcode.model.MyProjectInfo;
import com.example.cheatman.myapplication.newcode.model.expand.DetailDeviceInfo;
import com.example.cheatman.myapplication.newcode.model.expand.ItemDeviceInfo;
import com.example.cheatman.myapplication.newcode.model.DeviceInfoAll;
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

public class MainScheduleFragment extends BaseFragment {

    @BindView(R.id.rv_device_detail)
    RecyclerView mRvDeviceDetail;

    @BindView(R.id.rv_device_type)
    RecyclerView mRvDeviceType;

    // 外来数据源
    private List<DeviceInfoAll> mDeviceList;
    // list用数据源
    private List<Object> mInfoList;

    private DeviceDetail2Adapter mAdapter;
    private DeviceTypeAdapter mAdapterDeviceType;

    public static MainScheduleFragment newInstance() {
        MainScheduleFragment fragment = new MainScheduleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    protected  int getLayoutId(){
        return R.layout.fragment_newcode1;
    }

    @Override
    protected  void initView(View view, Bundle savedInstanceState){
        mRvDeviceType.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
        //竖直排列、正向排序
        mRvDeviceDetail.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        //添加了一个灰色背景
        //recyclerView.setBackgroundResource(R.color.light_grey);

        mRvDeviceDetail.setAdapter(mAdapter);
        mRvDeviceType.setAdapter(mAdapterDeviceType);
        /*if(addDecorationFlag){
            recyclerView.addItemDecoration(new RecyclerViewDecoration(mActivity, RecyclerViewDecoration.VERTICAL_LIST));
            addDecorationFlag = false;
        }*/



    }


    private void initData(){
        // 取外来数据源
        mDeviceList = MyProjectInfo.getInstance().getDeviceList();
        // 转换l成配置ist
        mInfoList = buildInfoList(mDeviceList);



        mAdapter = new DeviceDetail2Adapter(mActivity,mInfoList);
        mAdapterDeviceType = new DeviceTypeAdapter(mActivity);


        mAdapter.setOnItemClickListener(new DeviceDetail2Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ItemDeviceInfo info, int position) {
                boolean exp = !info.isExpanded();
                info.setExpanded(exp);
                for(Object item :mInfoList){
                    if(item instanceof DetailDeviceInfo){
                        DetailDeviceInfo detailDeviceInfo =(DetailDeviceInfo)item;
                        if(info.getName().equals(detailDeviceInfo.getName())){
                            detailDeviceInfo.setVisibility(info.isExpanded());
                        }
                    }
                }
                //设置下线
                //((View)view.getTag(1)).setVisibility(exp ? View.INVISIBLE : View.VISIBLE);
                ((View) view.findViewById(R.id.v_item_device_line)).setVisibility(exp ? View.INVISIBLE : View.VISIBLE);

                mAdapter.notifyItemChanged(position+1);
                //adapter.notifyDataSetChanged();
            }

            @Override
            public void onItemLongClick(View view, ItemDeviceInfo info, int position) {

            }
        });

        mAdapter.setOnTitleItemCheckedChangeListener(new DeviceDetail2Adapter.OnTitleItemCheckedChangeListener() {
            @Override
            public void mOnTitleItemCheckedChangeListener(View view, TitleInfo title, boolean isOpen) {
                boolean exp =!isOpen;
                // 设置折叠
                title.setExpanded( exp);
                int position = 0 ;
                for(Object item :mInfoList){
                    if(item instanceof ItemDeviceInfo){
                        ItemDeviceInfo itemDeviceInfo =(ItemDeviceInfo)item;
                        if(title.getName().equals(itemDeviceInfo.getType())){
                            itemDeviceInfo.setVisibility(exp);
                            // 如果折叠 子菜单也折叠 先不在set中写死，将来可能要改
                            if(!exp){
                                itemDeviceInfo.setExpanded(false);
                            }
                            mAdapter.notifyItemChanged(position);
                        }
                    }else if(!exp && item instanceof DetailDeviceInfo){
                        DetailDeviceInfo detailDeviceInfo =(DetailDeviceInfo)item;
                        if(title.getName().equals(detailDeviceInfo.getType())){
                            // 如果折叠 子菜单也折叠 先不在set中写死，将来可能要改
                            if(!exp){
                                detailDeviceInfo.setVisibility(false);
                            }
                            mAdapter.notifyItemChanged(position);
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
        Map<Integer,Object> insertCache = new LinkedHashMap<>();
        // 临时对比用
        Set<String> types = new HashSet<>();
        // 返回结果
        List<Object> result = new ArrayList<>();

        // 排序
        Collections.sort(list,new Comparator<DeviceInfoAll>(){
            public int compare(DeviceInfoAll arg0, DeviceInfoAll arg1) {
                if(arg0.getType().equals(arg1.getType())){
                    return arg0.getName().compareTo(arg1.getName());
                }else{
                    return arg0.getType().compareTo(arg1.getType());
                }
            }
        });

        // 索引
        int newIndex = 0;
        for( DeviceInfoAll item : list){
            // new 标题item
            if(!types.contains(item.getType())){
                insertCache.put(newIndex, new TitleInfo("id",item.getType(),true));
                types.add(item.getType());
                newIndex ++;
            }

            // new 明细控制item
            DetailDeviceInfo detailDeviceInfo =new DetailDeviceInfo(item.getId(),item.getName(),item.getType(),100,item.getRoomName());
            insertCache.put(newIndex+1, detailDeviceInfo);
            newIndex ++;

            // 增加明细item
            ItemDeviceInfo itemDeviceInfo =new ItemDeviceInfo(item.getId(),item.getName(),item.getType(),100,item.getRoomName());
            result.add(itemDeviceInfo);
            newIndex ++;
        }

        for(Map.Entry<Integer, Object> entry  : insertCache.entrySet()){
            // 增加标题item和明细控制item
            result.add(entry.getKey(),entry.getValue());
        }

        return result;
    }




}
