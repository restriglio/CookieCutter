package com.example.raulstriglio.livedataroompoc.network;

import android.arch.lifecycle.LiveData;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;

/**
 * Created by raul.striglio on 27/12/17.
 */

public abstract class NetworkBoundResource<ResultType, RequestType> {

    @WorkerThread
    protected abstract void saveCallResult(@NonNull RequestType item);

    @MainThread
    protected abstract boolean shouldFetch(@Nullable ResultType data);

    @NonNull
    @MainThread
    protected abstract LiveData<ResultType> loadFromDb();

    @NonNull @MainThread
    protected abstract LiveData<ApiResponse<RequestType>> createCall();

}
