package com.example.raulstriglio.livedataroompoc.di.modules;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;

import com.example.modelviewviewmodel.repository.BaseRepository;
import com.example.raulstriglio.livedataroompoc.App;
import com.example.raulstriglio.livedataroompoc.db.DatabaseInitializer;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.FindUserViewModelFactory;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.MainViewModelFactory;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 24/11/17.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    Application provideContext(App application) {
        return application;
    }


    @Provides
    @Singleton
    DatabaseInitializer provideDatabaseInitializer(DatabaseInitializer databaseInitializer){
        return databaseInitializer;
    }

    @Provides
    @Singleton
    @Named("MainViewModelFactory")
    ViewModelProvider.Factory provideViewModelFactory(MainViewModelFactory mainViewModelFactory){
        return mainViewModelFactory;
    }

    @Provides
    @Singleton
    @Named("FindUserViewModelFactory")
    ViewModelProvider.Factory provideFindUserViewModelFactory(FindUserViewModelFactory findUserViewModelFactory){
        return findUserViewModelFactory;
    }

    @Provides
    BaseRepository provideUserRepository(UserRepository userRepository){
        return userRepository;
    }

    @Provides
    StringBuilder provideStringBuilder(StringBuilder stringBuilder){
        return stringBuilder;
    }
}
