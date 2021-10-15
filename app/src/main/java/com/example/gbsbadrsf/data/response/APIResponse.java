package com.example.gbsbadrsf.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class APIResponse<T> {
    @SerializedName("modelState")
    @Expose
    private int modelState;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("data")
    @Expose
    private T data;

    public int getModelState() {
        return modelState;
    }

    public void setModelState(int modelState) {
        this.modelState = modelState;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
