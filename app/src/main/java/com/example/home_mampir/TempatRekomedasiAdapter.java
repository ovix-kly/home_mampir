package com.example.home_mampir;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TempatRekomedasiAdapter extends RecyclerView.Adapter<TempatRekomedasiAdapter.TempatRekomedasiViewHolder> {


    private ArrayList<ModelTempatRekomendasi> dataList;

    public TempatRekomedasiAdapter(ArrayList<ModelTempatRekomendasi> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public TempatRekomedasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewTempatRekomendasi = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_recomended_place,parent,false);
        return new TempatRekomedasiViewHolder(viewTempatRekomendasi);
    }

    @Override
    public void onBindViewHolder(@NonNull TempatRekomedasiViewHolder holder, int position) {
        holder.namaLokasi.setText(dataList.get(position).getNamaLokasi());
        holder.jenisLokasi.setText(dataList.get(position).getJenisLokasi());
        holder.jmlPengunjung.setText(dataList.get(position).getJmlPengunjung());
        holder.ratingLokasi.setText(dataList.get(position).getRatingLokasi());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }



    public class TempatRekomedasiViewHolder extends RecyclerView.ViewHolder {
        TextView namaLokasi;
        TextView jenisLokasi;
        TextView jmlPengunjung;
        TextView ratingLokasi;


        public TempatRekomedasiViewHolder(@NonNull View itemView) {
            super(itemView);
            namaLokasi = (TextView)itemView.findViewById(R.id.namaLokasi);
            jenisLokasi = (TextView)itemView.findViewById(R.id.jenisLokasi);
            jmlPengunjung = (TextView)itemView.findViewById(R.id.jmlPengunjung);
            ratingLokasi = (TextView)itemView.findViewById(R.id.ratingLokasi);

        }
    }


}
