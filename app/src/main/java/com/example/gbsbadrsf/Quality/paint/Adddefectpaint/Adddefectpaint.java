package com.example.gbsbadrsf.Quality.paint.Adddefectpaint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.AdddefectcustomDialog;
import com.example.gbsbadrsf.AdddefectpaintCustomdialog;
import com.example.gbsbadrsf.Quality.manfacturing.Adddefects.AdddefectsAdapter;
import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentAddDefectsBinding;
import com.example.gbsbadrsf.databinding.FragmentAdddefectpaintBinding;
import com.example.gbsbadrsf.productionsequence.SimpleDividerItemDecoration;


public class Adddefectpaint extends Fragment {

    FragmentAdddefectpaintBinding fragmentAdddefectpaintBinding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAdddefectpaintBinding = FragmentAdddefectpaintBinding.inflate(inflater, container, false);
        initViews();

        return fragmentAdddefectpaintBinding.getRoot();

    }

    private void initViews() {
        fragmentAdddefectpaintBinding.plusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdddefectpaintCustomdialog mycustomDialog=new AdddefectpaintCustomdialog();
                mycustomDialog.show(getChildFragmentManager(),"adddefectpaintcustomDialog");
            }
        });


    }
}