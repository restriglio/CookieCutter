package com.example.globant.sampleapp.di.modules;

import com.example.globant.sampleapp.posts.activity.PostsActivity;
import com.example.globant.sampleapp.users.activity.FindUserActivity;
import com.example.globant.sampleapp.users.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by raul.striglio on 24/11/17.
 *
 * This is a given module to dagger. We map all our activities here.
 * And Dagger know our activities in compile time.
 *
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract FindUserActivity bindFindUserActivity();

    @ContributesAndroidInjector(modules = {PostsActivityModule.class})
    abstract PostsActivity bindPostActivity();
}