package com.example.home_mampir.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home_mampir.modelClass.ModelTempatRekomendasi;
import com.example.home_mampir.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TempatRekomedasiAdapter extends RecyclerView.Adapter<TempatRekomedasiAdapter.TempatRekomedasiViewHolder> {


    public String StaticURLImg = "https://mampir.id/uploads/";
    private ArrayList<String> detailTempatTerdekat;
    private List<ModelTempatRekomendasi> mTempatRekomendasi;

    public TempatRekomedasiAdapter(List<ModelTempatRekomendasi> dataList){
        this.mTempatRekomendasi = dataList;
    }

    @NonNull
    @Override
    public TempatRekomedasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewTempatRekomendasi = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_recomended_place,parent,false);
        return new TempatRekomedasiViewHolder(viewTempatRekomendasi);
    }

    @Override
    public void onBindViewHolder(@NonNull TempatRekomedasiViewHolder holder, int position) {

        String imgUrl = mTempatRekomendasi.get(position).getThumbnailLandscape();
        String fixImgUrl = StaticURLImg + imgUrl;

        Picasso.get().load(fixImgUrl).resize(450, 80)
                .centerCrop().into(holder.bgRekomendasiTempat);


        holder.namaLokasi.setText(mTempatRekomendasi.get(position).getName());
        holder.jenisLokasi.setText(mTempatRekomendasi.get(position).getCategory().getName());
        holder.jmlPengunjung.setText("2022");
        holder.ratingLokasi.setText("104");
    }

    @Override
    public int getItemCount() {
        return (mTempatRekomendasi != null) ? mTempatRekomendasi.size() : 0;
    }



    public class TempatRekomedasiViewHolder extends RecyclerView.ViewHolder {
        TextView namaLokasi;
        TextView jenisLokasi;
        TextView jmlPengunjung;
        TextView ratingLokasi;
        ImageView bgRekomendasiTempat;


        public TempatRekomedasiViewHolder(@NonNull View itemView) {
            super(itemView);
            namaLokasi = (TextView)itemView.findViewById(R.id.namaLokasi);
            jenisLokasi = (TextView)itemView.findViewById(R.id.jenisLokasi);
            jmlPengunjung = (TextView)itemView.findViewById(R.id.jmlPengunjung);
            ratingLokasi = (TextView)itemView.findViewById(R.id.ratingLokasi);
            bgRekomendasiTempat = (ImageView)itemView.findViewById(R.id.bgRekomendasi);

        }
    }


}
