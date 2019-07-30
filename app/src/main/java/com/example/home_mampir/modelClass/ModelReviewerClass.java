package com.example.home_mampir.modelClass;

public class ModelReviewerClass {

    String isiReview,namaReviewer;

    public ModelReviewerClass(String isiReview,String namaReviewer){
        this.isiReview = isiReview;
        this.namaReviewer = namaReviewer;
    }

    public void setIsiReview(String isiReview){
        this.isiReview = isiReview;
    }

    public void setNamaReview(String namaReviewer){
        this.namaReviewer = namaReviewer;
    }

    public String getIsiReview(){
        return isiReview;
    }

    public String getNamaReviewer(){
        return namaReviewer;
    }

}
