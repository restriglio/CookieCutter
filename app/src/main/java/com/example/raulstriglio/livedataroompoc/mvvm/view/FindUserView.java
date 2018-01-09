package com.example.raulstriglio.livedataroompoc.mvvm.view;

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
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.activity.FindUserActivity;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.FindUserViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 09/01/18.
 */

public class FindUserView extends BaseView<FindUserActivity> {


    @BindView(R.id.found_user)
    TextView foundUser;

    @BindView(R.id.et_text_to_find)
    EditText etTextToFind;

    @BindView(R.id.pb_search)
    RelativeLayout mPbSearch;

    private Handler mHandler;
    private Runnable delayedAction = null;
    private List<User> mUsers;

    private FindUserViewModel mFindUserViewModel;

    public FindUserView(FindUserActivity baseActivity, FindUserViewModel findUserViewModel) {
        super(baseActivity);
        this.mFindUserViewModel = findUserViewModel;
        ButterKnife.bind(this, baseActivity);

        configureView();
        initLiveData();
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
        });
    }

    public void startSearching(String textToFind) {
        mFindUserViewModel.findUserByText(textToFind);
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
    protected void subscribeUiToLiveData() {
        subscribeSearchOperationLiveData();
    }

    //Since this users list comes from a search query, we just have to check our local DB.
    //After that, we could perform same ooperation after server ( Offline first approach )
    public void subscribeSearchOperationLiveData() {
        mFindUserViewModel.getFoundUsers().observe(mBaseActivity.get(), new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                if (users == null || users.size() <= 0) {
                    //Query not yet performed
                    noUserFound();
                } else {
                    //Fetched data from DataBase with Room
                    mUsers = users;
                    showDataInUi();
                }
            }
        });
    }

    public void showFoundUsers(List<User> users) {

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
