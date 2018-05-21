package io.github.amaceh.kuisprak1.activity.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Barang {
    @SerializedName("id") @Expose private int id;
    @SerializedName("nama_barang") @Expose private String nama_barang;
    @SerializedName("jenis") @Expose private String jenis;
    @SerializedName("harga") @Expose private String harga;

    public Barang(int id, String nb, String jn, String h){
        this.id = id;
        this.nama_barang=nb;
        this.jenis=jn;
        this.harga=h;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Barang(String nb, String jn, String h){
        this.nama_barang=nb;
        this.jenis=jn;
        this.harga=h;
    }



}
