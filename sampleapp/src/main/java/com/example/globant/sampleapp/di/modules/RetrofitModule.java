package com.example.globant.sampleapp.di.modules;

import com.example.globant.sampleapp.BuildConfig;
import com.example.globant.sampleapp.posts.services.PostApiService;
import com.example.globant.sampleapp.users.services.UserApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by raul.striglio on 31/01/18.
 */

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    UserApiService provideUserApiService(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();

        return retrofit.create(UserApiService.class);
    }

    @Provides
    @Singleton
    PostApiService providePostApiService(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();

        return retrofit.create(PostApiService.class);
    }

}
