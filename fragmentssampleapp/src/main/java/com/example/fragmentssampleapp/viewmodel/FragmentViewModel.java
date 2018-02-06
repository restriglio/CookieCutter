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

public class FragmentViewModel extends BaseViewModel {

    @Inject
    public FragmentViewModel(Application application, HeroRepository useCaseRepository) {
        super(application);
        this.useCaseRepository = useCaseRepository;
    }

    public LiveData<List<Hero>> getHeroes() {
        return useCaseRepository.getDataList();
    }

    public LiveData<Hero> getHero() {
        return useCaseRepository.getDataList();
    }

    public void fetchHerosFromServer() {
        useCaseRepository.requestDataToServer();
    }
}
