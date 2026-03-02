package com.bat.myvuse.mobile;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bat.myvuse.mobile.rncomponents.notifications.PushNotificationProps;
import com.google.firebase.messaging.Constants;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: loaded from: classes.dex */
public class SplashActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;

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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        TraceMachine.startTracing("SplashActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SplashActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "SplashActivity#onCreate", null);
        }
        super.onCreate(bundle);
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        if (getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            intent.putExtras(extras);
            if (extras.containsKey(Constants.MessagePayloadKeys.MSGID)) {
                PushNotificationProps pushNotificationProps = new PushNotificationProps(extras);
                if (pushNotificationProps.isFirebaseBackgroundPayload()) {
                    com.bat.myvuse.mobile.rncomponents.notifications.InitialNotificationHolder.getInstance().set(pushNotificationProps);
                }
            }
        }
        startActivity(intent);
        finish();
        TraceMachine.exitMethod();
    }
}
