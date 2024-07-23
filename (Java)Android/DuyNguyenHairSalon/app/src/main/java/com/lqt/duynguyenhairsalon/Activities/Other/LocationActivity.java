package com.lqt.duynguyenhairsalon.Activities.Other;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lqt.duynguyenhairsalon.R;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        initView();
    }

    private void initView() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragment_Map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(20.88735943336592, 105.93077116188901);
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Lấy vị trí tạm chơi vui vui thôi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 20));
    }
}