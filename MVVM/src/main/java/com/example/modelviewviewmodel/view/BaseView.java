package com.example.modelviewviewmodel.view;

import android.app.Activity;

import com.example.modelviewviewmodel.activities.BaseActivity;

import java.lang.ref.WeakReference;

/**
 * Created by raul.striglio on 03/11/17.
 */

public abstract class BaseView {

    protected WeakReference<BaseActivity> mBaseActivity;
    public BaseView(BaseActivity baseActivity){
        mBaseActivity = new WeakReference<BaseActivity>(baseActivity);
    }

    protected void initLiveData(){
        subscribeUiToLiveData();
    }

    protected abstract void subscribeUiToLiveData();
    protected abstract void showDataInUi();

}
