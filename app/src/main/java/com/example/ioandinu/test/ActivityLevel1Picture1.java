package com.example.ioandinu.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
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

import org.w3c.dom.Text;

/**
 * Created by Ioan.Dinu on 7/28/2016.
 */
public class ActivityLevel1Picture1 extends Activity {

    private Button checkButton ;
    private EditText editText;
    private CheckedTextView checkedTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_picture1);
        checkButton = (Button) findViewById(R.id.btn_check);
        editText = (EditText) findViewById(R.id.editText);
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
        Intent i = new Intent(this, Activity3.class);
        startActivity(i);
    }



    public void checkText(View view) {

        //Button
        checkButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Editable inputText = editText.getText();
                if (inputText.equals("TEST")) {
                    checkedTextView.setChecked(true);
                } else {
                    checkedTextView.setChecked(false);
                }
                if (inputText.equals("TEST")) {
                    new AlertDialog.Builder(ActivityLevel1Picture1.this).setMessage("Good !!!").show();
                } else {
                    new AlertDialog.Builder(ActivityLevel1Picture1.this).setMessage("Wrong !!!" + inputText.toString()).show();

                }
            }
        });

        // Keyboard button

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Editable inputText = editText.getText();
                    String test = "T";
                    if (test.equals(inputText.toString())) {
                        new AlertDialog.Builder(ActivityLevel1Picture1.this).setMessage("Good !!!").show();
                        // Closing keyboard
                        InputMethodManager imm = (InputMethodManager)getSystemService(ActivityLevel1Picture1.this.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        editText.setEnabled(false);
                    } else {
                        new AlertDialog.Builder(ActivityLevel1Picture1.this).setMessage("Wrong !!!" + inputText.toString()).show();
                        // Closing keyboard
                        InputMethodManager imm = (InputMethodManager)getSystemService(ActivityLevel1Picture1.this.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    }
                    return true;
                }
                return false;
            }
        });
    }

}
