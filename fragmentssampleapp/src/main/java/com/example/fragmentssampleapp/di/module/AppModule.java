package com.example.fragmentssampleapp.di.module;

import android.app.Application;
import android.content.Context;

import com.example.fragmentssampleapp.global.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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

}
