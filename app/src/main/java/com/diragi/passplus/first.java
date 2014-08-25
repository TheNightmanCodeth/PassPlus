package com.diragi.passplus;

import android.app.Activity;
import android.app.backup.RestoreObserver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
import android.app.backup.BackupManager;
import com.diragi.passplus.Encrypt2;
import com.diragi.passplus.passGen;


public class first extends themeCheck {
    SharedPreferences mPrefs;


    @Override
    public void finOnCreate() {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "0");
        setContentView(R.layout.activity_first);
        makefontsnotshit();
        mPrefs.getBoolean("Pro", false);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent goToPassGen = new Intent(first.this, passGen.class);

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //run the passGen thing
            first.this.startActivity(goToPassGen);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }



    public void setMastPass(View v){
        EditText mastPass = (EditText) findViewById(R.id.genPass);
        EditText mastPassConf = (EditText) findViewById(R.id.passwdText);
        EditText backupQuest = (EditText) findViewById(R.id.backupQuest);
        EditText backupAns = (EditText) findViewById(R.id.backupAns);
        Intent nextAct = new Intent(first.this, main.class);

        String pass = mastPass.getText().toString();
        String conf = mastPassConf.getText().toString();
        String backupQuestString = backupQuest.getText().toString();
        String backupAnsString = backupAns.getText().toString();
        char[] CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

        if(pass.equals(conf) && mastPass.getText().toString().trim().length() >= 10 && mastPassConf.getText().toString().trim().length() >= 10){

            //Change activity to activity_main
            first.this.startActivity(nextAct);
            SharedPreferences mPrefs;
            mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor passMainEditor = mPrefs.edit();
            Encrypt2 encrypt2 = new Encrypt2();
            passGen keyGen = new passGen();
            String key = "DECRYPT KEY GOES HERE";
            String encryptedPass = encrypt2.encrypt(key, pass);
            passMainEditor.putString("mastPass", encryptedPass);
            passMainEditor.putString("backupQuest", backupQuestString);

            passMainEditor.putString("backupAns", backupAnsString);
            Log.d("Passwords&backup", pass +", " +backupQuestString +", " +backupAnsString);
            passMainEditor.commit();
            this.finish();

        } else if(mastPass.getText().toString().trim().length() == 0 || mastPassConf.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "One or more fields are empty", Toast.LENGTH_SHORT).show();

        } else if (mastPass.getText().toString().trim().length() < 10) {
            Toast.makeText(getApplicationContext(), "That password is too short, for better security, please choose a password that is longer than 10 characters", Toast.LENGTH_LONG).show();
        }

        }

    public void makefontsnotshit(){
        EditText text1 = (EditText)findViewById(R.id.genPass);
        EditText text2 = (EditText)findViewById(R.id.passwdText);
        EditText text3 = (EditText)findViewById(R.id.backupQuest);
        EditText text4 = (EditText)findViewById(R.id.backupAns);

        text1.setTypeface(Typeface.DEFAULT);
        text2.setTypeface(Typeface.DEFAULT);
        text3.setTypeface(Typeface.DEFAULT);
        text4.setTypeface(Typeface.DEFAULT);
    }
    }


