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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;


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
        names.add(0,"Infinity");
        names.add(1,"Mercedes");
        names.add(2,"Toyota");
        names.add(3,"Mitsubishi");
        names.add(4,"Mazda");
        names.add(5,"Jaguar");
        names.add(6,"Chevrolet");
        names.add(7,"Dodge");
        names.add(8,"Cadillac");
        names.add(9,"Audi");
        names.add(10,"Volvo");
        names.add(11,"Opel");
        names.add(12,"Honda");
        names.add(13,"Porche");
        names.add(14,"Renault");
        names.add(15,"Subaru");
        names.add(16,"Pontiac");
        names.add(17,"Lamborghini");
        names.add(18,"Peugeot");
        names.add(19,"Lexus");
        names.add(20,"Maserati");
        names.add(21,"BMW");
        names.add(22,"Suzuki");
        names.add(23,"Fiat");
        names.add(24,"Seat");
        names.add(25,"Nissan");
        names.add(26,"Bentley");
        names.add(27,"Buick");
        names.add(28,"Saab");
        names.add(29,"Daewoo");
        names.add(30,"Saturn");
        names.add(31,"Holden");
        names.add(32,"Vauxhall");
        names.add(33,"Acura");
        names.add(34,"Corvette");
        names.add(35,"Saleen");
        names.add(36,"Land Rover");
        names.add(37,"Mustang");
        names.add(38,"Koenigsegg");
        names.add(39,"Lotus");
        names.add(40,"Lincoln");
        names.add(41,"Hummer");
        names.add(42,"Maybach");
        names.add(43,"Ssangyong");
        names.add(44,"GMC");
        names.add(45,"Dacia");
        names.add(46,"Smart");
        names.add(47,"Bugatti");
        names.add(48,"Aston Martin");

        List<Integer> drawables = new ArrayList<>();
        drawables.add(R.drawable.a1);
        drawables.add(R.drawable.a2);
        drawables.add(R.drawable.a3);
        drawables.add(R.drawable.a4);
        drawables.add(R.drawable.a5);
        drawables.add(R.drawable.a6);
        drawables.add(R.drawable.a7);
        drawables.add(R.drawable.a8);
        drawables.add(R.drawable.a9);
        drawables.add(R.drawable.a10);
        drawables.add(R.drawable.a11);
        drawables.add(R.drawable.a12);
        drawables.add(R.drawable.a13);
        drawables.add(R.drawable.a14);
        drawables.add(R.drawable.a15);
        drawables.add(R.drawable.a16);
        drawables.add(R.drawable.a17);
        drawables.add(R.drawable.a18);
        drawables.add(R.drawable.a19);
        drawables.add(R.drawable.a20);
        drawables.add(R.drawable.a21);
        drawables.add(R.drawable.a22);
        drawables.add(R.drawable.a23);
        drawables.add(R.drawable.a24);
        drawables.add(R.drawable.a25);
        drawables.add(R.drawable.a26);
        drawables.add(R.drawable.a27);
        drawables.add(R.drawable.a28);
        drawables.add(R.drawable.a29);
        drawables.add(R.drawable.a30);
        drawables.add(R.drawable.a31);
        drawables.add(R.drawable.a32);
        drawables.add(R.drawable.a33);
        drawables.add(R.drawable.a34);
        drawables.add(R.drawable.a35);
        drawables.add(R.drawable.a36);
        drawables.add(R.drawable.a37);
        drawables.add(R.drawable.a38);
        drawables.add(R.drawable.a39);
        drawables.add(R.drawable.a40);
        drawables.add(R.drawable.a41);
        drawables.add(R.drawable.a42);
        drawables.add(R.drawable.a43);
        drawables.add(R.drawable.a44);
        drawables.add(R.drawable.a45);
        drawables.add(R.drawable.a46);
        drawables.add(R.drawable.a48);
        drawables.add(R.drawable.a49);


        Bundle bundle = getIntent().getExtras();


        if(numberOfEntries < 48) {
            for (int i = 0; i < 48; i++) {
//                Bitmap icon = BitmapFactory.decodeResource(this.getResources(),
//                        drawables.get(i));
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                icon.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                byte[] byteArray = stream.toByteArray();



                ItemsToGuess itemsToGuess = new ItemsToGuess();
                itemsToGuess.setTextToGuess(names.get(i));
                itemsToGuess.setGuessed(false);
                itemsToGuess.setId(i);
                itemsToGuess.setDrawable(drawables.get(i));

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
