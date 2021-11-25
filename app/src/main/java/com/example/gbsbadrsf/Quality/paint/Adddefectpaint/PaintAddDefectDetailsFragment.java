package com.example.gbsbadrsf.Quality.paint.Adddefectpaint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.FragmentPaintAddDefectDetailsBinding;


public class PaintAddDefectDetailsFragment extends Fragment {


    public PaintAddDefectDetailsFragment() {
        // Required empty public constructor
    }


    public static PaintAddDefectDetailsFragment newInstance(String param1, String param2) {
        PaintAddDefectDetailsFragment fragment = new PaintAddDefectDetailsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    FragmentPaintAddDefectDetailsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPaintAddDefectDetailsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}