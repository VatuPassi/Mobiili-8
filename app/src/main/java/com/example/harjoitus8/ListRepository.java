package com.example.harjoitus8;

import android.app.Application;

import androidx.lifecycle.LiveData;


import java.util.List;

public class ListRepository {

    private TauluDao tauluDao;
    private LiveData<List<MyEntity>> listaLiveData;

    ListRepository(Application application){
        Tietokanta tk = Tietokanta.getDatabase(application);
        this.tauluDao = tk.tauluDao();
        this.listaLiveData = tauluDao.haeLista();
    }

    LiveData<List<MyEntity>> haeKaikki(){
        return listaLiveData;
    }

    void insert(final String txt) {
        Tietokanta.databaseWriteExecutor.execute(()->{
            MyEntity myEntity = new MyEntity();
            myEntity.txt = txt;
            tauluDao.insert(myEntity);
        });

    }
}

