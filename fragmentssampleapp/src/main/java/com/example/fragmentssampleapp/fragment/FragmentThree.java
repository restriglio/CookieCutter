package com.example.fragmentssampleapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.view.FragmentThreeView;
import com.example.modelviewviewmodel.fragment.BaseFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentThree extends BaseFragment {

    @Inject
    FragmentThreeView fragmentThreeView;

    public static FragmentThree newInstance() {
        Bundle args = new Bundle();

        FragmentThree fragment = new FragmentThree();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
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
