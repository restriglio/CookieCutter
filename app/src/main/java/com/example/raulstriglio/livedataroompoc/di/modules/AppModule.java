package com.example.raulstriglio.livedataroompoc.di.modules;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.modelviewviewmodel.repository.BaseRepository;
import com.example.raulstriglio.livedataroompoc.App;
import com.example.raulstriglio.livedataroompoc.db.AppDatabase;
import com.example.raulstriglio.livedataroompoc.db.DatabaseInitializer;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;
import com.example.raulstriglio.livedataroompoc.view.MainView;
import com.example.raulstriglio.livedataroompoc.viewmodel.MainViewModel;
import com.example.raulstriglio.livedataroompoc.viewmodel.ViewModelFactory;

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
    ViewModelProvider.Factory provideViewModelFactory(ViewModelFactory viewModelFactory){
        return viewModelFactory;
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
