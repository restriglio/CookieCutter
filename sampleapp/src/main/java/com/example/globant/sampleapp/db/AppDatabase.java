package com.example.globant.sampleapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.globant.sampleapp.db.dao.PostDao;
import com.example.globant.sampleapp.db.dao.UserDao;
import com.example.globant.sampleapp.db.entities.Post;
import com.example.globant.sampleapp.db.entities.User;

/**
 * Created by raul.striglio on 03/11/17.
 *
 * This class is used to create the database and get an instance of it.
 *
 */

@Database(entities = {User.class, Post.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    /*
    *  Data Access Objects (DAO) to manipulate our db table.
    *  We have to create an abstract method for every DAO class that we create.
    * */

    public abstract UserDao userModel();
    public abstract PostDao postsModel();


    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }


    // If you need to update your database version, and add entities or new columns,
    // you gonna have to implement a Migration operation in order to avoid crashes or users losing data

    /*public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE product "
                    + " ADD COLUMN street TEXT, number TEXT, neighborhood TEXT");
        }
    };*/

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
