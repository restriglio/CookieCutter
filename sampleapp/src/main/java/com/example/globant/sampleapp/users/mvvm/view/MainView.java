package com.example.globant.sampleapp.users.mvvm.view;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.globant.sampleapp.R;
import com.example.globant.sampleapp.db.entities.User;
import com.example.globant.sampleapp.users.activity.FindUserActivity;
import com.example.globant.sampleapp.users.activity.MainActivity;
import com.example.globant.sampleapp.users.mvvm.viewmodel.MainViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class MainView extends BaseView<MainActivity, MainViewModel> {

    private List<User> mUsers;

    @BindView(R.id.names)
    RecyclerView names;

    @BindView(R.id.fundUser)
    Button fundUser;

    @Inject
    public MainView(MainActivity mainActivity, MainViewModel mainViewModel) {
        super(mainActivity, mainViewModel);

        ButterKnife.bind(this, mainActivity);
        fundUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent findUser = new Intent(baseActivity.get(), FindUserActivity.class);
                baseActivity.get().startActivity(findUser);
            }
        });
    }

    @Override
    protected void subscribeUiToLiveData() {
        baseViewModel.getUsers().observe(baseActivity.get(), new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                if (users == null || users.size() <= 0) {
                    //There is no local data, so we have to fetch data from server
                    baseViewModel.fetchUsersFromServer();
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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseActivity.get());
        UserAdapter userAdapter = new UserAdapter(mUsers, baseActivity.get());
        names.setLayoutManager(linearLayoutManager);
        names.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();
    }
}
