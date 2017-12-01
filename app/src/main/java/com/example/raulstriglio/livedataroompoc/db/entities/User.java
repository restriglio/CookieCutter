package com.example.raulstriglio.livedataroompoc.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by raul.striglio on 03/11/17.
 */

@Entity(tableName = "users", indices =  @Index(value = {"first_name", "last_name"}))
public class User {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "first_name")
    public String name;

    @ColumnInfo(name = "last_name")
    public String lastName;

    public int age;

    @Embedded
    private Address address;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Address getAddress() {
        return address == null ? new Address("", "", "") : address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
