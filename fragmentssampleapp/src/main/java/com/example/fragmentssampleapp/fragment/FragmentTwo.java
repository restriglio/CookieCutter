package com.example.fragmentssampleapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.global.Constants;
import com.example.fragmentssampleapp.view.FragmentTwoView;
import com.example.modelviewviewmodel.fragment.BaseFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentTwo extends BaseFragment {

    @Inject
    FragmentTwoView fragmentTwoView;

    private int id;

    public static FragmentTwo newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt(Constants.HERO_ID, id);
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        id = getArguments().getInt(Constants.HERO_ID);
        setRootview(inflater.inflate(R.layout.fragment_three, container, false));
        return getRootview();
    }

    @Override
    public void onResume() {
        super.onResume();
        fragmentTwoView.loadHeroFromDB(id);
    }

    @Override
    protected void injectThis() {
        AndroidSupportInjection.inject(this);
    }

    @Override
    public String getFragmentTag() {
        return null;
    }

    public FragmentTwoView getFragmentTwoView() {
        return fragmentTwoView;
    }
}
