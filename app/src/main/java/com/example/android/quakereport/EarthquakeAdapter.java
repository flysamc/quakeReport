package com.example.android.quakereport;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;


import static com.example.android.quakereport.R.id.list;
import static com.example.android.quakereport.R.id.time;

/**
 * Created by flysamc on 2/3/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {

        super(context, 0, earthquakes);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );


        }





        Earthquake currentEarthquake = getItem(position);







        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitudeFormat = formatter.format(currentEarthquake.getMagnitude());
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText("" + magnitudeFormat);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView place = (TextView) listItemView.findViewById(R.id.place);
        place.setText(currentEarthquake.getPlace());

        TextView nearby = (TextView) listItemView.findViewById(R.id.location);
        nearby.setText(currentEarthquake.getNearBy());

        Date dateObject = new Date(currentEarthquake.getTime());

        TextView display = (TextView) listItemView.findViewById(R.id.date) ;
        String formattedTime = formatTime(dateObject);
        display.setText(formattedTime);

        TextView time = (TextView) listItemView.findViewById(R.id.time);


        String formatedDate = formatDate(dateObject);
        time.setText(formatedDate);

        return listItemView;

    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}




