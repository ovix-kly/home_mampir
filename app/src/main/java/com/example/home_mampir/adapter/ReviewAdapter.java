package com.example.home_mampir.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.home_mampir.modelClass.ModelReviewerClass;
import com.example.home_mampir.R;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private ArrayList<ModelReviewerClass> dataList;

    public ReviewAdapter(ArrayList<ModelReviewerClass> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewReview = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_reviews,parent,false);
        return new ReviewViewHolder(viewReview);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        holder.isiReview.setText(dataList.get(position).getIsiReview());
        holder.namaReview.setText(dataList.get(position).getNamaReviewer());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {

        TextView isiReview,namaReview;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            isiReview = (TextView)itemView.findViewById(R.id.isi_reviewer);
            namaReview = (TextView)itemView.findViewById(R.id.nama_reviewer);
        }
    }
}
