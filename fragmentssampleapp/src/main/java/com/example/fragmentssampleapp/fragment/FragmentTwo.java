package com.example.fragmentssampleapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.view.FragmentTwoView;
import com.example.modelviewviewmodel.fragment.BaseFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentTwo extends BaseFragment {

    @Inject
    FragmentTwoView fragmentTwoView;

    public static FragmentTwo newInstance() {

        Bundle args = new Bundle();

        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    protected void injectThis() {
        AndroidSupportInjection.inject(this);
    }

    @Override
    public String getFragmentTag() {
        return null;
    }
}
