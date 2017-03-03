package com.example.android.quakereport;

import java.text.SimpleDateFormat;

import static android.text.TextUtils.split;

/**
 * Created by flysamc on 1/3/17.
 */

public class Earthquake {
    private String mMagnitude;
    private String mPlace;
    private long mTime;
    private String mNearBy;
    private String mLocation;






    Earthquake(String magnitude,String place,long time){
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
    }

    public String getMagnitude(){
        return mMagnitude;
    }
    public String getPlace(){
        return mPlace;
    }
    public long getTime(){
        return mTime;
    }

    public void splitLocation(String mPlace){

        split(mPlace , ",");

    }




}
