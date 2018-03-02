package com.example.modelviewviewmodel.view;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleRegistryOwner;

import java.lang.ref.WeakReference;

/**
 * Created by raul.striglio on 03/11/17.
 *
 * @typeparam A This represents your Activity related to this view
 * @typeparam V This represents your own implementation of BaseViewModel
 *
 */

public abstract class BaseView<A extends LifecycleRegistryOwner, V extends AndroidViewModel> {

    protected WeakReference<A> baseActivity;
    protected V baseViewModel;

    public BaseView(A baseActivity, V baseViewModel){
        this.baseActivity = new WeakReference<>(baseActivity);
        this.baseViewModel = baseViewModel;
        subscribeUiToLiveData();
    }

    /* In this method you must define your observer in order to receive the LiveData changes managed
     * by the BaseViewModel.
     *
     *  e.g:
     *  We have a ViewModel that contains LiveData data that must be observed by our view,
     *  in order to react to changes in such data and show it calling showDataInUi method
     *
     *  baseViewModel.getDataList().observer(baseActivity.get(),new Observer<List<User>>() {
     *       @Override
     *       public void onChanged(@Nullable List<User> users) {
     *           showDataInUi();
     *       }
     *   });
     *
     *
     * */
    protected abstract void subscribeUiToLiveData();

    /* Show the observed live data in your view  */
    protected abstract void showDataInUi();

    public V getViewModel() {
        return baseViewModel;
    }

}
