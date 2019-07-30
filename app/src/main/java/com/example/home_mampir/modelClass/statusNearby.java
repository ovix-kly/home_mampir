package com.example.home_mampir.modelClass;

import com.example.home_mampir.modelClass.ModelTempatTerdekat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class statusNearby {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("result")
        @Expose
        private ArrayList<ModelTempatTerdekat> result = null;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<ModelTempatTerdekat> getAllNearbyPlace() {
            return result;
        }

        public void setResult(ArrayList<ModelTempatTerdekat> result) {
            this.result = result;
        }

}
