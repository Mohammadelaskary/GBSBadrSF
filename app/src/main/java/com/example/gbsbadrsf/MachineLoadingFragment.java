package com.example.gbsbadrsf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.databinding.FragmentMachineLoadingBinding;
import com.example.gbsbadrsf.databinding.FragmentSigninBinding;


public class MachineLoadingFragment extends Fragment {

    FragmentMachineLoadingBinding fragmentMachineLoadingBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentMachineLoadingBinding = FragmentMachineLoadingBinding.inflate(inflater, container, false);
        attachListeners();
        return fragmentMachineLoadingBinding.getRoot();

    }

    private void attachListeners() {
        fragmentMachineLoadingBinding.addworkersBtn.setOnClickListener(__ -> {
            Navigation.findNavController(getActivity(), R.id.myNavhostfragment).navigate(R.id.action_machineLoadingFragment_to_addworkersFragment);

        });

    }
}