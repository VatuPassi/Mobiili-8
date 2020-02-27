package com.example.harjoitus8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class Fragmentti extends Fragment {

    private FragmentViewModel fragmentViewModel;
    private Button button;
    private EditText editText;
    private MyEntity myEntity;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_uusifragment, container, false);
        this.editText = v.findViewById(R.id.editText);
        this.button = v.findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                fragmentViewModel.insert(editText.getText().toString());
            }
        });
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.fragmentViewModel = new ViewModelProvider(this).get(FragmentViewModel.class);
    }

}
