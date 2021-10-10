package com.example.gbsbadrsf.Quality.manfacturing.qualitydesicion;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.Quality.manfacturing.qualityrepair.qualityrepairAdapter;
import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentQualitydesicionBinding;
import com.example.gbsbadrsf.databinding.FragmentQualityrepairBinding;
import com.example.gbsbadrsf.productionsequence.SimpleDividerItemDecoration;


public class qualitydesicionFragment extends Fragment {
FragmentQualitydesicionBinding fragmentQualitydesicionBinding;
qualitydesicionAdapter qualitydesicionAdapter;
RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentQualitydesicionBinding = fragmentQualitydesicionBinding.inflate(inflater, container, false);
        initViews();
        recyclerView = fragmentQualitydesicionBinding.defectqtnRv;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        return fragmentQualitydesicionBinding.getRoot();

    }

    private void initViews() {
        qualitydesicionAdapter = new qualitydesicionAdapter();
        fragmentQualitydesicionBinding.defectqtnRv.setAdapter(qualitydesicionAdapter);
        fragmentQualitydesicionBinding.defectqtnRv.setLayoutManager(new LinearLayoutManager(getContext()));
       // fragmentQualitydesicionBinding.saveBtn.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   if (fragmentQualitydesicionBinding.scrapCheckBox.isChecked()){
               //     Navigation.findNavController(getView()).navigate(R.id.action_qualitydesicionFragment_to_scrapFragment);


                //}

        //}
        //});
        }
}