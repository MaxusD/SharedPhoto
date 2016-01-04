package com.androidbegin.parseimageupload;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity implements View.OnClickListener{

    public Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button)findViewById(R.id.login_button);
        btnLogin.setOnClickListener(this);

        /*loginEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    loginEditText.setHint("");
                } else {
                    loginEditText.setHint("Login");
                }
            }
        });*/

       /* passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    passwordEditText.setHint("");
                } else {
                    passwordEditText.setHint("Password");
                }
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }



    /*@Override
    protected void onResume() {
        super.onResume();
        loginEditText.clearFocus();
    }*/
}
