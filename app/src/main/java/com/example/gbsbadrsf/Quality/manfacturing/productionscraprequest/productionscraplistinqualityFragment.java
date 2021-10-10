package com.example.gbsbadrsf.Quality.manfacturing.productionscraprequest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.Util.OnClick;
import com.example.gbsbadrsf.databinding.FragmentProductionscraplistinqualityBinding;
import com.example.gbsbadrsf.databinding.FragmentQualityscraplistBinding;
import com.example.gbsbadrsf.qualityscrap.qualityscraplistadapter;


public class productionscraplistinqualityFragment extends Fragment implements OnClick {

    FragmentProductionscraplistinqualityBinding fragmentProductionscraplistinqualityBinding;
    productionscraplistAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentProductionscraplistinqualityBinding = FragmentProductionscraplistinqualityBinding.inflate(inflater, container, false);
        initViews();

        return fragmentProductionscraplistinqualityBinding.getRoot();

    }

    private void initViews() {
        adapter = new productionscraplistAdapter(this);
        fragmentProductionscraplistinqualityBinding.productionscrapscrapRv.setAdapter(adapter);
        fragmentProductionscraplistinqualityBinding.productionscrapscrapRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void OnItemClickedListener(int position) {
        Navigation.findNavController(getView()).navigate(R.id.action_productionscraplistinqualityFragment_to_productionscraprequestqcFragment);

    }
}