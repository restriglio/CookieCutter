package com.example.fragmentssampleapp.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.example.fragmentssampleapp.db.entities.Hero;
import com.example.fragmentssampleapp.fragment.FragmentTwo;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;
import com.example.modelviewviewmodel.view.BaseView;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentTwoView extends BaseView<FragmentTwo, FragmentViewModel> {

    private List<Hero> mHeroes;

    FragmentTwo fragmentTwo;

    @Inject
    public FragmentTwoView(FragmentTwo fragmentTwo, FragmentViewModel baseViewModel) {
        super(fragmentTwo, baseViewModel);
        this.fragmentTwo = fragmentTwo;
    }

    @Override
    protected void subscribeUiToLiveData() {
        mBaseViewModel.getHeroes().observe(mBaseActivity.get(), new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroes) {

                if (heroes == null || heroes.size() <= 0) {
                    //Fetch data from API or Server
                    mBaseViewModel.fetchHerosFromServer();
                } else {
                    //Data fetched from DataBase
                    mHeroes = heroes;
                    showDataInUi();
                }
            }
        });
    }

    @Override
    protected void showDataInUi() {
        Hero hero = mHeroes.get(0);
        fragmentTwo.getTvName().setText(hero.getName());
    }
}
