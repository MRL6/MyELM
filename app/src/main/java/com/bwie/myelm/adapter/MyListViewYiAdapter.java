package com.bwie.myelm.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.myelm.R;
import com.bwie.myelm.bean.Meau;

import java.util.ArrayList;
import java.util.List;

public class MyListViewYiAdapter extends BaseAdapter {
    private List<Meau.DataBean> list = new ArrayList<>();
    private Context context;

    public MyListViewYiAdapter(List<Meau.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.listview_yi_layout, null);
            holder = new ViewHolder();
            holder.text_name = convertView.findViewById(R.id.text_name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text_name.setText(list.get(position).getSellerName());
        return convertView;
    }
    class ViewHolder{
        TextView text_name;
    }
}
