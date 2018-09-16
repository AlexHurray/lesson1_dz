package com.example.ermolaenkoalex.androidacademydz1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String KEY_MESSAGE = "KEY_MESSAGE";
    private static final String FIELD_TO = "andr.academy.msk@gmail.com";
    private static final String FIELD_SUBJECT = "Hello, Android Academy MSK!";

    private Button mSendButton;
    private TextView mLabel;

    public static void start(Activity activity, String text) {
        Intent startIntent = new Intent(activity, SecondActivity.class);
        startIntent.putExtra(KEY_MESSAGE, text);
        activity.startActivity(startIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mSendButton = findViewById(R.id.btn_next);
        mLabel = findViewById(R.id.tv_message);

        final String emailText = getIntent().getStringExtra(KEY_MESSAGE);

        mLabel.setText(emailText);

        mSendButton.setOnClickListener(view -> sendEmail(emailText));
    }

    private void sendEmail(final String emailText){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{FIELD_TO});
        intent.putExtra(Intent.EXTRA_SUBJECT, FIELD_SUBJECT);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(SecondActivity.this, R.string.warning_no_mail_app, Toast.LENGTH_LONG).show();
            return;
        }

        startActivity(intent);
    }
}
