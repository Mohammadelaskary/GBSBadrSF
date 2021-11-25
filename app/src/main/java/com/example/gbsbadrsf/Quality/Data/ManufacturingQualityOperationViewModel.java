package com.example.gbsbadrsf.Quality.Data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gbsbadrsf.Model.ApiResponseLastMoveManufacturingBasket;
import com.example.gbsbadrsf.data.response.ResponseStatus;
import com.example.gbsbadrsf.data.response.Status;
import com.example.gbsbadrsf.repository.ApiInterface;
import com.google.gson.Gson;

import java.util.List;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ManufacturingQualityOperationViewModel extends ViewModel {
    MutableLiveData<ApiResponseLastMoveManufacturingBasket> basketDataLiveData;



    MutableLiveData<ResponseStatus> qualityOperationStatus;


    MutableLiveData<Status> basketDataStatus;
    MutableLiveData<Status> qualityOperationStatusStatus;
    MutableLiveData<Status> defectsListStatus;
    MutableLiveData<Status> defectsListByOperationStatus;
    MutableLiveData<List<Defect>> defectsListByOperationLiveData;


    public MutableLiveData<ResponseStatus> getQualityOperationStatus() {
        return qualityOperationStatus;
    }

    public void setQualityOperationStatus(MutableLiveData<ResponseStatus> qualityOperationStatus) {
        this.qualityOperationStatus = qualityOperationStatus;
    }

    @Inject
    ApiInterface apiInterface;
    private CompositeDisposable disposable;


    @Inject
    Gson gson;
    @Inject
    public ManufacturingQualityOperationViewModel(Gson gson) {
        this.gson = gson;
        basketDataLiveData = new MutableLiveData<>();
        basketDataStatus = new MutableLiveData<>();
        disposable = new CompositeDisposable();
        qualityOperationStatus = new MutableLiveData<>();
        defectsListStatus = new MutableLiveData<>();
        defectsListByOperationStatus = new MutableLiveData<>();
        defectsListByOperationLiveData= new MutableLiveData<>();
    }

    public void getBasketDataViewModel(String basketCode){
        disposable.add(apiInterface.getBasketData(basketCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe( __ -> basketDataStatus.postValue(Status.LOADING))
                .subscribe(
                        response -> {
                            basketDataLiveData.postValue(response);
                            basketDataStatus.postValue(Status.SUCCESS);
                            },
                        throwable -> {
                            basketDataStatus.postValue(Status.ERROR);
                        }
                ));
    }



    public void getDefectsManufacturingViewModel(int QualityOperationStatus,
                                                 int ChildId,
                                                 int SignOffQty,
                                                 boolean IsDefected){
        disposable.add(apiInterface.setQualityOperationStatus(
                QualityOperationStatus,
                ChildId,
                SignOffQty,
                IsDefected
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe( __ ->getQualityOperationStatusStatus().postValue(Status.LOADING))
                .subscribe(
                        response -> {
                            getQualityOperationStatus().postValue(response);
                            getQualityOperationStatusStatus().postValue(Status.SUCCESS);},
                        throwable -> {
                            getQualityOperationStatusStatus().postValue(Status.ERROR);
                        }
                ));
    }



    public void getDefectsListByOperationViewModel(int OperationID){
        disposable.add(apiInterface.getDefectsListPerOperation(OperationID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe( __ ->defectsListByOperationStatus.postValue(Status.LOADING))
                .subscribe(
                        response -> {
                            defectsListByOperationLiveData.postValue(response.getDefectsList());
                            defectsListByOperationStatus.postValue(Status.SUCCESS);},
                        throwable -> {
                            defectsListByOperationStatus.postValue(Status.ERROR);
                        }
                ));
    }




    public MutableLiveData<ApiResponseLastMoveManufacturingBasket> getBasketDataResponse() {
        return basketDataLiveData;
    }

    public MutableLiveData<Status> getStatus() {
        return basketDataStatus;
    }

    public MutableLiveData<ApiResponseLastMoveManufacturingBasket> getBasketDataLiveData() {
        return basketDataLiveData;
    }




    public MutableLiveData<Status> getBasketDataStatus() {
        return basketDataStatus;
    }

    public void setBasketDataStatus(MutableLiveData<Status> basketDataStatus) {
        this.basketDataStatus = basketDataStatus;
    }


    public MutableLiveData<Status> getQualityOperationStatusStatus() {
        return qualityOperationStatusStatus;
    }

    public void setQualityOperationStatusStatus(MutableLiveData<Status> qualityOperationStatusStatus) {
        this.qualityOperationStatusStatus = qualityOperationStatusStatus;
    }


    public MutableLiveData<Status> getDefectsListStatus() {
        return defectsListStatus;
    }

    public void setDefectsListStatus(MutableLiveData<Status> defectsListStatus) {
        this.defectsListStatus = defectsListStatus;
    }

    public MutableLiveData<List<Defect>> getDefectsListByOperationLiveData() {
        return defectsListByOperationLiveData;
    }

    public void setDefectsListByOperationLiveData(MutableLiveData<List<Defect>> defectsListByOperationLiveData) {
        this.defectsListByOperationLiveData = defectsListByOperationLiveData;
    }

    public MutableLiveData<Status> getDefectsListByOperationStatus() {
        return defectsListByOperationStatus;
    }

    public void setDefectsListByOperationStatus(MutableLiveData<Status> defectsListByOperationStatus) {
        this.defectsListByOperationStatus = defectsListByOperationStatus;
    }


}
