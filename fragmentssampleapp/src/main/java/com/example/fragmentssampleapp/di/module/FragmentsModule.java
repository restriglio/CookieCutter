package com.example.fragmentssampleapp.di.module;

import com.example.fragmentssampleapp.fragment.FragmentHeroList;
import com.example.fragmentssampleapp.fragment.FragmentHeroImage;
import com.example.fragmentssampleapp.fragment.FragmentHeroDetail;
import com.example.fragmentssampleapp.view.FragmentHeroImageView;
import com.example.fragmentssampleapp.view.FragmentHeroListView;
import com.example.fragmentssampleapp.view.FragmentHeroDetailView;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 02/02/18.
 */

@Module
public class FragmentsModule {

    @Provides
    FragmentHeroListView bindsFragmentOneView(FragmentHeroList fragmentHeroList, FragmentViewModel baseViewModel) {
        return new FragmentHeroListView(fragmentHeroList, baseViewModel);
    }

    @Provides
    FragmentHeroDetailView bindsFragmentTwoView(FragmentHeroDetail fragmentHeroDetail, FragmentViewModel fragmentViewModel) {
        return new FragmentHeroDetailView(fragmentHeroDetail, fragmentViewModel);
    }

    @Provides
    FragmentHeroImageView bindsFragmentThreeView(FragmentHeroImage fragmentHeroImage, FragmentViewModel fragmentViewModel) {
        return new FragmentHeroImageView(fragmentHeroImage, fragmentViewModel);
    }
}
