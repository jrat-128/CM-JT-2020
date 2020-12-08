package com.example.tpc1_dialer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;


public class QuickDial extends AppCompatActivity {
    String NUMBER;
    String LABEL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_dial);
        Button saveButton = findViewById(R.id.buttonSave);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout textInputSpeedDialLabel = findViewById(R.id.textFieldLabel);
                TextInputLayout textInputSpeedDialNumber = findViewById(R.id.textFieldNumber);
                if (!textInputSpeedDialLabel.getEditText().getText().equals("") &&
                        !textInputSpeedDialNumber.getEditText().getText().equals("")) {
                    // CHANGE THE QDBs
                    NUMBER = textInputSpeedDialNumber.getEditText().getText().toString();
                    LABEL = textInputSpeedDialLabel.getEditText().getText().toString();

                    Intent replyIntent = new Intent();
                    replyIntent.putExtra("label",LABEL);
                    replyIntent.putExtra("number",NUMBER);

                    setResult(RESULT_OK,replyIntent);
                    finish();
                }
            }
        });
    }
}