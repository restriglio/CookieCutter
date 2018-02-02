package com.example.fragmentssampleapp.di.module;

import com.example.fragmentssampleapp.fragment.FragmentOne;
import com.example.fragmentssampleapp.fragment.FragmentThree;
import com.example.fragmentssampleapp.fragment.FragmentTwo;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by raul.striglio on 02/02/18.
 */

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = FragmentsModule.class)
    abstract FragmentOne provideFragmentOneFactory();

    @ContributesAndroidInjector(modules = FragmentsModule.class)
    abstract FragmentTwo provideFragmentTwoFactory();

    @ContributesAndroidInjector(modules = FragmentsModule.class)
    abstract FragmentThree provideFragmentThreeFactory();

}
