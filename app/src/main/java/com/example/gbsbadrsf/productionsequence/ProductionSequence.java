package com.example.gbsbadrsf.productionsequence;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.Util.ViewModelProviderFactory;
import com.example.gbsbadrsf.data.response.Ppr;
import com.example.gbsbadrsf.databinding.FragmentProductionSequenceBinding;
import com.example.gbsbadrsf.databinding.FragmentProductionrepstatusBinding;
import com.example.gbsbadrsf.productionrepairstaus.ProductionrepstatusAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class ProductionSequence extends DaggerFragment {
    FragmentProductionSequenceBinding fragmentProductionSequenceBinding;
    public RecyclerView recyclerView;
    @Inject
    ViewModelProviderFactory provider;

    @Inject
    Gson gson;
    productionsequenceadapter adapter;
    List<Ppr> productionsequenceresponse;
    ProductionsequenceViewModel viewModel;
    List<String> selectedsequence;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProductionSequenceBinding = FragmentProductionSequenceBinding.inflate(inflater, container, false);
        viewModel = ViewModelProviders.of(this,provider).get(ProductionsequenceViewModel.class);


        setUpRecyclerView();

        attachListeners();
        selectedsequence = new ArrayList<>();

        recyclerView = fragmentProductionSequenceBinding.defectqtnRv;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        return fragmentProductionSequenceBinding.getRoot();


    }



    private void setUpRecyclerView() {
         productionsequenceresponse = new ArrayList<>();
        adapter = new productionsequenceadapter(productionsequenceresponse);
        fragmentProductionSequenceBinding.defectqtnRv.setAdapter(adapter);
        fragmentProductionSequenceBinding.defectqtnRv.setNestedScrollingEnabled(true);
        fragmentProductionSequenceBinding.defectqtnRv.setLayoutManager(new LinearLayoutManager(getContext()));



    }
    private void attachListeners() {

        viewModel.getProductionsequenceResponse().observe(getViewLifecycleOwner(), cuisines->{
            productionsequenceresponse.clear();
            if(cuisines!=null)
            productionsequenceresponse.addAll(cuisines);
            adapter.notifyDataSetChanged();
        });
        fragmentProductionSequenceBinding.newloadingBtn.setOnClickListener(__ -> {

            Navigation.findNavController(getView()).navigate(R.id.action_productionSequence_to_machineLoadingFragment);

        });

    }


}