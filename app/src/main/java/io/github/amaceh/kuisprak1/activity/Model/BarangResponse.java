package io.github.amaceh.kuisprak1.activity.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BarangResponse {
    @SerializedName("data") @Expose private List<Barang> barang;

    public List<Barang> getBarang() {
        return barang;
    }

    public void setBarang(List<Barang> barang) {
        this.barang = barang;
    }


}
