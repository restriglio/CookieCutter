package com.example.modelviewviewmodel.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import java.util.List;

/**
 * Created by raul.striglio on 27/11/17.
 *
 * @typeparam T This represents your model entity
 *
 */

public abstract class UseCaseRepository<T> {


    protected Context context;

    /* LiveData to manage a list of T elements */
    protected LiveData<List<T>> dataList = new MutableLiveData<>();

    /* LiveData to manage a T element */
    protected LiveData<T> mData = new MutableLiveData<>();

    public UseCaseRepository(Context context){
        this.context = context;
        initLocalData();
    }

    /* Initialize and configure local Room database  */
    public abstract void initLocalData();

    /* Add a T element into the databse */
    public abstract void addData(T t);

    /* Add a list of T into the database */
    public abstract void addDataList(List<T> dataList);

    /* method that returns the local LiveData list. This method must be observed in your view */
    public LiveData<List<T>> getDataList() {
        return dataList;
    }

    public void setDataList(LiveData<List<T>> mDataList) {
        this.dataList = mDataList;
    }

    /* Implements the logic to request the data to the server with RxAndroid */
    public abstract void requestDataToServer();

}
