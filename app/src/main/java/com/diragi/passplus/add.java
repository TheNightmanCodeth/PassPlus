package com.diragi.passplus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.diragi.passplus.Encrypt2;


import android.app.backup.BackupManager;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class add extends themeCheck {
    public static String TITLE = "title";
    public static String PASSWORD = "password";
    SharedPreferences mPrefs;
    SharedPreferences passPrefs;
    SharedPreferences.Editor editor;
    Set<String> passNames;
    Set<String> passNamesPrefs;






    private SimpleAdapter sa;

    @Override
    public void finOnCreate() {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "0");
        setContentView(R.layout.activity_add);
        makefontsnotshit();
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setTitle("Add a New Password");
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = mPrefs.edit();

        editor.putStringSet("passNames", null);



    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.swipeback_stack_to_front, R.anim.swipeback_stack_right_out);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        EditText titleBox = (EditText)findViewById(R.id.titleText);
        TITLE = titleBox.getText().toString();

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        passPrefs = getSharedPreferences("passData", MODE_APPEND);

        SharedPreferences.Editor editor = mPrefs.edit();
        SharedPreferences.Editor passPrefsEditor = passPrefs.edit();

        EditText passBox = (EditText)findViewById(R.id.passwdText);
        String pass = passBox.getText().toString();

        EditText confBox = (EditText)findViewById(R.id.confirmNewPass);
        String conf = confBox.getText().toString();





        if (pass.equals(conf)) {

            Intent intent = new Intent(this, main.class);

            Set<String> passwordList = mPrefs.getStringSet("pass", new HashSet<String>());

            Set<String> passwordData = passPrefs.getStringSet("passData", new HashSet<String>());

            String[] swag = passwordData.toArray(new String[passwordData.size()]);

            passwordData.add(TITLE);
            passPrefsEditor.putStringSet("passData", passwordData);




            passwordList.add(TITLE);

            editor.putStringSet("pass", passwordList);

            Encrypt2 Encrypt2 = new Encrypt2();

            EditText masPassBox = (EditText)findViewById(R.id.masterPassBox);

            String key = "DECRYPTION KEY GOES HERE";

            String mastPassData = masPassBox.getText().toString();

            String mastPassEncrypt = mPrefs.getString("mastPass", "");

            String mastPassDecrypt = Encrypt2.decrypt(key, mastPassEncrypt);

            Log.d("Decrypted pass: ", mastPassDecrypt);

            if (mastPassData.equals(mastPassDecrypt)) {

                String encrypt2 = Encrypt2.encrypt(key, conf);

                editor.putString(TITLE, encrypt2);
                passwordList.add(encrypt2);

                passwordData.add(encrypt2);
                passPrefsEditor.putStringSet("passData", passwordData);

                passPrefsEditor.commit();
                editor.commit();

                requestBackup();
                Log.d("Backup: ", "Did backup");

                startActivity(intent);

                this.finish();
            } else {
                Toast.makeText(getApplicationContext(), "That's not your main password", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
        }

    }

    public void requestBackup() {

        BackupManager bm = new BackupManager(this);
        bm.dataChanged();

    }

    public void makefontsnotshit(){
        EditText text1 = (EditText)findViewById(R.id.titleText);
        EditText text2 = (EditText)findViewById(R.id.passwdText);
        EditText text3 = (EditText)findViewById(R.id.confirmNewPass);
        EditText text4 = (EditText)findViewById(R.id.masterPassBox);

        text1.setTypeface(Typeface.DEFAULT);
        text2.setTypeface(Typeface.DEFAULT);
        text3.setTypeface(Typeface.DEFAULT);
        text4.setTypeface(Typeface.DEFAULT);
    }

}
