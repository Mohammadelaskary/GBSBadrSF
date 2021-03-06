package com.example.gbsbadrsf.Manfacturing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentMainmenuBinding;
import com.example.gbsbadrsf.databinding.FragmentManfacturingmenuBinding;

public class ManfacturingmenuFragment extends Fragment {
    FragmentManfacturingmenuBinding fragmentManfacturingmenuBinding;

    public ManfacturingmenuFragment() {
        // Required empty public constructor
    }


    public static ManfacturingmenuFragment newInstance(String param1, String param2) {
        ManfacturingmenuFragment fragment = new ManfacturingmenuFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentManfacturingmenuBinding = FragmentManfacturingmenuBinding.inflate(inflater,container,false);
        attachListeners();
        return fragmentManfacturingmenuBinding.getRoot();

    }

    private void attachListeners() {
        fragmentManfacturingmenuBinding.machineloadingBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingmenuFragment_to_mainmachineloading);

        });
        fragmentManfacturingmenuBinding.machinesignoffBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingmenuFragment_to_mainmachinesignoff);

        });
//        fragmentManfacturingmenuBinding.scraprequestBtn.setOnClickListener(__ -> {
//
//            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingmenuFragment_to_productionscrapFragment);
//
//        });
//        fragmentManfacturingmenuBinding.qualityscraprequest.setOnClickListener(__ -> {
//
//            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingmenuFragment_to_qualityscraplistFragment);
//
//        });
        fragmentManfacturingmenuBinding.productionrepairBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_manufacturing_menu_fragment_to_production_repair_fragment);

        });
//        fragmentManfacturingmenuBinding.baskettransferBtn.setOnClickListener(__ -> {
//
//            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingmenuFragment_to_baskettransferFragment);
//
//        });
        fragmentManfacturingmenuBinding.scraprmanagmentBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingmenuFragment_to_mainScrapmanagment);

        });






    }
}