package com.example.globant.sampleapp.users.view;

import android.arch.lifecycle.Observer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.globant.sampleapp.R;
import com.example.globant.sampleapp.users.activity.FindUserActivity;
import com.example.globant.sampleapp.db.entities.User;
import com.example.globant.sampleapp.users.viewmodel.FindUserViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 09/01/18.
 */

public class FindUserView extends BaseView<FindUserActivity, FindUserViewModel> {


    @BindView(R.id.foundUsers)
    TextView foundUsers;

    @BindView(R.id.textInputToFind)
    EditText textInputToFind;

    @BindView(R.id.progressBarContainer)
    RelativeLayout progressBarContainer;

    private Handler handler;
    private Runnable delayedAction = null;
    private List<User> usersList;
    private Observer<List<User>> usersListObserver;

    private boolean viewConfigured = false;

    @Inject
    public FindUserView(FindUserActivity baseActivity, FindUserViewModel findUserViewModel) {
        super(baseActivity, findUserViewModel);
        ButterKnife.bind(this, baseActivity);
        configureView();
    }

    public void configureView() {
        handler = new Handler();

        textInputToFind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                if (delayedAction != null) {
                    handler.removeCallbacks(delayedAction);
                }

                if (editable.toString() != null && !editable.toString().isEmpty()) {
                    delayedAction = new Runnable() {
                        @Override
                        public void run() {
                            progressBarContainer.setVisibility(View.VISIBLE);
                            textInputToFind.setVisibility(View.GONE);
                            foundUsers.setVisibility(View.GONE);
                            startSearching(editable.toString());
                        }
                    };

                    handler.postDelayed(delayedAction, 1000);
                }
            }
        });

        viewConfigured = true;
    }

    public void startSearching(String textToFind) {
        baseViewModel.findUserByText(textToFind);
    }

    public void showFoundUsers(String users) {
        progressBarContainer.setVisibility(View.GONE);
        textInputToFind.setVisibility(View.VISIBLE);
        foundUsers.setVisibility(View.VISIBLE);
        foundUsers.setText(users);
    }

    public void noUserFound() {
        progressBarContainer.setVisibility(View.GONE);
        textInputToFind.setVisibility(View.VISIBLE);
        foundUsers.setVisibility(View.VISIBLE);
        Toast.makeText(baseActivity.get(), "No se encontro resutado", Toast.LENGTH_SHORT).show();
    }

    @Override
    //Since this users list comes from a search query, we just have to check our local DB.
    protected void subscribeUiToLiveData() {

        usersListObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                if(viewConfigured) {
                    if (users == null || users.size() <= 0) {
                        //Query not yet performed
                        noUserFound();
                    } else {
                        //data fetched from DataBase
                        usersList = users;
                        showDataInUi();
                    }
                }
            }
        };

        baseViewModel.getFoundUsers().observe(baseActivity.get(), usersListObserver);
    }

    public void removeObserver() {
        baseViewModel.getFoundUsers().removeObserver(usersListObserver);
        baseViewModel.clearFoundUsers();
    }

    @Override
    protected void showDataInUi() {
        StringBuilder sb = new StringBuilder();
        for (User user : usersList) {
            sb.append(user.name);
            sb.append(", ");
            sb.append(user.userName);
            sb.append(", ");
            sb.append(user.getAddress().toString());
            sb.append("\n");
        }

        showFoundUsers(sb.toString());
    }
}
