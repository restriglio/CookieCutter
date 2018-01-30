package com.example.globant.livedataroompoc.posts.services;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.example.globant.livedataroompoc.BuildConfig;
import com.example.globant.livedataroompoc.global.Constants;
import com.example.globant.livedataroompoc.db.entities.Post;
import com.example.globant.livedataroompoc.posts.events.OnPostAddedSuccess;
import com.example.globant.livedataroompoc.utils.BusProvider;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by raul.striglio on 23/01/18.
 */

public class PostJob extends Job {

    private Post post;

    public PostJob(Post post) {
        super(new Params(1).requireNetwork().persist());
        this.post = post;
    }

    @Override
    public void onAdded() {
        //Change post status on DB or view
        Log.d("","");
    }

    @Override
    public void onRun() throws Throwable {


        final CompositeDisposable disposable = new CompositeDisposable();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder().build()).build();

        PostApiService mClient = retrofit.create(PostApiService.class);

        final String postId = post.getId();

        /*
         *  The server returns error if we don't clean up the id.
         *  To see on error behavior, uncomment this line.
         */

        post.setId(null);

        mClient.addPost(post).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Post>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(Post post) {
                        post.setStatus(Constants.STATUS_SYNCED);
                        post.setId(postId);
                        disposable.dispose();
                        BusProvider.getInstance().post(new OnPostAddedSuccess(post));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("error", e.getMessage());
                        post.setStatus(Constants.STATUS_ERROR);
                        disposable.dispose();
                        BusProvider.getInstance().post(new OnPostAddedSuccess(post));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
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
