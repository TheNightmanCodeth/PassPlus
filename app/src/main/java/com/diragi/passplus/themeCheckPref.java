package com.diragi.passplus;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by Joe on 8/23/14.
 */
public abstract class themeCheckPref extends PreferenceActivity {
    public String name = "Default";

    @Override
    public void onCreate(Bundle savedInstanceState){


        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "Default theme");
        name = "Default";

        if(theme.equals("Red theme"))

        {
            Log.d("theme:", "Red");
            setTheme(R.style.AppThemeRed);
            name = "Red";
            //Toast.makeText(getApplicationContext(), "If the theme is not correct, please reset Pass+", Toast.LENGTH_SHORT).show();
        }

        if(theme.equals("Black theme"))

        {
            setTheme(R.style.AppThemeBlack);
            name = "Black";
            //Toast.makeText(getApplicationContext(), "If the theme is not correct, please reset Pass+", Toast.LENGTH_SHORT).show();
        }

        if(theme.equals("Default theme"))

        {
            setTheme(R.style.AppTheme);
            name = "Default";
            //Toast.makeText(getApplicationContext(), "If the theme is not correct, please reset Pass+", Toast.LENGTH_SHORT).show();
        }

        if(theme.equals("Green theme"))

        {

            setTheme(R.style.AppThemeGreen);
            name = "Green";

        }

        if(theme.equals("Cyan theme"))

        {

            setTheme(R.style.AppThemeCyan);
            name = "Cyan";

        }

        if(theme.equals("drkBlu theme"))

        {

            setTheme(R.style.AppThemeDarkBlu);
            name = "Dark Blue";

        }

        if(theme.equals("drkGrn theme"))

        {

            setTheme(R.style.AppThemeDarkGrn);
            name = "Dark Green";

        }

        if(theme.equals("liteRed theme"))

        {

            setTheme(R.style.AppThemeRedLite);
            name = "Light Red";

        }

        if(theme.equals("mat theme"))

        {

            setTheme(R.style.AppThemeMatGray);
            name = "Material Gray";

        }

        if(theme.equals("Pnk theme"))

        {

            setTheme(R.style.AppThemePnk);
            name = "Pink";

        }

        if(theme.equals("tel theme"))

        {

            setTheme(R.style.AppThemeTeal);
            name = "Teal";

        }

        if(theme.equals("yel theme"))

        {

            setTheme(R.style.AppThemeYel);
            name = "Yellow";

        }

        if(theme.equals("Light gray theme"))

        {

            setTheme(R.style.AppThemeLiteGray);
            name = "Light Gray";

        }

        if(theme.equals("Purple theme"))

        {

            setTheme(R.style.AppThemePurp);
            name = "Dark Purple";

        }

        if(theme.equals("Holo theme"))

        {

            setTheme(R.style.AppThemeholo);
            name = "Holo Blue";

        }

        if(theme.equals("Holo dark theme"))

        {

            setTheme(R.style.AppThemeholodark);
            name = "Holo Blue Dark";

        }

        if(theme.equals("Holo brite theme"))

        {

            setTheme(R.style.AppThemeholobrite);
            name = "Holo Blue Bright";

        }

        if(theme.equals("Google blue theme"))

        {

            setTheme(R.style.AppThemegoogblu);
            name = "Google Blue";

        }

        if(theme.equals("Google yellow theme"))

        {

            setTheme(R.style.AppThemegoogyel);
            name = "Google Yellow";

        }

        if(theme.equals("Google red theme"))

        {

            setTheme(R.style.AppThemegoogred);
            name = "Google Red";

        }

        if(theme.equals("Google green theme"))

        {

            setTheme(R.style.AppThemegooggrn);
            name = "Google Green";

        }

        if(theme.equals("Weird green theme"))

        {

            setTheme(R.style.AppThemeweirdgrn);
            name = "Really Dark Green";

        }

        if(theme.equals("Bright yellow theme"))

        {

            setTheme(R.style.AppThemebrightyel);
            name = "Bright Yellow";

        }

        if(theme.equals("Light purple theme"))

        {

            setTheme(R.style.AppThemelightpurp);
            name = "Light Purple";

        }

        if(theme.equals("Light orange theme"))

        {

            setTheme(R.style.AppThemeornglite);
            name = "Light Orange";

        }

        if(theme.equals("Salmon theme"))

        {

            setTheme(R.style.AppThemesalmon);
            name = "Salmon";

        }

        if(theme.equals("Kinda purple theme"))

        {

            setTheme(R.style.AppThemekindapurple);
            name = "Purple";

        }

        if(theme.equals("Orange theme"))

        {

            setTheme(R.style.AppThemeorng);
            name = "Orange";

        }



        super.onCreate(savedInstanceState);

        finOnCreate();


    }

    public String setSummary(){

        return name;

    }

    abstract public void finOnCreate();

}
