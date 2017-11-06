package com.example.raulstriglio.livedataroompoc.db;

import android.os.AsyncTask;
import android.util.Log;

import com.example.raulstriglio.livedataroompoc.db.entities.User;

import java.util.Date;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class DatabaseInitializer {

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private static User addUser(final AppDatabase db, final String id, final String name,
                                final String lastName, final int age) {
        User user = new User();
        user.id = id;
        user.age = age;
        user.name = name;
        user.lastName = lastName;
        db.userModel().insertUser(user);
        return user;
    }

    private static void populateWithTestData(AppDatabase db) {
        db.userModel().deleteAll();

        User user1 = addUser(db, "1", "Jason", "Seaver", 40);
        User user2 = addUser(db, "2", "Mike", "Seaver", 12);
        addUser(db, "3", "Carol", "Seaver", 15);
    }


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

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
