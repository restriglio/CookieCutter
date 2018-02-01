package com.example.modelviewviewmodel.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.modelviewviewmodel.repository.UseCaseRepository;

/**
 *
 * Created by raul.striglio on 03/11/17.
 * @typeparam T This represents your model entity
 * @typeparam R This represents your repository that manages your T elements
 *
 */

public abstract class BaseViewModel<T, R extends UseCaseRepository<T>> extends AndroidViewModel {

    protected R useCaseRepository;

    public BaseViewModel(Application application) {
        super(application);
    }
}
