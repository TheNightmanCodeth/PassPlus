package com.diragi.passplus;

import com.diragi.passplus.util.IabHelper;
import com.diragi.passplus.util.IabResult;
import com.diragi.passplus.util.Inventory;
import com.diragi.passplus.util.Purchase;


import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import org.apache.commons.lang3.ArrayUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import com.diragi.passplus.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class main extends themeCheck {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private static final int ACTIVITY_CREATE = 0;
    private static final int ACTIVITY_EDIT = 1;
    private static ArrayAdapter<String> listadapter;
    private Bundle extras = new Bundle();
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String titleWoop;
    private String[] mDrawerSections;
    private static ArrayList<String> listFinal = new ArrayList<String>();
    ArrayList<String> list = new ArrayList<String>();
    TextView text;
    SharedPreferences mPrefs;
    Boolean lockScreen;
    private SimpleAdapter sa;
    Set<String> passList = null;


    @Override
    public void finOnCreate() {

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Set theme
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "0");

        setContentView(R.layout.activity_main);


        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("uh a Device Identifier string goes here for testing the ads... It's not important").build();

        adView.loadAd(adRequest);

        //final String[] passwordList = new String[]{"Add a password!"};

        final SharedPreferences.Editor editor = mPrefs.edit();
        final Set<String> passwordYay = mPrefs.getStringSet("pass", new HashSet<String>());
        final ListView passwordListView = (ListView) findViewById(R.id.passwordlistView);
        final LinearLayout adLayout = (LinearLayout) findViewById(R.id.linearLayout);
        final View adMob = (View) findViewById(R.id.adView);
        Boolean pro = mPrefs.getBoolean("pro", false);

        getActionBar().setTitle("Pass+");


        list = new ArrayList<String>(passwordYay);

        Boolean support = mPrefs.getBoolean("support", true);
        String sup = "blank";


        if (pro) {

            adLayout.removeView(adMob);
            ViewGroup.LayoutParams params = passwordListView.getLayoutParams();
            params.height = ViewGroup.LayoutParams.FILL_PARENT;
            passwordListView.setLayoutParams(params);
            passwordListView.requestLayout();

        }

        if (passwordYay == null){

            //TODO: Display a listview that has one item that says "click here to add a new password" and obviously when clicked start a new intent to the addPass activity

        }


        if (passwordYay != null) {
            listadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
            passwordListView.setAdapter(listadapter);
            //onClickListener for the main list
            passwordListView.setLongClickable(true);
            passwordListView.setOnItemLongClickListener(new OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View strings, final int i, long l) {

                    AlertDialog.Builder deleteConf = new AlertDialog.Builder(main.this);
                    final int positionToRemove = i;

                    deleteConf.setTitle("Delete Password?");
                    deleteConf.setMessage("Are you sure you want to delete the password '" + list.get(i) + "'?");

                    deleteConf.setNegativeButton("No", null);
                    deleteConf.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int w) {
                            Log.d("dialog", "Pressed YES");
                            editor.remove(list.get(positionToRemove));
                            list.remove(positionToRemove);

                            Set<String> updateList = new HashSet<String>(list);
                            editor.putStringSet("pass", updateList);
                            editor.commit();
                            listadapter.notifyDataSetChanged();
                            listadapter.notifyDataSetInvalidated();

                        }
                    });
                    deleteConf.show();
                    return true;
                }
            });
            passwordListView.setClickable(true);
            passwordListView.setOnItemClickListener((new OnItemClickListener() {
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                    //Get the password title to display on the passView actionbar
                    String title = (String) list.get(position);
                    editor.putString("listClickTitle", title);
                    editor.commit();

                    Intent passViewIntent = new Intent(main.this, passView.class);
                    startActivity(passViewIntent);
                }

            }));
            List<String> prefsList = new ArrayList<String>(list);

        }


        mTitle = mDrawerTitle = getTitle();
        mDrawerSections = getResources().getStringArray(R.array.drawerArray);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        //make a shadow
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        //set up drawer listview yay
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerSections));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());



        //Actionbar arrow icon thing
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);


    }

    public static class DrawerFragment extends Fragment {
        public static final String ARG_SEL_NUMBER = "sel_number";

        public DrawerFragment() {
            //empty for frag subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main, container, false);
            int i = getArguments().getInt(ARG_SEL_NUMBER);
            String item = getResources().getStringArray(R.array.drawerArray)[i];

            return rootView;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //called on invalidatoptionsmenu
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        Intent nextAct = new Intent(main.this, SettingsActivity.class);
        switch (item.getItemId()) {

            case R.id.action_settings:
                //Change to the passGen activity
                startActivity(nextAct);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //The clicklistener for the navbar ayy
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);

            switch (position) {
                case 0:
                    //Stay at the current screen
                    Intent intent = new Intent(main.this, main.class);

                    break;

                case 1:
                    //Add Password
                    Intent intent2 = new Intent(main.this, add.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    main.this.startActivity(intent2);

                    break;

                case 2:
                    //Password Generator
                    Intent passGenIntent = new Intent(main.this, passGen.class);
                    passGenIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    main.this.startActivity(passGenIntent);
                    break;

                case 3:
                    //settings
                    Intent settingsIntent = new Intent(main.this, SettingsActivity.class);
                    settingsIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    main.this.startActivity(settingsIntent);
                    break;

                case 4:
                    //Upgrade
                    Intent upgradeIntent = new Intent(main.this, Upgrade.class);
                    upgradeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    main.this.startActivity(upgradeIntent);
                    break;


                case 5:
                    //About
                    Intent aboutIntent = new Intent(main.this, AboutActivity.class);
                    aboutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    main.this.startActivity(aboutIntent);
                    break;


            }
        }
    }


    private void selectItem(int position) {

        mDrawerList.setItemChecked(position, true);
        //setTitle(mDrawerSections[position]);
        mDrawerLayout.closeDrawer(mDrawerList);

    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPrefs.edit();
        Set<String> listFin = new HashSet<String>(list);
        editor.putStringSet("pass", listFin);
        editor.commit();
    }

}




