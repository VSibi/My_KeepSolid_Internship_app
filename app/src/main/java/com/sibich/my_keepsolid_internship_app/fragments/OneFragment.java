package com.sibich.my_keepsolid_internship_app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.sibich.my_keepsolid_internship_app.MainActivity;
import com.sibich.my_keepsolid_internship_app.R;
import com.sibich.my_keepsolid_internship_app.SecondActivity;

public class OneFragment extends Fragment {

    private static final int REQUEST_CODE = 0;

    private EditText mEnterEmailTextView;
    private Button mClearButton, mSendButton;
    private CheckBox mAllowCheckBox;
    private View rootLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        rootLayout = v.findViewById(R.id.root_layout_fragment_one);

        mEnterEmailTextView = (EditText) v.findViewById(R.id.et_enter_email);
        mAllowCheckBox = (CheckBox) v.findViewById(R.id.ch_allow);

        mClearButton = (Button) v.findViewById(R.id.b_clear);
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEnterEmailTextView.setText("");
            }
        });

        mSendButton = (Button) v.findViewById(R.id.b_send);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEnterEmailTextView.getText().toString().isEmpty()) {
                    if (mEnterEmailTextView.getText().toString().contains("@")) {
                        Intent i = SecondActivity.newIntent(getActivity(), mEnterEmailTextView.getText().toString());
                        startActivityForResult(i, REQUEST_CODE);
                    } else {
                        Snackbar.make(rootLayout, getResources().getString(R.string.error_enter_email), Snackbar.LENGTH_LONG)
                                .show();
                    }
                }
                else {
                    Snackbar.make(rootLayout, getResources().getString(R.string.empty_email), Snackbar.LENGTH_LONG)
                            .show();
                }


            }
        });
        mSendButton.setEnabled(false);

        mAllowCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mSendButton.setEnabled(isChecked);
            }
        });


        return v;
    }


}
