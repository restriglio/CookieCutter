package com.example.raulstriglio.livedataroompoc.db;

import android.os.AsyncTask;

import com.example.raulstriglio.livedataroompoc.db.entities.Address;
import com.example.raulstriglio.livedataroompoc.db.entities.User;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class DatabaseInitializer {

    public void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private User addUser(final AppDatabase db, final String name,
                         final String lastName, final int age, Address address) {
        User user = new User();
        user.age = age;
        user.name = name;
        user.userName = lastName;
        user.setAddress(address);
        db.userModel().insertUser(user);
        return user;
    }

    private void populateWithTestData(AppDatabase db) {
        db.userModel().deleteAll();


        addUser(db, "Chuck", "Norris", 40, new Address("Maipu", "429", "Centro", zipcode));
        addUser(db, "jean claude", "van damme", 12, new Address("saavedra", "1429", "Centro", zipcode));
        addUser(db, "steven", "seagal", 15, new Address("Balcarce", "321", "Alerces", zipcode));
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
