package com.example.chloe.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPlants {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<Plants> listDataPlants;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Plants> getListDataPlants() {
        return listDataPlants;
    }

    public void setListDataPlants(List<Plants> listDataPlants) {
        this.listDataPlants = listDataPlants;
    }
}
