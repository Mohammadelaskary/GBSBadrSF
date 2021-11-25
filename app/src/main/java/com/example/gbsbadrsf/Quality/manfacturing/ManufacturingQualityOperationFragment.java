package com.example.gbsbadrsf.Quality.manfacturing;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gbsbadrsf.Model.LastMoveManufacturingBasket;
import com.example.gbsbadrsf.Quality.Data.ManufacturingQualityOperationViewModel;
import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.Util.ViewModelProviderFactory;
import com.example.gbsbadrsf.data.response.ResponseStatus;
import com.example.gbsbadrsf.data.response.Status;
import com.example.gbsbadrsf.databinding.FragmentManufacturingQualityOperationBinding;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class ManufacturingQualityOperationFragment extends DaggerFragment {

    FragmentManufacturingQualityOperationBinding binding;
    ManufacturingQualityOperationViewModel viewModel;
    public static final String EXISTING_BASKET_CODE  = "Data sent successfully";
    @Inject
    ViewModelProviderFactory provider;

    @Inject
    Gson gson;

    public ManufacturingQualityOperationFragment() {
        // Required empty public constructor
    }


    public static ManufacturingQualityOperationFragment newInstance() {
        ManufacturingQualityOperationFragment fragment = new ManufacturingQualityOperationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentManufacturingQualityOperationBinding.inflate(inflater,container,false);
        attachListener();
        initViewModel();
        getStatus();

        return binding.getRoot();
    }

    private void getStatus() {

    }
    LastMoveManufacturingBasket basketData;
    private void getBasketData() {
        viewModel.getBasketDataResponse().observe(getActivity(), apiResponseLastMoveManufacturingBasket -> {
            basketData = apiResponseLastMoveManufacturingBasket.getLastMoveManufacturingBasket();
            ResponseStatus responseStatus          = apiResponseLastMoveManufacturingBasket.getResponseStatus();

            String responseMessage = responseStatus.getStatusMessage();
            if (responseMessage.equals(EXISTING_BASKET_CODE)){
                if (basketData!=null) {
                    String childCode    = basketData.getChildCode();
                    String childDesc    = basketData.getChildDescription();
                    String jobOrderName = basketData.getJobOrderName();
                    int qnt             = basketData.getSignOffQty();
                    int operationId     = basketData.getOperationId();
                    binding.childCode.setText(childCode);
                    binding.childDesc.setText(childDesc);
                    binding.jobOrderName.setText(jobOrderName);
                    binding.signoffQtnEdt.setText(String.valueOf(qnt));
                    binding.operation.setText(String.valueOf(operationId));
                }
            } else {
                binding.itemcodeEdt.setError("Please Enter A Valid Basket Code!");
            }
        });
    }



    private void initViewModel() {
//        viewModel = ViewModelProvider.AndroidViewModelFactory
//                .getInstance(getActivity().getApplication()).create(ManufacturingQualityViewModel.class);
       viewModel = ViewModelProviders.of(this,provider).get(ManufacturingQualityOperationViewModel.class);
        viewModel.getBasketDataViewModel("Bskt1");
        getBasketData();
        observeGettingDataStatus();
    }

    private void observeGettingDataStatus() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        viewModel.getBasketDataStatus().observe(getViewLifecycleOwner(),status -> {
            if (status == Status.LOADING){
                progressDialog.show();
            } else {
                progressDialog.dismiss();
            }
        });
    }

    private void attachListener() {
        binding.addDefectButton.setOnClickListener(v -> {
            String sampleQty = binding.sampleQtnEdt.getText().toString().trim();
            if (sampleQty.isEmpty()){
                Toast.makeText(getContext(), "Please enter sample quantity!", Toast.LENGTH_SHORT).show();
            } else {
                Bundle bundle = new Bundle();
                bundle.putParcelable("basketData", basketData);
                bundle.putInt("sampleQty", Integer.parseInt(sampleQty));
                Navigation.findNavController(v).navigate(R.id.action_manufacturing_quality_operation_fragment_to_manufacturing_add_defect_fragment, bundle);
            }
        });
    }
}