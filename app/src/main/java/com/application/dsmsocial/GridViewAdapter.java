package com.application.dsmsocial;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class GridViewAdapter extends ArrayAdapter<ImageItem>{
    private Context context;
    private int layoutResourceId;
    private List<ImageItem> dataList = null;
    private ArrayList<ImageItem> data;


    public GridViewAdapter(Context context, int layoutResourceId, ArrayList<ImageItem> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = new ArrayList();
        this.data.addAll(data);
        this.dataList = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageTitle = (TextView) row.findViewById(R.id.text);
            holder.image = (ImageView) row.findViewById(R.id.image);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ImageItem item = dataList.get(position);
        holder.imageTitle.setText(item.getTitle());
        holder.image.setImageBitmap(item.getImage());
        return row;
    }

    static class ViewHolder {
        TextView imageTitle;
        ImageView image;
    }


    public void filter(String charText, int num) {
        charText = charText.toLowerCase();
        dataList.clear();

        if (num == 0)
        {
            if (charText.length() == 0) {
                dataList.addAll(data);
            } else {
                for (ImageItem i : data) {
                    if (i.getName().toLowerCase().contains(charText)||i.getType().toLowerCase().contains(charText)) {
                        dataList.add(i);
                    }
                }
            }
        }

        else{
            if (charText.length() == 0) {
                dataList.addAll(data);
            } else {
                for (ImageItem i : data) {
                    if (i.getName().toLowerCase().contains(charText) || i.getType().toLowerCase().contains(charText) || i.getPrice().toLowerCase().contains(charText)) {
                        dataList.add(i);
                    }
                }
            }
        }
        this.notifyDataSetChanged();
    }
}