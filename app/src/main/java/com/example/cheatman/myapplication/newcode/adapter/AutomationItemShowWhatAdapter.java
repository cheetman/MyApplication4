package com.example.cheatman.myapplication.newcode.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.cheatman.myapplication.R;
import com.example.cheatman.myapplication.newcode.model.DeviceInfoAll;
import com.example.cheatman.myapplication.newcode.model.SceneInfo;
import com.example.cheatman.myapplication.newcode.model.expand.ItemDeviceInfo;
import com.example.cheatman.myapplication.newcode.model.expand.TitleInfo;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cheatman on 2017/12/11.
 */

public class AutomationItemShowWhatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;

    private List<Object> items;

    private boolean onBindFlag = true;
    //view type

    public AutomationItemShowWhatAdapter(Context context, List<Object> items){
        this.context = context;
        this.items= items;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return  new AutomationItemShowWhatAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_automation_what,parent,false));

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        onBindFlag = true;
        Log.d("测试", "onBindViewHolder:" + String.valueOf(position) );

            final AutomationItemShowWhatAdapter.ItemViewHolder itemViewHolder = (AutomationItemShowWhatAdapter.ItemViewHolder) holder;
            final Object itemObj = items.get(position);
                        if(itemObj instanceof DeviceInfoAll){
                            DeviceInfoAll      item =   (DeviceInfoAll)itemObj;


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
                        }else if(itemObj instanceof SceneInfo){
                            SceneInfo      item =   (SceneInfo)itemObj;
                            itemViewHolder.tv_item_device_name.setText(item.getName());
                            itemViewHolder.tv_item_device_status.setText("");
                        }



        onBindFlag = false;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    class ItemViewHolder extends RecyclerView.ViewHolder{
        //common
        View view;
        //明细
        @BindView(R.id.tv_item_device_name)
        TextView tv_item_device_name;
        @BindView(R.id.tv_item_device_status)
        TextView tv_item_device_status;
        @BindView(R.id.v_item_device_line)
        View v_item_device_line;


        public ItemViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
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

}
