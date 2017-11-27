package com.example.raulstriglio.livedataroompoc.di.modules;

import com.example.raulstriglio.livedataroompoc.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by raul.striglio on 24/11/17.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity bindMainActivity();

}
