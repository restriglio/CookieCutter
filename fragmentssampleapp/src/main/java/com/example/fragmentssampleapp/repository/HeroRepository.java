package com.example.fragmentssampleapp.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.fragmentssampleapp.db.AppDatabase;
import com.example.fragmentssampleapp.db.entities.Hero;
import com.example.fragmentssampleapp.services.HeroApiService;
import com.example.modelviewviewmodel.repository.UseCaseRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ciro.oyarzun on 05-Feb-18.
 */

@Singleton
public class HeroRepository extends UseCaseRepository<Hero> {

    private AppDatabase mDataBase;
    private HeroApiService mClient;
    private CompositeDisposable disposable;

    private MutableLiveData<List<Hero>> mHeroesList = new MutableLiveData<>();

    @Inject
    public HeroRepository(Application context, HeroApiService client) {
        super(context);
        mContext = context;
        mClient = client;
        disposable = new CompositeDisposable();
    }

    public void initLocalData() {
        mDataBase = AppDatabase.getInMemoryDatabase(mContext);
        setDataList(mDataBase.heroModel().loadAllHeros());
    }

    @Override
    public void addData(Hero hero) {
        mDataBase.heroModel().insertHero(hero);
    }

    @Override
    public void addDataList(List<Hero> dataList) {
        mDataBase.heroModel().insertAll(dataList);
        setDataList(mDataBase.heroModel().loadAllHeros());
    }

    @Override
    public void requestDataToServer() {
        mClient.getHeros().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Hero>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<Hero> heroes) {
                        addDataList(heroes);
                        disposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<List<Hero>> findHero(int id) {

        mHeroesList.setValue(mDataBase.heroModel().findById(id));
        return getFoundHeroList();
    }

    public MutableLiveData<List<Hero>> getFoundHeroList() {
        return mHeroesList;
    }
}
