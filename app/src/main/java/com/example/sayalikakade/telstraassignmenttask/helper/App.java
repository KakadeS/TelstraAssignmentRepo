package com.example.sayalikakade.telstraassignmenttask.helper;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.example.sayalikakade.telstraassignmenttask.databinding.AppDataBindingComponent;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }
}
