package com.example.sayalikakade.telstraassignmenttask.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.example.sayalikakade.telstraassignmenttask.BR;
import com.example.sayalikakade.telstraassignmenttask.adapter.DataAdapter;
import com.example.sayalikakade.telstraassignmenttask.helper.ApiInterface;
import com.example.sayalikakade.telstraassignmenttask.helper.RetrofitClass;
import com.example.sayalikakade.telstraassignmenttask.model.CountryListModel;
import com.example.sayalikakade.telstraassignmenttask.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataViewModel extends BaseObservable {
    private static final String TAG = "DataViewModel";
    private DataAdapter adapter;
    private List<CountryModel> data;

    public DataViewModel() {
        data = new ArrayList<CountryModel>();
        adapter = new DataAdapter();
    }

    public void setUp() {
        // perform set up tasks, such as adding listeners, data population, etc.
        populateData();
    }


    @Bindable
    public List<CountryModel> getData() {
        return this.data;
    }

    @Bindable
    public DataAdapter getAdapter() {
        return this.adapter;
    }

    private void populateData() {
        // populate the data from the source, such as the database.
              Log.d("inside","populate");
        ApiInterface api = RetrofitClass.getRetrofitObject().create(ApiInterface.class);
        Call<CountryListModel> call = api.getCountryDetails();
        call.enqueue(new Callback<CountryListModel>() {
            @Override
            public void onResponse(Call<CountryListModel> call, Response<CountryListModel> response) {
                Log.d("response=", String.valueOf(response.body()));
                data= filterDataList(response.body().getRows());
              //  data = response.body().getRows();
            }

            @Override
            public void onFailure(Call<CountryListModel> call, Throwable t) {
                Log.d("error=", String.valueOf(t));
            }
        });
        notifyPropertyChanged(BR.data);
    }
    public ArrayList<CountryModel> filterDataList(ArrayList<CountryModel> filterList){
        if (filterList != null) {
            for (int i = 0; i < filterList.size(); i++) {
                CountryModel dataModel = filterList.get(i);
                if (dataModel.getTitle() == null && dataModel.getDescription() == null && dataModel.getImageHref() == null){
                    filterList.remove(dataModel);
                }else if(dataModel.getDescription()==null){
                    dataModel.setDescription("Description does not appear");
                }
            }
        }
        return filterList;
    }
}
