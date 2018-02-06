package com.example.fragmentssampleapp.view;

import com.example.fragmentssampleapp.db.entities.Hero;
import com.example.fragmentssampleapp.fragment.FragmentOne;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;
import com.example.modelviewviewmodel.view.BaseView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentOneView extends BaseView<FragmentOne, FragmentViewModel> {

    private List<Hero> mHeroes;

    @Inject
    public FragmentOneView(FragmentOne fragmentOne, FragmentViewModel baseViewModel) {
        super(fragmentOne, baseViewModel);
    }

    @Override
    protected void subscribeUiToLiveData() {
        /*mBaseViewModel.getHeroes().observe(mBaseActivity.get(), new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroes) {

                if (heroes == null || heroes.size() <= 0) {
                    //Fetch data from API or Server
                    mBaseViewModel.fetchHerosFromServer();
                } else {
                    //Data fetched from DataBase
                    mHeroes = heroes;
                    showDataInUi();
                    initView();
                }
            }
        });*/
    }

    @Override
    protected void showDataInUi() {
        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mBaseActivity.get());
        HeroAdapter heroAdapter = new HeroAdapter(mHeroes, mBaseActivity.get());
        mHerosRecyclerView.setLayoutManager(linearLayoutManager);
        mHerosRecyclerView.setAdapter(heroAdapter);
        heroAdapter.notifyDataSetChanged();*/
    }
}
