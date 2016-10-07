package com.mlabs.bbm.firstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.R.*;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

/**
 * Created by VielPC on 7/22/2016.
 */
public class Login extends AppCompatActivity {
    EditText editText_user, editText_password;

    Button log_in, btshowpass;
    DataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editText_user = (EditText) findViewById(R.id.editText_user);
        editText_user.requestFocus();
        editText_password = (EditText) findViewById(R.id.editText_password);
        loginDataBaseAdapter = new DataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        log_in = (Button) findViewById(R.id.log_in);
        btshowpass = (Button) findViewById(R.id.btshowpass);

        btshowpass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int cursor = editText_password.getSelectionStart();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Classname", "ACTION_DOWN");
                        editText_password.setTransformationMethod(null);
                        editText_password.setSelection(cursor);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("Classname", "ACTION_UP");
                        editText_password.setTransformationMethod(new PasswordTransformationMethod());
                        editText_password.setSelection(cursor);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        editText_password.setSelection(cursor);
                    default:
                        break;

                }

                return true;
            }
        });

    }
    public void loginb(View view) {

        String email = editText_user.getText().toString();
        //String userName = editUser.getText().toString();
        String pw = editText_password.getText().toString();
        String user = loginDataBaseAdapter.getSinlgeEntry(email);//User
        String emailt = loginDataBaseAdapter.getSinlgeEntryEmail(email);//email

        if (pw.equals(user)) {
            Toast.makeText(Login.this, "Hello! Welcome", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else if (pw.equals(emailt)) {
            Toast.makeText(Login.this, "Hello! Welcome", Toast.LENGTH_LONG).show();
            Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else {
            if (email.equals("") && pw.equals("")) {
                Toast.makeText(getApplicationContext(), "Please fill out all the field.", Toast.LENGTH_LONG).show();
                return;
            } else if (email.equals("") || pw.equals("")) {
                Toast.makeText(getApplicationContext(), "Please fill out the field.", Toast.LENGTH_LONG).show();
                return;
            }
            Toast.makeText(Login.this, "Incorrect Email/Username or Password.", Toast.LENGTH_LONG).show();

            //------------------------------------------------------

        }
    }



    private Boolean validateEmail(String emailAdd) {
        if (emailAdd == null || !Patterns.EMAIL_ADDRESS.matcher(emailAdd).matches()) {
            return false;
        } else {
            return true;
        }
    }


    private Boolean validatePwd(String password) {
        if (password != null && password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

    public void SignUp(View v){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}

