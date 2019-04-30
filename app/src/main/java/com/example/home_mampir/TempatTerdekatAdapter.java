package com.example.home_mampir;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TempatTerdekatAdapter extends RecyclerView.Adapter<TempatTerdekatAdapter.TempatTerdekatViewHolder> {

    private ArrayList<ModelTempatTerdekat> dataList;

    public TempatTerdekatAdapter(ArrayList<ModelTempatTerdekat> dataList){
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public TempatTerdekatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewTempatTerdekat = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_nearby_place,parent,false);
        return new TempatTerdekatViewHolder(viewTempatTerdekat);
    }

    @Override
    public void onBindViewHolder(@NonNull TempatTerdekatViewHolder holder, int position) {

        holder.namaLokasi.setText(dataList.get(position).getNamaLokasi());
        holder.jenisLokasi.setText(dataList.get(position).getJenisLokasi());
        holder.jmlPengunjung.setText(dataList.get(position).getJmlPengunjung());
        holder.ratingLokasi.setText(dataList.get(position).getRatingLokasi());

        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context mContext = view.getContext();
                Intent intent = new Intent(mContext, PageDetailActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class TempatTerdekatViewHolder extends RecyclerView.ViewHolder {
        TextView namaLokasi;
        TextView jenisLokasi;
        TextView jmlPengunjung;
        TextView ratingLokasi;
        Button mButton;

        public TempatTerdekatViewHolder(@NonNull View itemView) {
            super(itemView);
            namaLokasi = (TextView)itemView.findViewById(R.id.namaLokasi);
            jenisLokasi = (TextView)itemView.findViewById(R.id.jenisLokasi);
            jmlPengunjung = (TextView)itemView.findViewById(R.id.jmlPengunjung);
            ratingLokasi = (TextView)itemView.findViewById(R.id.ratingLokasi);
            mButton = (Button)itemView.findViewById(R.id.buttonNearby);
        }
    }


}
