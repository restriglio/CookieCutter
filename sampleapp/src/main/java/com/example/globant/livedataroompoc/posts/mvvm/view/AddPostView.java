package com.example.globant.livedataroompoc.posts.mvvm.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.globant.livedataroompoc.R;
import com.example.globant.livedataroompoc.db.entities.Post;
import com.example.globant.livedataroompoc.posts.activity.AddPostActivity;
import com.example.globant.livedataroompoc.posts.mvvm.viewmodel.AddPostViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by raul.striglio on 17/01/18.
 */

public class AddPostView extends BaseView<AddPostActivity, AddPostViewModel> {


    @BindView(R.id.add_post)
    Button button;

    @BindView(R.id.et_title)
    EditText etTitle;

    @BindView(R.id.et_body)
    EditText etBody;


    @Inject
    public AddPostView(AddPostActivity baseActivity, AddPostViewModel addPostViewModel) {
        super(baseActivity, addPostViewModel);
        ButterKnife.bind(this, baseActivity);
        mBaseViewModel.setmUserId(mBaseActivity.get().getUserId());
    }

    @Override
    protected void subscribeUiToLiveData() {
        mBaseViewModel.getAddedPost().observe(mBaseActivity.get(), new Observer<Post>() {
            @Override
            public void onChanged(@Nullable Post post) {
                if(post != null && post.getStatus() != null) {
                  mBaseActivity.get().onBackPressed();
                }
            }
        });
    }

    @Override
    protected void showDataInUi() {

    }

    @OnClick(R.id.add_post)
    public void addPost() {
        Post newPost = new Post();
        mBaseViewModel.setmUserId(mBaseActivity.get().getUserId());
        newPost.setUserId(mBaseActivity.get().getUserId());
        newPost.setBody(etBody.getText().toString());
        newPost.setTitle(etTitle.getText().toString());
        mBaseViewModel.addPostToDb(newPost);
    }
}
