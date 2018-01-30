package com.example.globant.livedataroompoc.di.modules;

import com.example.globant.livedataroompoc.users.activity.MainActivity;
import com.example.globant.livedataroompoc.users.repositories.UserRepository;
import com.example.globant.livedataroompoc.users.view.MainView;
import com.example.globant.livedataroompoc.users.viewmodel.MainViewModel;
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
