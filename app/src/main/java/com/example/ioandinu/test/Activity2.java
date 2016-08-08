/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ioandinu.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmQuery;


/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
public class Activity2 extends Activity {
    private static final int PROGRESS = 0x1;

    private ProgressBar mProgress;
    private int mProgressStatus = 0;
    private long guessed = 0;
    private Realm realm;
    private TextView textProgress;

    private Handler mHandler = new Handler();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mProgress = (ProgressBar) findViewById(R.id.progress_bar);
        textProgress = (TextView) findViewById(R.id.text_progres);

        realm = Realm.getInstance(Activity2.this);
        RealmQuery<ItemsToGuess> query = realm.where(ItemsToGuess.class);
        guessed = query.equalTo("isGuessed",true).count();
        long unGuessed = 49 - guessed;
        textProgress.setText("" + (int)guessed + "/" + unGuessed);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 49) {

//                    RealmQuery<ItemsToGuess> query = realm.where(ItemsToGuess.class);
//                    guessed = query.equalTo("isGuessed",true).count();
                    mProgressStatus = (int) guessed;

                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void back(View view){
        Intent i = new Intent(this, Activity1.class);
        startActivity(i);
    }

    public void level1(View view)
    {
        Intent i = new Intent(this, Activity3.class);
        startActivity(i);
    }




}
