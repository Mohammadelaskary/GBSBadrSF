package com.example.gbsbadrsf.Quality.manfacturing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentManfacturingmenuBinding;
import com.example.gbsbadrsf.databinding.FragmentManfacturingqualityBinding;


public class ManfacturingqualityFragment extends Fragment {
    FragmentManfacturingqualityBinding fragmentManfacturingqualityBinding;


    public ManfacturingqualityFragment() {
        // Required empty public constructor
    }


    public static ManfacturingqualityFragment newInstance(String param1, String param2) {
        ManfacturingqualityFragment fragment = new ManfacturingqualityFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentManfacturingqualityBinding = FragmentManfacturingqualityBinding.inflate(inflater,container,false);
        attachListeners();
        return fragmentManfacturingqualityBinding.getRoot();

    }

    private void attachListeners() {
        fragmentManfacturingqualityBinding.adddefectBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingqualityFragment_to_addDefectsFragment);

        });
        fragmentManfacturingqualityBinding.qualityrepairBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingqualityFragment_to_qualityrepairFragment);

        });
        fragmentManfacturingqualityBinding.qualitydesicionBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingqualityFragment_to_qualitydesicionFragment);

        });
        fragmentManfacturingqualityBinding.adddefectBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingqualityFragment_to_addDefectsFragment);

        });
        fragmentManfacturingqualityBinding.productionscraprequestBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingqualityFragment_to_productionscraplistinqualityFragment);

        });
        fragmentManfacturingqualityBinding.scraprequestBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_manfacturingqualityFragment_to_productionscrapFragment);

        });


    }
}