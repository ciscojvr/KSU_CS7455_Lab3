package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity"; // Using TAG constant for logging
    EditText username;
    EditText password;
    Button loginButton;

    private static final String validUsername = "cs7455";
    private static final String validPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.editText_username);
        password = (EditText) findViewById(R.id.editText_password);
        loginButton = (Button) findViewById(R.id.button_login);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameEntered = username.getText().toString();
                String passwordEntered = password.getText().toString();

                if (usernameEntered.equals(validUsername) && passwordEntered.equals(validPassword)) {
                    Log.d(TAG, "Login successful!");
                }  else {
                    Log.d(TAG, "Incorrect login!");
                }

                Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("enteredUsername", usernameEntered);
                bundle.putString("enteredPassword", passwordEntered);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}