package com.example.homework32;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ThreeFragment extends Fragment {
    private TextView textView;
    private Button next;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.text);
        next = view.findViewById(R.id.next);


        if (getArguments() != null){
            String textValue = getArguments().getString(MainFragment.KEY_FOR_BUNDLE);
            textView.setText(textValue);
        }
        next.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(MainFragment.KEY_FOR_BUNDLE, textView.getText().toString());

                Fragment fourFragment = new FourFragment();

                fourFragment.setArguments(bundle);

                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fourFragment).addToBackStack("").commit();

            }
        });
    }
}



