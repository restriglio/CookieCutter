package com.example.raulstriglio.sampleapp.di.components;

import com.example.raulstriglio.sampleapp.global.App;
import com.example.raulstriglio.sampleapp.di.modules.ActivityBuilder;
import com.example.raulstriglio.sampleapp.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by raul.striglio on 24/11/17.
 */


@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(App application);

        AppComponent build();

    }

    void inject(App app);

}
