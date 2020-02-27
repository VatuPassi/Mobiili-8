package com.example.harjoitus8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class Fragmentti2 extends Fragment {

    private FragmentViewModel2 fragmentViewModel2;
    ArrayAdapter<String> arrayAdapter;
    private ListView listView;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_uusifragment2, container, false);
        this.listView = v.findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        this.fragmentViewModel2 = viewModelProvider.get(FragmentViewModel2.class);
        this.fragmentViewModel2.lLiveData.observe(getViewLifecycleOwner(), myEntities -> {
            for (MyEntity t : myEntities){
                String s = "";
                s = s + t.txt;
                arrayAdapter.add(s);
            }
        });


    }
}

