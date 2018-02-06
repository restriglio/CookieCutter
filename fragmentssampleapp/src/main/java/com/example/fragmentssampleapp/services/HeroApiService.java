package com.example.fragmentssampleapp.services;

import com.example.fragmentssampleapp.db.entities.Hero;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ciro.oyarzun on 05-Feb-18.
 */

public interface HeroApiService {

    @GET("marvel")
    Observable<List<Hero>> getHeros();
}
