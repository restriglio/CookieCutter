package com.example.globant.livedataroompoc.di.components;

import com.example.globant.livedataroompoc.global.App;
import com.example.globant.livedataroompoc.di.modules.ActivityBuilder;
import com.example.globant.livedataroompoc.di.modules.AppModule;

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
