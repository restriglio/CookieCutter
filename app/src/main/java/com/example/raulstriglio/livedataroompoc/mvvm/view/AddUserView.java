package com.example.raulstriglio.livedataroompoc.mvvm.view;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.activity.AddUserActivity;
import com.example.raulstriglio.livedataroompoc.db.entities.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by raul.striglio on 17/01/18.
 */

public class AddUserView extends BaseView<AddUserActivity> {

    @BindView(R.id.add_user)
    Button button;

    @BindView(R.id.et_name)
    EditText etName;

    @BindView(R.id.et_last_name)
    EditText etLastName;

    public AddUserView(AddUserActivity baseActivity) {
        super(baseActivity);
        ButterKnife.bind(this, baseActivity);
    }

    @Override
    protected void subscribeUiToLiveData() {

    }

    @Override
    protected void showDataInUi() {

    }

    @OnClick(R.id.add_user)
    public void addUser() {

        String name = etName.getText().toString();
        String userName = etLastName.getText().toString();

        if (!name.isEmpty() && !userName.isEmpty()) {
            User newUser = new User();
            newUser.name = name;
            newUser.userName = userName;
            //mMainViewModel.addUser(newUser);
        } else {
            Toast.makeText(mBaseActivity.get(), "Incomplete information", Toast.LENGTH_SHORT).show();
        }

    }
}
