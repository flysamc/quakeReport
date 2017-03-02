package com.example.android.quakereport;

/**
 * Created by flysamc on 1/3/17.
 */

public class Earthquake {
    private String mMagnitude;
    private String mPlace;
    private int mTime;

    Earthquake(String magnitude,String place,int time){
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
    public int getTime(){
        return mTime;
    }


}
