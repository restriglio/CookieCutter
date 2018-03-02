package com.example.fragmentssampleapp.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.activity.MainActivity;
import com.example.fragmentssampleapp.fragment.FragmentHeroDetail;
import com.example.fragmentssampleapp.fragment.FragmentHeroList;
import com.example.fragmentssampleapp.fragment.FragmentHeroImage;
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


        tabColors = baseActivity.get().getApplicationContext().getResources().getIntArray(R.array.tab_colors);
        navigationAdapter = new AHBottomNavigationAdapter(baseActivity.get(), R.menu.bottom_navigation_menu_3);
        navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);

        bottomNavigation.setTranslucentNavigationEnabled(true);

        bottomNavigation.setDefaultBackgroundColor(ContextCompat.getColor(baseActivity.get(), R.color.colorPrimaryDark));
        bottomNavigation.setAccentColor(ContextCompat.getColor(baseActivity.get(), R.color.colorAccent));
        bottomNavigation.setInactiveColor(ContextCompat.getColor(baseActivity.get(), R.color.inactive_tabs));

        bottomNavigation.setOnTabSelectedListener(this);
        onTabSelected(0, false);
    }


    public AHBottomNavigation getNav() {
        return bottomNavigation;
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        // Pop off everything up to and including the current tab
        FragmentManager fragmentManager = baseActivity.get().getSupportFragmentManager();
        fragmentManager.popBackStack(BACK_STACK_MAIN_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);


        switch (position) {
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, FragmentHeroList.newInstance())
                        .addToBackStack(BACK_STACK_MAIN_TAG)
                        .commit();
                break;

            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, FragmentHeroDetail.newInstance(1))
                        .addToBackStack(BACK_STACK_MAIN_TAG)
                        .commit();
                break;

            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, FragmentHeroImage.newInstance(2))
                        .addToBackStack(BACK_STACK_MAIN_TAG)
                        .commit();
                break;

        }

        return true;
    }
}
