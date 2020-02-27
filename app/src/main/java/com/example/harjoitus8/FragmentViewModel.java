package com.example.harjoitus8;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FragmentViewModel extends AndroidViewModel {

    private ListRepository lRepository;
    private LiveData<List<MyEntity>> lKaikkiTxt;

    public FragmentViewModel(@NonNull Application application) {
        super(application);

        lRepository = new ListRepository(application);
        lKaikkiTxt = lRepository.haeKaikki();

    }
    LiveData<List<MyEntity>> haeKaikki() {return lKaikkiTxt; }

    public void insert (String myEntity) {lRepository.insert(myEntity);}
}
