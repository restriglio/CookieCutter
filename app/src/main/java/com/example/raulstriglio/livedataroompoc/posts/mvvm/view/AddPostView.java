package com.example.raulstriglio.livedataroompoc.posts.mvvm.view;

import android.widget.Button;
import android.widget.EditText;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.db.entities.Post;
import com.example.raulstriglio.livedataroompoc.posts.activity.AddPostActivity;
import com.example.raulstriglio.livedataroompoc.posts.mvvm.viewmodel.AddPostViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by raul.striglio on 17/01/18.
 */

public class AddPostView extends BaseView<AddPostActivity, AddPostViewModel> {

    private AddPostViewModel mAddPostViewModel;

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
        this.mAddPostViewModel = addPostViewModel;
    }

    @Override
    protected void subscribeUiToLiveData() {

    }

    @Override
    protected void showDataInUi() {

    }

    @OnClick(R.id.add_post)
    public void addPost() {
        Post newPost = new Post();
        newPost.setUserId(mBaseActivity.get().getUserId());
        newPost.setBody(etBody.getText().toString());
        newPost.setTitle(etTitle.getText().toString());
        mAddPostViewModel.addPostToDb(newPost);
    }
}
