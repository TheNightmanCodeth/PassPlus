package com.diragi.passplus;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
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
import com.diragi.passplus.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.diragi.passplus.DriveBackup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Backup extends PreferenceActivity {

    GoogleApiClient.Builder mGoogleApiClient;
    SharedPreferences mPrefs;
    List<List<String>> passBackup = new ArrayList<List<String>>();

    //WORK IN PROGRESS

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.backup);

        mPrefs = getSharedPreferences("backupFile", MODE_APPEND);

        SharedPreferences.Editor editor = mPrefs.edit();
        mPrefs.getStringSet("pass", null);



    }



}
