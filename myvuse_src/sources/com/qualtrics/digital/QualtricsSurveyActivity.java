package com.qualtrics.digital;

import android.R;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.qualtrics.C3902R;

/* JADX INFO: loaded from: classes6.dex */
public class QualtricsSurveyActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;
    protected ViewGroup linearLayout;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final class IntentKeys {
        static final String AUTO_CLOSE_AT_END_OF_SURVEY = "autoCloseAtEndOfSurvey";
        static final String LAYOUT_FLAGS = "layoutFlags";

        public IntentKeys() {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        TraceMachine.startTracing("QualtricsSurveyActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "QualtricsSurveyActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "QualtricsSurveyActivity#onCreate", null);
        }
        super.onCreate(bundle);
        try {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            String stringExtra = getIntent().getStringExtra("targetURL");
            String stringExtra2 = getIntent().getStringExtra("interceptID");
            String stringExtra3 = getIntent().getStringExtra("creativeID");
            String stringExtra4 = getIntent().getStringExtra("actionSetID");
            boolean booleanExtra = getIntent().getBooleanExtra("autoCloseAtEndOfSurvey", false);
            if (stringExtra == null) {
                LogInstrumentation.m2728e("Qualtrics", "Could not get target URL from intent");
            }
            setTheme(C3902R.style.Theme_AppCompat_Light);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setHomeAsUpIndicator(Qualtrics.instance().getWebviewTheme().getCloseButtonId());
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Qualtrics.instance().getWebviewTheme().getActionBarColor()));
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
            getWindow().setSoftInputMode(16);
            getWindow().addFlags(getIntent().getIntExtra("layoutFlags", 0));
            this.linearLayout = new LinearLayout(this);
            this.linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            ((LinearLayout) this.linearLayout).setOrientation(1);
            this.linearLayout.setFitsSystemWindows(true);
            this.linearLayout.setBackgroundColor(-1);
            FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setId(View.generateViewId());
            this.linearLayout.addView(frameLayout);
            getFragmentManager().beginTransaction().add(frameLayout.getId(), QualtricsSurveyFragment.newInstance(stringExtra, stringExtra2, stringExtra3, stringExtra4, getPackageName(), booleanExtra)).commit();
            setContentView(this.linearLayout);
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
        }
        TraceMachine.exitMethod();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isTaskRoot()) {
            getApplicationContext().startActivity(getApplicationContext().getPackageManager().getLaunchIntentForPackage(getApplicationContext().getPackageName()));
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (isTaskRoot()) {
            getApplicationContext().startActivity(getApplicationContext().getPackageManager().getLaunchIntentForPackage(getApplicationContext().getPackageName()));
        } else {
            super.finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
