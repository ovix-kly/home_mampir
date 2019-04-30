package com.example.home_mampir;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class PageDetailActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    ReviewAdapter reviewAdapter;
    RecyclerView rvReview;
    ArrayList<ModelReviewerClass> listReviewer;
    LinearLayout view;
    boolean opened;
    Button btnReview;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_detail_location);

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
        LatLng sydney = new LatLng(-6.1894318, 106.8336546);
        gMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        gMap.addMarker(new MarkerOptions().position(sydney).title("Anda Disini!"));
        gMap.animateCamera(CameraUpdateFactory.zoomTo(17f));

    }
}
