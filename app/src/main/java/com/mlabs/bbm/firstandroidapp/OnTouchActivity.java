package com.mlabs.bbm.firstandroidapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by VielPC on 9/3/2016.
 */
public class OnTouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_touch_activity);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        final String TAG = OnTouchActivity.class.getSimpleName();

        imageView.setOnTouchListener(new View.OnTouchListener() {

            float initialX, initialY, finalX, finalY;

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                int event = motionEvent.getAction();
                switch(event){
                    case MotionEvent.ACTION_DOWN:
                        initialX = motionEvent.getX();
                        initialY = motionEvent.getY();
                        Toast.makeText(getApplicationContext(),"X: " + initialX + "Y:" + initialY, Toast.LENGTH_LONG).show();
                        return true;

                    case MotionEvent.ACTION_UP:
                        finalX= motionEvent.getX();
                        finalY = motionEvent.getY();

                        Log.d(TAG, "Action Was UP");

                        if(initialX < finalX ){
                            Log.d(TAG, "Left to Right swipe performed");
                            Toast.makeText(getApplicationContext(), "Left to Right Performed, X:" + initialX + "Y: " + initialY, Toast.LENGTH_LONG).show();
                        }

                        if(initialX > finalX){
                            Log.d(TAG, "Right to Left swipe performed");
                            Toast.makeText(getApplicationContext(), "Right to Left Performed, X:" + initialX + "Y:" + initialY, Toast.LENGTH_LONG).show();
                        }

                        if(initialY < finalY ){
                            Log.d(TAG, "Up to Down swipe performed");
                            Toast.makeText(getApplicationContext(), "Up to Down Performed, X:" + initialX + "Y: " + initialY, Toast.LENGTH_LONG).show();
                        }

                        if(initialY > finalY){
                            Log.d(TAG, "Down to Up swipe performed");
                            Toast.makeText(getApplicationContext(), "Down to Up Performed, X:" + initialX + "Y:" + initialY, Toast.LENGTH_LONG).show();
                        }
                        return true;
                }

                return false;
            }
        });
    }
}
