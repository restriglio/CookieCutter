package com.example.fragmentssampleapp.di.module;

import com.example.fragmentssampleapp.fragment.FragmentOne;
import com.example.fragmentssampleapp.fragment.FragmentThree;
import com.example.fragmentssampleapp.fragment.FragmentTwo;
import com.example.fragmentssampleapp.view.FragmentOneView;
import com.example.fragmentssampleapp.view.FragmentThreeView;
import com.example.fragmentssampleapp.view.FragmentTwoView;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 02/02/18.
 */

@Module
public class FragmentsModule {

    @Provides
    FragmentOneView bindsFragmentOneView(FragmentOne fragmentOne, FragmentViewModel baseViewModel) {
        return new FragmentOneView(fragmentOne, baseViewModel);
    }

    @Provides
    FragmentTwoView bindsFragmentTwoView(FragmentTwo fragmentTwo, FragmentViewModel fragmentViewModel) {
        return new FragmentTwoView(fragmentTwo, fragmentViewModel);
    }

    @Provides
    FragmentThreeView bindsFragmentThreeView(FragmentThree fragmentThree, FragmentViewModel fragmentViewModel) {
        return new FragmentThreeView(fragmentThree, fragmentViewModel);
    }
}
