package com.example.gbsbadrsf.Production;

import static com.example.gbsbadrsf.Quality.manfacturing.ManufacturingQualityOperationFragment.EXISTING_BASKET_CODE;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gbsbadrsf.Model.LastMoveManufacturingBasket;
import com.example.gbsbadrsf.Model.QtyDefectsQtyDefected;
import com.example.gbsbadrsf.Production.Data.ProductionRepairViewModel;
import com.example.gbsbadrsf.Quality.Data.DefectsManufacturing;
import com.example.gbsbadrsf.Util.ViewModelProviderFactory;
import com.example.gbsbadrsf.data.response.ResponseStatus;
import com.example.gbsbadrsf.data.response.Status;
import com.example.gbsbadrsf.databinding.FragmentProductionRepairBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class ProductionRepairFragment extends DaggerFragment {

    FragmentProductionRepairBinding binding;
    List<DefectsManufacturing>  defectsManufacturingList = new ArrayList<>();
    ProductionRepairChildsQtyDefectsQtyAdapter adapter;
    ProductionRepairViewModel viewModel;
    private static final String SUCCESS = "Data sent successfully";

    @Inject
    ViewModelProviderFactory provider;
    ProgressDialog progressDialog;
    String basketCode ="Bskt1";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductionRepairBinding.inflate(inflater, container, false);
        setUpProgressDialog();
        initViewModel();
        getBasketData(basketCode);
        observeGettingBasketData();
        getBasketDefectsManufacturing(basketCode);
        observeGettingDefectsManufacturing();
        initViews();
        setupRecyclerView();
        return binding.getRoot();
    }

    private void observeGettingDefectsManufacturing() {
        viewModel.getDefectsManufacturingListStatus().observe(getViewLifecycleOwner(),status -> {
            if (status == Status.LOADING)
                progressDialog.show();
            else
                progressDialog.dismiss();
        });
    }

    private void getBasketDefectsManufacturing(String basketCode) {
        viewModel.getDefectsManufacturingViewModel(basketCode);
        viewModel.getDefectsManufacturingListLiveData().observe(getViewLifecycleOwner(),apiResponseDefectsManufacturing -> {
            ResponseStatus responseStatus = apiResponseDefectsManufacturing.getResponseStatus();
            String statusMessage = responseStatus.getStatusMessage();
            if (statusMessage.equals(SUCCESS)){
                if (apiResponseDefectsManufacturing.getData()!=null){
                    defectsManufacturingList.clear();
                    List<DefectsManufacturing> defectsManufacturingListLocal = apiResponseDefectsManufacturing.getData();
                    defectsManufacturingList.addAll(defectsManufacturingListLocal);
                    adapter.setDefectsManufacturingList(defectsManufacturingList);
                    List<QtyDefectsQtyDefected> qtyDefectsQtyDefectedList = groupDefectsById(defectsManufacturingList);
                    adapter.setQtyDefectsQtyDefectedList(qtyDefectsQtyDefectedList);
                    String defectedQty = calculateDefectedQty(qtyDefectsQtyDefectedList);
                    binding.defectQtn.setText(defectedQty);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
    public List<QtyDefectsQtyDefected> groupDefectsById(List<DefectsManufacturing> defectsManufacturingListLocal) {
        List<QtyDefectsQtyDefected> qtyDefectsQtyDefectedListLocal = new ArrayList<>();
        int id = -1 ;
        for (DefectsManufacturing defectsManufacturing:defectsManufacturingListLocal){
            if (defectsManufacturing.getManufacturingDefectsId()!=id){
                int currentId = defectsManufacturing.getManufacturingDefectsId();
                int defectedQty = defectsManufacturing.getDeffectedQty();
                QtyDefectsQtyDefected qtyDefectsQtyDefected = new QtyDefectsQtyDefected(currentId,defectedQty,getDefectsQty(currentId));
                qtyDefectsQtyDefectedListLocal.add(qtyDefectsQtyDefected);
                id = currentId;
            }
        }
        return qtyDefectsQtyDefectedListLocal;
    }

    private int getDefectsQty(int currentId) {
        int defectNo = 0;
        for (DefectsManufacturing defectsManufacturing:defectsManufacturingList){
            if (defectsManufacturing.getManufacturingDefectsId()==currentId)
                defectNo++;
        }
        return  defectNo;
    }


    private String calculateDefectedQty(List<QtyDefectsQtyDefected> qtyDefectsQtyDefectedList) {
        int sum = 0;
        for (QtyDefectsQtyDefected qtyDefectsQtyDefected : qtyDefectsQtyDefectedList){
            sum +=qtyDefectsQtyDefected.getDefectedQty();
        }
        return String.valueOf(sum);
    }
    private void setUpProgressDialog() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
    }

    private void observeGettingBasketData() {
        viewModel.getApiResponseBasketDataStatus().observe(getViewLifecycleOwner(),status -> {
            if (status== Status.LOADING){
                progressDialog.show();
            } else {
                progressDialog.dismiss();
            }
        });
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this,provider).get(ProductionRepairViewModel.class);
    }
    LastMoveManufacturingBasket basketData;
    private void getBasketData(String basketCode) {
        viewModel.getBasketDataViewModel(basketCode);
        viewModel.getApiResponseBasketDataLiveData().observe(getViewLifecycleOwner(),apiResponseLastMoveManufacturingBasket -> {
            basketData = apiResponseLastMoveManufacturingBasket.getLastMoveManufacturingBasket();
            adapter.setBasketData(basketData);
            ResponseStatus responseStatus = apiResponseLastMoveManufacturingBasket.getResponseStatus();
            String statusMessage = responseStatus.getStatusMessage();
            if (statusMessage.equals(EXISTING_BASKET_CODE)){
                String childDesc     = basketData.getChildDescription();
                String childCode     = basketData.getChildCode();
                String operationName = basketData.getOperationEnName();
                fillData(childDesc,childCode,operationName);
            }
        });
    }

    private void fillData(String childDesc, String childCode, String operationName) {
        binding.childCode.setText(childCode);
        binding.childDesc.setText(childDesc);
        binding.operation.setText(operationName);
    }


    private void setupRecyclerView() {
        adapter = new ProductionRepairChildsQtyDefectsQtyAdapter();
        binding.defectsDetailsList.setAdapter(adapter);
    }

    private void initViews() {

    }





}
