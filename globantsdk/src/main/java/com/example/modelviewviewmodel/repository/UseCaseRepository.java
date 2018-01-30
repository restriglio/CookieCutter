package com.example.modelviewviewmodel.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import java.util.List;

/**
 * Created by raul.striglio on 27/11/17.
 */

public abstract class UseCaseRepository<T> {


    protected Context mContext;
    protected LiveData<List<T>> mDataList = new MutableLiveData<>();

    public UseCaseRepository(Context context){
        mContext = context;
        initLocalData();
    }

    public abstract void initLocalData();
    public abstract void addData(T t);
    public abstract void addDataList(List<T> dataList);
    public abstract void requestDataToServer();

    public LiveData<List<T>> getDataList() {
        return mDataList;
    }

    public void setDataList(LiveData<List<T>> mDataList) {
        this.mDataList = mDataList;
    }
}
