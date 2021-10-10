package com.example.gbsbadrsf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.databinding.FragmentProductionSequenceBinding;
import com.example.gbsbadrsf.databinding.FragmentWeldingSequenceBinding;
import com.example.gbsbadrsf.productionsequence.SimpleDividerItemDecoration;
import com.example.gbsbadrsf.productionsequence.productionsequenceadapter;


public class WeldingSequence extends Fragment {
    FragmentWeldingSequenceBinding fragmentWeldingSequenceBinding;
    productionsequenceadapter productionsequenceadapter;
    public RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentWeldingSequenceBinding = FragmentWeldingSequenceBinding.inflate(inflater, container, false);
        initViews();
        attachListeners();
        recyclerView = fragmentWeldingSequenceBinding.defectqtnRv;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));


        return fragmentWeldingSequenceBinding.getRoot();

    }


    private void initViews() {
        productionsequenceadapter = new productionsequenceadapter();
        fragmentWeldingSequenceBinding.defectqtnRv.setAdapter(productionsequenceadapter);
        fragmentWeldingSequenceBinding.defectqtnRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void attachListeners() {
        fragmentWeldingSequenceBinding.qtnokBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_weldingSequence_to_machineloadingweFragment);

        });

    }
}

