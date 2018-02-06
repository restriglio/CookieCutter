package com.example.fragmentssampleapp.di.module;

import android.app.Application;
import android.content.Context;

import com.example.fragmentssampleapp.BuildConfig;
import com.example.fragmentssampleapp.global.App;
import com.example.fragmentssampleapp.repository.HeroRepository;
import com.example.fragmentssampleapp.services.HeroApiService;
import com.example.modelviewviewmodel.repository.UseCaseRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by raul.striglio on 02/02/18.
 */

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    Application provideContext(App application) {
        return application;
    }

    @Provides
    @Singleton
    UseCaseRepository provideHeroRepository(HeroRepository heroRepository) {
        return heroRepository;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    HeroApiService provideHeroApiService(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();

        return retrofit.create(HeroApiService.class);
    }
}
