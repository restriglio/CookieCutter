package com.example.globant.livedataroompoc.users.view;

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
import com.example.globant.livedataroompoc.R;
import com.example.globant.livedataroompoc.users.activity.FindUserActivity;
import com.example.globant.livedataroompoc.db.entities.User;
import com.example.globant.livedataroompoc.users.viewmodel.FindUserViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 09/01/18.
 */

public class FindUserView extends BaseView<FindUserActivity, FindUserViewModel> {


    @BindView(R.id.found_user)
    TextView foundUser;

    @BindView(R.id.et_text_to_find)
    EditText etTextToFind;

    @BindView(R.id.pb_search)
    RelativeLayout mPbSearch;

    private Handler mHandler;
    private Runnable delayedAction = null;
    private List<User> mUsers;
    private Observer<List<User>> mListObserver;

    private boolean viewConfigured = false;

    @Inject
    public FindUserView(FindUserActivity baseActivity, FindUserViewModel findUserViewModel) {
        super(baseActivity, findUserViewModel);
        ButterKnife.bind(this, baseActivity);
        configureView();
    }

    public void configureView() {
        mHandler = new Handler();

        etTextToFind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                if (delayedAction != null) {
                    mHandler.removeCallbacks(delayedAction);
                }

                if (editable.toString() != null && !editable.toString().isEmpty()) {
                    delayedAction = new Runnable() {
                        @Override
                        public void run() {
                            mPbSearch.setVisibility(View.VISIBLE);
                            etTextToFind.setVisibility(View.GONE);
                            foundUser.setVisibility(View.GONE);
                            startSearching(editable.toString());
                        }
                    };

                    mHandler.postDelayed(delayedAction, 1000);
                }
            }
        });

        viewConfigured = true;
    }

    public void startSearching(String textToFind) {
        mBaseViewModel.findUserByText(textToFind);
    }

    public void showFoundUsers(String users) {
        mPbSearch.setVisibility(View.GONE);
        etTextToFind.setVisibility(View.VISIBLE);
        foundUser.setVisibility(View.VISIBLE);
        foundUser.setText(users);
    }

    public void noUserFound() {
        mPbSearch.setVisibility(View.GONE);
        etTextToFind.setVisibility(View.VISIBLE);
        foundUser.setVisibility(View.VISIBLE);
        Toast.makeText(mBaseActivity.get(), "No se encontro resutado", Toast.LENGTH_SHORT).show();
    }

    @Override
    //Since this users list comes from a search query, we just have to check our local DB.
    protected void subscribeUiToLiveData() {

        mListObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                if(viewConfigured) {
                    if (users == null || users.size() <= 0) {
                        //Query not yet performed
                        noUserFound();
                    } else {
                        //data fetched from DataBase
                        mUsers = users;
                        showDataInUi();
                    }
                }
            }
        };

        mBaseViewModel.getFoundUsers().observe(mBaseActivity.get(), mListObserver);
    }

    public void removeObserver() {
        mBaseViewModel.getFoundUsers().removeObserver(mListObserver);
        mBaseViewModel.clearFoundUsers();
    }

    @Override
    protected void showDataInUi() {
        StringBuilder sb = new StringBuilder();
        for (User user : mUsers) {
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
