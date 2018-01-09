package com.example.modelviewviewmodel.view;

import android.app.Activity;

import com.example.modelviewviewmodel.activities.BaseActivity;

import java.lang.ref.WeakReference;

/**
 * Created by raul.striglio on 03/11/17.
 */

public abstract class BaseView<T> {

    protected WeakReference<T> mBaseActivity;
    public BaseView(T baseActivity){
        mBaseActivity = new WeakReference<>(baseActivity);
    }

    protected void initLiveData(){
        subscribeUiToLiveData();
    }

    protected abstract void subscribeUiToLiveData();
    protected abstract void showDataInUi();

}
