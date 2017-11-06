package com.example.raulstriglio.livedataroompoc.db.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by raul.striglio on 03/11/17.
 */

@Entity
public class User {
    public @PrimaryKey
    String id;
    public String name;
    public String lastName;
    public int age;
}
