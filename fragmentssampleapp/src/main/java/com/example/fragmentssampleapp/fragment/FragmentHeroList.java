package com.example.fragmentssampleapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.view.FragmentHeroListView;
import com.example.modelviewviewmodel.fragment.BaseFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentHeroList extends BaseFragment {

    @Inject
    FragmentHeroListView fragmentHeroListView;

    public static FragmentHeroList newInstance() {

        Bundle args = new Bundle();

        FragmentHeroList fragment = new FragmentHeroList();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRootview(inflater.inflate(R.layout.fragment_hero_list, container, false));
        return getRootview();

    }

    @Override
    protected void injectThis() {
        AndroidSupportInjection.inject(this);
    }

    @Override
    public String getFragmentTag() {
        return FragmentHeroList.class.getSimpleName();
    }
}
