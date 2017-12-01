package com.example.raulstriglio.livedataroompoc.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 01/12/17.
 */

public class FindUserFragment extends Fragment {

    @BindView(R.id.found_user)
    TextView foundUser;

    @BindView(R.id.et_text_to_find)
    EditText etTextToFind;

    private Handler mHandler;
    private Runnable delayedAction = null;

    public static FindUserFragment newInstance() {

        Bundle args = new Bundle();

        FindUserFragment fragment = new FindUserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static String getFindUserFragmentTag() {
        return FindUserFragment.class.getSimpleName();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View mRootView = inflater.inflate(R.layout.find_user_fragment, container, false);
        ButterKnife.bind(this, mRootView);
        return mRootView;

    }

    @Override
    public void onResume() {
        super.onResume();

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
                        startSearching(editable.toString());
                    }
                };

                mHandler.postDelayed(delayedAction, 1000);
            }
        });

    }

    public void startSearching(String textToFind) {
        ((MainActivity) getActivity()).getMainView().performSearch(textToFind);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
