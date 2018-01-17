package com.example.raulstriglio.livedataroompoc.services;

import com.example.raulstriglio.livedataroompoc.mvvm.events.GetUsersResponse;
import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 09/01/18.
 */

public class ServiceItem {

    UserApiService client;
    Bus bus;

    @Inject
    public ServiceItem(UserApiService client, Bus bus) {
        this.client = client;
        this.bus = bus;
    }

    public void getUsers() {
        //Call<List<User>> call =


       /* call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                bus.post(new GetUsersResponse(false, response.body()));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                bus.post(new GetUsersResponse(true, "Error from server"));
            }
        });*/
    }

}
