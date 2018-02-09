package com.example.fragmentssampleapp.view;

import android.arch.lifecycle.Observer;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.db.entities.Hero;
import com.example.fragmentssampleapp.fragment.FragmentHeroImage;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;
import com.example.modelviewviewmodel.view.BaseView;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentHeroImageView extends BaseView<FragmentHeroImage, FragmentViewModel> {

    private Observer<List<Hero>> mListObserver;
    private Hero mHero;
    private FragmentHeroImage fragmentHeroImage;

    private TextView tvTitle;
    private ImageView imageView;

    @Inject
    public FragmentHeroImageView(FragmentHeroImage fragmentHeroImage, FragmentViewModel baseViewModel) {
        super(fragmentHeroImage, baseViewModel);
        this.fragmentHeroImage = fragmentHeroImage;
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
        tvTitle = fragmentHeroImage.getRootview().findViewById(R.id.tv_title);
        imageView = fragmentHeroImage.getRootview().findViewById(R.id.imageView);

        tvTitle.setText(mHero.getName());
        setFont(mHero.getId(), tvTitle);
        Picasso.with(fragmentHeroImage.getActivity()).load(mHero.getImageurl()).into(imageView);
    }

    public void setFont(int id, TextView text) {
        if (id == 1) {
            text.setTypeface(Typeface.createFromAsset(fragmentHeroImage.getActivity().getAssets(), "fonts/capitan.ttf"));
        } else if (id == 2) {
            text.setTypeface(Typeface.createFromAsset(fragmentHeroImage.getActivity().getAssets(), "fonts/iron_man.ttf"));
        } else if (id == 3) {
            text.setTypeface(Typeface.createFromAsset(fragmentHeroImage.getActivity().getAssets(), "fonts/wolverine.ttf"));
        } else if (id == 4) {
            text.setTypeface(Typeface.createFromAsset(fragmentHeroImage.getActivity().getAssets(), "fonts/spider.ttf"));
        } else if (id == 5) {
            text.setTypeface(Typeface.createFromAsset(fragmentHeroImage.getActivity().getAssets(), "fonts/thor.ttf"));
        }
    }
}
