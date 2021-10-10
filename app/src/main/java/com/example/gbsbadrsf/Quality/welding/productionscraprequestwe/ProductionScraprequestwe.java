package com.example.gbsbadrsf.Quality.welding.productionscraprequestwe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentProductionScraprequestweBinding;
import com.example.gbsbadrsf.databinding.FragmentProductionscraprequestqcBinding;


public class ProductionScraprequestwe extends Fragment {

   FragmentProductionScraprequestweBinding fragmentProductionScraprequestweBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProductionScraprequestweBinding = FragmentProductionScraprequestweBinding.inflate(inflater,container,false);
        return fragmentProductionScraprequestweBinding.getRoot();
    }
}