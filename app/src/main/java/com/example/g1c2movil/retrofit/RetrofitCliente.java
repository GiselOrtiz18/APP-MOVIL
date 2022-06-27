package com.example.g1c2movil.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCliente {

    private static Retrofit _retrofit = null;

    public static Retrofit getCliente(String url) {
        if (_retrofit == null) {
            _retrofit = new Retrofit.Builder()
                    .baseUrl(url).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return _retrofit;
    }

}
