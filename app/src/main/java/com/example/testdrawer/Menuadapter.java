package com.example.testdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Menuadapter extends BaseAdapter {
    Context context;
    private int layout;
    private List<Itemmenu> list;

    public Menuadapter(Context context, int layout, List<Itemmenu> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return  list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHolder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         ViewHolder viewHolder;
        if(view==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            viewHolder=new ViewHolder();
            viewHolder.tv=(TextView) view.findViewById(R.id.tvitem);
            viewHolder.img=(ImageView) view.findViewById(R.id.imgicon);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.tv.setText(list.get(i).item);
        viewHolder.img.setImageResource(list.get(i).icon);

        return view;
    }
}
