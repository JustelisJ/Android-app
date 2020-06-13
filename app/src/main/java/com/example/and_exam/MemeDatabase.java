package com.example.and_exam;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Meme.class}, version = 2)
public abstract class MemeDatabase extends RoomDatabase {

    private static MemeDatabase instance;
    public abstract MemeDao memeDao();

    public static synchronized MemeDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MemeDatabase.class, "meme_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
