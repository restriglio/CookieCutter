package com.example.fragmentssampleapp.view;

import com.example.fragmentssampleapp.fragment.FragmentOne;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;
import com.example.modelviewviewmodel.view.BaseView;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentOneView extends BaseView<FragmentOne, FragmentViewModel> {

    @Inject
    public FragmentOneView(FragmentOne fragmentOne, FragmentViewModel baseViewModel) {
        super(fragmentOne, baseViewModel);
    }

    @Override
    protected void subscribeUiToLiveData() {

    }

    @Override
    protected void showDataInUi() {

    }
}
