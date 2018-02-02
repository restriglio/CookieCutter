package com.example.fragmentssampleapp.di.component;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import com.example.fragmentssampleapp.di.module.ActivityBuilder;
import com.example.fragmentssampleapp.di.module.AppModule;
import com.example.fragmentssampleapp.global.App;

/**
 * Created by raul.striglio on 02/02/18.
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