package com.example.harjoitus8;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TauluDao {
    @Query("SELECT * FROM entityTaulu ORDER BY txt ASC")
    LiveData<List<MyEntity>> haeLista();

    @Insert
    void insert(MyEntity myEntity);

    @Delete
    void deleteTaulu(MyEntity myEntity);
}
