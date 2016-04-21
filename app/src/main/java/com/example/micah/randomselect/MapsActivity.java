package com.example.micah.randomselect;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        //Start - my location
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            mMap.getUiSettings().setMyLocationButtonEnabled(true);


            // Enable MyLocation Layer of Google Map
            googleMap.setMyLocationEnabled(true);
        }
        //End - my location


        int length = Data.getLength();
        if (length <= 0){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MapsActivity.this);
            builder1.setMessage("Unable to find any data.  Please try again later.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Okay",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        } else {
            int selection = -1; //Initializes the selection variable to prime the error check loop below.
            while (selection < 0 || selection > Data.getLength()) {

                selection = (int) (Math.random() * Data.getLength());  //Data.getLength will return a number >= 1 if there are items in the list which is zero indexed, so only simple multiplication is needed.
            }

            mMap.clear();
            Marker marker = mMap.addMarker(new MarkerOptions().position(Data.getLatLng(selection)).title(Data.getData(selection)));
            marker.showInfoWindow();
            mMap.animateCamera(CameraUpdateFactory.newLatLng(Data.getLatLng(selection)));
        }
    }

    public void onSearch(View view) {
        String location = "";
        EditText location_tf = (EditText) findViewById(R.id.searchtf);
        location = location_tf.getText().toString();

        if(location.equals("")){
            onMapReady(mMap);
        }else if (location != null || !location.equals("")) {
            List<Address> addressList = null;

            Geocoder geocoder = new Geocoder(this);

            try {
                addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (addressList.isEmpty()) {
                location_tf.setText("Please enter a valid location.");
            } else {
                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.clear();
                Marker marker = mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
                marker.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(12));
            }
        }
    }
}
