package com.example.homework32;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class MainFragment extends Fragment {
    private Button btnClick;
    private EditText editText;
public final static String KEY_FOR_BUNDLE = "key.bundle";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

 
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnClick = view.findViewById(R.id.btn_click);
        editText =view.findViewById(R.id.edit);
        btnClick.setOnClickListener(new View.OnClickListener() {


            @Override

                public void onClick (View view){
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_FOR_BUNDLE, editText.getText().toString());

                    Fragment secondFragment = new SecondFragment();

                    secondFragment.setArguments(bundle);

                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,secondFragment).addToBackStack("").commit();

                }



        });


    }



    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}