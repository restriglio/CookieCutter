package com.example.fragmentssampleapp.di.module;

import com.example.fragmentssampleapp.fragment.FragmentHeroImage;
import com.example.fragmentssampleapp.fragment.FragmentHeroList;
import com.example.fragmentssampleapp.fragment.FragmentHeroDetail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by raul.striglio on 02/02/18.
 */

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = FragmentsModule.class)
    abstract FragmentHeroList provideFragmentOneFactory();

    @ContributesAndroidInjector(modules = FragmentsModule.class)
    abstract FragmentHeroDetail provideFragmentTwoFactory();

    @ContributesAndroidInjector(modules = FragmentsModule.class)
    abstract FragmentHeroImage provideFragmentThreeFactory();

}
