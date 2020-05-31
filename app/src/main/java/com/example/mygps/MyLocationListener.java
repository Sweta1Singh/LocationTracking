package com.example.mygps;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MyLocationListener   implements LocationListener {
private Context conn ;
private  String AddressRet;
private  String  lat,longi;
    public MyLocationListener(Context conn)
    {
        this.conn=conn;



    }
    @Override
    public void onLocationChanged(Location loc) {


        Toast.makeText(
                conn,
                "Location changed: Lat: " + loc.getLatitude() + " Lng: "
                        + loc.getLongitude(), Toast.LENGTH_SHORT).show();
        String longitude = "Longitude: " + loc.getLongitude();

        String latitude = "Latitude: " + loc.getLatitude();



        /*------- To get city name from coordinates -------- */
        String cityName = null;
        Geocoder gcd = new Geocoder(conn, Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = gcd.getFromLocation(loc.getLatitude(),
                    loc.getLongitude(), 1);
            if (addresses.size() > 0) {
                System.out.println(addresses.get(0).getLocality());
                cityName = addresses.get(0).getLocality();
                AddressRet=addresses.get(0).getLocality();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String s = longitude + "\n" + latitude + "\n\nMy Current City is: "
                + cityName;
longi= String.valueOf((longitude));
lat=String.valueOf(latitude);
    }

    public String getLat()
    {
        return lat;
    }
    public String getLongi()
    {
        return longi;
    }
    public String getAddress()
    {
        return AddressRet;
    }



    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
}
