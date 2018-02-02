package com.example.fragmentssampleapp.di.module;

import com.example.fragmentssampleapp.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by raul.striglio on 02/02/18.
 */

@Module
public abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = {MainActivityModule.class, FragmentBuilder.class})
    abstract MainActivity bindMainActivity();

}
