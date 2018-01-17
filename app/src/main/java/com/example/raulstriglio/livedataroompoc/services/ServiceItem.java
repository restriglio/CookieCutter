package com.example.raulstriglio.livedataroompoc.services;

import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.mvvm.events.GetUsersResponse;
import com.example.raulstriglio.livedataroompoc.utils.BusProvider;
import com.squareup.otto.Bus;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
