package com.example.home_mampir.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home_mampir.modelClass.ModelTempatTerdekat;
import com.example.home_mampir.activity.PageDetailActivity;
import com.example.home_mampir.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TempatTerdekatAdapter extends RecyclerView.Adapter<TempatTerdekatAdapter.TempatTerdekatViewHolder> implements RecyclerView.OnClickListener {

    private List<ModelTempatTerdekat> mDataTempatTerdekat;
    public String StaticURLImg = "https://mampir.id/uploads/";
    private ArrayList<String> detailTempatTerdekat;


    public TempatTerdekatAdapter(List<ModelTempatTerdekat> mDataTerdekatList){
        this. mDataTempatTerdekat = mDataTerdekatList;
    }


    @NonNull
    @Override
    public TempatTerdekatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewTempatTerdekat = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_nearby_place,parent,false);
        return new TempatTerdekatViewHolder(viewTempatTerdekat);
    }

    @Override
    public void onBindViewHolder(@NonNull TempatTerdekatViewHolder holder, final int position) {

        holder.namaLokasi.setText(mDataTempatTerdekat.get(position).getName());
        holder.jenisLokasi.setText(mDataTempatTerdekat.get(position).getCategory().getName());

        String imgUrl = mDataTempatTerdekat.get(position).getThumbnailPotrait();
        String fixImgUrl = StaticURLImg + imgUrl;




        Picasso.get().load(fixImgUrl).resize(80, 80)
                .centerCrop().into(holder.imgLokasi);


        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*for(int i=0;i<detailTempatTerdekat.size();i++){
                    Log.d(" Isi Detail Lokasi ", String.valueOf(detailTempatTerdekat.get(i)));
                }*/


                    Log.d(" Isi Detail Lokasi ", String.valueOf(mDataTempatTerdekat.get(position).getName()));

                        detailTempatTerdekat = new ArrayList<String>(Arrays.asList(
                        mDataTempatTerdekat.get(position).getName(),
                        mDataTempatTerdekat.get(position).getCategory().getName(),
                        mDataTempatTerdekat.get(position).getThumbnailLandscape(),
                        mDataTempatTerdekat.get(position).getAddress(),
                        mDataTempatTerdekat.get(position).getLatitude(),
                        mDataTempatTerdekat.get(position).getLongitute()));


                Context mContext = view.getContext();
                Intent intent = new Intent(mContext, PageDetailActivity.class);
                intent.putStringArrayListExtra("detailTempatTerdekat",detailTempatTerdekat);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (mDataTempatTerdekat != null) ? mDataTempatTerdekat.size() : 0;
    }

    @Override
    public void onClick(View view) {

    }

    public class TempatTerdekatViewHolder extends RecyclerView.ViewHolder{
        TextView namaLokasi;
        TextView jenisLokasi;
        TextView jmlPengunjung;
        TextView ratingLokasi;
        ImageView imgLokasi;
        Button mButton;

        public TempatTerdekatViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLokasi = (ImageView)itemView.findViewById(R.id.imageLokasi);
            namaLokasi = (TextView)itemView.findViewById(R.id.namaLokasi);
            jenisLokasi = (TextView)itemView.findViewById(R.id.jenisLokasi);
            jmlPengunjung = (TextView)itemView.findViewById(R.id.jmlPengunjung);
            ratingLokasi = (TextView)itemView.findViewById(R.id.ratingLokasi);
            mButton = (Button)itemView.findViewById(R.id.buttonNearby);
        }
    }


}
