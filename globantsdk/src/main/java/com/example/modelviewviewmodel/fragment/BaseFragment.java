package com.example.modelviewviewmodel.fragment;

import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by raul.striglio on 01/02/18.
 */

public abstract class BaseFragment extends LifecycleFragment {

    /*
      The next two commented lines are an example of how to inject the view into the Fragment using dagger 2.11
      in order to resolve this dependency, to have our view instantiated.

      @Inject
      BaseView baseView;

    */
    private View rootview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectThis();
    }


    /* Implement this  method to allow injection into this activity
     *  e.g: implement with 'AndroidInjection.inject(this);'
     *
     */
    protected abstract void injectThis();
    public abstract String getFragmentTag();

    /*public View getRootview() {
        return rootview;
    }*/
}
