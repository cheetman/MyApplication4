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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cheatman on 2017/12/11.
 */

public class AutomationSettingListAdapter extends RecyclerView.Adapter<AutomationSettingListAdapter.ViewHolder>{

        Context context;
        List<AutomationInfo> items;


        public AutomationSettingListAdapter(Context context, List<AutomationInfo> items){
            this.context = context;
            this.items= items;
        }


        class ViewHolder extends RecyclerView.ViewHolder{

            @BindView(R.id.tv_item_automation_name)
            TextView tv_item_automation_name;

            public ViewHolder(View view){
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder holder=  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_automation_setting,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            AutomationInfo item =  items.get(position);
            holder.tv_item_automation_name.setText(item.getName());

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

        }



        @Override
        public int getItemCount() {
            return items.size();
        }


        //利用回调实现单击事件
        public interface OnItemListener
        {
            void onItemClick(View view, AutomationInfo info, int position);
        }

        private OnItemListener mOnItemListener;

        public void setOnItemClickListener(OnItemListener mOnItemClickListener)
        {
            this.mOnItemListener = mOnItemClickListener;
        }




}
