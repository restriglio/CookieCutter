package com.example.raulstriglio.livedataroompoc.mvvm.view;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.activity.MainActivity;
import com.example.raulstriglio.livedataroompoc.activity.UserAdapter;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.activity.FindUserActivity;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.MainViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class MainView extends BaseView<MainActivity> {

    private MainViewModel mMainViewModel;
    private List<User> mUsers;

    @BindView(R.id.names_list)
    RecyclerView mUsersRecyclerView;

    @BindView(R.id.add_user)
    Button button;

    @BindView(R.id.et_name)
    EditText etName;

    @BindView(R.id.et_last_name)
    EditText etLastName;

    @BindView(R.id.fund_user)
    Button mFundUser;

    @BindView(R.id.cl_container)
    ConstraintLayout mClContainer;

    @Inject
    public MainView(MainActivity mainActivity, MainViewModel mainViewModel) {
        super(mainActivity);

        ButterKnife.bind(this, mainActivity);
        mMainViewModel = mainViewModel;
        initLiveData();

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
        mMainViewModel.getUsers().observe(mBaseActivity.get(), new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                if (users == null || users.size() <= 0) {
                    //Fetch data from API or Server
                    mMainViewModel.requestUsersToServer();
                } else {
                    //Data fetched from DataBase
                    mUsers = users;
                    showDataInUi();
                }
            }
        });
    }

    @OnClick(R.id.add_user)
    public void addUser() {

        String name = etName.getText().toString();
        String userName = etLastName.getText().toString();

        if (!name.isEmpty() && !userName.isEmpty()) {
            User newUser = new User();
            newUser.name = name;
            newUser.userName = userName;
            mMainViewModel.addUser(newUser);
        } else {
            Toast.makeText(mBaseActivity.get(), "Incomplete information", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void showDataInUi() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mBaseActivity.get());
        UserAdapter userAdapter = new UserAdapter(mUsers);
        mUsersRecyclerView.setLayoutManager(linearLayoutManager);
        mUsersRecyclerView.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();
    }

    public MainViewModel getViewModel() {
        return mMainViewModel;
    }

    public void onViewBackPressed(){
        mClContainer.setVisibility(View.VISIBLE);
    }
}
