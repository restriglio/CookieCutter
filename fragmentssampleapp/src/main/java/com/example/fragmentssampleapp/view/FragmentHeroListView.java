package com.example.fragmentssampleapp.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.db.entities.Hero;
import com.example.fragmentssampleapp.fragment.FragmentHeroList;
import com.example.fragmentssampleapp.view.adapters.HeroAdapter;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;
import com.example.modelviewviewmodel.view.BaseView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentHeroListView extends BaseView<FragmentHeroList, FragmentViewModel> {

    private List<Hero> mHeroes;

    private RecyclerView mRecyclerView;

    private FragmentHeroList fragmentHeroList;

    @Inject
    public FragmentHeroListView(FragmentHeroList fragmentHeroList, FragmentViewModel baseViewModel) {
        super(fragmentHeroList, baseViewModel);
        this.fragmentHeroList = fragmentHeroList;
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
        mRecyclerView = fragmentHeroList.getRootview().findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mBaseActivity.get().getActivity());
        HeroAdapter heroAdapter = new HeroAdapter(mHeroes, mBaseActivity.get().getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(heroAdapter);
        heroAdapter.notifyDataSetChanged();
    }
}
