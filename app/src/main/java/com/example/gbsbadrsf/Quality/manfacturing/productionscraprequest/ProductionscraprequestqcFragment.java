package com.example.gbsbadrsf.Quality.manfacturing.productionscraprequest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.Reopendefects.ReopendefectsAdapter;
import com.example.gbsbadrsf.databinding.FragmentProductionMenuBinding;
import com.example.gbsbadrsf.databinding.FragmentProductionscraprequestqcBinding;
import com.example.gbsbadrsf.databinding.FragmentReopenDefectBinding;
import com.example.gbsbadrsf.databinding.FragmentScraprequestBinding;


public class ProductionscraprequestqcFragment extends Fragment {
    FragmentProductionscraprequestqcBinding fragmentProductionscraprequestqcBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProductionscraprequestqcBinding = FragmentProductionscraprequestqcBinding.inflate(inflater,container,false);
        return fragmentProductionscraprequestqcBinding.getRoot();
    }


}