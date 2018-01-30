package com.example.raulstriglio.sampleapp.db;

import android.os.AsyncTask;

import com.example.raulstriglio.sampleapp.db.entities.Address;
import com.example.raulstriglio.sampleapp.db.entities.User;

/**
 * Created by raul.striglio on 03/11/17.
 *
 * Class used to populate with dummy data our database
 *
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


        addUser(db, "Chuck", "Norris", 40,
                new Address("Maipu", "429", "Centro", "2000"));
        addUser(db, "jean claude", "van damme",
                12, new Address("saavedra", "1429", "Centro", "1012"));
        addUser(db, "steven", "seagal", 15,
                new Address("Balcarce", "321", "Alerces", "2600"));
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
