package com.example.raulstriglio.sampleapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by raul.striglio on 03/11/17.
 */

@Entity(tableName = "users", indices =  @Index(value = {"first_name", "user_name"}))
public class User implements Serializable {

    @SerializedName("id")
    @Expose
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "first_name")
    public String name;

    @SerializedName("username")
    @Expose
    @ColumnInfo(name = "user_name")
    public String userName;

    public int age;

    @Embedded
    @SerializedName("address")
    @Expose
    private Address address;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Address getAddress() {
        return address == null ? new Address("", "", "", "") : address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
