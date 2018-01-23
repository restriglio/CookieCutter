package com.example.raulstriglio.livedataroompoc.di.modules;

import android.app.Application;

import com.example.modelviewviewmodel.repository.UseCaseRepository;
import com.example.raulstriglio.livedataroompoc.App;
import com.example.raulstriglio.livedataroompoc.BuildConfig;
import com.example.raulstriglio.livedataroompoc.repositories.PostRepository;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;
import com.example.raulstriglio.livedataroompoc.services.PostApiService;
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

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    Application provideContext(App application) {
        return application;
    }


    @Provides
    @Singleton
    UseCaseRepository provideUserRepository(UserRepository userRepository){
        return userRepository;
    }

    @Provides
    @Singleton
    UseCaseRepository providePostRepository(PostRepository postRepository){
        return postRepository;
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
