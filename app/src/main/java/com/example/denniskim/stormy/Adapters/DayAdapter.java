package com.example.denniskim.stormy.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.denniskim.stormy.R;
import com.example.denniskim.stormy.Weather.Daily;

/**
 * Created by denniskim on 8/30/15.
 */
public class DayAdapter extends BaseAdapter {

    private Context mContext;
    private Daily[] mDays;

    public DayAdapter(Context context, Daily[] days){
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /* Its called each time we scroll a new item onto the list
        convertView -- the view object that we want to reuse, and will be null first time its called
        when its not null, thats when we recycle the View data
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null)
        {
            //layout inflator - an android object that takes xml layouts and turns them into views
            //in code that we can use
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item,null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImage);
            holder.tempLabel = (TextView) convertView.findViewById(R.id.tempLabel);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);
            convertView.setTag(holder);
        }

        else{
            holder = (ViewHolder) convertView.getTag();
        }

        Daily day = mDays[position];

        holder.iconImageView.setImageResource(day.getIconId());
        holder.tempLabel.setText(day.getTempMax() + "");
        if(position == 0)
        {
            holder.dayLabel.setText("Today");
        }
        else {
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }

        return convertView;
    }

    /*
       - ViewHolder is a helper object that lets us reuse the same references to the objects
        in the view like text views, which will save us memory and perform better
     */
    private static class ViewHolder{
        ImageView iconImageView;
        TextView tempLabel;
        TextView dayLabel;

    }
}
