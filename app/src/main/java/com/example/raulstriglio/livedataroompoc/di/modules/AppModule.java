package com.example.raulstriglio.livedataroompoc.di.modules;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;

import com.example.modelviewviewmodel.repository.BaseRepository;
import com.example.raulstriglio.livedataroompoc.App;
import com.example.raulstriglio.livedataroompoc.BuildConfig;
import com.example.raulstriglio.livedataroompoc.db.DatabaseInitializer;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;
import com.example.raulstriglio.livedataroompoc.services.UserApiService;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();

        return retrofit.create(UserApiService.class);
    }
}
