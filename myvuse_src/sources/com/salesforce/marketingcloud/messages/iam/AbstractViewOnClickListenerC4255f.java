package com.salesforce.marketingcloud.messages.iam;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout;
import com.salesforce.marketingcloud.util.C4389h;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.f */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractViewOnClickListenerC4255f extends FragmentActivity implements View.OnClickListener, SwipeDismissConstraintLayout.SwipeDismissListener, TraceFieldInterface {

    /* JADX INFO: renamed from: c */
    private static final int f5239c = 123;

    /* JADX INFO: renamed from: d */
    private static final String f5240d = "completedEvent";

    /* JADX INFO: renamed from: e */
    private static final String f5241e = C4170g.m3197a("IamBaseActivity");
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    private C4260k f5242a;

    /* JADX INFO: renamed from: b */
    private C4259j f5243b;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.f$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5244a;

        static {
            int[] iArr = new int[InAppMessage.Button.ActionType.values().length];
            f5244a = iArr;
            try {
                iArr[InAppMessage.Button.ActionType.url.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5244a[InAppMessage.Button.ActionType.pushSettings.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5244a[InAppMessage.Button.ActionType.locationSettings.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    AbstractViewOnClickListenerC4255f() {
    }

    /* JADX INFO: renamed from: d */
    private void m3739d() {
        if (C4389h.m4322b(this) && MarketingCloudSdk.isReady()) {
            RegionMessageManager regionMessageManager = MarketingCloudSdk.getInstance().getRegionMessageManager();
            try {
                if (regionMessageManager.enableGeofenceMessaging()) {
                    C4170g.m3202a(f5241e, "Geofence messaging enabled from IAM action", new Object[0]);
                }
                if (regionMessageManager.enableProximityMessaging()) {
                    C4170g.m3202a(f5241e, "Proximity messaging enabled from IAM action", new Object[0]);
                }
            } catch (Exception e) {
                C4170g.m3207b(f5241e, e, "Unable to enable region messaging", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m3740e() {
        if (C4389h.m4322b(this)) {
            C4170g.m3202a(f5241e, "Location permission already allowed.  Skipping action from button click.", new Object[0]);
            m3739d();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.ACCESS_FINE_LOCATION")) {
                ActivityCompat.requestPermissions(this, C4389h.f5807b, f5239c);
                return;
            }
            try {
                startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", getPackageName(), null)), f5239c);
                return;
            } catch (ActivityNotFoundException e) {
                C4170g.m3207b(f5241e, e, "Unable to launch application settings page for location permission request.", new Object[0]);
            }
        }
        finish();
    }

    /* JADX INFO: renamed from: f */
    private void m3741f() {
        Intent intentPutExtra = new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        if (intentPutExtra != null) {
            try {
                startActivity(intentPutExtra);
            } catch (ActivityNotFoundException e) {
                C4170g.m3207b(f5241e, e, "Unable to handle push settings button action.", new Object[0]);
            }
        } else {
            C4170g.m3202a(f5241e, "Unable to launch notification settings for this device.", new Object[0]);
        }
        finish();
    }

    /* JADX INFO: renamed from: g */
    private void m3742g() {
        try {
            int iM3775i = m3746c().m3775i();
            if (iM3775i != 0) {
                getWindow().setStatusBarColor(iM3775i);
            }
        } catch (Exception e) {
            C4170g.m3203a(f5241e, e, "Failed to find status bar color from meta-data", new Object[0]);
        }
    }

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    protected long m3743a() {
        C4260k c4260kM3746c = m3746c();
        c4260kM3746c.m3776j();
        return c4260kM3746c.m3769b();
    }

    /* JADX INFO: renamed from: b */
    protected InAppMessage m3745b() {
        return this.f5242a.m3771d();
    }

    /* JADX INFO: renamed from: c */
    protected C4260k m3746c() {
        return this.f5242a;
    }

    @Override // android.app.Activity
    public void finish() {
        C4260k c4260k = this.f5242a;
        if (c4260k != null) {
            c4260k.m3767a(this.f5243b);
        }
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == f5239c) {
            m3739d();
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.f5243b = C4259j.m3757b(this.f5242a.m3770c(), m3743a());
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            boolean z = view.getTag() instanceof InAppMessage.Button;
            Object tag = view.getTag();
            if (z) {
                mo3685b((InAppMessage.Button) tag);
            } else if (tag instanceof InAppMessage.CloseButton) {
                this.f5243b = C4259j.m3757b(this.f5242a.m3770c(), m3743a());
                finish();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        TraceMachine.startTracing("f");
        try {
            TraceMachine.enterMethod(this._nr_trace, "f#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "f#onCreate", null);
        }
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.f5242a = (C4260k) getIntent().getParcelableExtra("messageHandler");
        }
        C4260k c4260k = this.f5242a;
        if (c4260k == null || !c4260k.m3768a()) {
            finish();
            TraceMachine.exitMethod();
        } else {
            m3742g();
            if (bundle != null) {
                this.f5243b = (C4259j) bundle.getParcelable(f5240d);
            }
            TraceMachine.exitMethod();
        }
    }

    public void onDismissed() {
        this.f5243b = C4259j.m3757b(this.f5242a.m3770c(), m3743a());
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        m3746c().m3773f();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        m3739d();
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m3746c().m3774g();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(f5240d, this.f5243b);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void onSwipeStarted() {
    }

    public void onViewSettled() {
    }

    /* JADX INFO: renamed from: a */
    private void m3738a(InAppMessage.Button button) {
        PendingIntent pendingIntentM3766a = m3746c().m3766a(this, button);
        if (pendingIntentM3766a != null) {
            try {
                pendingIntentM3766a.send();
            } catch (PendingIntent.CanceledException e) {
                C4170g.m3207b(f5241e, e, "Unable to launch url for button click", new Object[0]);
            }
        } else {
            C4170g.m3202a(f5241e, "No PendingIntent returned for button click.", new Object[0]);
        }
        finish();
    }

    /* JADX INFO: renamed from: b */
    public void mo3685b(InAppMessage.Button button) {
        if (button != null) {
            this.f5243b = C4259j.m3756a(this.f5242a.m3770c(), m3743a(), button);
            int i = a.f5244a[button.actionType().ordinal()];
            if (i == 1) {
                m3738a(button);
                return;
            }
            if (i == 2) {
                m3741f();
            } else if (i != 3) {
                finish();
            } else {
                m3740e();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m3744a(C4259j c4259j) {
        this.f5243b = c4259j;
    }
}
