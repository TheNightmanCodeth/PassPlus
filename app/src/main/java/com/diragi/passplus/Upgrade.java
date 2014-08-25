package com.diragi.passplus;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.android.vending.billing.IInAppBillingService;
import com.diragi.passplus.R;
import com.diragi.passplus.util.IabHelper;
import com.diragi.passplus.util.IabResult;
import com.diragi.passplus.util.Inventory;
import com.diragi.passplus.util.Purchase;

import java.util.List;


public class Upgrade extends themeCheckPref {


    IabHelper mHelper;
    SharedPreferences mPrefs;
    Boolean pro = false;
    static final String ITEM_SKU = "com.diragi.passplus.pro";


    @Override
    public void finOnCreate() {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = mPrefs.getString("pref_themeColor", "0");
        addPreferencesFromResource(R.xml.upgrade);

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPrefs.edit();

        Preference upgradePref = findPreference("upgradeItem");
        upgradePref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                //Make sure the user doesn't 1337HAxx0r our IAP
                Boolean isFreedomInstalled = isPackageInstalled("cc.madkite.freedom");
                if (isFreedomInstalled) {
                    Log.d("Freedom Check", "Freedom IS installed");
                    AlertDialog.Builder freedomAlert = new AlertDialog.Builder(Upgrade.this);
                    freedomAlert.setTitle("Freedom installed");
                    freedomAlert.setMessage("You can't buy pro with Freedom installed! Come on you know this... I worked really hard on this app if the ads bother you that much then uninstall freedom and buy pro to help me out. Click 'Done' to admit that you suck.")
                            .setNegativeButton("I Suck", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int I) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = freedomAlert.create();

                    alertDialog.show();

                } else if (!isFreedomInstalled) {
                    Log.d("Freedom Check", "Freedom is NOT installed");
                    launchPurchase();
                }
                return true;

            }


        });

        String base64EncodedPublicKey = "Play store IAP key goes here";
        mHelper = new IabHelper(this, base64EncodedPublicKey);

        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            @Override
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {
                    Log.d("Swag", "IAP setup failed" +result);
                } else {
                    Log.d("Swag", "IAP setup successful");
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


        IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
            public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
                if (result.isFailure()) {
                    Log.d("Swag", "result.isFailure");
                    return;
                } else if (purchase.getSku().equals(ITEM_SKU)) {
                    consumeItem();
                }
            }

        };

    public void launchPurchase() {
        mHelper.launchPurchaseFlow(this, ITEM_SKU, 10001, mPurchaseFinishedListener, "your purchase token");
    }


    public void consumeItem() {
        mHelper.queryInventoryAsync(mReceivedInventoryListener);
    }

    IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            if (result.isFailure()) {
                Log.d("Swag", "onQueryInventoryFinished error" +result);
            } else {
                mHelper.consumeAsync(inventory.getPurchase(ITEM_SKU), mConsumerFinishedListener);
            }
        }
    };

    IabHelper.OnConsumeFinishedListener mConsumerFinishedListener = new IabHelper.OnConsumeFinishedListener() {
        public void onConsumeFinished(Purchase purchase, IabResult result) {
            if (result.isSuccess()) {
                //Purchas succesful
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putBoolean("pro", true);
                editor.commit();


            } else {
                //welp that's an error
                Toast.makeText(Upgrade.this, "Purchase unsuccessful, please try again later", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mHelper != null) mHelper.dispose();
        mHelper = null;
    }


    private boolean isPackageInstalled(String packagename) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}





