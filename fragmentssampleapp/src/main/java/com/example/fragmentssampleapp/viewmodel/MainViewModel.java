package com.example.fragmentssampleapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.fragmentssampleapp.db.entities.Hero;
import com.example.fragmentssampleapp.repository.HeroRepository;
import com.example.modelviewviewmodel.viewmodel.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 02/02/18.
 */

public class MainViewModel extends BaseViewModel {

    @Inject
    public MainViewModel(Application application, HeroRepository useCaseRepository) {
        super(application);
        this.useCaseRepository = useCaseRepository;
    }

    public LiveData<List<Hero>> getHeroes() {
        return useCaseRepository.getDataList();
    }

    public void fetchHerosFromServer() {
        useCaseRepository.requestDataToServer();
    }
}