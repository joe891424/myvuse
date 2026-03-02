package com.facetec.sdk;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facetec.sdk.h */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractActivityC2220h extends Activity implements TraceFieldInterface {

    /* JADX INFO: renamed from: B */
    C2138ad f3470B;
    private final AtomicBoolean Code = new AtomicBoolean(false);

    /* JADX INFO: renamed from: I */
    Handler f3471I;

    /* JADX INFO: renamed from: V */
    View f3472V;

    /* JADX INFO: renamed from: Z */
    RelativeLayout f3473Z;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: com.facetec.sdk.h$I */
    enum I {
        NOT_GRANTED,
        DENIED_ALWAYS,
        GRANTED
    }

    /* JADX INFO: renamed from: B */
    abstract void mo2180B(String str);

    /* JADX INFO: renamed from: C */
    abstract void mo2182C();

    abstract void Code();

    /* JADX INFO: renamed from: D */
    abstract void mo2183D();

    /* JADX INFO: renamed from: F */
    abstract void mo2184F();

    /* JADX INFO: renamed from: L */
    abstract void mo2186L();

    /* JADX INFO: renamed from: S */
    abstract void mo2187S();

    /* JADX INFO: renamed from: Z */
    abstract void mo2188Z();

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    abstract void mo2194a();

    /* JADX INFO: renamed from: b */
    abstract void mo2195b();

    /* JADX INFO: renamed from: c */
    abstract void mo2196c();

    /* JADX INFO: renamed from: d */
    abstract void mo2197d();

    /* JADX INFO: renamed from: e */
    abstract void mo2198e();

    /* JADX INFO: renamed from: f */
    abstract void mo2199f();

    /* JADX INFO: renamed from: h */
    abstract void mo2201h();

    /* JADX INFO: renamed from: i */
    abstract void mo2202i();

    /* JADX INFO: renamed from: j */
    abstract void mo2203j();

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

    AbstractActivityC2220h() {
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f3471I.postDelayed(new Runnable() { // from class: com.facetec.sdk.h.2
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractActivityC2220h.this.hasWindowFocus()) {
                    return;
                }
                AbstractActivityC2220h.this.m2220g();
            }
        }, 1000L);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public synchronized void onWindowFocusChanged(boolean z) {
        if (!z) {
            m2220g();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public synchronized void m2220g() {
        if (!m2222I() && !isFinishing()) {
            mo2188Z();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C2221j.m2247V(configuration)) {
            mo2202i();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Handler handler = this.f3471I;
        if (handler != null) {
            handler.removeCallbacks(null);
        }
    }

    /* JADX INFO: renamed from: V */
    protected final void m2223V() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 0);
        Code(true);
    }

    /* JADX INFO: renamed from: B */
    protected final I m2221B() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            if (C2221j.m2228C(this).getBoolean("cameraPermissionsShown", false) && !ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA")) {
                return I.DENIED_ALWAYS;
            }
            return I.NOT_GRANTED;
        }
        return I.GRANTED;
    }

    /* JADX INFO: renamed from: I */
    final boolean m2222I() {
        return this.Code.get();
    }

    final void Code(boolean z) {
        this.Code.set(z);
    }
}
