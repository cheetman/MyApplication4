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
import com.example.cheatman.myapplication.newcode.model.SceneInfo;
import com.example.cheatman.myapplication.newcode.model.expand.DetailDeviceInfo;
import com.example.cheatman.myapplication.newcode.model.expand.ItemDeviceInfo;
import com.example.cheatman.myapplication.newcode.model.expand.TitleInfo;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cheatman on 2017/12/11.
 */

public class SceneItemShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;

    private List<Object> items;

    private boolean onBindFlag = true;
    //view type
    private static final int VIEW_TYPE_TITLE = R.layout.item_list_expand_title_room;
    private static final int VIEW_TYPE_ITEM_DEVICE = R.layout.item_list_expand_item_device_2;

    public SceneItemShowAdapter(Context context, List<Object> items){
        this.context = context;
        this.items= items;
    }

    @Override
    public int getItemViewType(int position) {
        if ("ItemDeviceInfo".equals(getModelType(position)))
            return VIEW_TYPE_ITEM_DEVICE;
        else if("Title".equals(getModelType(position)))
            return VIEW_TYPE_TITLE;
        return VIEW_TYPE_ITEM_DEVICE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM_DEVICE)
            return  new SceneItemShowAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(viewType,parent,false),viewType);
        else if(viewType == VIEW_TYPE_TITLE)
            return   new SceneItemShowAdapter.TitleViewHolder(LayoutInflater.from(context).inflate(viewType,parent,false),viewType);
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        onBindFlag = true;
        Log.d("测试", "onBindViewHolder:" + String.valueOf(position) );
        if(holder instanceof SceneItemShowAdapter.ItemViewHolder) {
            final SceneItemShowAdapter.ItemViewHolder itemViewHolder = (SceneItemShowAdapter.ItemViewHolder) holder;
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
                itemViewHolder.tv_item_device_name.setText(item.getName());

                String statusValue = " ";
                switch (item.getType()) {
                    case "Light":
                        statusValue = String.format(Locale.CHINESE ,"%s      %d%%", item.isOn()?"ON":"OFF" , (int)item.getValue());
                        break;
                    case "Plug":
                        statusValue = String.format(Locale.CHINESE ,"%s      %d%%", item.isOn()?"ON":"OFF" , (int)item.getValue());
                        break;
                    case "DoublePole":
                        statusValue = String.format(Locale.CHINESE ,"%s", item.isOn()?"ON":"OFF" );
                        break;
                    case "Curtain":
                        statusValue = String.format(Locale.CHINESE ,"%s      %d%%", item.isOn()?"ON":"OFF" , (int)item.getValue());
                        break;
                    case "FloorHeating":
                        statusValue = String.format(Locale.CHINESE ,"%s      %d%%", item.isOn()?"ON":"OFF" , (int)item.getValue());
                        break;
                    case "TV":
                        break;
                    case "AC":
                        break;
                    case "Sensor":
                        break;
                    default:
                        break;
                }

                itemViewHolder.tv_item_device_status.setText(statusValue);
            }
        }
        else if(holder instanceof SceneItemShowAdapter.TitleViewHolder) {
            final SceneItemShowAdapter.TitleViewHolder titleViewHolder =  (SceneItemShowAdapter.TitleViewHolder)holder;
            final TitleInfo item = (TitleInfo) items.get(position);
            titleViewHolder.tv_item_title.setText(item.getName());
            //Log.d("测试", String.valueOf(item2.isExpanded) );
            titleViewHolder.tb_item_title_button.setChecked(!item.isExpanded());
            titleViewHolder.tb_item_title_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (onBindFlag == false && mOnTitleItemCheckedChangeListener != null) {
                        mOnTitleItemCheckedChangeListener.mOnTitleItemCheckedChangeListener(buttonView, item, isChecked);
                    }
                }
            });
        }


        onBindFlag = false;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }





    public interface OnTitleItemCheckedChangeListener {
        void mOnTitleItemCheckedChangeListener(View view,TitleInfo title, boolean isOpen);
    }

    private SceneItemShowAdapter.OnTitleItemCheckedChangeListener mOnTitleItemCheckedChangeListener;

    public void setOnTitleItemCheckedChangeListener(SceneItemShowAdapter.OnTitleItemCheckedChangeListener mOnTitleItemCheckedChangeListener)
    {
        this.mOnTitleItemCheckedChangeListener = mOnTitleItemCheckedChangeListener;
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
        @BindView(R.id.tv_item_device_status)
        TextView tv_item_device_status;
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



    private String getModelType (int position){
        if( items.get(position) instanceof ItemDeviceInfo){
            return "ItemDeviceInfo";
        }else if(items.get(position) instanceof TitleInfo){
            return "Title";
        }else {
            return "Title";
        }
    }

}
