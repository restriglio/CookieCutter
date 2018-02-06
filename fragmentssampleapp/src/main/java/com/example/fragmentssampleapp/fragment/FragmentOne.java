package com.example.fragmentssampleapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.view.FragmentOneView;
import com.example.modelviewviewmodel.fragment.BaseFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentOne extends BaseFragment {

    @Inject
    FragmentOneView fragmentOneView;

    RecyclerView mRecyclerView;

    public String getFragmentTag(){
        return FragmentOne.class.getSimpleName();
    }

    public static FragmentOne newInstance() {

        Bundle args = new Bundle();

        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);

        return view;

    }

    @Override
    protected void injectThis() {
        AndroidSupportInjection.inject(this);
    }

    public RecyclerView getmRecyclerView() {
        return mRecyclerView;
    }
}
