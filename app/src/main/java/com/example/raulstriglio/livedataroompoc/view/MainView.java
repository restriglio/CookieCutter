package com.example.raulstriglio.livedataroompoc.view;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.activity.MainActivity;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.modelview.MainViewModel;

import java.lang.ref.WeakReference;
import java.lang.reflect.AccessibleObject;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class MainView extends BaseView {

    private MainViewModel mMainViewModel;
    private List<User> mUsers;

    @BindView(R.id.db_info)
    TextView mDbInfo;

    @BindView(R.id.add_user)
    Button button;

    public MainView(MainActivity mainActivity, MainViewModel mainViewModel ){
        super(mainActivity);

        ButterKnife.bind(this, mainActivity);
        mMainViewModel = mainViewModel;
        initLiveData();
    }

    @Override
    protected void subscribeUiToLiveData() {
        mMainViewModel.getUsers().observe(mBaseActivity.get(), new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                mUsers = users;
                showDataInUi();
            }
        });
    }

    @OnClick(R.id.add_user)
    public void addUser(){
        mMainViewModel.addUser();
    }

    @Override
    protected void showDataInUi() {

        StringBuilder sb = new StringBuilder();
        for (User user: mUsers) {
            sb.append(user.name);
            sb.append(",");
            sb.append(user.lastName);
            sb.append("\n");
        }

        mDbInfo.setText(sb.toString());
        Toast.makeText(mBaseActivity.get(), sb.toString(), Toast.LENGTH_SHORT).show();
    }
}
