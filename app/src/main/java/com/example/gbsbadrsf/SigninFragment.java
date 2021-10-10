package com.example.gbsbadrsf;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.databinding.FragmentSigninBinding;

public class SigninFragment extends Fragment {
    FragmentSigninBinding fragmentSigninBinding;



    public SigninFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SigninFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SigninFragment newInstance(String param1, String param2) {
        SigninFragment fragment = new SigninFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  if (getArguments() != null) {
        //    mParam1 = getArguments().getString(ARG_PARAM1);
          //  mParam2 = getArguments().getString(ARG_PARAM2);
        //}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSigninBinding = FragmentSigninBinding.inflate(inflater,container,false);
        attachListeners();
        return fragmentSigninBinding.getRoot();

    }

    private void attachListeners() {
        fragmentSigninBinding.loginBtn.setOnClickListener(__ ->{
            Navigation.findNavController(getActivity(),R.id.myNavhostfragment).navigate(R.id.action_signinFragment_to_mainmenuFragment);

        });

    }
}