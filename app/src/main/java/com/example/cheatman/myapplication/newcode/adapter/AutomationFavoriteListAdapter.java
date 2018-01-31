package com.example.cheatman.myapplication.newcode.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.model.AutomationInfo;

import java.util.List;

/**
 * Created by Cheatman on 2017/12/11.
 */

public class AutomationFavoriteListAdapter extends RecyclerView.Adapter<AutomationFavoriteListAdapter.ViewHolder>{

        Context context;
        List<AutomationInfo> items;


        public AutomationFavoriteListAdapter(Context context, List<AutomationInfo> items){
            this.context = context;
            this.items= items;
        }


        class ViewHolder extends RecyclerView.ViewHolder{
            ToggleButton iv_item_favorite_icon;
            TextView tv_item_automation_name;

            public ViewHolder(View view){
                super(view);
                iv_item_favorite_icon = (ToggleButton) view.findViewById(R.id.iv_item_favorite_icon);
                tv_item_automation_name = (TextView) view.findViewById(R.id.tv_item_automation_name);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder holder=  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_automation_favorite,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            AutomationInfo item =  items.get(position);
            holder.tv_item_automation_name.setText(item.getName());

            holder.iv_item_favorite_icon.setOnCheckedChangeListener(null);
            holder.iv_item_favorite_icon.setChecked(item.isFavorite());


            holder.itemView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {

                        int position = holder.getLayoutPosition();
                        if(mOnItemListener != null)
                        mOnItemListener.onItemClick(holder.itemView,items.get(position), position);
                    }
                });
                holder.iv_item_favorite_icon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        int position = holder.getLayoutPosition();
                        AutomationInfo info = items.get(position);
                        info.setFavorite(b);
                        if(mOnItemListener != null)
                        mOnItemListener.onToggleButtonCheckedChange(holder.itemView,info, position,b);
                    }
                });
        }



        @Override
        public int getItemCount() {
            return items.size();
        }


        //利用回调实现单击事件
        public interface OnItemListener
        {
            void onItemClick(View view, AutomationInfo info, int position);
            void onToggleButtonCheckedChange(View view, AutomationInfo info, int position, boolean b);
        }

        private OnItemListener mOnItemListener;

        public void setOnItemClickListener(OnItemListener mOnItemClickListener)
        {
            this.mOnItemListener = mOnItemClickListener;
        }




}
