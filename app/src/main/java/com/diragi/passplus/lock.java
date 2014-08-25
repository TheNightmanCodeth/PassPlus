package com.diragi.passplus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.diragi.passplus.Encrypt2;

public class lock extends themeCheck {
    final String welcomeScreenShownPref = "welcomeScreenShown";
    Boolean lockScreen;
    final String lockScreenShowPref = "lockScreenShow";

    SharedPreferences mPrefs;
    String masterPass;
    String pass;

    @Override
    public void finOnCreate() {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "0");
        setContentView(R.layout.activity_lock);
        makefontsnotshit();

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);



        Boolean welcomeScreenShown = mPrefs.getBoolean(welcomeScreenShownPref, false);
        SharedPreferences.Editor editor = mPrefs.edit();
        if (!welcomeScreenShown) {
            Intent goToNextAct = new Intent(lock.this, first.class);
            startActivity(goToNextAct);
            editor.putBoolean(welcomeScreenShownPref, true);
            editor.commit();

        } else if (welcomeScreenShown) {

            editor.putBoolean(lockScreenShowPref, true);




        masterPass = mPrefs.getString("mastPass", "empty");

        if (masterPass.equals("empty")) {

            //If we can't find a master password we need to ask the user to set one
            AlertDialog.Builder setMastPass = new AlertDialog.Builder(lock.this);
            setMastPass.setTitle("Set Master Password?")
                    .setMessage("It looks like you haven't set a master password yet. Without a master password you won't be able to use Pass+): Tap 'Set Now' to set your master password.")
                    .setPositiveButton("Set Now", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface d, int i) {

                            Intent setPass = new Intent(lock.this, first.class);
                            startActivity(setPass);

                        }
                    });
            AlertDialog ad = setMastPass.create();
            ad.show();

        }


        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lock, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent forgotPass = new Intent(lock.this, forgot.class);
        switch (item.getItemId()){
            case R.id.action_settings:
                startActivity(forgotPass);



        }
        return super.onOptionsItemSelected(item);
    }

    public void onItemClick(View v){
        EditText mastPass = (EditText)findViewById(R.id.backupQuest);
        String pass = mastPass.getText().toString();
        String key = "DECRYPT KEY GOES HERE";
        Encrypt2 encrypt2 = new Encrypt2();

        String mastPassDecrypt = encrypt2.decrypt(key, masterPass);
        Log.d("MastPasDecrypt = ", mastPassDecrypt);

        if (pass.equals(mastPassDecrypt)){

            Intent i = new Intent(lock.this, main.class);
            this.startActivity(i);

        } else {
            Toast.makeText(getApplicationContext(), "That password is incorrect", Toast.LENGTH_SHORT).show();
        }

    }

    public void makefontsnotshit(){
        EditText text1 = (EditText)findViewById(R.id.backupQuest);

        text1.setTypeface(Typeface.DEFAULT);
    }

}
