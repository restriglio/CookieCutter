package com.example.globant.sampleapp.posts.repositories;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.modelviewviewmodel.repository.UseCaseRepository;
import com.example.globant.sampleapp.db.AppDatabase;
import com.example.globant.sampleapp.db.entities.Post;
import com.example.globant.sampleapp.posts.services.PostApiService;

import java.util.List;
import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by raul.striglio on 18/01/18.
 */

public class PostRepository extends UseCaseRepository<Post> {

    private AppDatabase dataBase;
    private PostApiService client;
    private CompositeDisposable disposable;
    private String userId;


    @Inject
    public PostRepository(Application context, PostApiService client){
        super(context);
        this.context = context;
        this.client = client;
        disposable = new CompositeDisposable();
    }

    @Override
    public void initLocalData() {
        dataBase = AppDatabase.getInMemoryDatabase(context);
        setDataList(dataBase.postsModel().loadAllPosts());
    }

    @Override
    public void addData(Post post) {
        //not used yet
    }

    @Override
    public void addDataList(List<Post> dataList) {
        dataBase.postsModel().insertAll(dataList);
        setDataList(dataBase.postsModel().loadAllPosts());
    }

    public void setPostsDataListByUserId(String userId){
        MutableLiveData<List<Post>> listMutableLiveData = new MutableLiveData<>();
        listMutableLiveData.setValue(dataBase.postsModel().loadPostsByUser(userId));
        setDataList(listMutableLiveData);
    }

    @Override
    public void requestDataToServer() {
        client.getPosById(userId).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        dataBase.postsModel().insertAll(posts);
                        setPostsDataListByUserId(userId);
                        getDataList();
                        disposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("error", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void requestPostsToServerByUser(final String userId) {
        this.userId = userId;
        requestDataToServer();
    }
}
