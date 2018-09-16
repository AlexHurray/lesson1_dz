package com.example.ermolaenkoalex.androidacademydz1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mMessage;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessage = findViewById(R.id.et_message);
        mButton = findViewById(R.id.btn_next);
        mButton.setOnClickListener(view -> onButtonNext());
    }

    private void onButtonNext(){
        if (mMessage.getText().toString().length() > 0){
            SecondActivity.start(MainActivity.this, mMessage.getText().toString());
        } else{
            Toast.makeText(MainActivity.this, R.string.warning_string_length, Toast.LENGTH_LONG).show();
        }
    }
}
