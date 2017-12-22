package com.example.raulstriglio.livedataroompoc.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.activity.MainActivity;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.fragments.FindUserFragment;
import com.example.raulstriglio.livedataroompoc.viewmodel.MainViewModel;

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

    @BindView(R.id.names_list)
    TextView mDbInfo;

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
                ((MainActivity) mBaseActivity.get()).goToFragmentWithStack(
                        R.id.fragment_container,
                        FindUserFragment.newInstance(),
                        FindUserFragment.getFindUserFragmentTag()
                );

                mClContainer.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void subscribeUiToLiveData() {
        mMainViewModel.getUsers().observe(mBaseActivity.get(), new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                if (users == null || users.size() <= 0) {
                    //Fetch date from API or Server
                } else {
                    //Fetched data from DataBase with Room
                    mUsers = users;
                    showDataInUi();
                }
            }
        });

        subscribeSearchOperationLiveData();
    }

    //Since this users list comes from a search query, we just have to check on our local DB.
    //After that, we could perform same ooperation after server ( Offline first approach )
    public void subscribeSearchOperationLiveData() {
        mMainViewModel.getFoundUsers().observe(mBaseActivity.get(), new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                if (((MainActivity) mBaseActivity.get()).getmCurrentFragment() != null) {
                    if (users == null || users.size() <= 0) {
                        //Query not yet performed
                    } else {
                        //Fetched data from DataBase with Room
                        ((MainActivity) mBaseActivity.get()).showFoundUsersInFragment(users);
                    }
                }
            }
        });
    }

    public void performSearch(String textToFind) {
        getViewModel().findUserByText(textToFind);
    }

    @OnClick(R.id.add_user)
    public void addUser() {

        String name = etName.getText().toString();
        String lastName = etLastName.getText().toString();

        if (!name.isEmpty() && !lastName.isEmpty()) {
            mMainViewModel.addUser(name, lastName);
        } else {
            Toast.makeText(mBaseActivity.get(), "Incomplete information", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void showDataInUi() {

        StringBuilder sb = new StringBuilder();
        for (User user : mUsers) {
            sb.append(user.name);
            sb.append(", ");
            sb.append(user.lastName);
            sb.append(", ");
            sb.append(user.getAddress().toString());
            sb.append("\n");
        }

        mDbInfo.setText(sb.toString());
    }

    public MainViewModel getViewModel() {
        return mMainViewModel;
    }

    public void onViewBackPressed(){
        mClContainer.setVisibility(View.VISIBLE);
    }
}
