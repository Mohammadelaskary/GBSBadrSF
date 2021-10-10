package com.example.gbsbadrsf.productionsequence;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentProductionSequenceBinding;
import com.example.gbsbadrsf.databinding.FragmentProductionrepstatusBinding;
import com.example.gbsbadrsf.productionrepairstaus.ProductionrepstatusAdapter;


public class ProductionSequence extends Fragment {
    FragmentProductionSequenceBinding fragmentProductionSequenceBinding;
    productionsequenceadapter productionsequenceadapter;
    public RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProductionSequenceBinding = FragmentProductionSequenceBinding.inflate(inflater, container, false);
        initViews();
        attachListeners();
        recyclerView = fragmentProductionSequenceBinding.defectqtnRv;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));


        return fragmentProductionSequenceBinding.getRoot();

    }



    private void initViews() {
        productionsequenceadapter = new productionsequenceadapter();
        fragmentProductionSequenceBinding.defectqtnRv.setAdapter(productionsequenceadapter);
        fragmentProductionSequenceBinding.defectqtnRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    private void attachListeners() {
        fragmentProductionSequenceBinding.newloadingBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_productionSequence_to_machineLoadingFragment);

        });

    }


}