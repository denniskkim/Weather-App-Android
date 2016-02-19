package com.example.denniskim.stormy.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.denniskim.stormy.R;
import com.example.denniskim.stormy.Weather.Hour;

import org.w3c.dom.Text;

/**
 * Created by denniskim on 8/31/15.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder>{

    private Hour[] mHours;
    private Context mContext;

    public HourAdapter(Context context, Hour[] hours)
    {
        mContext = context;
        mHours = hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.hourly_list_item, viewGroup, false);

        HourViewHolder viewHolder = new HourViewHolder(view);


        return viewHolder;
    }

    /*
        bridge between adapter and bind method on the bottom
     */
    @Override
    public void onBindViewHolder(HourViewHolder hourViewHolder, int i) {
        hourViewHolder.bindHour(mHours[i]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }
    // creating the onClickListener and setting it for the root view in the ViewHolder to handle
    // list item taps in a recyclerView
    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mTimeLabel;
        public TextView mTempLabel;
        public TextView mSummaryLabel;
        public ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);

            mTimeLabel = (TextView) itemView.findViewById(R.id.timeLabel);
            mTempLabel = (TextView) itemView.findViewById(R.id.tempLabel);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.summaryLabel);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);

            itemView.setOnClickListener(this);

        }

        public void bindHour(Hour hour) {
            mTimeLabel.setText(hour.getHour());
            mTempLabel.setText(hour.getTemperature() + "");
            mSummaryLabel.setText(hour.getSummary());
            mIconImageView.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View v) {
            String time = mTimeLabel.getText().toString();
            String temperature = mTempLabel.getText().toString();
            String summary = mSummaryLabel.getText().toString();

            String message = String.format("At %s it will be %s and %s", time, temperature,summary);

            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();

        }
    }
}
