package com.mlabs.bbm.firstandroidapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import  android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainActivity extends Activity {
    Button OnTbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnTbutton = (Button) findViewById(R.id.OnTbutton);
    }

    public void Ontouch(View view) {
        Intent intent = new Intent(MainActivity.this, OnTouchActivity.class);
        startActivity(intent);
    }

    public void saTouch(View view){
        Intent intent = new Intent(MainActivity.this, HandsOnExam.class);
        startActivity(intent);
    }
}


