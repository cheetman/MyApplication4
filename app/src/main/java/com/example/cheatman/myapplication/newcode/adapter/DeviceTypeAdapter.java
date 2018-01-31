package com.example.cheatman.myapplication.newcode.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.model.DeviceTypeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cheatman on 2017/12/11.
 */

public class DeviceTypeAdapter extends RecyclerView.Adapter<DeviceTypeAdapter.ViewHolder>{

        Context context;
        List<DeviceTypeInfo> items;


        public DeviceTypeAdapter(Context context){
            this.context = context;
            List<DeviceTypeInfo> list = new ArrayList<DeviceTypeInfo>();
            list.add(new DeviceTypeInfo("id","Light"));
            list.add(new DeviceTypeInfo("id","Plug"));
            list.add(new DeviceTypeInfo("id","DoublePole"));
            list.add(new DeviceTypeInfo("id","Curtain"));
            list.add(new DeviceTypeInfo("id","FloorHeating"));
            list.add(new DeviceTypeInfo("id","TV"));
            list.add(new DeviceTypeInfo("id","AC"));
            list.add(new DeviceTypeInfo("id","Sensor"));
            this.items= list;
        }


        class ViewHolder extends RecyclerView.ViewHolder{
            ImageButton ib_item_device_top_icon;

            public ViewHolder(View view){
                super(view);
                ib_item_device_top_icon = (ImageButton) view.findViewById(R.id.ib_item_device_top_icon);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder holder=  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_device_type,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            DeviceTypeInfo item =  items.get(position);

                    switch (item.getName()){
                        case "Light":
                            holder.ib_item_device_top_icon.setImageResource(R.drawable.device_light_green);
                            break;
                        case "Plug":
                            holder.ib_item_device_top_icon.setImageResource(R.drawable.device_plug_green);
                            break;
                        case "DoublePole":
                            holder.ib_item_device_top_icon.setImageResource(R.drawable.device_double_pole_green);
                            break;
                        case "Curtain":
                            holder.ib_item_device_top_icon.setImageResource(R.drawable.device_curtain_green);
                            break;
                        case "FloorHeating":
                            holder.ib_item_device_top_icon.setImageResource(R.drawable.device_floor_heating_green);
                            break;
                        case "TV":
                            holder.ib_item_device_top_icon.setImageResource(R.drawable.device_tv_green);
                            break;
                        case "AC":
                            holder.ib_item_device_top_icon.setImageResource(R.drawable.device_ac_green);
                            break;
                        case "Sensor":
                            holder.ib_item_device_top_icon.setImageResource(R.drawable.device_sensor_green);
                            break;
                        default:
                            break;
                    }

            // 如果设置了回调，则设置点击事件
                    if (mOnItemClickListener != null)
            {
                holder.itemView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {

                        int position = holder.getLayoutPosition();
                        mOnItemClickListener.onItemClick(holder.itemView, position);
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
                {
                    @Override
                    public boolean onLongClick(View v)
                    {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                        return false;
                    }
                });
            }
        }



        @Override
        public int getItemCount() {
            return items.size();
        }


        //利用回调实现单击事件
        public interface OnItemClickListener
        {
            void onItemClick(View view, int position);
            void onItemLongClick(View view, int position);
        }

        private OnItemClickListener mOnItemClickListener;

        public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
        {
            this.mOnItemClickListener = mOnItemClickListener;
        }




}
