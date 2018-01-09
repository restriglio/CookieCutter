package com.example.raulstriglio.livedataroompoc.services;

import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.mvvm.events.GetUsersResponse;
import com.example.raulstriglio.livedataroompoc.utils.BusProvider;
import com.squareup.otto.Bus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by raul.striglio on 09/01/18.
 */

public class ServiceItem {

    private ApiService client;
    private Bus mBus;

    public ServiceItem() {
        client = ServiceGenerator.createService(ApiService.class);
        mBus = BusProvider.getInstance();
    }

    public void getUsers() {
        Call<List<User>> call =
                client.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mBus.post(new GetUsersResponse(false, response.body()));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                //Handle failure
                mBus.post(new GetUsersResponse(true, "Error from server"));
            }
        });
    }

}
