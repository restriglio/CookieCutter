package com.example.modelviewviewmodel.view;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

/**
 * Created by raul.striglio on 03/11/17.
 */

public abstract class BaseView<A extends LifecycleActivity, V extends ViewModel> {

    protected WeakReference<A> mBaseActivity;
    protected V mBaseViewModel;

    public BaseView(A baseActivity, V baseViewModel){
        mBaseActivity = new WeakReference<>(baseActivity);
        mBaseViewModel = baseViewModel;
        subscribeUiToLiveData();
    }

    protected abstract void subscribeUiToLiveData();
    protected abstract void showDataInUi();

    public V getViewModel() {
        return mBaseViewModel;
    }

}
