package com.miguelcr.maps;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(37.380356,-6.006939);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker Jesús place's"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        Marker poznanMarker = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(52.406374,16.925168))
                .title("Fire in Poznan!")
                .draggable(true));

        poznanMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_fire));

        poznanMarker.setSnippet("Poland");
        poznanMarker.showInfoWindow();
        // to hide:
        //poznanMarker.hideInfoWindow();

        // Draw lines in Map
        // Instantiates a new CircleOptions object and defines the center and radius
        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(52.406374,16.925168))
                .radius(1000)
                .fillColor(android.R.color.holo_purple)
                .strokeColor(android.R.color.holo_red_dark); // In meters

        // Get back the mutable Circle
        Circle circle = mMap.addCircle(circleOptions);



    }
}
