package com.example.cheatman.myapplication.newcode.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.model.expand.DetailDeviceInfo;
import com.example.cheatman.myapplication.newcode.model.expand.ItemDeviceInfo;
import com.example.cheatman.myapplication.newcode.model.expand.TitleInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cheatman on 2017/12/11.
 */

public class DeviceDetail2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private Context context;

        private List<Object> items;

        private boolean onBindFlag = true;
        //view type
        private static final int VIEW_TYPE_TITLE = R.layout.item_list_expand_title;
        private static final int VIEW_TYPE_ITEM_DEVICE = R.layout.item_list_expand_item_device;
        private static final int VIEW_TYPE_DETAIL_LIGHT= R.layout.item_list_expand_detail_device;

    public DeviceDetail2Adapter(Context context, List<Object> items){
        this.context = context;
        this.items= items;
    }

        @Override
        public int getItemViewType(int position) {
            if ("ItemDeviceInfo".equals(getModelType(position)))
                return VIEW_TYPE_ITEM_DEVICE;
            else if("Title".equals(getModelType(position)))
                return VIEW_TYPE_TITLE;
            else if("DetailDeviceInfo".equals(getModelType(position)))
                return VIEW_TYPE_DETAIL_LIGHT;
            return VIEW_TYPE_ITEM_DEVICE;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == VIEW_TYPE_ITEM_DEVICE)
                return  new ItemViewHolder(LayoutInflater.from(context).inflate(viewType,parent,false),viewType);
            else if(viewType == VIEW_TYPE_TITLE)
                return   new TitleViewHolder(LayoutInflater.from(context).inflate(viewType,parent,false),viewType);
            else if(viewType == VIEW_TYPE_DETAIL_LIGHT)
                return  new DetailViewHolder(LayoutInflater.from(context).inflate(viewType,parent,false),viewType);
            return null;
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
            Log.d("测试", "onBindViewHolder:" + String.valueOf(position) );
            if(holder instanceof ItemViewHolder) {
                final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                final ItemDeviceInfo item = (ItemDeviceInfo) items.get(position);
                // 隐藏
                if (item.isVisibility()) {
                    itemViewHolder.setVisibility(true);
                    itemViewHolder.v_item_device_line.setVisibility(View.VISIBLE);
                } else {
                    itemViewHolder.setVisibility(false);
                }
                if (item.isExpanded()) {
                    itemViewHolder.v_item_device_line.setVisibility(View.INVISIBLE);
                } else {
                    itemViewHolder.v_item_device_line.setVisibility(View.VISIBLE);
                }

                // 如果未隐藏才执行 优化效率忽略不计
                if (item.isVisibility()) {
                    switch (item.getType()) {
                        case "Light":
                            itemViewHolder.iv_item_device_icon.setImageResource(R.drawable.device_light_green);
                            break;
                        case "Plug":
                            itemViewHolder.iv_item_device_icon.setImageResource(R.drawable.device_plug_green);
                            break;
                        case "DoublePole":
                            itemViewHolder.iv_item_device_icon.setImageResource(R.drawable.device_double_pole_green);
                            break;
                        case "Curtain":
                            itemViewHolder.iv_item_device_icon.setImageResource(R.drawable.device_curtain_green);
                            break;
                        case "FloorHeating":
                            itemViewHolder.iv_item_device_icon.setImageResource(R.drawable.device_floor_heating_green);
                            break;
                        case "TV":
                            itemViewHolder.iv_item_device_icon.setImageResource(R.drawable.device_tv_green);
                            break;
                        case "AC":
                            itemViewHolder.iv_item_device_icon.setImageResource(R.drawable.device_ac_green);
                            break;
                        case "Sensor":
                            itemViewHolder.iv_item_device_icon.setImageResource(R.drawable.device_sensor_green);
                            break;
                        default:
                            break;
                    }

                    itemViewHolder.tv_item_device_name.setText(item.getName());
                    itemViewHolder.tv_item_device_roomname.setText(item.getRoomName());

                    // 如果设置了回调，则设置点击事件
                    if (mOnItemClickListener != null) {
                        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int position = itemViewHolder.getLayoutPosition();
                                mOnItemClickListener.onItemClick(itemViewHolder.itemView, item, position);
                            }
                        });

                        itemViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                int pos = itemViewHolder.getLayoutPosition();
                                mOnItemClickListener.onItemLongClick(itemViewHolder.itemView, item, pos);
                                return false;
                            }
                        });
                    }
                }
            }
            else if(holder instanceof TitleViewHolder ) {
                        final TitleViewHolder titleViewHolder =  (TitleViewHolder)holder;
                        final TitleInfo item = (TitleInfo) items.get(position);
                        titleViewHolder.tv_item_title.setText(item.getName());
                        //Log.d("测试", String.valueOf(item2.isExpanded) );
                        titleViewHolder.tb_item_title_button.setOnCheckedChangeListener(null);
                        titleViewHolder.tb_item_title_button.setChecked(!item.isExpanded());
                        titleViewHolder.tb_item_title_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                                if (mOnTitleItemCheckedChangeListener != null) {
                                    mOnTitleItemCheckedChangeListener.mOnTitleItemCheckedChangeListener(buttonView, item, isChecked);
                                }
                            }
                        });
                    }
                    else if(holder instanceof DetailViewHolder) {
                final DetailViewHolder detailViewHolder =  (DetailViewHolder)holder;
                        final DetailDeviceInfo item = (DetailDeviceInfo) items.get(position);

                        // 隐藏
                        if (item.isVisibility()) {
                            detailViewHolder.setVisibility(true);
                        } else {
                            detailViewHolder.setVisibility(false);
                        }
                    }
        }

        @Override
        public int getItemCount() {
        return items.size();
    }





        public interface OnTitleItemCheckedChangeListener {
            void mOnTitleItemCheckedChangeListener(View view,TitleInfo title, boolean isOpen);
        }

        private OnTitleItemCheckedChangeListener mOnTitleItemCheckedChangeListener;

        public void setOnTitleItemCheckedChangeListener(OnTitleItemCheckedChangeListener mOnTitleItemCheckedChangeListener)
        {
            this.mOnTitleItemCheckedChangeListener = mOnTitleItemCheckedChangeListener;
        }


        //利用回调实现单击事件
        public interface OnItemClickListener
        {
            void onItemClick(View view, ItemDeviceInfo info, int position);
            void onItemLongClick(View view, ItemDeviceInfo info, int position);
        }

        private OnItemClickListener mOnItemClickListener;

        public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
        {
            this.mOnItemClickListener = mOnItemClickListener;
        }



    class TitleViewHolder extends RecyclerView.ViewHolder{
        //common
        View view;
        int viewType;

        //标题
        @BindView(R.id.tv_item_title)
        TextView tv_item_title;
        @BindView(R.id.tb_item_title_button)
        ToggleButton tb_item_title_button;

        public TitleViewHolder(View view, int viewType){
            super(view);
            ButterKnife.bind(this, view);
            //setIsRecyclable(false);
            this.viewType = viewType;
            this.view = view;
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        //common
        View view;
        int viewType;
        //明细
        @BindView(R.id.tv_item_device_name)
        TextView tv_item_device_name;
        @BindView(R.id.tv_item_device_roomname)
        TextView tv_item_device_roomname;
        @BindView(R.id.iv_item_device_icon)
        ImageView iv_item_device_icon;
        @BindView(R.id.v_item_device_line)
        View v_item_device_line;


        public ItemViewHolder(View view, int viewType){
            super(view);
            ButterKnife.bind(this, view);
            this.viewType = viewType;
            //setIsRecyclable(false);
            this.view = view;
        }

        public void setVisibility(boolean isVisible){
            RecyclerView.LayoutParams param = (RecyclerView.LayoutParams)view.getLayoutParams();
            if (isVisible){
                param.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                param.width = LinearLayout.LayoutParams.MATCH_PARENT;
                view.setVisibility(View.VISIBLE);
            }else{
                view.setVisibility(View.INVISIBLE);
                param.height = 0;
                param.width = 0;
            }
            view.setLayoutParams(param);
        }
    }

    class DetailViewHolder extends RecyclerView.ViewHolder{

        //common
        View view;
        int viewType;
        //明细
        View v_item_device_detail_line;

        public DetailViewHolder(View view, int viewType){
            super(view);

            //setIsRecyclable(false);
            this.view = view;
            this.viewType = viewType;

        }

        public void setVisibility(boolean isVisible){
            RecyclerView.LayoutParams param = (RecyclerView.LayoutParams)view.getLayoutParams();
            if (isVisible){
                param.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                param.width = LinearLayout.LayoutParams.MATCH_PARENT;
                view.setVisibility(View.VISIBLE);
            }else{
                view.setVisibility(View.INVISIBLE);
                param.height = 0;
                param.width = 0;
            }
            view.setLayoutParams(param);
        }
    }



    private String getModelType (int position){
        if( items.get(position) instanceof ItemDeviceInfo){
            return "ItemDeviceInfo";
        }else if(items.get(position) instanceof TitleInfo){
            return "Title";
        }else if(items.get(position) instanceof DetailDeviceInfo){
            return "DetailDeviceInfo";
        }else {
            return "Title";
        }
    }

}
