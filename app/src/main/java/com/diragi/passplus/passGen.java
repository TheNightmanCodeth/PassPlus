package com.diragi.passplus;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.Random;

public class passGen extends themeCheck {
    NumberPicker lengthChooser;
    SharedPreferences mPrefs;

    @Override
    public void finOnCreate() {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "0");
        setContentView(R.layout.activity_passgen);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);


    }

    public static String randomPassString(char[] characterSet, int length) {

        Random randPass = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i <result.length; i++) {

            //pick random index out of character set
            int randomCharIndex = randPass.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];

        }

        return new String(result);
    }

    public void genPass(View v) {
        EditText genPass = (EditText)findViewById(R.id.genPass);
        int length;
        EditText passLength = (EditText)findViewById(R.id.titleText);
        char[] CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        CheckBox symbolsOrNah = (CheckBox)findViewById(R.id.checkBox);

        if (symbolsOrNah.isChecked()) {

            CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*".toCharArray();

        }

        if (passLength.getText().toString().length() == 0) {

            length = 10;

        } else {

            length = Integer.parseInt(passLength.getText().toString());

        }

        if (length > 45) {

            Toast.makeText(getApplicationContext(), "Length cannot be longer than 45", Toast.LENGTH_SHORT).show();

        } else if (length == 0) {

            Toast.makeText(getApplicationContext(), "Length cannot be '0'", Toast.LENGTH_SHORT).show();

        } else {

            String generatedPass = randomPassString(CHARSET, length);
            genPass.setText(generatedPass);

        }




    }

    public void makefontsnotshit(){
        EditText text1 = (EditText)findViewById(R.id.titleText);
        EditText text2 = (EditText)findViewById(R.id.genPass);

        text1.setTypeface(Typeface.DEFAULT);
        text2.setTypeface(Typeface.DEFAULT);
    }

}
