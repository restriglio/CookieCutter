package com.example.fragmentssampleapp.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.activity.MainActivity;
import com.example.fragmentssampleapp.fragment.FragmentOne;
import com.example.fragmentssampleapp.fragment.FragmentThree;
import com.example.fragmentssampleapp.fragment.FragmentTwo;
import com.example.fragmentssampleapp.viewmodel.MainViewModel;
import com.example.modelviewviewmodel.view.BaseView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class MainActivityView extends BaseView<MainActivity, MainViewModel> implements AHBottomNavigation.OnTabSelectedListener {

    private static final String BACK_STACK_MAIN_TAG = "main_tab_fragment";

    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottomNavigation;

    private int[] tabColors;
    private AHBottomNavigationAdapter navigationAdapter;

    @Inject
    public MainActivityView(MainActivity baseActivity, MainViewModel baseViewModel) {
        super(baseActivity, baseViewModel);

        ButterKnife.bind(this, baseActivity);
    }

    @Override
    protected void subscribeUiToLiveData() {

    }

    @Override
    protected void showDataInUi() {

    }

    public void initView() {
        tabColors = mBaseActivity.get().getApplicationContext().getResources().getIntArray(R.array.tab_colors);
        navigationAdapter = new AHBottomNavigationAdapter(mBaseActivity.get(), R.menu.bottom_navigation_menu_3);
        navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);

        bottomNavigation.setTranslucentNavigationEnabled(true);

        bottomNavigation.setDefaultBackgroundColor(ContextCompat.getColor(mBaseActivity.get(), R.color.colorPrimaryDark));
        bottomNavigation.setAccentColor(ContextCompat.getColor(mBaseActivity.get(), R.color.colorAccent));
        bottomNavigation.setInactiveColor(ContextCompat.getColor(mBaseActivity.get(), R.color.inactive_tabs));

        bottomNavigation.setOnTabSelectedListener(this);
        onTabSelected(0, false);
    }


    public AHBottomNavigation getNav() {
        return bottomNavigation;
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        // Pop off everything up to and including the current tab
        FragmentManager fragmentManager = mBaseActivity.get().getSupportFragmentManager();
        fragmentManager.popBackStack(BACK_STACK_MAIN_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);


        switch (position) {
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, FragmentOne.newInstance())
                        .addToBackStack(BACK_STACK_MAIN_TAG)
                        .commit();
                break;

            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, FragmentTwo.newInstance(1))
                        .addToBackStack(BACK_STACK_MAIN_TAG)
                        .commit();
                break;

            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, FragmentThree.newInstance(2))
                        .addToBackStack(BACK_STACK_MAIN_TAG)
                        .commit();
                break;

        }

        return true;
    }
}
