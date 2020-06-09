package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    TextView result;
    Button goBackButton;

    private static final String validUsername = "cs7455";
    private static final String validPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        result = (TextView) findViewById(R.id.textView_results);
        goBackButton = (Button) findViewById(R.id.button_go_back);

        Bundle bundle = getIntent().getExtras();

        String usernameEntered = bundle.getString("enteredUsername");
        String passwordEntered = bundle.getString("enteredPassword");

        if(usernameEntered.equals(validUsername) && passwordEntered.equals(validPassword)) {
            result.setText(usernameEntered + ", Welcome to my webpage!");
            goBackButton.setVisibility(View.INVISIBLE);
        } else {
            result.setText("Login Fail! Please go back, try it again!");
            goBackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                    startActivity(intent);
                }
            });
        }
    }
}