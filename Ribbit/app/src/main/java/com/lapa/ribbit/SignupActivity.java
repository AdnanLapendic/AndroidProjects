package com.lapa.ribbit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * A login screen that offers login via email/password.
 */
public class SignupActivity extends AppCompatActivity {

    // UI references.
     EditText mUsernameView;
     EditText mEmailView;
     EditText mPasswordView;
     View mProgressView;
     View mLoginFormView;
    Button mEmailSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // Set up the login form.

        mUsernameView = (EditText)findViewById(R.id.signUpUsername);
        mEmailView = (EditText) findViewById(R.id.signUpEmail);

        mPasswordView = (EditText) findViewById(R.id.signUpPassword);


        mEmailSignInButton = (Button) findViewById(R.id.signUpActivitySignUpButton);


        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

    }
}


