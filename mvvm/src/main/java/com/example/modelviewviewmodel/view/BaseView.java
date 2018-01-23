package com.example.modelviewviewmodel.view;

import java.lang.ref.WeakReference;

/**
 * Created by raul.striglio on 03/11/17.
 */

public abstract class BaseView<A, V> {

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
