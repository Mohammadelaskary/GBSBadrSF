package com.example.gbsbadrsf.repository;

import com.example.gbsbadrsf.Quality.Data.AddManufacturingDefectData;
import com.example.gbsbadrsf.Quality.Data.ApiResponseAddingManufacturingRepairQuality;
import com.example.gbsbadrsf.Quality.Data.ApiResponseDefectsList;
import com.example.gbsbadrsf.Model.ApiResponseDefectsManufacturing;
import com.example.gbsbadrsf.Model.ApiResponseLastMoveManufacturingBasket;
import com.example.gbsbadrsf.Quality.Data.ApiResponseGetRandomQualityInception;
import com.example.gbsbadrsf.Quality.Data.ApiResponseSaveRandomQualityInception;
import com.example.gbsbadrsf.Quality.Data.Defect;
import com.example.gbsbadrsf.data.response.APIResponse;
import com.example.gbsbadrsf.data.response.Ppr;
import com.example.gbsbadrsf.data.response.ResponseStatus;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("GetManufacturingLoadingSequence")
    Single<APIResponse<List<Ppr>>> getproductionsequence(@Query("UserID") long userId,
                                                         @Query("DeviceSerialNo") String deviceSerialNumber);




    @GET("GetBasketInfoForQuality")
    Single<ApiResponseLastMoveManufacturingBasket> getBasketData(@Query("BasketCode") String basketCode);



    @GET("GetManufacturingDefectsList")
    Single<ApiResponseDefectsManufacturing> getManufacturingDefectsList(
            @Query("JobOrderId") int JobOrderId,
            @Query("ChildId") int ChildId
    );

    @GET("GetManufacturingDefectedQtyByBasketCode")
    Single<ApiResponseDefectsManufacturing> getManufacturingDefectedQtyByBasketCode(
            @Query("BasketCode") String BasketCode
    );

    @POST("AddManufacturingDefect")
    Single<ApiResponseDefectsManufacturing> AddManufacturingDefect(
           @Body AddManufacturingDefectData data
    );

    @GET("QualityOperationStatus")
    Single<ResponseStatus> setQualityOperationStatus(
            @Query("QualityOperationStatus") int QualityOperationStatus,
            @Query("ChildId") int ChildId,
            @Query("SignOffQty") int SignOffQty,
            @Query("IsDefected") boolean IsDefected
    );
    @GET("GetDefectsList")
    Single<ApiResponseDefectsList> getDefectsList();

    @GET("GetDefectsListPerOperation")
    Single<ApiResponseDefectsList<List<Defect>>> getDefectsListPerOperation(
            @Query("OperationID") int OperationID
    );

    @GET("AddManufacturingDefectedChildToBasket")
    Single<ResponseStatus> addManufacturingDefectedChildToBasket(
            @Query("JobOrderId") int JobOrderId,
            @Query("ParentID") int ParentID,
            @Query("ChildId") int ChildId,
            @Query("BasketCode") String BasketCode,
            @Query("NewBasketCode") String NewBasketCode
    );
    @GET("ManufacturingRepair_Production")
    Single<ResponseStatus> addManufacturingRepair_Production(
            @Query("UserID") long userId,
            @Query("DeviceSerialNo") String deviceSerialNumber,
            @Query("DefectsManufacturingDetailsId") int DefectsManufacturingDetailsId,
            @Query("Notes") String Notes,
            @Query("DefectStatus") int DefectStatus,
            @Query("QtyRepaired") int QtyRepaired
    );

    @GET("ManufacturingRepair_QC")
    Single<ApiResponseAddingManufacturingRepairQuality> addManufacturingRepair_QC(
            @Query("UserID") long userId,
            @Query("DeviceSerialNo") String deviceSerialNumber,
            @Query("DefectsManufacturingDetailsId") int DefectsManufacturingDetailsId,
            @Query("Notes") String Notes,
            @Query("DefectStatus") int DefectStatus,
            @Query("QtyApproved") int QtyApproved
    );

    @GET("GetInfoForQualityRandomInpection")
    Single<ApiResponseGetRandomQualityInception> GetInfoForQualityRandomInspection(
            @Query("UserID") int userId,
            @Query("DeviceSerialNo") String deviceSerialNumber,
            @Query("Code") String Code
    );
    @GET("SaveQualityRandomInpection")
    Single<ApiResponseSaveRandomQualityInception> SaveQualityRandomInspection(
            @Query("UserID") int userId,
            @Query("DeviceSerialNo") String deviceSerialNumber,
            @Query("LastMoveId") int LastMoveId,
            @Query("QtyDefected") int QtyDefected,
            @Query("SampleQty") int SampleQty,
            @Query("Notes") String Notes
    );
}
