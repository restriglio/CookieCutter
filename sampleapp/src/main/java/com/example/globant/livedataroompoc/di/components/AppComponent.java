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
 *
 *  Android apps have one application class. That is why we have one application component.
 *  This component is responsible for providing application scope instances (eg. OkHttp, Database, SharedPrefs.).
 *  This Component is root of our dagger graph. Application component is providing 3 module in our app.
 *
 *  AndroidInjectionModule : We didn’t create this. It is an internal class in Dagger.
 *  Provides our activities and fragments with given module.
 *
 *  ActivityBuilder : We created this module. This is a given module to dagger.
 *  We map all our activities here. And Dagger know our activities in compile time.
 *  In our app we have Main and Detail activity. So we map both activities here.
 *
 *  AppModule: We provide retrofit client, okhttp, UseCaseRepository, etc here.
 *
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
