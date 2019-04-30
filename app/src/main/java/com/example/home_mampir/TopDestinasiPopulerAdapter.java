package com.example.home_mampir;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TopDestinasiPopulerAdapter extends RecyclerView.Adapter<TopDestinasiPopulerAdapter.TopDestinasiPopulerViewHolder> {

    public ArrayList<ModelTempatTerdekat> dataList;

    public TopDestinasiPopulerAdapter(ArrayList<ModelTempatTerdekat> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public TopDestinasiPopulerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View TopDestinasiPopuler = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_top_10,parent,false);
        return new TopDestinasiPopulerViewHolder(TopDestinasiPopuler);
    }

    @Override
    public void onBindViewHolder(@NonNull TopDestinasiPopulerViewHolder holder, int position) {
        holder.namaLokasi.setText(dataList.get(position).getNamaLokasi());
        holder.jenisLokasi.setText(dataList.get(position).getJenisLokasi());
        holder.jmlPengunjung.setText(dataList.get(position).getJmlPengunjung());
        holder.ratingLokasi.setText(dataList.get(position).getRatingLokasi());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class TopDestinasiPopulerViewHolder extends RecyclerView.ViewHolder{

        TextView namaLokasi;
        TextView jenisLokasi;
        TextView jmlPengunjung;
        TextView ratingLokasi;

        public TopDestinasiPopulerViewHolder(View itemView){
            super(itemView);
            namaLokasi = (TextView)itemView.findViewById(R.id.namaLokasi);
            jenisLokasi = (TextView)itemView.findViewById(R.id.jenisLokasi);
            jmlPengunjung = (TextView)itemView.findViewById(R.id.jmlPengunjung);
            ratingLokasi = (TextView)itemView.findViewById(R.id.ratingLokasi);

        }

    }
}
