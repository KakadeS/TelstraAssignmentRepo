package com.example.sayalikakade.telstraassignmenttask.model;

import java.util.ArrayList;

public class CountryListModel {
//    @SerializedName("rows")
    public String title;
    private ArrayList<CountryModel> rows;

    public ArrayList<CountryModel> getRows() {
        return rows;
    }

    public void setRows(ArrayList<CountryModel> rows) {
        this.rows = rows;
    }
}
