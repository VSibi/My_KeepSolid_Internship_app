package com.sibich.my_keepsolid_internship_app.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sibich.my_keepsolid_internship_app.R;

public class TwoFragment extends Fragment {

    private Button mOkButton;

    public interface onOkEventListener {
        void buttonOkPressed();
    }
    onOkEventListener okEventListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            okEventListener = (onOkEventListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onOkEventListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);

        mOkButton = (Button)v.findViewById(R.id.b_ok);
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okEventListener.buttonOkPressed();
            }
        });



        return v;
    }

}
