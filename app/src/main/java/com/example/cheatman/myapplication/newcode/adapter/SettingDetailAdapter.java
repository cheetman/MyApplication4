package com.example.cheatman.myapplication.newcode.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.model.SettingInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cheatman on 2017/12/11.
 */

public class SettingDetailAdapter extends RecyclerView.Adapter<SettingDetailAdapter.ViewHolder>{

        Activity mContext;
        List<SettingInfo> mSettingList;


        public SettingDetailAdapter(Context context){
            this.mContext = (Activity)context;
            mSettingList = new ArrayList<>();
            mSettingList.add(new SettingInfo("User","Logout","Update Password"));
            mSettingList.add(new SettingInfo("Network","192.168.15.243","Manage"));
            mSettingList.add(new SettingInfo("Rooms","8 Rooms","Manage"));
            mSettingList.add(new SettingInfo("Devices","20 Devices","Manage"));
            mSettingList.add(new SettingInfo("Scene","18 Scenes","Manage"));
            mSettingList.add(new SettingInfo("Automation","13 Automations","Manage"));
            mSettingList.add(new SettingInfo("Users","13 Users","Manage"));
            mSettingList.add(new SettingInfo("Gateway Firmware","1.0.0.1","Update"));
            mSettingList.add(new SettingInfo("EZVIZ","not configed","EZVIZ Login"));
        }


        class ViewHolder extends RecyclerView.ViewHolder{
            TextView tv_item_setting_name;
            TextView tv_item_setting_detail;
            TextView tv_item_setting_manage;
            ImageView iv_item_setting_image;
            public ViewHolder(View view){
                super(view);
                tv_item_setting_name = (TextView) view.findViewById(R.id.tv_item_setting_name);
                tv_item_setting_detail = (TextView) view.findViewById(R.id.tv_item_setting_detail);
                tv_item_setting_manage = (TextView) view.findViewById(R.id.tv_item_setting_manage);
                iv_item_setting_image = (ImageView) view.findViewById(R.id.iv_item_setting_image);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder holder=  new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list_setting,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            final SettingInfo item =  mSettingList.get(position);

            switch (item.getName()){
                case "User":
                    holder.iv_item_setting_image.setImageResource(R.drawable.menu_user);
                    holder.tv_item_setting_detail.setText(R.string.setting_logout);
                    holder.tv_item_setting_detail.setTextColor(ContextCompat.getColor(mContext,R.color.skyblue));
                    holder.tv_item_setting_manage.setText(R.string.setting_update_password);
                    holder.tv_item_setting_name.setText(item.getName());
                    break;
                case "Network":
                    holder.iv_item_setting_image.setImageResource(R.drawable.menu_networkstatus);
                    holder.tv_item_setting_detail.setText(item.getDetailName());
                    holder.tv_item_setting_detail.setTextColor(ContextCompat.getColor(mContext,R.color.lightgrey));
                    holder.tv_item_setting_manage.setText(R.string.setting_manage);
                    holder.tv_item_setting_name.setText(R.string.setting_network);
                    break;
                case "Rooms":
                    holder.iv_item_setting_image.setImageResource(R.drawable.menu_home);
                    holder.tv_item_setting_detail.setText(item.getDetailName());
                    holder.tv_item_setting_detail.setTextColor(ContextCompat.getColor(mContext,R.color.lightgrey));
                    holder.tv_item_setting_manage.setText(R.string.setting_manage);
                    holder.tv_item_setting_name.setText(R.string.setting_rooms);
                    break;
                case "Devices":
                    holder.iv_item_setting_image.setImageResource(R.drawable.menu_devices);
                    holder.tv_item_setting_detail.setText(item.getDetailName());
                    holder.tv_item_setting_detail.setTextColor(ContextCompat.getColor(mContext,R.color.lightgrey));
                    holder.tv_item_setting_manage.setText(R.string.setting_manage);
                    holder.tv_item_setting_name.setText(R.string.setting_devices);
                    break;
                case "Scene":
                    holder.iv_item_setting_image.setImageResource(R.drawable.menu_scenes);
                    holder.tv_item_setting_detail.setText(item.getDetailName());
                    holder.tv_item_setting_detail.setTextColor(ContextCompat.getColor(mContext,R.color.lightgrey));
                    holder.tv_item_setting_manage.setText(R.string.setting_manage);
                    holder.tv_item_setting_name.setText(R.string.setting_scene);
                    break;
                case "Automation":
                    holder.iv_item_setting_image.setImageResource(R.drawable.menu_scheduler);
                    holder.tv_item_setting_detail.setText(item.getDetailName());
                    holder.tv_item_setting_detail.setTextColor(ContextCompat.getColor(mContext,R.color.lightgrey));
                    holder.tv_item_setting_manage.setText(R.string.setting_manage);
                    holder.tv_item_setting_name.setText(R.string.setting_automation);
                    break;
                case "Users":
                    holder.iv_item_setting_image.setImageResource(R.drawable.menu_user);
                    holder.tv_item_setting_detail.setText(item.getDetailName());
                    holder.tv_item_setting_detail.setTextColor(ContextCompat.getColor(mContext,R.color.lightgrey));
                    holder.tv_item_setting_manage.setText(R.string.setting_manage);
                    holder.tv_item_setting_name.setText(R.string.setting_users);
                    break;
                case "Gateway Firmware":
                    holder.iv_item_setting_image.setImageResource(R.drawable.menu_networkstatus);
                    holder.tv_item_setting_detail.setText(item.getDetailName());
                    holder.tv_item_setting_detail.setTextColor(ContextCompat.getColor(mContext,R.color.lightgrey));
                    holder.tv_item_setting_manage.setText(R.string.setting_update);
                    holder.tv_item_setting_name.setText(R.string.setting_gateway);
                    break;
                case "EZVIZ":
                    holder.iv_item_setting_image.setImageResource(R.drawable.device_ipcamera_grey);
                    holder.tv_item_setting_detail.setText(item.getDetailName());
                    holder.tv_item_setting_detail.setTextColor(ContextCompat.getColor(mContext,R.color.lightgrey));
                    holder.tv_item_setting_manage.setText(R.string.setting_ezviz_login);
                    holder.tv_item_setting_name.setText(R.string.setting_ezviz);
                    break;
                default:
                    break;
            }

            // 点击事件
          if (mOnItemClickListener != null)
            {
                holder.tv_item_setting_detail.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {

                        int position = holder.getLayoutPosition();
                        mOnItemClickListener.onDetailItemClick(holder.itemView, item,position);
                    }
                });
                holder.tv_item_setting_manage.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickListener.onManageItemClick(holder.itemView,item, pos);
                    }
                });
            }
        }



        @Override
        public int getItemCount() {
            return mSettingList.size();
        }


        //利用回调实现单击事件
        public interface OnItemClickListener
        {
            void onDetailItemClick(View view, SettingInfo model,int position);
            void onManageItemClick(View view,SettingInfo model, int position);
        }

        private OnItemClickListener mOnItemClickListener;

        public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
        {
            this.mOnItemClickListener = mOnItemClickListener;

        }


}
