package com.example.raulstriglio.livedataroompoc.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 27/11/17.
 */

public class ViewModelFactory implements ViewModelProvider.Factory {

    private MainViewModel mViewModel;

    @Inject
    public ViewModelFactory(MainViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) mViewModel;
        }
        throw new IllegalArgumentException("Unknown class name");

    }
}
