package com.example.fragmentssampleapp.di.module;


import com.example.fragmentssampleapp.activity.MainActivity;
import com.example.fragmentssampleapp.view.MainActivityView;
import com.example.fragmentssampleapp.viewmodel.MainViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 02/02/18.
 */

@Module
public class MainActivityModule {

    @Provides
    MainActivityView provideMainView(MainActivity mainActivity, MainViewModel mainViewModel){
        return new MainActivityView(mainActivity, mainViewModel);
    }

}
