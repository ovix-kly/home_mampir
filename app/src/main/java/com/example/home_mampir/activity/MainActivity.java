package com.example.home_mampir.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.home_mampir.R;
import com.example.home_mampir.adapter.ArtikelAdapter;
import com.example.home_mampir.adapter.TempatRekomedasiAdapter;
import com.example.home_mampir.adapter.TempatTerdekatAdapter;
import com.example.home_mampir.homeMampirAPIservice;
import com.example.home_mampir.modelClass.ModelArtikel;
import com.example.home_mampir.modelClass.statusNearby;
import com.example.home_mampir.modelClass.statusRecomendation;
import com.example.home_mampir.utility.gpsUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mainMap;
    RecyclerView rvNearby,rvRecomendation,rvArtikel;
    TempatTerdekatAdapter tempatTerdekatAdapter;
    TempatRekomedasiAdapter tempatRekomendasiAdapter;
    ArtikelAdapter artikelAdapter;
    ArrayList<ModelArtikel> listArtikel;
    ImageView btnViewDetailDestinationPopuler;
    ModelArtikel modelArtikel;

    private FusedLocationProviderClient mFusedLocationClient;
    public double Latitude = 0.0, Longitude = 0.0;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;


    private boolean isContinue = false;
    private boolean isGPS = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Check if GPS Enable or Disable

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10 * 1000); // 10 seconds
        locationRequest.setFastestInterval(5 * 1000); // 5 seconds


        new gpsUtils(this).turnGPSOn(new gpsUtils.onGpsListener() {
            @Override
            public void gpsStatus(boolean isGPSEnable) {
                // turn on GPS
                isGPS = isGPSEnable;
                getLocation();
            }
        });


        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        Latitude = location.getLatitude();
                        Longitude = location.getLongitude();
                        if (mFusedLocationClient != null) {
                            if (!isContinue && mFusedLocationClient != null) {
                                mFusedLocationClient.removeLocationUpdates(locationCallback);
                            }
                        }
                    }
                }
            }
        };

        if (!isGPS) {
            Toast.makeText(this, "Please turn on GPS", Toast.LENGTH_SHORT).show();
            return;
        }else{
            //getLocation();
        }


        //RecycleView - Konten
        homeMampirAPIservice tempatTerdekatAPI = homeMampirAPIservice.nearbyPlaceClient.create(homeMampirAPIservice.class);
        homeMampirAPIservice tempatRekomendasiAPI = homeMampirAPIservice.recomendationPlaceClient.create(homeMampirAPIservice.class);


        Call<statusNearby> callTempatTerdekat = tempatTerdekatAPI.getAllNearbyPlace(7);
        Call<statusRecomendation> callTempatRekomendasi = tempatRekomendasiAPI.getAllRecomendationPlace(7);


        callTempatTerdekat.enqueue(new Callback<statusNearby>() {

            @Override
            public void onResponse(Call<statusNearby> call, Response<statusNearby> response) {

                statusNearby state = response.body();

                if(state.getStatus().equals("success")){
                    tempatTerdekatAdapter = new TempatTerdekatAdapter(state.getAllNearbyPlace());
                    rvNearby.setAdapter(tempatTerdekatAdapter);
                    Log.d("Status : ",state.getStatus());
                }else{
                    Log.d("Status : ","Failed Fetch API 1");
                }

            }

            @Override
            public void onFailure(Call<statusNearby> call, Throwable t) {
               //Log.d(" Get size of NearbyPlace", String.valueOf());
                Log.d("Status : ","Failed Fetch API 2");
            }
        });


        callTempatRekomendasi.enqueue(new Callback<statusRecomendation>() {

            @Override
            public void onResponse(Call<statusRecomendation> call, Response<statusRecomendation> response) {

                statusRecomendation stateRecomendation = response.body();

                Log.d("Status ",String.valueOf(stateRecomendation.getStatus()));
                tempatRekomendasiAdapter = new TempatRekomedasiAdapter(stateRecomendation.getAllRecomendationPlace());
                rvRecomendation.setAdapter(tempatRekomendasiAdapter);

            }

            @Override
            public void onFailure(Call<statusRecomendation> call, Throwable t) {

            }
        });


        rvNearby = (RecyclerView)findViewById(R.id.rv_nearby);
        rvRecomendation = (RecyclerView)findViewById(R.id.rv_recomendation);
        rvArtikel = (RecyclerView)findViewById(R.id.rv_artikel);



        addDataArtikel();


        artikelAdapter = new ArtikelAdapter(listArtikel);




        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);

        rvNearby.setLayoutManager(layoutManager);
        rvRecomendation.setLayoutManager(layoutManager2);
        rvArtikel.setLayoutManager(layoutManager3);
        rvArtikel.setAdapter(artikelAdapter);

        SnapHelper snapHelperNearby = new LinearSnapHelper();
        SnapHelper snapHelperRecomended = new LinearSnapHelper();

        snapHelperNearby.attachToRecyclerView(rvNearby);
        snapHelperRecomended.attachToRecyclerView(rvRecomendation);

        btnViewDetailDestinationPopuler = (ImageView)findViewById(R.id.viewAllDestinasiPopuler);

        btnViewDetailDestinationPopuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Context mContext = getApplicationContext();
                Intent intent = new Intent(MainActivity.this, PageDetailDestinasiPopuler.class);
                startActivity(intent);
            }
        });

        //END OF RecycleView - Konten


    }



    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    gpsUtils.AppConstants.LOCATION_REQUEST);

        } else {
            if (isContinue) {
                mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
            } else {
                mFusedLocationClient.getLastLocation().addOnSuccessListener(MainActivity.this, location -> {
                    if (location != null) {
                        Latitude = location.getLatitude();
                       Longitude = location.getLongitude();
                        Log.d("Isi kordinat ",String.valueOf(Latitude));

                        SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager()
                                .findFragmentById(R.id.mainMapView);
                        supportMapFragment.getMapAsync(this);

                    } else {
                        mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
                    }
                });
            }
        }
    }



    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1000: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (isContinue) {
                        mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
                    } else {
                        mFusedLocationClient.getLastLocation().addOnSuccessListener(MainActivity.this, location -> {
                            if (location != null) {
                                Latitude = location.getLatitude();
                                Longitude = location.getLongitude();
                            } else {
                                mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
                            }
                        });
                    }
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == gpsUtils.AppConstants.GPS_REQUEST) {
                isGPS = true; // flag maintain before get location
            }
        }
    }



    public void addDataArtikel(){
        listArtikel = new ArrayList<>();
        listArtikel.add(new ModelArtikel("36 Tempat & Destinasi Wisata Malang Paling Populer"));
        listArtikel.add(new ModelArtikel("36 Tempat & Destinasi Wisata Malang Paling Populer"));
        listArtikel.add(new ModelArtikel("36 Tempat & Destinasi Wisata Malang Paling Populer"));
        listArtikel.add(new ModelArtikel("36 Tempat & Destinasi Wisata Malang Paling Populer"));
        listArtikel.add(new ModelArtikel("36 Tempat & Destinasi Wisata Malang Paling Populer"));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mainMap = googleMap;
        LatLng yourLocation = new LatLng(Latitude,Longitude);
        mainMap.addMarker(new MarkerOptions().position(yourLocation).title(String.valueOf("Anda Disini!")));
        mainMap.moveCamera(CameraUpdateFactory.newLatLng(yourLocation));
        mainMap.animateCamera(CameraUpdateFactory.zoomTo(17f));

        Log.d("Latitude ",String.valueOf(Latitude));
        Log.d("Longitude ",String.valueOf(Longitude));

    }



}
