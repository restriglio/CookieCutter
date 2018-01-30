package com.example.modelviewviewmodel.activities;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by raul.striglio on 03/11/17.
 */

public abstract class BaseActivity extends LifecycleActivity {


    /*
      The next two commented lines are an example of how to inject the view into the activity using dagger 2.11
      Dagger 2.11 must be used to resolve this dependency in order to have our view instanciated.

      @Inject
      BaseView baseView;

    */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        injectThis();
        super.onCreate(savedInstanceState);
    }


    /* Implement this  method to allow injection into this activity
     *  e.g: implement with 'AndroidInjection.inject(this);'
     *
     */
    protected abstract void injectThis();

}
