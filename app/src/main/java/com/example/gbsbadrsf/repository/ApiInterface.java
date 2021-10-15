package com.example.gbsbadrsf.repository;

import com.example.gbsbadrsf.data.response.APIResponse;
import com.example.gbsbadrsf.data.response.Ppr;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("GetManufacturingLoadingSequence")
    Single<APIResponse<List<Ppr>>> getproductionsequence(@Query("UserID") String userid,
                                                         @Query("DeviceSerialNo") String deviceserialnumber);

}
