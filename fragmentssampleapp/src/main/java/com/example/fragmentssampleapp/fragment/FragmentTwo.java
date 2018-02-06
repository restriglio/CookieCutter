package com.example.fragmentssampleapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.view.FragmentTwoView;
import com.example.modelviewviewmodel.fragment.BaseFragment;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentTwo extends BaseFragment {

    @Inject
    FragmentTwoView fragmentTwoView;

    TextView tvName;
    TextView tvRealName;
    TextView tvTeam;
    TextView tvFirst;
    TextView tvCreate;
    TextView tvPublisher;
    TextView tvBio;
    ImageView imageView;

    public static FragmentTwo newInstance() {

        Bundle args = new Bundle();

        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        tvName = view.findViewById(R.id.tv_name);
        tvRealName = view.findViewById(R.id.tv_real_name);
        tvTeam = view.findViewById(R.id.tv_team);
        tvFirst = view.findViewById(R.id.tv_first);
        tvCreate = view.findViewById(R.id.tv_create);
        tvPublisher = view.findViewById(R.id.tv_publisher);
        tvBio = view.findViewById(R.id.tv_bio);
        imageView = view.findViewById(R.id.imageView);

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

    public FragmentTwoView getFragmentTwoView() {
        return fragmentTwoView;
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvRealName() {
        return tvRealName;
    }

    public TextView getTvTeam() {
        return tvTeam;
    }

    public TextView getTvFirst() {
        return tvFirst;
    }

    public TextView getTvCreate() {
        return tvCreate;
    }

    public TextView getTvPublisher() {
        return tvPublisher;
    }

    public TextView getTvBio() {
        return tvBio;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
