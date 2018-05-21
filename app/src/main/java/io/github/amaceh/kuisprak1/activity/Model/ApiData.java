package io.github.amaceh.kuisprak1.activity.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiData<T> {
    private String status;
    @SerializedName("data") @Expose
    private T data;

    public ApiData() {
    }

    public ApiData(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
