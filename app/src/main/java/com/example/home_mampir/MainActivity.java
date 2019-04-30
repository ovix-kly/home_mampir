package com.example.home_mampir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvNearby,rvRecomendation,rvArtikel;
    TempatTerdekatAdapter tempatTerdekatAdapter;
    TempatRekomedasiAdapter tempatRekomendasiAdapter;
    ArtikelAdapter artikelAdapter;
    ArrayList<ModelTempatTerdekat> listTempatTerdekat;
    ArrayList<ModelTempatRekomendasi> listTempatRekomendasi;
    ArrayList<ModelArtikel> listArtikel;
    ImageView btnViewAllDestinationPopuler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDataTempatTerdekat();
        addDataTempatRekomendasi();
        addDataArtikel();


        rvNearby = (RecyclerView)findViewById(R.id.rv_nearby);
        rvRecomendation = (RecyclerView)findViewById(R.id.rv_recomendation);
        rvArtikel = (RecyclerView)findViewById(R.id.rv_artikel);

        tempatRekomendasiAdapter = new TempatRekomedasiAdapter(listTempatRekomendasi);
        tempatTerdekatAdapter = new TempatTerdekatAdapter(listTempatTerdekat);
        artikelAdapter = new ArtikelAdapter(listArtikel);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);

        rvNearby.setLayoutManager(layoutManager);
        rvNearby.setAdapter(tempatTerdekatAdapter);

        rvRecomendation.setLayoutManager(layoutManager2);
        rvRecomendation.setAdapter(tempatRekomendasiAdapter);

        rvArtikel.setLayoutManager(layoutManager3);
        rvArtikel.setAdapter(artikelAdapter);

        SnapHelper snapHelperNearby = new LinearSnapHelper();
        SnapHelper snapHelperRecomended = new LinearSnapHelper();

        snapHelperNearby.attachToRecyclerView(rvNearby);
        snapHelperRecomended.attachToRecyclerView(rvRecomendation);

        btnViewAllDestinationPopuler = (ImageView)findViewById(R.id.viewAllDestinasiPopuler);

        btnViewAllDestinationPopuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Context mContext = getApplicationContext();
                Intent intent = new Intent(MainActivity.this, PageDetailDestinasiPopuler.class);
                startActivity(intent);
            }
        });



    }

    public void addDataTempatTerdekat(){
        listTempatTerdekat = new ArrayList<>();
        listTempatTerdekat.add(new ModelTempatTerdekat("Ragunan","Wisata","2100","45"));
        listTempatTerdekat.add(new ModelTempatTerdekat("Es Krim 201","Kuliner","2100","45"));
        listTempatTerdekat.add(new ModelTempatTerdekat("Kota Tua","Wisata","2100","45"));
        listTempatTerdekat.add(new ModelTempatTerdekat("Ancol","Wisata","2100","45"));
        listTempatTerdekat.add(new ModelTempatTerdekat("Ragunan","Wisata","2100","45"));
        listTempatTerdekat.add(new ModelTempatTerdekat("Es Krim 201","Kuliner","2100","45"));
        listTempatTerdekat.add(new ModelTempatTerdekat("Kota Tua","Wisata","2100","45"));
        listTempatTerdekat.add(new ModelTempatTerdekat("Ancol","Wisata","2100","45"));

    }

    public void addDataTempatRekomendasi(){
        listTempatRekomendasi = new ArrayList<>();
        listTempatRekomendasi.add(new ModelTempatRekomendasi("Ragunan","Wisata","2100","45"));
        listTempatRekomendasi.add(new ModelTempatRekomendasi("Es Krim 201","Kuliner","2100","45"));
        listTempatRekomendasi.add(new ModelTempatRekomendasi("Kota Tua","Wisata","2100","45"));
        listTempatRekomendasi.add(new ModelTempatRekomendasi("Ancol","Wisata","2100","45"));
        listTempatRekomendasi.add(new ModelTempatRekomendasi("Ragunan","Wisata","2100","45"));
        listTempatRekomendasi.add(new ModelTempatRekomendasi("Es Krim 201","Kuliner","2100","45"));

    }

    public void addDataArtikel(){
        listArtikel = new ArrayList<>();
        listArtikel.add(new ModelArtikel("36 Tempat & Destinasi Wisata Malang Paling Populer"));
        listArtikel.add(new ModelArtikel("36 Tempat & Destinasi Wisata Malang Paling Populer"));
        listArtikel.add(new ModelArtikel("36 Tempat & Destinasi Wisata Malang Paling Populer"));
        listArtikel.add(new ModelArtikel("36 Tempat & Destinasi Wisata Malang Paling Populer"));
        listArtikel.add(new ModelArtikel("36 Tempat & Destinasi Wisata Malang Paling Populer"));
    }
}
