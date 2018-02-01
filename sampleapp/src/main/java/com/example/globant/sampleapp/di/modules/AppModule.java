package com.example.globant.sampleapp.di.modules;

import android.app.Application;

import com.example.globant.sampleapp.global.App;
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
 * Created by raul.striglio on 24/11/17.
 */

@Module(includes = {ViewModelModule.class, RetrofitModule.class})
public class AppModule {

    @Provides
    @Singleton
    Application provideContext(App application) {
        return application;
    }
}
