package com.example.home_mampir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.home_mampir.R;
import com.example.home_mampir.adapter.ReviewAdapter;
import com.example.home_mampir.modelClass.ModelReviewerClass;
import com.example.home_mampir.page_input_review;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PageDetailActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gMap;
    ReviewAdapter reviewAdapter;
    RecyclerView rvReview;
    ArrayList<ModelReviewerClass> listReviewer;
    LinearLayout view;
    boolean opened;
    Button btnReview;
    FrameLayout frameLayout;
    ArrayList<String> getDetailTempatTerdekat = new ArrayList<>();
    String StaticURLImg = "https://mampir.id/uploads/";
    String fixImgUrl;
    double Latitude, Longitude;

    //View
    ImageView imgThumbLandscape;
    TextView namaLokasi, kategoriLokasi, alamat;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_detail_location);

        imgThumbLandscape = (ImageView)findViewById(R.id.thumbLandscape);
        namaLokasi = (TextView)findViewById(R.id.detailNamaLokasi);
        kategoriLokasi = (TextView)findViewById(R.id.detailKategoriLokasi);
        alamat = (TextView)findViewById(R.id.detailAlamat);

        Intent intent = getIntent();
        getDetailTempatTerdekat = intent.getStringArrayListExtra("detailTempatTerdekat");


        //Send value to View
        fixImgUrl = StaticURLImg + getDetailTempatTerdekat.get(2);
        Picasso.get().load(fixImgUrl).fit().centerCrop().into(imgThumbLandscape);

        namaLokasi.setText(getDetailTempatTerdekat.get(0));
        kategoriLokasi.setText(getDetailTempatTerdekat.get(1));
        alamat.setText(getDetailTempatTerdekat.get(3));







        for(int i=0;i<getDetailTempatTerdekat.size();i++){
            Log.d(" Isi Detail Lokasi ", getDetailTempatTerdekat.get(i));
        }

        //view = findViewById(R.layout.page_feedback);
        //view.setVisibility(View.INVISIBLE);

        btnReview = (Button)findViewById(R.id.input_review);

        addDataReviewer();

        rvReview = (RecyclerView)findViewById(R.id.rv_review);
        reviewAdapter = new ReviewAdapter(listReviewer);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PageDetailActivity.this, LinearLayoutManager.HORIZONTAL,false);
        rvReview.setLayoutManager(layoutManager);
        rvReview.setAdapter(reviewAdapter);

        SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        supportMapFragment.getMapAsync(this);

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                page_input_review pageInputReview = page_input_review.newInstance();
                pageInputReview.show(getSupportFragmentManager(),"page_input_review_fragment");

            }
        });

    }


    public void addDataReviewer(){
        listReviewer = new ArrayList<>();
        listReviewer.add(new ModelReviewerClass("Good place for children, plenty variety of street food","Sabrina"));
        listReviewer.add(new ModelReviewerClass("No Place like home","David"));
        listReviewer.add(new ModelReviewerClass("So comfortable, sleep under the star","Yuna"));
        listReviewer.add(new ModelReviewerClass("Good place for children, plenty variety of street food","Sabrina"));
        listReviewer.add(new ModelReviewerClass("No Place like home","David"));
        listReviewer.add(new ModelReviewerClass("So comfortable, sleep under the star","Yuna"));
        listReviewer.add(new ModelReviewerClass("Good place for children, plenty variety of street food","Sabrina"));
        listReviewer.add(new ModelReviewerClass("No Place like home","David"));
        listReviewer.add(new ModelReviewerClass("So comfortable, sleep under the star","Yuna"));
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        gMap = googleMap;
        LatLng sydney = new LatLng(Double.valueOf(getDetailTempatTerdekat.get(5)),Double.valueOf(getDetailTempatTerdekat.get(4)));
        gMap.addMarker(new MarkerOptions().position(sydney).title(String.valueOf(getDetailTempatTerdekat.get(5)) +", "+ String.valueOf(getDetailTempatTerdekat.get(4)) +", "+ getDetailTempatTerdekat.get(0)));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        gMap.animateCamera(CameraUpdateFactory.zoomTo(17f));

        Log.d(" Isi Longitude ", getDetailTempatTerdekat.get(5));
        Log.d(" Isi Latitude ", getDetailTempatTerdekat.get(4));

    }
}
