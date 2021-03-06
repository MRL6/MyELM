package com.bwie.myelm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.myelm.MainActivity;
import com.bwie.myelm.R;
import com.bwie.myelm.bean.Meau;
import com.bwie.myelm.core.MyView;

import java.util.ArrayList;
import java.util.List;

public class MyListViewErAdapter extends BaseAdapter {
    private List<Meau.DataBean.ListBean> list = new ArrayList<>();
    private Context context;

    public MyListViewErAdapter(List<Meau.DataBean.ListBean> list, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyListViewErAdapter.ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.listview_er_layout, null);
            holder = new MyListViewErAdapter.ViewHolder();
            holder.text_name = convertView.findViewById(R.id.text_name);
            holder.text_price = convertView.findViewById(R.id.text_price);
            holder.img_pic = convertView.findViewById(R.id.img_pic);
            holder.myView = convertView.findViewById(R.id.myView);
            convertView.setTag(holder);
        }else {
            holder = (MyListViewErAdapter.ViewHolder) convertView.getTag();
        }
        holder.text_name.setText(list.get(position).getTitle());
        holder.text_price.setText(list.get(position).getPrice()+"");
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        if (split.length > 0) {
            Glide.with(context).load(split[0]).into(holder.img_pic);
        }
        Log.i("asdf",list.get(position).getTitle());
        holder.myView.setCount(list.get(position).getNum());
        holder.myView.setMyViewListener(new MyView.MyViewListener() {
            @Override
            public void myView(int count) {
                    list.get(position).setNum(count);
                    onNumListener.onNum();
            }
        });
        return convertView;
    }
    class ViewHolder{
        TextView text_name,text_price;
        ImageView img_pic;
        MyView myView;
    }
    private OnNumListener onNumListener;

    public void setOnNumListener(OnNumListener onNumListener) {
        this.onNumListener = onNumListener;
    }
    public interface OnNumListener{
        void onNum();
    }
}
