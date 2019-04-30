package com.example.home_mampir;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowMapFragment extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gMap;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_detail_location);
        SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        LatLng sydney = new LatLng(-6.3323578, 106.7498257);
        gMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        gMap.addMarker(new MarkerOptions().position(sydney).title("Anda Disini!"));
        gMap.animateCamera(CameraUpdateFactory.zoomTo(15.5f));
    }
}
