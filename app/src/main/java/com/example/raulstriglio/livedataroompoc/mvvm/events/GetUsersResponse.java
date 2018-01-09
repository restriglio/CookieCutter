package com.example.raulstriglio.livedataroompoc.mvvm.events;

import com.example.raulstriglio.livedataroompoc.db.entities.User;

import java.util.List;

/**
 * Created by raul.striglio on 09/01/18.
 */

public class GetUsersResponse {

    private boolean mIsFaulted;
    private List<User> mUsers;
    private String mErrorMessage;

    public GetUsersResponse(boolean isFaulted, List<User> users){
        this.mIsFaulted = isFaulted;
        this.mUsers = users;
    }

    public GetUsersResponse(boolean isFaulted, String message){
        this.mIsFaulted = isFaulted;
        this.mErrorMessage = message;
    }

    public boolean ismIsFaulted() {
        return mIsFaulted;
    }


    public List<User> getmUsers() {
        return mUsers;
    }

    public String getmErrorMessage() {
        return mErrorMessage;
    }
}
