package com.example.fragmentssampleapp.view;

import com.example.fragmentssampleapp.fragment.FragmentThree;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;
import com.example.modelviewviewmodel.view.BaseView;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class FragmentThreeView extends BaseView<FragmentThree, FragmentViewModel> {

    @Inject
    public FragmentThreeView(FragmentThree fragmentThree, FragmentViewModel baseViewModel) {
        super(fragmentThree, baseViewModel);
    }

    @Override
    protected void subscribeUiToLiveData() {

    }

    @Override
    protected void showDataInUi() {

    }
}
