package com.example.modelviewviewmodel.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

/**
 * Created by raul.striglio on 03/11/17.
 */

public abstract class BaseViewModel extends AndroidViewModel {

    public BaseViewModel(Application application) {
        super(application);
    }
}
