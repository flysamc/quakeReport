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
    private Double mMagnitude;
    private String mPlace;
    private long mTime;
    private String mNearBy;
    private String mLocation;
    private String mEventPage;
    private static final String LOCATION_SEPARATOR = " of ";






    Earthquake(Double magnitude,String place,long time,String eventPage){
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
        mEventPage = eventPage;
        setSeperateLocation(mPlace);
    }

    public Double getMagnitude(){
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

    public String getEventPage(){
        return mEventPage;
    }




}
