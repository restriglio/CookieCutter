package com.example.globant.sampleapp.di.modules;

import com.example.globant.sampleapp.users.activity.MainActivity;
import com.example.globant.sampleapp.users.repositories.UserRepository;
import com.example.globant.sampleapp.users.mvvm.view.MainView;
import com.example.globant.sampleapp.users.mvvm.viewmodel.MainViewModel;
import com.example.modelviewviewmodel.repository.UseCaseRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 24/11/17.
 */

@Module
public class MainActivityModule {

    @Provides
    @Singleton
    UseCaseRepository provideUserRepository(UserRepository userRepository){
        return userRepository;
    }

    @Provides
    MainView provideMainView(MainActivity mainActivity, MainViewModel mainViewModel){
        return new MainView(mainActivity, mainViewModel);
    }
}
