package com.example.ioandinu.test;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class ItemsToGuess extends RealmObject{
    @PrimaryKey
    private int id ;
    private String textToGuess;
    private boolean isGuessed = false;
    private int drawable;

    public boolean isGuessed() {
        return isGuessed;
    }

    public void setGuessed(boolean guessed) {
        isGuessed = guessed;
    }

    public ItemsToGuess(){
        this.textToGuess = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextToGuess() {
        return textToGuess;
    }

    public void setTextToGuess(String textToGuess) {
        this.textToGuess = textToGuess;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
