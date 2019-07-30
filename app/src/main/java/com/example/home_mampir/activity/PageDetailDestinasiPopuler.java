package com.example.home_mampir.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.home_mampir.R;
import com.example.home_mampir.adapter.TempatTerdekatDestinasiAdapter;
import com.example.home_mampir.adapter.TopDestinasiPopulerAdapter;
import com.example.home_mampir.modelClass.ModelTempatTerdekat;
import com.example.home_mampir.modelClass.ModelTempatTerdekatDestinasi;

import java.util.ArrayList;

public class PageDetailDestinasiPopuler extends AppCompatActivity {

    ArrayList<ModelTempatTerdekatDestinasi> listTempatTerdekatDestinasi;
    ArrayList<ModelTempatTerdekat> listTopTenTempat;
    RecyclerView rvNearbyDestinationPopuler,rvTopTenPopular;
    TempatTerdekatDestinasiAdapter tempatTerdekatDestinasiAdapter;
    com.example.home_mampir.adapter.TopDestinasiPopulerAdapter TopDestinasiPopulerAdapter;

    @Override
    public void onCreate(Bundle saveInstance){
        super.onCreate(saveInstance);
        setContentView(R.layout.page_detail_destinasi_favorit);

        //addDataTempatTerdekatDestinasi();
        //addDataTopTen();

        rvTopTenPopular = (RecyclerView)findViewById(R.id.top_destination);
        rvNearbyDestinationPopuler = (RecyclerView)findViewById(R.id.popular_destination);


        TopDestinasiPopulerAdapter = new TopDestinasiPopulerAdapter(listTopTenTempat);
        tempatTerdekatDestinasiAdapter = new TempatTerdekatDestinasiAdapter(listTempatTerdekatDestinasi);

        RecyclerView.LayoutManager layoutManagerTopTen = new LinearLayoutManager(PageDetailDestinasiPopuler.this, LinearLayoutManager.VERTICAL, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PageDetailDestinasiPopuler.this,LinearLayoutManager.HORIZONTAL,false);


        rvTopTenPopular.setLayoutManager(layoutManagerTopTen);
        rvTopTenPopular.setAdapter(TopDestinasiPopulerAdapter);

        rvNearbyDestinationPopuler.setLayoutManager(layoutManager);
        rvNearbyDestinationPopuler.setAdapter(tempatTerdekatDestinasiAdapter);



    }


   /* public void addDataTempatTerdekatDestinasi(){

        listTempatTerdekatDestinasi = new ArrayList<>();
        listTempatTerdekatDestinasi.add(new ModelTempatTerdekatDestinasi("Ragunan","Wisata","2100","45"));
        listTempatTerdekatDestinasi.add(new ModelTempatTerdekatDestinasi("Es Krim 201","Kuliner","2100","45"));
        listTempatTerdekatDestinasi.add(new ModelTempatTerdekatDestinasi("Kota Tua","Wisata","2100","45"));
        listTempatTerdekatDestinasi.add(new ModelTempatTerdekatDestinasi("Ancol","Wisata","2100","45"));
        listTempatTerdekatDestinasi.add(new ModelTempatTerdekatDestinasi("Ragunan","Wisata","2100","45"));
        listTempatTerdekatDestinasi.add(new ModelTempatTerdekatDestinasi("Es Krim 201","Kuliner","2100","45"));
        listTempatTerdekatDestinasi.add(new ModelTempatTerdekatDestinasi("Kota Tua","Wisata","2100","45"));
        listTempatTerdekatDestinasi.add(new ModelTempatTerdekatDestinasi("Ancol","Wisata","2100","45"));
        Log.d("isi dari array Tempat Terdekat Destinasi ",String.valueOf(listTempatTerdekatDestinasi.size()));
    }



   public void addDataTopTen(){

        listTopTenTempat = new ArrayList<>();
        listTopTenTempat.add(new ModelTempatTerdekat("Ragunan","Wisata","2100","45"));
        listTopTenTempat.add(new ModelTempatTerdekat("Es Krim 201","Kuliner","2100","45"));
        listTopTenTempat.add(new ModelTempatTerdekat("Kota Tua","Wisata","2100","45"));
        listTopTenTempat.add(new ModelTempatTerdekat("Ancol","Wisata","2100","45"));
        listTopTenTempat.add(new ModelTempatTerdekat("Ragunan","Wisata","2100","45"));
        listTopTenTempat.add(new ModelTempatTerdekat("Es Krim 201","Kuliner","2100","45"));
        listTopTenTempat.add(new ModelTempatTerdekat("Kota Tua","Wisata","2100","45"));
        listTopTenTempat.add(new ModelTempatTerdekat("Ancol","Wisata","2100","45"));
    }
    */
}
