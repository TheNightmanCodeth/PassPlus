package com.diragi.passplus;

import android.app.Activity;
import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;
import com.diragi.passplus.Encrypt2;

import com.diragi.passplus.R;

public class forgot extends themeCheck {
    TextView backupQuestTextView;
    EditText backupAnsEditText;
    SharedPreferences mPrefs;
    SharedPreferences.Editor editor;
    String backupAns;

    @Override
    public void finOnCreate() {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "0");

        setContentView(R.layout.activity_forgot);

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = mPrefs.edit();

        backupQuestTextView = (TextView) findViewById(R.id.backupQuestTextView);
        backupAnsEditText = (EditText) findViewById(R.id.yolo);
        String backupQuest = mPrefs.getString("backupQuest", "You haven't set a backup question!...Which is odd...");
        backupAns = mPrefs.getString("backupAns", null);

        backupQuestTextView.setText(backupQuest);
        Log.d("forgot", "" +backupQuest +", " +backupAns);


    }

    public void forgotOnClick(View v) {

        String ansText = backupAnsEditText.getText().toString();
        String mastPass = mPrefs.getString("mastPass", "");
        Encrypt2 encrypt2 = new Encrypt2();
        String key = "DECRYPT KEY GOES HERE";
        String mastPassDec = encrypt2.decrypt(key, mastPass);

        if (backupAns != null) {

            if (ansText.equals(backupAns)){
                Toast.makeText(getApplicationContext(), "Your master password is: " +mastPassDec, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "That isn't the correct answer", Toast.LENGTH_SHORT).show();
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.forgot, menu);
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

        EditText text1 = (EditText)findViewById(R.id.yolo);

        text1.setTypeface(Typeface.DEFAULT);

    }
}
