package com.example.home_mampir.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.home_mampir.modelClass.ModelArtikel;
import com.example.home_mampir.R;

import java.util.ArrayList;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder> {

    private ArrayList<ModelArtikel> dataList;

    public ArtikelAdapter(ArrayList<ModelArtikel> dataList){
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public ArtikelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewArtikel = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_artikel_video,parent,false);
        return new ArtikelViewHolder(viewArtikel);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelViewHolder holder, int position) {

        holder.judulArtikel.setText(dataList.get(position).getJudulArtikel());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ArtikelViewHolder extends RecyclerView.ViewHolder {
        TextView judulArtikel;

        public ArtikelViewHolder(@NonNull View itemView) {
            super(itemView);
            judulArtikel = (TextView)itemView.findViewById(R.id.judulArtikel);
        }
    }
}
