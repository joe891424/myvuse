package com.bat.myvuse.mobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.reactnativenavigation.NavigationActivity;
import io.branch.rnbranch.RNBranchModule;
import org.devio.p104rn.splashscreen.SplashScreen;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends NavigationActivity {
    private static final String TAG = "MainActivity";
    private static final String TAG2 = "SFMC";

    @Override // com.reactnativenavigation.NavigationActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        RNBranchModule.setDebug();
        RNBranchModule.initSession(getIntent().getData(), this);
    }

    @Override // com.reactnativenavigation.NavigationActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Intent intent = new Intent("onConfigurationChanged");
        intent.putExtra("newConfig", configuration);
        sendBroadcast(intent);
    }

    @Override // com.reactnativenavigation.NavigationActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        SplashScreen.show(this);
        LogInstrumentation.m2730i(TAG, "onCreate");
        LogInstrumentation.m2730i(TAG2, "onCreate");
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra("notification")) {
            LogInstrumentation.m2730i(TAG2, "onCreate -> notification is present: " + getIntent().getStringExtra("notification"));
            LogInstrumentation.m2730i(TAG2, "Populating sharedpreferences");
            SharedPreferences.Editor editorEdit = getSharedPreferences("MYVUSEPrefs", 0).edit();
            editorEdit.putString("notification", getIntent().getStringExtra("notification"));
            editorEdit.apply();
        }
        super.onCreate(bundle);
    }

    @Override // com.reactnativenavigation.NavigationActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogInstrumentation.m2730i(TAG, "onNewIntent");
        LogInstrumentation.m2730i(TAG2, "onNewIntent");
        if (intent != null && intent.hasExtra("branch_force_new_session") && intent.getBooleanExtra("branch_force_new_session", false)) {
            RNBranchModule.onNewIntent(intent);
        }
        if (intent != null && intent.getExtras() != null && intent.hasExtra("notification")) {
            LogInstrumentation.m2730i(TAG2, "MainActivity - onNewIntent: " + intent.getStringExtra("notification"));
            sendDataToReactNative(intent.getStringExtra("notification"));
        }
        setIntent(intent);
    }

    private void sendDataToReactNative(String str) {
        LogInstrumentation.m2730i(TAG2, "Pushing data via broacastmanager");
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Intent intent = new Intent("my-custom-event");
        intent.putExtra("notification", str);
        localBroadcastManager.sendBroadcast(intent);
    }
}
