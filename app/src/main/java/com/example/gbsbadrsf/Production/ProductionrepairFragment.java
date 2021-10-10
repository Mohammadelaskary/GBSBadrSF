package com.example.gbsbadrsf.Production;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.AdddefectcustomDialog;
import com.example.gbsbadrsf.Productionrepaircustomdialog;
import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.Util.OnClick;
import com.example.gbsbadrsf.databinding.FragmentProductionrepairBinding;
import com.example.gbsbadrsf.productionsequence.SimpleDividerItemDecoration;


public class ProductionrepairFragment extends Fragment implements OnClick {
    FragmentProductionrepairBinding fragmentProductionrepairBinding;
    ProductionrepairAdapter productionrepairAdapter;
    RecyclerView recyclerView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProductionrepairBinding = FragmentProductionrepairBinding.inflate(inflater, container, false);
        initViews();
        recyclerView = fragmentProductionrepairBinding.qcnotesRv;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        return fragmentProductionrepairBinding.getRoot();
    }
    private void initViews() {

        productionrepairAdapter = new ProductionrepairAdapter(this);
        fragmentProductionrepairBinding.qcnotesRv.setAdapter(productionrepairAdapter);
        fragmentProductionrepairBinding.qcnotesRv.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void OnItemClickedListener(int position) {
        Productionrepaircustomdialog mycustomDialog=new Productionrepaircustomdialog();
        mycustomDialog.show(getChildFragmentManager(),"repaircustomdialog");


    }
}
