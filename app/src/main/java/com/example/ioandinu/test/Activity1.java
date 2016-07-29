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
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
public class Activity1 extends Activity {
    Realm database =
            Realm.getInstance(
                    new RealmConfiguration.Builder(Activity1.this)
                            .name("GuessTheCar.realm")
                            .build()
            );


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        try{
            ItemsToGuess itemsToGuess = new ItemsToGuess();
            


            database.beginTransaction();
            ItemsToGuess itemsToGuess2 = database.copyToRealm(itemsToGuess);
            database.commitTransaction();

        }catch(Exception e){
            e.printStackTrace();
        }
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

    public void play(View view)
    {
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }



}
