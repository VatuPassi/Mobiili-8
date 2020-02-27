package com.example.harjoitus8;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


import java.io.Serializable;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "entityTaulu")
class MyEntity implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String txt;
}



