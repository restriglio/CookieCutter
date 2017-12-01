package com.example.raulstriglio.livedataroompoc.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import com.example.raulstriglio.livedataroompoc.db.dao.UserDao;
import com.example.raulstriglio.livedataroompoc.db.entities.User;

/**
 * Created by raul.striglio on 03/11/17.
 */

@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDao userModel();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE product "
                    + " ADD COLUMN street TEXT, number TEXT, neighborhood TEXT");
        }
    };

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
