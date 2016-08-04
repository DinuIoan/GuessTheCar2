package com.example.ioandinu.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ioandinu.test.utils.SharedPreference;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Ioan.Dinu on 7/28/2016.
 */




public class ActivityLevel1Picture1 extends Activity {

    private Button checkButton ;
    private EditText editText;
    private CheckedTextView checkedTextView;
    boolean infinityIsChecked ;
    private SharedPreference sharedPreference;
    Activity context = this;
    boolean b ;
    Realm realm;

    //Realm realm ;
    //ItemsToGuess textToGuess;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_picture1);
        checkButton = (Button) findViewById(R.id.btn_check);
        editText = (EditText) findViewById(R.id.editText);

        realm = Realm.getInstance(this);


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                RealmQuery<ItemsToGuess> query = realm.where(ItemsToGuess.class);
                query.equalTo("id",0);
                ItemsToGuess itemsToGuess = new ItemsToGuess();
                itemsToGuess = query.findFirst();
                String name = itemsToGuess.getTextToGuess();
                b = itemsToGuess.isGuessed();


                if (actionId == EditorInfo.IME_ACTION_DONE) {


                    if (b == false) {
                        Editable inputText = editText.getText();
                        if (name.equals(inputText.toString())) {
                            infinityIsChecked = true;
                            realm.beginTransaction();
                            itemsToGuess.setGuessed(true);
                            realm.commitTransaction();
                            new AlertDialog.Builder(ActivityLevel1Picture1.this).setMessage("Good !!!" ).show();

                            // Closing keyboard
                            InputMethodManager imm = (InputMethodManager) getSystemService(ActivityLevel1Picture1.this.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                            editText.setEnabled(false);

                        } else {

                            new AlertDialog.Builder(ActivityLevel1Picture1.this).setMessage("Wrong !!!" + inputText.toString()).show();

                            // Closing keyboard
                            InputMethodManager imm = (InputMethodManager) getSystemService(ActivityLevel1Picture1.this.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        }
                        return true;
                    }
                    else{
                        editText.setFocusable(false);
                        editText.setEnabled(false);
                    }

                }
                return false;
            }
        });









       // this.realm = RealmController.with(this).getRealm();
       // RealmController.with(this).refresh();

       // textToGuess = RealmController.with(this).getItem(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(infinityIsChecked == true){
            editText.setFocusable(false);
            editText.setEnabled(false);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(infinityIsChecked == true){
            editText.setFocusable(false);
            editText.setEnabled(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(infinityIsChecked == true){
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(infinityIsChecked == true){
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(infinityIsChecked == true){
        }
    }

    public void back(View view){
        Intent i = new Intent(this, Activity3.class);
        startActivity(i);
    }



    public void checkText(View view) {









//
//        //Button
//        checkButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Editable inputText = editText.getText();
//                if (inputText.equals(textToGuess)) {
//                    checkedTextView.setChecked(true);
//                } else {
//                    checkedTextView.setChecked(false);
//                }
//                if (inputText.equals("TEST")) {
//                    new AlertDialog.Builder(ActivityLevel1Picture1.this).setMessage("Good !!!").show();
//                } else {
//                    new AlertDialog.Builder(ActivityLevel1Picture1.this).setMessage("Wrong !!!" + inputText.toString()).show();
//
//                }
//            }
//        });

        // Keyboard button



//        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                SharedPreferences sharedPreferences = getSharedPreferences("PREFERENCE_FILE_STRINGS", Context.MODE_PRIVATE);
//
//
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//
//                    String name = sharedPreferences.getString("name", "No name");
//                    boolean infinityBoolean = sharedPreferences.getBoolean("name1", false);
//
//                    if (infinityBoolean == false) {
//                        Editable inputText = editText.getText();
//                        if (name.equals(inputText.toString())) {
//
//                            SharedPreferences.Editor editor =  getSharedPreferences("PREFERENCE_FILE_STRINGS", Context.MODE_PRIVATE).edit();
//                            editor.remove("name1").apply();
//                            editor.putBoolean("name1",true);
//                            editor.commit();
//
//                            boolean infinityBoolean2 = sharedPreferences.getBoolean("name1", false);
//
//
//                            new AlertDialog.Builder(ActivityLevel1Picture1.this).setMessage("Good !!!" + " " + infinityBoolean2).show();
//                            infinityIsChecked = true;
//                            // Closing keyboard
//                            InputMethodManager imm = (InputMethodManager) getSystemService(ActivityLevel1Picture1.this.INPUT_METHOD_SERVICE);
//                            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
//                            editText.setEnabled(false);
//
//                        } else {
//
//                            new AlertDialog.Builder(ActivityLevel1Picture1.this).setMessage("Wrong !!!" + inputText.toString()).show();
//
//                            // Closing keyboard
//                            InputMethodManager imm = (InputMethodManager) getSystemService(ActivityLevel1Picture1.this.INPUT_METHOD_SERVICE);
//                            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
//                        }
//                        return true;
//                    }
//                    else{
//                        editText.setEnabled(false);
//                    }
//
//                }
//                return false;
//            }
//        });
    }

//    public void updateGuessed(final ItemsToGuess itemsToGuess){
//        itemsToGuess.setGuessed(true);
//        realm.executeTransaction(new Realm.Transaction(){
//
//            @Override
//            public void execute(Realm realm) {
//                realm.copyToRealm(itemsToGuess);
//            }
//        });

    //}

}
