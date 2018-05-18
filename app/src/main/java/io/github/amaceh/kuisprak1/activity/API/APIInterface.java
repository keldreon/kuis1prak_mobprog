package io.github.amaceh.kuisprak1.activity.API;

import java.util.List;

import io.github.amaceh.kuisprak1.activity.Model.ApiData;
import io.github.amaceh.kuisprak1.activity.Model.Barang;
import retrofit.Call;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;

public interface APIInterface {
    /*
    *
    * Semua operasi ada pada alamat yang sama, body menggunakan JSON dan backend juga akan mereturn dalam bentuk JSON.
      Supaya tidak mengganggu kelompok lain, gunakan prefix/suffix khusus di value kalian, misalnya kel1_hp. Jadi kesepakatannya kelompok lain tidak boleh menyentuh value ini.
      GET tidak memerlukan argumen apapun, akan memberikan data yang berisi daftar barang.
      POST memerlukan body berisi : nama_barang, jenis, harga. Bila berhasil return ”data” : “1”.
      PUT memerlukan body berisi : id, nama_barang, jenis, harga. Bila berhasil return ”data” : “1”.
      DELETE memerlukan body berisi : id. Bila berhasil return ”data” : “1”.
    * */

    @GET("barang/")
    Call<ApiData<List<Barang>>> getBarang();

    @FormUrlEncoded
    @POST("barang/")
    Call<Barang> postBarang(@Field("nama_barang") String nb, @Field("jenis") String jn, @Field("harga") String harga);

    @FormUrlEncoded
    @PUT("barang/")
    Call<Barang> putBarang(@Field("id") String id, @Field("nama_barang") String nb, @Field("jenis") String jn, @Field("harga") String harga);

    @FormUrlEncoded
    @DELETE("barang/")
    Call<Barang> delBarang(@Field("id") String id);
}
