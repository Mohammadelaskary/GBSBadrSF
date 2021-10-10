package com.example.gbsbadrsf.Quality.paint.qcdesicionpaint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.Quality.manfacturing.qualitydesicion.qualitydesicionAdapter;
import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentQualitydesicionBinding;
import com.example.gbsbadrsf.databinding.FragmentQualitydesicionpaintBinding;
import com.example.gbsbadrsf.productionsequence.SimpleDividerItemDecoration;


public class qualitydesicionpaintFragment extends Fragment {
    FragmentQualitydesicionpaintBinding fragmentQualitydesicionpaintBinding;
   qcdesicionpaintAdapter qcdesicionpaintAdapter;
   RecyclerView recyclerView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentQualitydesicionpaintBinding = FragmentQualitydesicionpaintBinding.inflate(inflater, container, false);
        initViews();
        recyclerView = fragmentQualitydesicionpaintBinding.defectqtnRv;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        return fragmentQualitydesicionpaintBinding.getRoot();

    }

    private void initViews() {
        qcdesicionpaintAdapter = new qcdesicionpaintAdapter();
        fragmentQualitydesicionpaintBinding.defectqtnRv.setAdapter(qcdesicionpaintAdapter);
        fragmentQualitydesicionpaintBinding.defectqtnRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}