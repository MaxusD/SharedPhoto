package com.androidbegin.parseimageupload;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends Activity /*implements View.OnClickListener*/ {

    public Button loginButton;
    public Button signupButton;
    public EditText usernameEditText;
    public EditText passwordEditText;
    public String username;
    public String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)findViewById(R.id.login_button);
        signupButton = (Button)findViewById(R.id.sign_up_button);
        //loginButton.setOnClickListener(this);

        usernameEditText = (EditText)findViewById(R.id.login_editText);
        passwordEditText = (EditText)findViewById(R.id.password_editText);


        loginButton.setOnClickListener(new View.OnClickListener(){
                                           @Override
                                           public void onClick(View arg0) {

                                               username = usernameEditText.getText().toString();
                                               password = passwordEditText.getText().toString();

                                               ParseUser.logInInBackground(username, password, new LogInCallback()
                                                       {
                                                           public void done(ParseUser user, ParseException e) {
                                                               if (user != null) {
                                                                   // If user exist and authenticated, send user to Welcome.class
                                                                   Intent intent = new Intent(
                                                                           LoginActivity.this,
                                                                           ListViewFriendsActivity.class);
                                                                   startActivity(intent);
                                                                   Toast.makeText(getApplicationContext(),
                                                                           "Successfully Logged in",
                                                                           Toast.LENGTH_LONG).show();
                                                                   finish();
                                                               } else {
                                                                   Toast.makeText(
                                                                           getApplicationContext(),
                                                                           "No such user exist, please signup",
                                                                           Toast.LENGTH_LONG).show();
                                                               }
                                                           }
                                                       }
                                               );
                                           }

                                       }

        );

       /* usernameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    usernameEditText.setHint("");
                } else {
                    usernameEditText.setHint("Login");
                }
            }
        });

        passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    passwordEditText.setHint("");
                } else {
                    passwordEditText.setHint("Password");
                }
            }
        });*/

        signupButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();

                // Force user to fill up the form
                if (username.equals("") && password.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please complete the sign up form",
                            Toast.LENGTH_LONG).show();

                } else {
                    // Save new user data into Parse.com Data Storage
                    ParseUser user = new ParseUser();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                // Show a simple Toast message upon successful registration
                                Toast.makeText(getApplicationContext(),
                                        "Successfully Signed up, please log in.",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Sign up Error", Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    });
                }

            }
        });

    }

/*    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                *//*Intent intent = new Intent(this, ListViewFriendsActivity.class);
                startActivity(intent);
                break;
            default:
                break;*//*
                if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
                    // If user is anonymous, send the user to MainActivity.class
                    Intent intent = new Intent(LoginActivity.this,
                            LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // If current user is NOT anonymous user
                    // Get current user data from Parse.com
                    ParseUser currentUser = ParseUser.getCurrentUser();
                    if (currentUser != null) {
                        // Send logged in users to Welcome.class
                        Intent intent = new Intent(LoginActivity.this, ListViewFriendsActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Send user to MainActivity.class
                        Intent intent = new Intent(LoginActivity.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
        }
    }*/



    @Override
    protected void onResume() {
        super.onResume();
        usernameEditText.clearFocus();
    }
}
