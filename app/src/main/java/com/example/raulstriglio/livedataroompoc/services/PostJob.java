package com.example.raulstriglio.livedataroompoc.services;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.example.raulstriglio.livedataroompoc.db.entities.Post;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 23/01/18.
 */

public class PostJob extends Job {

    @Inject
    PostApiService mClient;

    private Post post;

    protected PostJob(Params params, Post post) {
        super(params);
        this.post = post;
        //super(new Params(1).requireNetwork().persist());
    }

    @Override
    public void onAdded() {
        //Change post status on DB or view
    }

    @Override
    public void onRun() throws Throwable {
        mClient.addPost(post);
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {
        //manage error
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {

        /*
        Check error 400 o 500
         return RetryConstraint.CANCEL;
         */

        return RetryConstraint.RETRY;
    }
}
