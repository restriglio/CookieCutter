package com.example.globant.livedataroompoc.posts.events;

import com.example.globant.livedataroompoc.db.entities.Post;

/**
 * Created by raul.striglio on 29/01/18.
 */

public class OnPostAddedSuccess {

    private Post post;

    public OnPostAddedSuccess(Post post){
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}