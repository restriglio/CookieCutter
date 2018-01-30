package com.example.globant.livedataroompoc.users.view;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.globant.livedataroompoc.R;
import com.example.globant.livedataroompoc.db.entities.User;
import com.example.globant.livedataroompoc.users.activity.FindUserActivity;
import com.example.globant.livedataroompoc.users.activity.MainActivity;
import com.example.globant.livedataroompoc.users.viewmodel.MainViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class MainView extends BaseView<MainActivity, MainViewModel> {

    private List<User> mUsers;

    @BindView(R.id.names_list)
    RecyclerView mUsersRecyclerView;

    @BindView(R.id.fund_user)
    Button mFundUser;

    @Inject
    public MainView(MainActivity mainActivity, MainViewModel mainViewModel) {
        super(mainActivity, mainViewModel);

        ButterKnife.bind(this, mainActivity);
        mFundUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent findeUser = new Intent(mBaseActivity.get(), FindUserActivity.class);
                mBaseActivity.get().startActivity(findeUser);
            }
        });
    }

    @Override
    protected void subscribeUiToLiveData() {
        mBaseViewModel.getUsers().observe(mBaseActivity.get(), new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                if (users == null || users.size() <= 0) {
                    //Fetch data from API or Server
                    mBaseViewModel.fetchUsersFromServer();
                } else {
                    //Data fetched from DataBase
                    mUsers = users;
                    showDataInUi();
                }
            }
        });
    }

    @Override
    protected void showDataInUi() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mBaseActivity.get());
        UserAdapter userAdapter = new UserAdapter(mUsers, mBaseActivity.get());
        mUsersRecyclerView.setLayoutManager(linearLayoutManager);
        mUsersRecyclerView.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();
    }
}
