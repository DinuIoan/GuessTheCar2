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

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
public class Activity1 extends Activity {
    private RealmConfiguration database ;
    private Realm realm;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());





        database =  new RealmConfiguration.Builder(this)
                        .name("GuessTheCar.realm")
                        .deleteRealmIfMigrationNeeded()
                        .build();
        Realm.setDefaultConfiguration(database);

        this.realm = RealmController.with(this).getRealm();
        //RealmController.with(this).refresh();
       // RealmController.with(this).add("Infinity");
        //RealmController.with(this).add("Mercedes");
      //  RealmController.with(this).add("Mazda");

        realm.beginTransaction();
        ItemsToGuess itemsToGuess1 = realm.createObject(ItemsToGuess.class);
        itemsToGuess1.setTextToGuess("Infinity");
        int nextID = (int) (realm.where(ItemsToGuess.class).max("id").intValue() + 1);
        itemsToGuess1.setId(nextID);
        itemsToGuess1.setGuessed(false);
        realm.commitTransaction();


       /* ItemsToGuess itemsToGuess2 = realm.createObject(ItemsToGuess.class);
        itemsToGuess2.setTextToGuess("Mercedes");
        itemsToGuess2.setId(2);
        itemsToGuess2.setGuessed(false);



        ItemsToGuess itemsToGuess3 = realm.createObject(ItemsToGuess.class);
        itemsToGuess3.setTextToGuess("Mazda");
        itemsToGuess3.setId(3);
        itemsToGuess3.setGuessed(false);*/
        realm.commitTransaction();

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
