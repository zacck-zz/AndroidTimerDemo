package com.zacck.androidtimerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lets create a handler
        //allows chunks of code to be run in a delayed manner the handler controlls the timing betwwen run
        final Handler mAndroidHandler = new Handler();

        Runnable mRun = new Runnable() {
            @Override
            public void run() {
                //insert code to be run at each interval
                Log.i(getPackageName(), "A second has passed runnable needs to be run");

                mAndroidHandler.postDelayed(/*this runnable*/this, /*run the code every second*/1000);
            }
        };

        //Start the Thread
        //Uncomment to start thread at intervals
        //mAndroidHandler.post(mRun);

        //Doing a Task regularly Using a CountDownTimer

        new CountDownTimer(10000/*run every ten seconds*/,1000/*tick every second*/){

            public void onFinish(){
                //this code runs when the countdown is finished
                Log.i(getPackageName(), "Countdown Timer finished ");
            }

            //this is called on every interval
            public void onTick(long milliSecondsUntilDone)
            {
               //happens every interval of the countdown
                Log.i(getPackageName(), String.valueOf(milliSecondsUntilDone/1000)+" Seconds Left");

            }


        }.start();
    }
}
