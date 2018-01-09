package com.example.raulstriglio.livedataroompoc.mvvm.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 09/01/18.
 */

public class FindUserViewModelFactory implements ViewModelProvider.Factory {

    private FindUserViewModel findUserViewModel;

    @Inject
    public FindUserViewModelFactory(FindUserViewModel viewModel) {
        this.findUserViewModel = viewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FindUserViewModel.class)) {
            return (T) findUserViewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
