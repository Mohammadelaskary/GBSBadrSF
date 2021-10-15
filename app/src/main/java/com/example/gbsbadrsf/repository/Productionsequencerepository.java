package com.example.gbsbadrsf.repository;

import com.example.gbsbadrsf.data.response.APIResponse;
import com.example.gbsbadrsf.data.response.Ppr;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Productionsequencerepository {
    @Inject
    ApiInterface apiInterface;
    @Inject

    public Productionsequencerepository() {
    }
//    public Single<APIResponse<List<Ppr>>> Getproductionsequence(String userid, String deviceserialnumber){
//        return apiInterface.getproductionsequence(userid, deviceserialnumber)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }

}
