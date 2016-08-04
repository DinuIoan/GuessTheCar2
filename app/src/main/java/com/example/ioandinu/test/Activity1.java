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
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.ioandinu.test.utils.Message;
import com.example.ioandinu.test.utils.SQLiteClass;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;


/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
public class Activity1 extends Activity {
   // private RealmConfiguration database ;
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



        realm = Realm.getInstance(this);

        RealmQuery<ItemsToGuess> query = realm.where(ItemsToGuess.class);
        long numberOfEntries = query.count();

        List<String> names = new ArrayList<>();
        names.add(0,"Mercedes");
        names.add(1,"Toyota");
        names.add(2,"Mitsubishi");
        names.add(3,"Mazda");
        names.add(4,"Jaguar");
        names.add(5,"Chevrolet");
        names.add(6,"Dodge");
        names.add(7,"Cadillac");
        names.add(8,"Audi");
        names.add(9,"Volvo");
        names.add(10,"Opel");
        names.add(11,"Honda");
        names.add(12,"Porche");
        names.add(13,"Renault");
        names.add(14,"Subaru");
        names.add(15,"Pontiac");
        names.add(16,"Lamborghini");
        names.add(17,"Peugeot");
        names.add(18,"Lexus");
        names.add(19,"Maserati");
        names.add(20,"BMW");
        names.add(21,"Suzuki");
        names.add(22,"Fiat");
        names.add(23,"Seat");
        names.add(24,"Nissan");
        names.add(25,"Bentley");
        names.add(26,"Buick");
        names.add(27,"Saab");
        names.add(28,"Daewoo");
        names.add(29,"Saturn");
        names.add(30,"Holden");
        names.add(31,"Vauxhall");
        names.add(32,"Acura");
        names.add(33,"Corvette");
        names.add(34,"Saleen");
        names.add(35,"Land Rover");
        names.add(36,"Mustang");
        names.add(37,"Koenigsegg");
        names.add(38,"Lotus");
        names.add(39,"Lincoln");
        names.add(40,"Hummer");
        names.add(41,"Maybach");
        names.add(42,"Ssangyong");
        names.add(43,"GMC");
        names.add(44,"Dacia");
        names.add(45,"Smart");
        names.add(46,"Bugatti");
        names.add(47,"Aston Martin");


        if(numberOfEntries < 49) {
            for (int i = 2; i < 49; i++) {
                ItemsToGuess itemsToGuess = new ItemsToGuess();
                itemsToGuess.setTextToGuess(names.get(i - 1));
                itemsToGuess.setGuessed(false);
                itemsToGuess.setId(i);

                realm.beginTransaction();
                itemsToGuess = realm.copyToRealm(itemsToGuess);
                realm.commitTransaction();
            }
        }



//        ItemsToGuess itemsToGuess = new ItemsToGuess();
//        itemsToGuess.setTextToGuess("Infinity");
//        itemsToGuess.setId(1);
//        itemsToGuess.setGuessed(false);
//
//        realm.beginTransaction();
//        itemsToGuess = realm.copyToRealm(itemsToGuess);
//        realm.commitTransaction();




//        Stetho.initialize(
//                Stetho.newInitializerBuilder(this)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
//                        .build());





//        database =  new RealmConfiguration.Builder(this)
//                        .name("GuessTheCar.realm")
//                        .deleteRealmIfMigrationNeeded()
//                        .build();
//        Realm.setDefaultConfiguration(database);
//
//        this.realm = RealmController.with(this).getRealm();
//        //RealmController.with(this).refresh();
//       // RealmController.with(this).add("Infinity");
//        //RealmController.with(this).add("Mercedes");
//      //  RealmController.with(this).add("Mazda");
//
//        realm.beginTransaction();
//        ItemsToGuess itemsToGuess1 = realm.createObject(ItemsToGuess.class);
//        itemsToGuess1.setTextToGuess("Infinity");
//        int nextID = (int) (realm.where(ItemsToGuess.class).max("id").intValue() + 1);
//        itemsToGuess1.setId(nextID);
//        itemsToGuess1.setGuessed(false);
//        realm.commitTransaction();
//
//
//       /* ItemsToGuess itemsToGuess2 = realm.createObject(ItemsToGuess.class);
//        itemsToGuess2.setTextToGuess("Mercedes");
//        itemsToGuess2.setId(2);
//        itemsToGuess2.setGuessed(false);
//
//
//
//        ItemsToGuess itemsToGuess3 = realm.createObject(ItemsToGuess.class);
//        itemsToGuess3.setTextToGuess("Mazda");
//        itemsToGuess3.setId(3);
//        itemsToGuess3.setGuessed(false);*/
//        realm.commitTransaction();

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
