package com.example.fragmentssampleapp.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.db.entities.Hero;
import com.example.fragmentssampleapp.fragment.FragmentOne;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;
import com.example.modelviewviewmodel.view.BaseView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentOneView extends BaseView<FragmentOne, FragmentViewModel> {

    private List<Hero> mHeroes;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    public FragmentOneView(FragmentOne fragmentOne, FragmentViewModel baseViewModel) {
        super(fragmentOne, baseViewModel);
        ButterKnife.bind(this, fragmentOne);
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mBaseActivity.get().getActivity());
        HeroAdapter heroAdapter = new HeroAdapter(mHeroes, mBaseActivity.get().getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(heroAdapter);
        heroAdapter.notifyDataSetChanged();
    }
}
