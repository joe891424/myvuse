package com.google.firebase.analytics;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzdn;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@22.0.1 */
/* JADX INFO: loaded from: classes2.dex */
public class GoogleAnalyticsServerPreviewActivity extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("GoogleAnalyticsServerPreviewActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "GoogleAnalyticsServerPreviewActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "GoogleAnalyticsServerPreviewActivity#onCreate", null);
        }
        super.onCreate(bundle);
        zzdn.zza(this).zza(getIntent());
        finish();
        TraceMachine.exitMethod();
    }
}
