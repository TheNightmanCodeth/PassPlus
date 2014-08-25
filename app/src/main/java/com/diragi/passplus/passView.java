package com.diragi.passplus;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.diragi.passplus.Encrypt2;

import com.diragi.passplus.R;

public class passView extends themeCheck {
    SharedPreferences mPrefs;
    String masterPass = "";
    String passedPassword = "";
    String passBoxContent = "";
    EditText textPreview;
    EditText masterPassBox;

    @Override
    public void finOnCreate() {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "0");
        setContentView(R.layout.activity_pass_view);

        makefontsnotshit();

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = mPrefs.edit();



        String passedTitle = mPrefs.getString("listClickTitle", null);
        Log.d("passView", "The clicked title is: " +passedTitle);

        passedPassword = mPrefs.getString(passedTitle, null);
        Log.d("passView", "The clicked password is: " +passedPassword);

         masterPass = mPrefs.getString("mastPass", "");

        getActionBar().setTitle(passedTitle);

        masterPassBox = (EditText)findViewById(R.id.mastPassView);

        textPreview = (EditText)findViewById(R.id.passPreview);

    }

    public void onClick(View v) {

        passBoxContent = masterPassBox.getText().toString();
        Encrypt2 encrypt = new Encrypt2();
        String key = "SUPER SECRET ENCRYPTION KEY GOES HERE";

        String masterPassDec = encrypt.decrypt(key, masterPass);
        Log.d("Decrypt: ", masterPassDec);

        if (passBoxContent.equals(masterPassDec)) {
            Log.d("passView", "The passwords match");

            String decrypt = "";
            Log.d(masterPass, passedPassword);


            Encrypt2 encrypt2 = new Encrypt2();

            String mastPassData = passBoxContent;

            String masterPassDecrypt = encrypt2.decrypt(key, masterPass);

            if (masterPassDecrypt.equals(mastPassData)) {

                try {
                    decrypt = encrypt2.decrypt(key, passedPassword);
                    Log.d("Decryption: ", "Succeded: " + decrypt);
                } catch (Exception e) {
                    Log.d("Decryption", "failed");
                }
                textPreview.setText(decrypt);
                //TODO: Only show password for a set amount of time, then hide it
            } else {
                Toast.makeText(getApplicationContext(), "That is not your master password", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pass_view, menu);
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

    public void makefontsnotshit(){
        EditText text1 = (EditText)findViewById(R.id.mastPassView);

        text1.setTypeface(Typeface.DEFAULT);
    }


    @Override
    public void onPause(){

        //clear the textviews/edittexts so people can't go back and find your passwords
        textPreview.setText("");
        masterPassBox.setText("");
        super.onPause();

    }

}
