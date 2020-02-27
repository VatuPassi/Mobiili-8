package com.example.harjoitus8;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MyEntity.class}, version=1, exportSchema = false)
public abstract class Tietokanta extends RoomDatabase {

    public static final String kannanNimi = "DATABASE";
    public abstract TauluDao tauluDao();
    private static volatile Tietokanta INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static Tietokanta getDatabase(final Context context){
            if(INSTANCE == null){
                synchronized (Tietokanta.class){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                Tietokanta.class, "TIETOKANTA")
                                .build();
                    }
                }
            }
            return INSTANCE;
    }
}
