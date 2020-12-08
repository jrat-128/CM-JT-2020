package com.example.tpc1_dialer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public class quickDialButton{
        String number="";
        String label="";
        Button button;
    }


    public static int ACTIVITY_INDEX = 4;
    public static String BUTTON_NUMBER = "com.example.tpc1_dialer.Message";
    public String RETURN_STRING = "";
    public String PHONE_NUMBER = "";
    public String LABELS = "";

    public quickDialButton QD1 = new quickDialButton();
    public quickDialButton QD2 = new quickDialButton();
    public quickDialButton QD3 = new quickDialButton();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QD1.button = findViewById(R.id.buttonQD1);
        QD2.button = findViewById(R.id.buttonQD2);
        QD3.button = findViewById(R.id.buttonQD3);

        TextView textView = findViewById(R.id.textView);
        textView.setText(PHONE_NUMBER);

        QD1.button.setOnLongClickListener(new View.OnLongClickListener(){
            String msg = QD1.button.getText().toString();
            @Override
            public boolean onLongClick(View view){
                ACTIVITY_INDEX = 1;
                PHONE_NUMBER = QD1.number;
                LABELS = QD1.label;
                ClickNHold(msg);
                QD1.number = RETURN_STRING;
                return false;
            }
        });

        QD2.button.setOnLongClickListener(new View.OnLongClickListener(){
            String msg = QD2.button.getText().toString();
            @Override
            public boolean onLongClick(View view){
                ACTIVITY_INDEX = 1;
                PHONE_NUMBER = QD2.number;
                LABELS = QD2.label;
                ClickNHold(msg);
                QD2.number = RETURN_STRING;
                return false;
            }
        });

        QD3.button.setOnLongClickListener(new View.OnLongClickListener(){
            String msg = QD3.button.getText().toString();
            @Override
            public boolean onLongClick(View view){
                ACTIVITY_INDEX = 1;
                PHONE_NUMBER = QD3.number;
                LABELS = QD3.label;
                ClickNHold(msg);
                QD3.number = RETURN_STRING;
                return false;
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            String nmbr = data.getStringExtra("number");
            String lbl = data.getStringExtra("label");

            if(ACTIVITY_INDEX == 1) {
                QD1.number = nmbr;
                QD1.label = lbl;
                QD1.button.setText(lbl);
            } else if (ACTIVITY_INDEX == 2){
                QD2.number = nmbr;
                QD2.label = lbl;
                QD2.button.setText(lbl);
            } else if (ACTIVITY_INDEX == 3){
                QD3.number = nmbr;
                QD3.label = lbl;
                QD3.button.setText(lbl);
            }

        }
    }

    public void ClickNHold(String msg)
    {
        LABELS = msg;
        Intent intent = new Intent(this, QuickDial.class);
        startActivityForResult(intent,ACTIVITY_INDEX);
    }

    public void clickOne(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '1';
        textView.setText(PHONE_NUMBER);

    }

    public void clickTwo(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '2';
        textView.setText(PHONE_NUMBER);
    }

    public void clickThree(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '3';
        textView.setText(PHONE_NUMBER);
    }

    public void clickFour(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '4';
        textView.setText(PHONE_NUMBER);
    }

    public void clickFive(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '5';
        textView.setText(PHONE_NUMBER);
    }

    public void clickSix(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '6';
        textView.setText(PHONE_NUMBER);
    }

    public void clickSeven(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '7';
        textView.setText(PHONE_NUMBER);
    }

    public void clickEight(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '8';
        textView.setText(PHONE_NUMBER);
    }

    public void clickNine(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '9';
        textView.setText(PHONE_NUMBER);
    }

    public void clickZero(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '0';
        textView.setText(PHONE_NUMBER);
    }

    public void clickHash(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '#';
        textView.setText(PHONE_NUMBER);
    }

    public void clickAst(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = PHONE_NUMBER + '*';
        textView.setText(PHONE_NUMBER);
    }

    public void inputDelete(View view){
        String temp = null;
        if((PHONE_NUMBER!=null)&&(PHONE_NUMBER.length()>0)){
            temp = PHONE_NUMBER.substring(0,PHONE_NUMBER.length()-1);
        }
        PHONE_NUMBER = temp;
        TextView textView = findViewById(R.id.textView);
        textView.setText(PHONE_NUMBER);
    }

    public void startCall(View view){
        String str = "tel:" + PHONE_NUMBER;
        Uri uri = Uri.parse(str);
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);
    }

    public void clickQD1(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = QD1.number;
        textView.setText(PHONE_NUMBER);
    }

    public void clickQD2(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = QD2.number;
        textView.setText(PHONE_NUMBER);
    }

    public void clickQD3(View view){
        TextView textView = findViewById(R.id.textView);
        PHONE_NUMBER = QD3.number;
        textView.setText(PHONE_NUMBER);
    }
}

