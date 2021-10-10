package com.example.gbsbadrsf.Quality.manfacturing.Adddefects;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.AdddefectcustomDialog;
import com.example.gbsbadrsf.databinding.FragmentAddDefectsBinding;
import com.example.gbsbadrsf.productionsequence.SimpleDividerItemDecoration;


public class AddDefectsFragment extends Fragment {
    FragmentAddDefectsBinding fragmentAddDefectsBinding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAddDefectsBinding = FragmentAddDefectsBinding.inflate(inflater, container, false);
        initViews();

        return fragmentAddDefectsBinding.getRoot();

    }

    private void initViews() {
        fragmentAddDefectsBinding.plusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdddefectcustomDialog mycustomDialog=new AdddefectcustomDialog();
                mycustomDialog.show(getChildFragmentManager(),"MycustomDialog");
            }
        });


    }
}