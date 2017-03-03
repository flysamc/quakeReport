package com.example.android.quakereport;

import android.util.Log;

import java.text.SimpleDateFormat;

import static android.text.TextUtils.split;
import static android.text.TextUtils.substring;
import static java.security.AccessController.getContext;

/**
 * Created by flysamc on 1/3/17.
 */

public class Earthquake {
    private String mMagnitude;
    private String mPlace;
    private long mTime;
    private String mNearBy;
    private String mLocation;
    private static final String LOCATION_SEPARATOR = " of ";






    Earthquake(String magnitude,String place,long time){
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
        setSeperateLocation(mPlace);
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


    public void setSeperateLocation(String mPlace){
        //if-else statement to check if the location string contains offset location or not
        if(mPlace.contains(LOCATION_SEPARATOR)){

            String [] strarr = mPlace.split(LOCATION_SEPARATOR);
            mNearBy = strarr[0] + LOCATION_SEPARATOR;
            mLocation = strarr[1];

        }
        else{
            mNearBy = " near the ";
            mLocation = mPlace;
        }


    }


}
