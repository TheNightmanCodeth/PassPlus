package com.diragi.passplus;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;
import android.app.backup.FileBackupHelper;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.app.backup.BackupManager;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Joe on 7/10/14.
 */

public class BackupAgent extends BackupAgentHelper {

    //WORK IN PROGRESS

    static final String name_of_preferences = "com.diragi.passplus_preferences";
    static final String PREFS_BACKUP_KEY = "passPlus";

    @Override
    public void onCreate() {

        Log.d("Name of sharedPrefs", name_of_preferences);
        SharedPreferencesBackupHelper backupPrefs = new SharedPreferencesBackupHelper(this, name_of_preferences);
        addHelper(PREFS_BACKUP_KEY, backupPrefs);
    }



}
