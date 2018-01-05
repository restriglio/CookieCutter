package com.example.raulstriglio.livedataroompoc.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by raul.striglio on 26/12/17.
 */

public class ApiClient {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getClient().create(ApiService.class);
    }

}
