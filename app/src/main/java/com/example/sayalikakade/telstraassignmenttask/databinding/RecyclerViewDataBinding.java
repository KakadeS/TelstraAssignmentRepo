package com.example.sayalikakade.telstraassignmenttask.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.sayalikakade.telstraassignmenttask.adapter.DataAdapter;
import com.example.sayalikakade.telstraassignmenttask.model.CountryModel;

import java.util.List;

public class RecyclerViewDataBinding {
    /**
     * Binds the data to the {@link RecyclerView.Adapter}, sets the
     * recycler view on the adapter, and performs some other recycler view initialization.
     *
     * @param recyclerView passed in automatically with the data binding
     * @param adapter      must be explicitly passed in
     * @param data         must be explicitly passed in
     */
    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, DataAdapter adapter, List<CountryModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }
}
