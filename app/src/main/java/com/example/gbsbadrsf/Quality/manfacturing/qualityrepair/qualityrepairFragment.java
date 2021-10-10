package com.example.gbsbadrsf.Quality.manfacturing.qualityrepair;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.Production.ProductionrepairAdapter;
import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentProductionrepairBinding;
import com.example.gbsbadrsf.databinding.FragmentQualityrepairBinding;
import com.example.gbsbadrsf.productionsequence.SimpleDividerItemDecoration;


public class qualityrepairFragment extends Fragment {
    FragmentQualityrepairBinding qualityrepairBinding;
    qualityrepairAdapter qualityrepairAdapter;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        qualityrepairBinding = FragmentQualityrepairBinding.inflate(inflater, container, false);
        initViews();
        recyclerView = qualityrepairBinding.defectqtnRv;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        return qualityrepairBinding.getRoot();

    }

    private void initViews() {
        qualityrepairAdapter = new qualityrepairAdapter();
        qualityrepairBinding.defectqtnRv.setAdapter(qualityrepairAdapter);
        qualityrepairBinding.defectqtnRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}