package com.example.dp_client6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dp_client6.R;

import java.util.Date;

public class settingslog extends Fragment {

    public settingslog(){
        super(R.layout.settings);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText text = (EditText) getView().findViewById(R.id.editTextTextPersonName4);
        MainActivity2 m = (MainActivity2) getActivity();
        Button btn = (Button) getView().findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.url = text.getText().toString();
            }
        });
    }
}
