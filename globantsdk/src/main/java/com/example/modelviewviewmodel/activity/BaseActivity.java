package com.example.modelviewviewmodel.activity;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by raul.striglio on 03/11/17.
 */

public abstract class BaseActivity extends LifecycleActivity {


    /*

      The next two commented lines are an example of how to inject the view into the activity using dagger 2.11
      in order to resolve this dependency, to have our view instantiated.

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
