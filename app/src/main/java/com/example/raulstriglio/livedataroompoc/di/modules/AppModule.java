package com.example.raulstriglio.livedataroompoc.di.modules;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;

import com.example.modelviewviewmodel.repository.BaseRepository;
import com.example.raulstriglio.livedataroompoc.App;
import com.example.raulstriglio.livedataroompoc.BuildConfig;
import com.example.raulstriglio.livedataroompoc.db.DatabaseInitializer;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.FindUserViewModelFactory;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.MainViewModelFactory;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;
import com.example.raulstriglio.livedataroompoc.services.ServiceItem;
import com.example.raulstriglio.livedataroompoc.services.UserApiService;
import com.example.raulstriglio.livedataroompoc.utils.BusProvider;
import com.squareup.otto.Bus;

import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by raul.striglio on 24/11/17.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    Application provideContext(App application) {
        return application;
    }


    @Provides
    @Singleton
    DatabaseInitializer provideDatabaseInitializer(DatabaseInitializer databaseInitializer){
        return databaseInitializer;
    }

    @Provides
    @Singleton
    @Named("MainViewModelFactory")
    ViewModelProvider.Factory provideViewModelFactory(MainViewModelFactory mainViewModelFactory){
        return mainViewModelFactory;
    }

    @Provides
    @Singleton
    @Named("FindUserViewModelFactory")
    ViewModelProvider.Factory provideFindUserViewModelFactory(FindUserViewModelFactory findUserViewModelFactory){
        return findUserViewModelFactory;
    }

    @Provides
    BaseRepository provideUserRepository(UserRepository userRepository){
        return userRepository;
    }

    @Provides
    StringBuilder provideStringBuilder(StringBuilder stringBuilder){
        return stringBuilder;
    }

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
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();

        return retrofit.create(UserApiService.class);
    }

    @Provides
    @Singleton
    Bus provideBus() {
        return BusProvider.getInstance();
    }

    @Provides
    @Singleton
    ServiceItem provideServiceItem(Bus bus, UserApiService userApiService ){
        return new ServiceItem(userApiService, bus);
    }
}
