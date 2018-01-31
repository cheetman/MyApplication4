package com.example.cheatman.myapplication.newcode.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.model.SceneInfo;

import java.util.List;

/**
 * Created by Cheatman on 2017/12/11.
 */

public class SceneFavoriteListAdapter extends RecyclerView.Adapter<SceneFavoriteListAdapter.ViewHolder>{

        Context context;
        List<SceneInfo> items;


        public SceneFavoriteListAdapter(Context context, List<SceneInfo> items){
            this.context = context;
            this.items= items;
        }


        class ViewHolder extends RecyclerView.ViewHolder{
            ToggleButton iv_item_favorite_icon;
            TextView tv_item_scene_name;

            public ViewHolder(View view){
                super(view);
                iv_item_favorite_icon = (ToggleButton) view.findViewById(R.id.iv_item_favorite_icon);
                tv_item_scene_name = (TextView) view.findViewById(R.id.tv_item_scene_name);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder holder=  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_scene_favorite,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            SceneInfo item =  items.get(position);
            holder.tv_item_scene_name.setText(item.getName());

            // 如果设置了回调，则设置点击事件
            if (mOnItemClickListener != null)
            {
                holder.itemView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {

                        int position = holder.getLayoutPosition();
                        mOnItemClickListener.onItemClick(holder.itemView,items.get(position), position);
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
            void onItemClick(View view, SceneInfo info, int position);
        }

        private OnItemClickListener mOnItemClickListener;

        public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
        {
            this.mOnItemClickListener = mOnItemClickListener;
        }




}
