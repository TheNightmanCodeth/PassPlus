package com.diragi.passplus;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.Image;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.diragi.passplus.R;
import com.hannesdorfmann.swipeback.Position;
import com.hannesdorfmann.swipeback.SwipeBack;

import java.util.List;
import java.util.Objects;

/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsActivity extends themeCheckPref implements Preference.OnPreferenceClickListener{

    ImageView red;
    ImageView def;
    ImageView bla;
    Dialog dialog;
    String theme = "Default";
    Preference themePick;
    String themePickSum;
    ImageView cya;
    ImageView grn;
    ImageView drkBlu;
    ImageView drkGrn;
    ImageView liteRed;
    ImageView mat;
    ImageView Pnk;
    ImageView tel;
    ImageView yel;
    //Pro
    ImageView ltgry;
    ImageView purp;
    ImageView holo;
    ImageView holodark;
    ImageView holobrite;
    ImageView googblu;
    ImageView googyel;
    ImageView googred;
    ImageView googgrn;
    ImageView weirdgrn;
    ImageView bryel;
    ImageView lpurp;
    ImageView orlt;
    ImageView sal;
    ImageView kpurp;
    ImageView orng;
    Boolean pro;
    Boolean dialogpress = false;


    @Override
    public void finOnCreate() {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "0");
        pro = mPrefs.getBoolean("pro", false);

        name = setSummary();

        String summary = "Chose a new theme. The current theme is: " +name;


        addPreferencesFromResource(R.xml.preferences);
        themePick = (Preference)findPreference("pref_themeColor");
        themePick.setSummary(summary);


        themePick.setOnPreferenceClickListener(this);


    }

    @Override
    public boolean onPreferenceClick(Preference preference){

        dialogpress = true;

        dialog = new Dialog(SettingsActivity.this);
        dialog.setContentView(R.layout.themes_dialog);
        dialog.setTitle("Themes");
        dialog.setCancelable(true);

        // Free theme imageviews
        red = (ImageView)dialog.findViewById(R.id.Red);
        def = (ImageView)dialog.findViewById(R.id.Default);
        bla = (ImageView)dialog.findViewById(R.id.Black);
        cya = (ImageView)dialog.findViewById(R.id.Cyan);
        grn = (ImageView)dialog.findViewById(R.id.grn);
        drkBlu = (ImageView)dialog.findViewById(R.id.drkBlu);
        drkGrn = (ImageView)dialog.findViewById(R.id.drkGrn);
        liteRed = (ImageView)dialog.findViewById(R.id.liteRed);
        mat = (ImageView)dialog.findViewById(R.id.mat);
        Pnk = (ImageView)dialog.findViewById(R.id.Pnk);
        tel = (ImageView)dialog.findViewById(R.id.tel);
        yel = (ImageView)dialog.findViewById(R.id.yel);

        // Pro theme imageviews
        ltgry = (ImageView)dialog.findViewById(R.id.ltgry);
        purp = (ImageView)dialog.findViewById(R.id.purp);
        holo = (ImageView)dialog.findViewById(R.id.holo);
        holodark = (ImageView)dialog.findViewById(R.id.holodark);
        holobrite = (ImageView)dialog.findViewById(R.id.holobrite);
        googblu = (ImageView)dialog.findViewById(R.id.googblu);
        googyel = (ImageView)dialog.findViewById(R.id.googyel);
        googred = (ImageView)dialog.findViewById(R.id.googred);
        googgrn = (ImageView)dialog.findViewById(R.id.googgrn);
        weirdgrn = (ImageView)dialog.findViewById(R.id.weirdgrn);
        bryel = (ImageView)dialog.findViewById(R.id.brightyel);
        lpurp = (ImageView)dialog.findViewById(R.id.lightPurp);
        orlt = (ImageView)dialog.findViewById(R.id.ornglite);
        sal = (ImageView)dialog.findViewById(R.id.salmon);
        kpurp = (ImageView)dialog.findViewById(R.id.kindapurple);
        orng = (ImageView)dialog.findViewById(R.id.orng);

        final SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPrefs.edit();

        String color = mPrefs.getString("pref_themeColor", "Default theme");

        checkTheRightBox(color);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                red.setImageResource(R.drawable.redbuttonw);
                def.setImageResource(R.drawable.defbutton);
                bla.setImageResource(R.drawable.blackbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "Red theme");
                editor.commit();

                theme = "Red";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();


            }
        });

        drkBlu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                red.setImageResource(R.drawable.redbutton);
                def.setImageResource(R.drawable.defbutton);
                bla.setImageResource(R.drawable.blackbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkbluw);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "drkBlu theme");
                editor.commit();

                theme = "Dark Blue";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();


            }
        });

        drkGrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                red.setImageResource(R.drawable.redbutton);
                def.setImageResource(R.drawable.defbutton);
                bla.setImageResource(R.drawable.blackbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreenw);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "drkGrn theme");
                editor.commit();

                theme = "Dark Green";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();


            }
        });

        liteRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                red.setImageResource(R.drawable.redbutton);
                def.setImageResource(R.drawable.defbutton);
                bla.setImageResource(R.drawable.blackbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.literedw);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "liteRed theme");
                editor.commit();

                theme = "Light Red";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();


            }
        });

        mat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                red.setImageResource(R.drawable.redbutton);
                def.setImageResource(R.drawable.defbutton);
                bla.setImageResource(R.drawable.blackbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.matw);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "mat theme");
                editor.commit();

                theme = "Green";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();


            }
        });

        Pnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                red.setImageResource(R.drawable.redbutton);
                def.setImageResource(R.drawable.defbutton);
                bla.setImageResource(R.drawable.blackbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnkw);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "Pnk theme");
                editor.commit();

                theme = "Pink";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();


            }
        });

        tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                red.setImageResource(R.drawable.redbutton);
                def.setImageResource(R.drawable.defbutton);
                bla.setImageResource(R.drawable.blackbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.telw);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "tel theme");
                editor.commit();

                theme = "Teal";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();


            }
        });

        yel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                red.setImageResource(R.drawable.redbutton);
                def.setImageResource(R.drawable.defbutton);
                bla.setImageResource(R.drawable.blackbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yelw);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "yel theme");
                editor.commit();

                theme = "Yellow";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();


            }
        });

        grn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                red.setImageResource(R.drawable.redbutton);
                def.setImageResource(R.drawable.defbutton);
                bla.setImageResource(R.drawable.blackbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.greenw);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "Green theme");
                editor.commit();

                theme = "Green";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();


            }
        });

        cya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                red.setImageResource(R.drawable.redbutton);
                def.setImageResource(R.drawable.defbutton);
                bla.setImageResource(R.drawable.blackbutton);
                cya.setImageResource(R.drawable.cyaw);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "Cyan theme");
                editor.commit();

                theme = "Cyan";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();


            }
        });
        Log.d("Push: ", "yas4");

        def.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                def.setImageResource(R.drawable.defbuttonw);
                bla.setImageResource(R.drawable.blackbutton);
                red.setImageResource(R.drawable.redbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "Default theme");
                editor.commit();

                theme = "Default";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();

            }
        });
        Log.d("Push: ", "yas5");

        bla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bla.setImageResource(R.drawable.blackbuttonw);
                def.setImageResource(R.drawable.defbutton);
                red.setImageResource(R.drawable.redbutton);
                cya.setImageResource(R.drawable.cya);
                grn.setImageResource(R.drawable.green);
                drkBlu.setImageResource(R.drawable.drkblu);
                drkGrn.setImageResource(R.drawable.wgreen);
                liteRed.setImageResource(R.drawable.litered);
                mat.setImageResource(R.drawable.mat);
                Pnk.setImageResource(R.drawable.pnk);
                tel.setImageResource(R.drawable.tel);
                yel.setImageResource(R.drawable.yel);
                ltgry.setImageResource(R.drawable.ltgry);
                purp.setImageResource(R.drawable.purp);
                holo.setImageResource(R.drawable.holo);
                holodark.setImageResource(R.drawable.holodark);
                holobrite.setImageResource(R.drawable.holobrite);
                googblu.setImageResource(R.drawable.googblu);
                googyel.setImageResource(R.drawable.googyel);
                googred.setImageResource(R.drawable.googred);
                googgrn.setImageResource(R.drawable.googgrn);
                weirdgrn.setImageResource(R.drawable.weirdgrn);
                bryel.setImageResource(R.drawable.brightyel);
                lpurp.setImageResource(R.drawable.lightpurp);
                orlt.setImageResource(R.drawable.ornglite);
                sal.setImageResource(R.drawable.salmon);
                kpurp.setImageResource(R.drawable.kindapurple);
                orng.setImageResource(R.drawable.orng);

                editor.putString("pref_themeColor", "Black theme");
                editor.commit();

                theme = "Default";

                themePick.setSummary("Chose a new theme. The current theme is: " +theme);

                AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                freedomAlert.setTitle("Restart Pass+?");
                freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                        .setInverseBackgroundForced(true)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(restart);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int I) {
                                dialog.cancel();
                            }

                        });

                AlertDialog alertDialog = freedomAlert.create();

                alertDialog.show();

            }
        });

        ltgry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {

                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgryw);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Light gray theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }

        });

        purp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {

                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purpw);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Purple theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }
            }
        });

        holo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {

                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holow);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Holo theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                }else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        holodark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {
                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodarkw);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Holo dark theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        holobrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {
                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobritew);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Holo brite theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        googblu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {

                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googbluw);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Google blue theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                }else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }
            }
        });

        googyel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {

                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyelw);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Google yellow theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();
                }else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        googred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {
                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googredw);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Google red theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        googgrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {

                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrnw);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Google green theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        weirdgrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {
                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrnw);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Weird green theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        bryel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {
                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyelw);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Bright yellow theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        lpurp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {
                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurpw);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Light purple theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();
                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        orlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {
                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglitew);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Light orange theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();
                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        sal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {
                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmonw);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Salmon theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }
            }
        });

        kpurp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {
                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurplew);
                    orng.setImageResource(R.drawable.orng);

                    editor.putString("pref_themeColor", "Kinda purple theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();
                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        orng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pro) {
                    bla.setImageResource(R.drawable.blackbutton);
                    def.setImageResource(R.drawable.defbutton);
                    red.setImageResource(R.drawable.redbutton);
                    cya.setImageResource(R.drawable.cya);
                    grn.setImageResource(R.drawable.green);
                    drkBlu.setImageResource(R.drawable.drkblu);
                    drkGrn.setImageResource(R.drawable.wgreen);
                    liteRed.setImageResource(R.drawable.litered);
                    mat.setImageResource(R.drawable.mat);
                    Pnk.setImageResource(R.drawable.pnk);
                    tel.setImageResource(R.drawable.tel);
                    yel.setImageResource(R.drawable.yel);
                    ltgry.setImageResource(R.drawable.ltgry);
                    purp.setImageResource(R.drawable.purp);
                    holo.setImageResource(R.drawable.holo);
                    holodark.setImageResource(R.drawable.holodark);
                    holobrite.setImageResource(R.drawable.holobrite);
                    googblu.setImageResource(R.drawable.googblu);
                    googyel.setImageResource(R.drawable.googyel);
                    googred.setImageResource(R.drawable.googred);
                    googgrn.setImageResource(R.drawable.googgrn);
                    weirdgrn.setImageResource(R.drawable.weirdgrn);
                    bryel.setImageResource(R.drawable.brightyel);
                    lpurp.setImageResource(R.drawable.lightpurp);
                    orlt.setImageResource(R.drawable.ornglite);
                    sal.setImageResource(R.drawable.salmon);
                    kpurp.setImageResource(R.drawable.kindapurple);
                    orng.setImageResource(R.drawable.orngw);

                    editor.putString("pref_themeColor", "Orange theme");
                    editor.commit();

                    theme = "Default";

                    themePick.setSummary("Chose a new theme. The current theme is: " + theme);

                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(SettingsActivity.this);
                    freedomAlert.setTitle("Restart Pass+?");
                    freedomAlert.setMessage("The theme will not change until you restart Pass+. If you click 'Accept' below, Pass+ will restart now, otherwise you will have to restart later.")
                            .setInverseBackgroundForced(true)
                            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent restart = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                                    restart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(restart);

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }

                            });

                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();
                } else {
                    Toast.makeText(SettingsActivity.this, "This is a pro theme. Please buy pro to unlock all themes(:", Toast.LENGTH_LONG).show();
                }

            }
        });

        Log.d("Push: ", "yas6");


        dialog.show();
        Log.d("Push: ", "yas7");

        return false;

    }

    public void checkTheRightBox(String color){

        //Make sure the correct theme is checked when user goes to change theme

        if (color.equals("Red theme")){

            red.setImageResource(R.drawable.redbuttonw);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Default theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbuttonw);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Black theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbuttonw);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Cyan theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cyaw);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Green theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.greenw);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("drkBlu theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkbluw);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("drkGrn theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreenw);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("liteRed theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.literedw);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("mat theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.matw);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Pnk theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnkw);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("tel theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.telw);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("yel theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yelw);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Light gray theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgryw);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Purple theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purpw);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Holo theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holow);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Holo dark theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodarkw);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Holo brite theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobritew);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Google blue theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googbluw);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Google yellow theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyelw);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Google red theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googredw);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Google green theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrnw);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Weird green theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrnw);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Bright yellow theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyelw);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Light purple theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurpw);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Light orange theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglitew);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Salmon theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmonw);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Kinda purple theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurplew);
            orng.setImageResource(R.drawable.orng);

        }

        if (color.equals("Orange theme")){

            red.setImageResource(R.drawable.redbutton);
            def.setImageResource(R.drawable.defbutton);
            bla.setImageResource(R.drawable.blackbutton);
            cya.setImageResource(R.drawable.cya);
            grn.setImageResource(R.drawable.green);
            drkBlu.setImageResource(R.drawable.drkblu);
            drkGrn.setImageResource(R.drawable.wgreen);
            liteRed.setImageResource(R.drawable.litered);
            mat.setImageResource(R.drawable.mat);
            Pnk.setImageResource(R.drawable.pnk);
            tel.setImageResource(R.drawable.tel);
            yel.setImageResource(R.drawable.yel);
            ltgry.setImageResource(R.drawable.ltgry);
            purp.setImageResource(R.drawable.purp);
            holo.setImageResource(R.drawable.holo);
            holodark.setImageResource(R.drawable.holodark);
            holobrite.setImageResource(R.drawable.holobrite);
            googblu.setImageResource(R.drawable.googblu);
            googyel.setImageResource(R.drawable.googyel);
            googred.setImageResource(R.drawable.googred);
            googgrn.setImageResource(R.drawable.googgrn);
            weirdgrn.setImageResource(R.drawable.weirdgrn);
            bryel.setImageResource(R.drawable.brightyel);
            lpurp.setImageResource(R.drawable.lightpurp);
            orlt.setImageResource(R.drawable.ornglite);
            sal.setImageResource(R.drawable.salmon);
            kpurp.setImageResource(R.drawable.kindapurple);
            orng.setImageResource(R.drawable.orngw);

        }

    }

    @Override
    public void onPause(){

        //This is important. Without this the dialog window will leak and that's bad news.
        //We check if the dialog was opened, If it was we dismiss it, and if it wasn't then we don't do anything....
        if (dialogpress) {

            dialog.dismiss();

        }

        super.onPause();

    }


}

