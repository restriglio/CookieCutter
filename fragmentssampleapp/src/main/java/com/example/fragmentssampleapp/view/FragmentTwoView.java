package com.example.fragmentssampleapp.view;

import com.example.fragmentssampleapp.fragment.FragmentTwo;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;
import com.example.modelviewviewmodel.view.BaseView;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentTwoView extends BaseView<FragmentTwo, FragmentViewModel> {

    @Inject
    public FragmentTwoView(FragmentTwo fragmentTwo, FragmentViewModel baseViewModel) {
        super(fragmentTwo, baseViewModel);
    }

    @Override
    protected void subscribeUiToLiveData() {

    }

    @Override
    protected void showDataInUi() {

    }
}
