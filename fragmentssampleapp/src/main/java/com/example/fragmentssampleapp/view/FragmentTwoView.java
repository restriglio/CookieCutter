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

    private TextView tvName;
    private TextView tvRealName;
    private TextView tvTeam;
    private TextView tvFirst;
    private TextView tvCreate;
    private TextView tvPublisher;
    private TextView tvBio;
    private ImageView imageView;

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
        tvName = fragmentTwo.getRootview().findViewById(R.id.tv_name);
        tvRealName = fragmentTwo.getRootview().findViewById(R.id.tv_real_name);
        tvTeam = fragmentTwo.getRootview().findViewById(R.id.tv_team);
        tvFirst = fragmentTwo.getRootview().findViewById(R.id.tv_first);
        tvCreate = fragmentTwo.getRootview().findViewById(R.id.tv_create);
        tvPublisher = fragmentTwo.getRootview().findViewById(R.id.tv_publisher);
        tvBio = fragmentTwo.getRootview().findViewById(R.id.tv_bio);
        imageView = fragmentTwo.getRootview().findViewById(R.id.imageView);

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
