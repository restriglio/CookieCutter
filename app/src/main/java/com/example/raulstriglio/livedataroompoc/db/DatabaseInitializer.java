package com.example.raulstriglio.livedataroompoc.db;

import android.os.AsyncTask;
import android.util.Log;

import com.example.raulstriglio.livedataroompoc.db.entities.User;

import java.util.Date;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class DatabaseInitializer {

    public void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private User addUser(final AppDatabase db, final String id, final String name,
                                final String lastName, final int age) {
        User user = new User();
        user.id = id;
        user.age = age;
        user.name = name;
        user.lastName = lastName;
        db.userModel().insertUser(user);
        return user;
    }

    private void populateWithTestData(AppDatabase db) {
        db.userModel().deleteAll();

        User user1 = addUser(db, "1", "Esteban", "Moya", 40);
        User user2 = addUser(db, "2", "Camilo", "Rever", 12);
        addUser(db, "3", "Susan", "Sanson", 15);
    }


    private class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
