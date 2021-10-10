package com.example.gbsbadrsf.Quality.paint.qualityrepairpaint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.Quality.manfacturing.qualityrepair.qualityrepairAdapter;
import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentQualityrepairBinding;
import com.example.gbsbadrsf.databinding.FragmentQualityrepairpaintBinding;
import com.example.gbsbadrsf.productionsequence.SimpleDividerItemDecoration;

public class qualityrepairpaintFragment extends Fragment {

    FragmentQualityrepairpaintBinding qualityrepairpaintBinding;
     qualityrepairpaintAdapter qualityrepairpaintAdapter;
     RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        qualityrepairpaintBinding = FragmentQualityrepairpaintBinding.inflate(inflater, container, false);
        initViews();
        recyclerView = qualityrepairpaintBinding.defectqtnRv;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        return qualityrepairpaintBinding.getRoot();

    }

    private void initViews() {
        qualityrepairpaintAdapter = new qualityrepairpaintAdapter();
        qualityrepairpaintBinding.defectqtnRv.setAdapter(qualityrepairpaintAdapter);
        qualityrepairpaintBinding.defectqtnRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}