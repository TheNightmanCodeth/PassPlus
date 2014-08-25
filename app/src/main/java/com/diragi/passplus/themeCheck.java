package com.diragi.passplus;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by Joe on 8/23/14.
 */
public abstract class themeCheck extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "Default theme");
        String themename = "Default";

        if(theme.equals("Red theme"))

        {
            Log.d("theme:", "Red");
            setTheme(R.style.AppThemeRed);
            themename = "Red";
            //Toast.makeText(getApplicationContext(), "If the theme is not correct, please reset Pass+", Toast.LENGTH_SHORT).show();
        }

        if(theme.equals("Black theme"))

        {
            setTheme(R.style.AppThemeBlack);
            themename = "Black";
            //Toast.makeText(getApplicationContext(), "If the theme is not correct, please reset Pass+", Toast.LENGTH_SHORT).show();
        }

        if(theme.equals("Default theme"))

        {
            setTheme(R.style.AppTheme);
            themename = "Default";
            //Toast.makeText(getApplicationContext(), "If the theme is not correct, please reset Pass+", Toast.LENGTH_SHORT).show();
        }

        if(theme.equals("Green theme"))

        {

            setTheme(R.style.AppThemeGreen);
            themename = "Green";

        }

        if(theme.equals("Cyan theme"))

        {

            setTheme(R.style.AppThemeCyan);
            themename = "Cyan";

        }

        if(theme.equals("drkBlu theme"))

        {

            setTheme(R.style.AppThemeDarkBlu);
            themename = "Dark Blue";

        }

        if(theme.equals("drkGrn theme"))

        {

            setTheme(R.style.AppThemeDarkGrn);
            themename = "Dark Green";

        }

        if(theme.equals("liteRed theme"))

        {

            setTheme(R.style.AppThemeRedLite);
            themename = "Light Red";

        }

        if(theme.equals("mat theme"))

        {

            setTheme(R.style.AppThemeMatGray);
            themename = "Material Gray";

        }

        if(theme.equals("Pnk theme"))

        {

            setTheme(R.style.AppThemePnk);
            themename = "Pink";

        }

        if(theme.equals("tel theme"))

        {

            setTheme(R.style.AppThemeTeal);
            themename = "Teal";

        }

        if(theme.equals("yel theme"))

        {

            setTheme(R.style.AppThemeYel);
            themename = "Yellow";

        }

        if(theme.equals("Light gray theme"))

        {

            setTheme(R.style.AppThemeLiteGray);
            themename = "Light Gray";

        }

        if(theme.equals("Purple theme"))

        {

            setTheme(R.style.AppThemePurp);
            themename = "Dark Purple";

        }

        if(theme.equals("Holo theme"))

        {

            setTheme(R.style.AppThemeholo);
            themename = "Holo Blue";

        }

        if(theme.equals("Holo dark theme"))

        {

            setTheme(R.style.AppThemeholodark);
            themename = "Holo Blue Dark";

        }

        if(theme.equals("Holo brite theme"))

        {

            setTheme(R.style.AppThemeholobrite);
            themename = "Holo Blue Bright";

        }

        if(theme.equals("Google blue theme"))

        {

            setTheme(R.style.AppThemegoogblu);
            themename = "Google Blue";

        }

        if(theme.equals("Google yellow theme"))

        {

            setTheme(R.style.AppThemegoogyel);
            themename = "Google Yellow";

        }

        if(theme.equals("Google red theme"))

        {

            setTheme(R.style.AppThemegoogred);
            themename = "Google Red";

        }

        if(theme.equals("Google green theme"))

        {

            setTheme(R.style.AppThemegooggrn);
            themename = "Google Green";

        }

        if(theme.equals("Weird green theme"))

        {

            setTheme(R.style.AppThemeweirdgrn);
            themename = "Really Dark Green";

        }

        if(theme.equals("Bright yellow theme"))

        {

            setTheme(R.style.AppThemebrightyel);
            themename = "Bright Yellow";

        }

        if(theme.equals("Light purple theme"))

        {

            setTheme(R.style.AppThemelightpurp);
            themename = "Light Purple";

        }

        if(theme.equals("Light orange theme"))

        {

            setTheme(R.style.AppThemeornglite);
            themename = "Light Orange";

        }

        if(theme.equals("Salmon theme"))

        {

            setTheme(R.style.AppThemesalmon);
            themename = "Salmon";

        }

        if(theme.equals("Kinda purple theme"))

        {

            setTheme(R.style.AppThemekindapurple);
            themename = "Purple";

        }

        if(theme.equals("Orange theme"))

        {

            setTheme(R.style.AppThemeorng);
            themename = "Orange";

        }



        finOnCreate();


    }

    abstract public void finOnCreate();

}
