package com.example.gbsbadrsf.Quality.welding.adddefectwe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.AdddefectcustomDialog;
import com.example.gbsbadrsf.AdddefectweCustomdialog;
import com.example.gbsbadrsf.Quality.manfacturing.Adddefects.AdddefectsAdapter;
import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentAddDefectsBinding;
import com.example.gbsbadrsf.databinding.FragmentAdddefectweBinding;
import com.example.gbsbadrsf.productionsequence.SimpleDividerItemDecoration;


public class Adddefectwe extends Fragment {

    FragmentAdddefectweBinding adddefectweBinding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        adddefectweBinding = FragmentAdddefectweBinding.inflate(inflater, container, false);
        initViews();

        return adddefectweBinding.getRoot();

    }

    private void initViews() {
        adddefectweBinding.plusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdddefectweCustomdialog mycustomDialog=new AdddefectweCustomdialog();
                mycustomDialog.show(getChildFragmentManager(),"MycustomDialog");
            }
        });

    }
}