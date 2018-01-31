package com.example.cheatman.myapplication.newcode.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cheatman.myapplication.R;

import com.example.cheatman.myapplication.newcode.model.expand.ItemDeviceInfo;

import java.util.List;

/**
 * Created by Cheatman on 2017/12/11.
 */

public class DeviceDetailAdapter extends RecyclerView.Adapter<DeviceDetailAdapter.ViewHolder>{

        Context context;
        List<ItemDeviceInfo> items;


        public DeviceDetailAdapter(Context context, List<ItemDeviceInfo> items){
            this.context = context;
            this.items= items;
        }


        class ViewHolder extends RecyclerView.ViewHolder{

            TextView tv_item_device_name;
            TextView tv_item_device_roomname;

            public ViewHolder(View view){
                super(view);
                tv_item_device_name = (TextView) view.findViewById(R.id.tv_item_device_name);
                tv_item_device_roomname = (TextView) view.findViewById(R.id.tv_item_device_roomname);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder holder=  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_expand_item_device,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            ItemDeviceInfo item =  items.get(position);
            holder.tv_item_device_name.setText(item.getName());
            holder.tv_item_device_roomname.setText(item.getRoomName());

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
