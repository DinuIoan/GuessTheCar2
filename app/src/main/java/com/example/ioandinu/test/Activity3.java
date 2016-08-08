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
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.ioandinu.test.utils.Message;

import io.realm.Realm;
import io.realm.RealmQuery;



/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
public class Activity3 extends Activity {

    Realm realm;
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        //ImageAdapter imageAdapter2 = new ImageAdapter(Activity3.this);



        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {


                ImageAdapter imageAdapter = new ImageAdapter(Activity3.this);
                Integer image = imageAdapter.getItem(position);
                Intent i = new Intent(Activity3.this, ActivityLevel1Picture1.class);
                i.putExtra("position",position);
                i.putExtra("image",image);
                //i.putExtra("image",image);
                startActivity(i);

            }
        });
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
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }

    public void picture1(View view){
        Intent i = new Intent(this, ActivityLevel1Picture1.class);
        startActivity(i);
    }



}
