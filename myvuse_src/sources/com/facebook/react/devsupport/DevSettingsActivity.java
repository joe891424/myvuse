package com.facebook.react.devsupport;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.facebook.react.C1848R;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: loaded from: classes3.dex */
public class DevSettingsActivity extends PreferenceActivity implements TraceFieldInterface {
    public Trace _nr_trace;

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("DevSettingsActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "DevSettingsActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "DevSettingsActivity#onCreate", null);
        }
        super.onCreate(bundle);
        setTitle(getApplication().getResources().getString(C1848R.string.catalyst_settings_title));
        addPreferencesFromResource(C1848R.xml.rn_dev_preferences);
        TraceMachine.exitMethod();
    }
}
