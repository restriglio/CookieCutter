package com.example.raulstriglio.livedataroompoc.di;

import com.example.raulstriglio.livedataroompoc.App;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by raul.striglio on 03/11/17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app);
}