package com.example.fragmentssampleapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ciro.oyarzun on 05-Feb-18.
 */

@Entity(tableName = "hero", indices = @Index(value = {"id"}))
public class Hero implements Serializable {

    @SerializedName("id")
    @Expose
    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("realname")
    @Expose
    @ColumnInfo(name = "realname")
    public String realname;

    @SerializedName("firstappearance")
    @Expose
    @ColumnInfo(name = "firstappearance")
    public String firstappearance;

    @SerializedName("team")
    @Expose
    @ColumnInfo(name = "team")
    public String team;

    @SerializedName("createdby")
    @Expose
    @ColumnInfo(name = "createdby")
    public String createdby;

    @SerializedName("publisher")
    @Expose
    @ColumnInfo(name = "publisher")
    public String publisher;

    @SerializedName("imageurl")
    @Expose
    @ColumnInfo(name = "imageurl")
    public String imageurl;

    @SerializedName("bio")
    @Expose
    @ColumnInfo(name = "bio")
    public String bio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public void setFirstappearance(String firstappearance) {
        this.firstappearance = firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

