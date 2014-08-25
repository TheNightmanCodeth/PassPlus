package com.diragi.passplus;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.diragi.passplus.R;

import java.util.List;

public class AboutActivity extends themeCheckPref implements Preference.OnPreferenceClickListener{
    int i = 0;

    @Override
    public void finOnCreate() {

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "0");

        addPreferencesFromResource(R.xml.about);

        Preference author = (Preference)findPreference("author");

        author.setOnPreferenceClickListener(this);



    }

    @Override
    public boolean onPreferenceClick(Preference preference){
        final SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor edit = mPrefs.edit();

        if (i <= 9){
            i++;
        }

        if (i == 10){
            i = 0;
            final String[] keys = getResources().getStringArray(R.array.keys);
            AlertDialog.Builder enterKey = new AlertDialog.Builder(this);

            enterKey.setTitle("Enter Pass+ Pro Key");
            enterKey.setMessage("If you received a Pass+ key, enter it below: ");

            final EditText keyInput = new EditText(this);
            enterKey.setView(keyInput);

            enterKey.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String keyInputVal = keyInput.getText().toString();

                    Boolean isKeyMatch = isKeyMatch(keyInputVal, keys);

                    if (isKeyMatch) {
                        Boolean pro = mPrefs.getBoolean("pro", false);
                        edit.putBoolean("pro", true);
                        edit.commit();
                        AlertDialog.Builder reset = new AlertDialog.Builder(AboutActivity.this);
                        reset.setTitle("Reset");
                        reset.setMessage("Pro version will become active after Pass+ resets. Would you like to reset now?");
                        reset.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        });
                        reset.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.cancel();

                            }
                        });
                        reset.show();


                        Toast.makeText(getApplicationContext(), "Upgrade successful", Toast.LENGTH_LONG).show();
                    } else if (keyCheck(keyInputVal)){

                        Boolean pro = mPrefs.getBoolean("pro", false);
                        edit.putBoolean("pro", true);
                        edit.commit();
                        AlertDialog.Builder reset = new AlertDialog.Builder(AboutActivity.this);
                        reset.setTitle("Reset");
                        reset.setMessage("Pro version will become active after Pass+ resets. Would you like to reset now?");
                        reset.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        });
                        reset.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.cancel();

                            }
                        });
                        reset.show();


                        Toast.makeText(getApplicationContext(), "Upgrade successful", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "That is not a valid key, please try again. Keys are case sensitive. If problem persists, email me and I'll help you out.", Toast.LENGTH_LONG).show();
                    }

                }
            });

            enterKey.show();
        }

        return false;

    }

    public static boolean isKeyMatch(String inputString, String[] items){

        for (int i = 0; i < items.length; i++)
        {
            if (inputString.contains(items[i])){
                return true;
            }
        }

        return false;

    }

    public boolean keyCheck(String key){

        //Super secret key checking algorithm goes here(;
        return false;

    }


}
