package com.example.harjoitus8;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FragmentViewModel2 extends AndroidViewModel {

    private ListRepository lRepository;
    LiveData<List<MyEntity>> lLiveData;

    public FragmentViewModel2(@NonNull Application application) {
        super(application);
        this.lRepository = new ListRepository(application);
        this.lLiveData = lRepository.haeKaikki();
    }
}
