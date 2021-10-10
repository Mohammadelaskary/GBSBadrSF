package com.example.gbsbadrsf.Quality.welding.qcrepairwe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.Quality.paint.qualityrepairpaint.qualityrepairpaintAdapter;
import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentQcrepairweBinding;
import com.example.gbsbadrsf.databinding.FragmentQualityrepairpaintBinding;
import com.example.gbsbadrsf.productionsequence.SimpleDividerItemDecoration;


public class Qcrepairwe extends Fragment {
FragmentQcrepairweBinding fragmentQcrepairweBinding;
QcrepairweAdapter qcrepairweAdapter;
RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        fragmentQcrepairweBinding = FragmentQcrepairweBinding.inflate(inflater, container, false);
        initViews();
        recyclerView = fragmentQcrepairweBinding.defectqtnRv;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        return fragmentQcrepairweBinding.getRoot();

    }

    private void initViews() {
        qcrepairweAdapter = new QcrepairweAdapter();
        fragmentQcrepairweBinding.defectqtnRv.setAdapter(qcrepairweAdapter);
        fragmentQcrepairweBinding.defectqtnRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}