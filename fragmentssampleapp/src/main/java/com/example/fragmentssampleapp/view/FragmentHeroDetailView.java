package com.example.fragmentssampleapp.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.activity.MainActivity;
import com.example.fragmentssampleapp.db.entities.Hero;
import com.example.fragmentssampleapp.fragment.FragmentHeroDetail;
import com.example.fragmentssampleapp.fragment.FragmentHeroImage;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;
import com.example.modelviewviewmodel.view.BaseView;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentHeroDetailView extends BaseView<FragmentHeroDetail, FragmentViewModel> {

    private Observer<List<Hero>> mListObserver;
    private Hero mHero;
    private FragmentHeroDetail fragmentHeroDetail;

    private TextView tvName;
    private TextView tvRealName;
    private TextView tvTeam;
    private TextView tvFirst;
    private TextView tvCreate;
    private TextView tvPublisher;
    private TextView tvBio;
    private ImageView imageView;

    @Inject
    public FragmentHeroDetailView(FragmentHeroDetail fragmentHeroDetail, FragmentViewModel baseViewModel) {
        super(fragmentHeroDetail, baseViewModel);
        this.fragmentHeroDetail = fragmentHeroDetail;
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
                    mBaseViewModel.fetchHerosFromServer();
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
        tvName = fragmentHeroDetail.getRootview().findViewById(R.id.tv_name);
        tvRealName = fragmentHeroDetail.getRootview().findViewById(R.id.tv_real_name);
        tvTeam = fragmentHeroDetail.getRootview().findViewById(R.id.tv_team);
        tvFirst = fragmentHeroDetail.getRootview().findViewById(R.id.tv_first);
        tvCreate = fragmentHeroDetail.getRootview().findViewById(R.id.tv_create);
        tvPublisher = fragmentHeroDetail.getRootview().findViewById(R.id.tv_publisher);
        tvBio = fragmentHeroDetail.getRootview().findViewById(R.id.tv_bio);
        imageView = fragmentHeroDetail.getRootview().findViewById(R.id.imageView);

        tvName.setText(mHero.getName());
        tvRealName.setText(mHero.getRealname());
        tvTeam.setText(mHero.getTeam());
        tvFirst.setText(mHero.getFirstappearance());
        tvCreate.setText(mHero.getCreatedby());
        tvPublisher.setText(mHero.getPublisher());
        tvBio.setText(mHero.getBio());
        Picasso.with(fragmentHeroDetail.getActivity()).load(mHero.getImageurl()).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentHeroImage fragment = FragmentHeroImage.newInstance(mHero.getId());
                ((MainActivity) fragmentHeroDetail.getActivity()).addFragmentOnTop(fragment);
            }
        });

    }
}
