package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText(currentEarthquake.getMagnitude());

        TextView place = (TextView) listItemView.findViewById(R.id.place);
        place.setText(currentEarthquake.getPlace());

        Date dateObject = new Date(currentEarthquake.getTime());

        TextView display = (TextView) listItemView.findViewById(R.id.date) ;
        String formattedTime = formatTime(dateObject);
        display.setText(formattedTime);

        TextView time = (TextView) listItemView.findViewById(R.id.time);


        String formatedDate = formatDate(dateObject);
        time.setText(formatedDate);

        return listItemView;

    }
}




