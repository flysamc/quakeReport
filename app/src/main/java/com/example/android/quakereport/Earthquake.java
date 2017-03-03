package com.example.android.quakereport;

import android.util.Log;

import java.text.SimpleDateFormat;

import static android.text.TextUtils.split;
import static android.text.TextUtils.substring;

/**
 * Created by flysamc on 1/3/17.
 */

public class Earthquake {
    private String mMagnitude;
    private String mPlace;
    private long mTime;
    private String mNearBy;
    private String mLocation;
    private String[] seperateLocation;






    Earthquake(String magnitude,String place,long time){
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
    }

    public String getMagnitude(){
        return mMagnitude;
    }
    public String getPlace(){
        return mLocation;
    }
    public String getNearBy(){

        return mNearBy;
    }
    public long getTime(){
        return mTime;
    }

    public void splitLocation(String mPlace){

        seperateLocation = split(mPlace , ",");
        mLocation = seperateLocation[1];
        mNearBy = seperateLocation[0];
        Log.v("Earthquake" , mNearBy);
        Log.v("Earthquake" , mLocation);

    }




}
