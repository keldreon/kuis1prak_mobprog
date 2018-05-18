package io.github.amaceh.kuisprak1.activity.API;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class APIClient {
    public static final String BASE_URL="http://mahasiswa-mobprog.dx.am/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
