package com.example.home_mampir;

public class ModelTempatTerdekat {

    String namaLokasi;
    String jenisLokasi;
    String jmlPengunjung;
    String ratingLokasi;

    public ModelTempatTerdekat(String namaLokasi, String jenisLokasi, String jmlPengunjung, String ratingLokasi){
        this.namaLokasi = namaLokasi;
        this.jenisLokasi = jenisLokasi;
        this.jmlPengunjung = jmlPengunjung;
        this.ratingLokasi = ratingLokasi;
    }

    public void setNamaLokasi(String namaLokasi){
        this.namaLokasi = namaLokasi;
    }

    public void setJenisLokasi(String jenisLokasi){
        this.jenisLokasi = jenisLokasi;
    }

    public void setJmlPengunjung(String jmlPengunjung){
        this.jmlPengunjung = jmlPengunjung;
    }

    public void setRatingLokasi(String ratingLokasi){
        this.ratingLokasi = ratingLokasi;
    }

    public String getNamaLokasi(){
        return namaLokasi;
    }

    public String getJenisLokasi(){
        return jenisLokasi;
    }

    public String getRatingLokasi(){
        return ratingLokasi;
    }

    public String getJmlPengunjung(){
        return jmlPengunjung;
    }


}
