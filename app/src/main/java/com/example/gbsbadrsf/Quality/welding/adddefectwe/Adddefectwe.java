package com.example.gbsbadrsf.Quality.welding.adddefectwe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.AdddefectweCustomdialog;
import com.example.gbsbadrsf.databinding.FragmentWeldingAddDeffectsBinding;


public class Adddefectwe extends Fragment {

    FragmentWeldingAddDeffectsBinding binding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWeldingAddDeffectsBinding.inflate(inflater, container, false);
        initViews();

        return binding.getRoot();

    }

    private void initViews() {
        binding.plusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdddefectweCustomdialog mycustomDialog=new AdddefectweCustomdialog();
                mycustomDialog.show(getChildFragmentManager(),"MycustomDialog");
            }
        });

    }
}