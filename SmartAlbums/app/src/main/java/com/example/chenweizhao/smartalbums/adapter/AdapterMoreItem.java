package com.example.chenweizhao.smartalbums.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chenweizhao.smartalbums.R;
import com.example.chenweizhao.smartalbums.data.DataMoreItem;

import java.util.ArrayList;

    public class AdapterMoreItem extends BaseAdapter {
    private ArrayList<DataMoreItem> datas;
    Context context;
    ImageView icon;
    TextView content;
    public AdapterMoreItem(ArrayList<DataMoreItem> data, Context context){
        this.datas = data;
        this.context = context;
    }

    @Override
    public DataMoreItem getItem(int position){
        if (datas != null || position >= datas.size()) {
            return null;
        }
        return datas.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public int getCount(){
        if (datas == null) {
            return 0;
        }
        return datas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_more_layout, null);
        }
        icon = convertView.findViewById(R.id.more_icon);
        content = convertView.findViewById(R.id.more_content);
        icon.setBackground(datas.get(position).getIcon());
        content.setText(datas.get(position).getContent());
        return convertView;
    }
}

