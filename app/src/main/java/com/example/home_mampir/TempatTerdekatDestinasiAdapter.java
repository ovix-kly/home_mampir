package com.example.home_mampir;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TempatTerdekatDestinasiAdapter extends RecyclerView.Adapter<TempatTerdekatDestinasiAdapter.TempatTerdekatDestinasiViewHolder> {

    private ArrayList<ModelTempatTerdekatDestinasi> dataList;

    public TempatTerdekatDestinasiAdapter(ArrayList<ModelTempatTerdekatDestinasi> dataList){
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public TempatTerdekatDestinasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutViewDestinasiTerdekat = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_destinasi_populer_detail_carousel,parent,false);
        return new TempatTerdekatDestinasiViewHolder(layoutViewDestinasiTerdekat);
    }

    @Override
    public void onBindViewHolder(@NonNull TempatTerdekatDestinasiViewHolder holder, int position) {
        holder.namaLokasi.setText(dataList.get(position).getNamaLokasi());
        holder.jenisLokasi.setText(dataList.get(position).getJenisLokasi());
        holder.jmlPengunjung.setText(dataList.get(position).getJmlPengunjung());
        holder.ratingLokasi.setText(dataList.get(position).getRatingLokasi());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class TempatTerdekatDestinasiViewHolder extends RecyclerView.ViewHolder{
        TextView namaLokasi;
        TextView jenisLokasi;
        TextView jmlPengunjung;
        TextView ratingLokasi;

        public TempatTerdekatDestinasiViewHolder (@NonNull View view){
            super(view);
            namaLokasi = (TextView)view.findViewById(R.id.namaLokasi);
            jenisLokasi = (TextView)view.findViewById(R.id.jenisLokasi);
            jmlPengunjung = (TextView)view.findViewById(R.id.jmlPengunjung);
            ratingLokasi = (TextView)view.findViewById(R.id.ratingLokasi);
        }
    }
}
