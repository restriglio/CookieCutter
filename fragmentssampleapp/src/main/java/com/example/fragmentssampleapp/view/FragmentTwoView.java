package com.example.fragmentssampleapp.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.db.entities.Hero;
import com.example.fragmentssampleapp.fragment.FragmentThree;
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

    private Observer<List<Hero>> mListObserver;
    private Hero mHero;
    private FragmentTwo fragmentTwo;

    TextView tvName;
    TextView tvRealName;
    TextView tvTeam;
    TextView tvFirst;
    TextView tvCreate;
    TextView tvPublisher;
    TextView tvBio;
    ImageView imageView;

    @Inject
    public FragmentTwoView(FragmentTwo fragmentTwo, FragmentViewModel baseViewModel) {
        super(fragmentTwo, baseViewModel);
        this.fragmentTwo = fragmentTwo;
    }

    public void loadHeroFromDB(int id) {
        mBaseViewModel.findbyId(id);
    }

    @Override
    //Since this users list comes from a search query, we just have to check our local DB.
    protected void subscribeUiToLiveData() {

        mListObserver = new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroes) {

                if (heroes == null && heroes.size() == 0) {
                    //Query not yet performed
                } else {
                    //data fetched from DataBase
                    mHero = heroes.get(0);
                    showDataInUi();
                }
            }
        };

        mBaseViewModel.getFoundHero().observe(mBaseActivity.get(), mListObserver);
    }

    @Override
    protected void showDataInUi() {
        tvName = fragmentTwo.getRootView().findViewById(R.id.tv_name);
        tvRealName = fragmentTwo.getRootView().findViewById(R.id.tv_real_name);
        tvTeam = fragmentTwo.getRootView().findViewById(R.id.tv_team);
        tvFirst = fragmentTwo.getRootView().findViewById(R.id.tv_first);
        tvCreate = fragmentTwo.getRootView().findViewById(R.id.tv_create);
        tvPublisher = fragmentTwo.getRootView().findViewById(R.id.tv_publisher);
        tvBio = fragmentTwo.getRootView().findViewById(R.id.tv_bio);
        imageView = fragmentTwo.getRootView().findViewById(R.id.imageView);

        tvName.setText(mHero.getName());
        tvRealName.setText(mHero.getRealname());
        tvTeam.setText(mHero.getTeam());
        tvFirst.setText(mHero.getFirstappearance());
        tvCreate.setText(mHero.getCreatedby());
        tvPublisher.setText(mHero.getPublisher());
        tvBio.setText(mHero.getBio());
        Picasso.with(fragmentTwo.getActivity()).load(mHero.getImageurl()).into(imageView);
    }
}
