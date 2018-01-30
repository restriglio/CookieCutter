package com.example.raulstriglio.sampleapp.di.modules;

import com.example.raulstriglio.sampleapp.posts.activity.PostsActivity;
import com.example.raulstriglio.sampleapp.users.activity.FindUserActivity;
import com.example.raulstriglio.sampleapp.users.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by raul.striglio on 24/11/17.
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
