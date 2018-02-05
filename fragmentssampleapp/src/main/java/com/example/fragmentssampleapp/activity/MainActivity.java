package com.example.fragmentssampleapp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.view.MainActivityView;
import com.example.modelviewviewmodel.activity.BaseActivity;
import com.example.modelviewviewmodel.fragment.BaseFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends BaseActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<android.support.v4.app.Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    MainActivityView mainActivityView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void injectThis() {
        AndroidInjection.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainActivityView.initView();
    }

    @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    /**
     * Add a fragment on top of the current tab
     */
    public void addFragmentOnTop(BaseFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(fragment.getFragmentTag())
                .commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragments = getSupportFragmentManager();
        Fragment homeFrag = fragments.findFragmentByTag("0");

        if (fragments.getBackStackEntryCount() > 1) {
            // We have fragments on the backstack that are poppable
            fragments.popBackStackImmediate();
        } else if (homeFrag == null || !homeFrag.isVisible()) {
            // We aren't showing the home screen, so that is the next stop on the back journey
            mainActivityView.getNav().setCurrentItem(0);
        } else {
            // We are already showing the home screen, so the next stop is out of the app.
            supportFinishAfterTransition();
        }
    }

}
