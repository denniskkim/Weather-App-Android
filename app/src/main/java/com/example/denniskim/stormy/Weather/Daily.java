package com.example.denniskim.stormy.Weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by denniskim on 8/27/15.
 */
public class Daily implements Parcelable{
    private long mTime;
    private String mSummary;
    private double mTempMax;
    private String mIcon;
    private String mTimeZone;

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public int getTempMax() {

        return (int)Math.round(mTempMax);
    }

    public void setTempMax(double tempMax) {
        mTempMax = tempMax;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getIconId()
    {
        return Forecast.getIconId(mIcon);
    }

    public String getDayOfTheWeek()
    {
        //the string is a format that can be found in the SimpleDateFormat api
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        formatter.setTimeZone(TimeZone.getTimeZone(mTimeZone));

        Date dateTime = new Date(mTime * 1000);

        return formatter.format(dateTime);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    // this method ships the data to our destination (wraps it up) we need another method that
    // unwraps it
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeDouble(mTempMax);
        dest.writeString(mIcon);
        dest.writeString(mTimeZone);
    }

    // this is the unwrap method. the data passed in order matters, so it needs to be the same
    private Daily(Parcel in)
    {
        mTime = in.readLong();
        mSummary = in.readString();
        mTempMax = in.readDouble();
        mIcon = in.readString();
        mTimeZone = in.readString();
    }
    public Daily() { }
    // need this method when implementing parcel
    public static final Creator<Daily> CREATOR = new Creator<Daily>() {
        @Override
        public Daily createFromParcel(Parcel source) {
            return new Daily(source);
        }

        @Override
        public Daily[] newArray(int size) {
            return new Daily[size];
        }
    };
}
