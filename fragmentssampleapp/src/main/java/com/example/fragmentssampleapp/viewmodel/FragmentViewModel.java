package com.example.fragmentssampleapp.viewmodel;

import android.app.Application;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentViewModel extends BaseViewModel {

    @Inject
    public FragmentViewModel(Application application) {
        super(application);
    }
}
