package com.microblink.activity;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import androidx.appcompat.C0261R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.microblink.blinkid.secured.llIIllllIl;
import com.microblink.fragment.RecognizerRunnerFragment;
import com.microblink.fragment.overlay.ScanningOverlay;
import com.microblink.library.C3714R;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.uisettings.UISettings;
import com.microblink.view.recognition.ScanResultListener;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes2.dex */
abstract class BaseScanActivity<UiSettingsType extends UISettings, ScanOverlayType extends ScanningOverlay> extends AppCompatActivity implements RecognizerRunnerFragment.ScanningOverlayBinder, TraceFieldInterface {
    protected UiSettingsType IlIllIlIIl;
    protected ScanOverlayType IllIIIllII;
    public Trace _nr_trace;
    private Throwable llIIIlllll;
    protected RecognizerRunnerFragment llIIlIlIIl;

    /* JADX INFO: renamed from: com.microblink.activity.BaseScanActivity$1 */
    /* JADX INFO: compiled from: line */
    static /* synthetic */ class C36091 {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[RecognitionSuccessType.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[RecognitionSuccessType.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[RecognitionSuccessType.PARTIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[RecognitionSuccessType.STAGE_SUCCESSFUL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                llIIlIlIIl[RecognitionSuccessType.UNSUCCESSFUL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class ResultListener implements ScanResultListener {
        ResultListener() {
        }

        @Override // com.microblink.view.recognition.ScanResultListener
        public void onScanningDone(RecognitionSuccessType recognitionSuccessType) {
            BaseScanActivity baseScanActivity = BaseScanActivity.this;
            baseScanActivity.llIIlIlIIl.getRecognizerRunnerView().pauseScanning();
            Intent intent = new Intent();
            int i = C36091.llIIlIlIIl[recognitionSuccessType.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                baseScanActivity.setResult(-1, intent);
            } else if (i == 4) {
                baseScanActivity.setResult(0);
            }
            baseScanActivity.IlIllIlIIl(intent);
            baseScanActivity.finish();
        }

        @Override // com.microblink.view.recognition.ScanResultListener
        public void onUnrecoverableError(Throwable th) {
            BaseScanActivity.this.llIIIlllll = th;
        }
    }

    BaseScanActivity() {
    }

    protected abstract void IlIllIlIIl(Intent intent);

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @Override // com.microblink.fragment.RecognizerRunnerFragment.ScanningOverlayBinder
    public ScanningOverlay getScanningOverlay() {
        return this.IllIIIllII;
    }

    protected abstract UiSettingsType llIIlIlIIl(Intent intent);

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.llIIIlllll != null) {
            Intent intent = new Intent();
            intent.putExtra("com.microblink.scanexception", this.llIIIlllll);
            setResult(0, intent);
        } else {
            setResult(0);
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        TraceMachine.startTracing("BaseScanActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "BaseScanActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "BaseScanActivity#onCreate", null);
        }
        UiSettingsType uisettingstype = (UiSettingsType) llIIlIlIIl(getIntent());
        this.IlIllIlIIl = uisettingstype;
        this.IllIIIllII = (ScanOverlayType) uisettingstype.createOverlayController(this, new ResultListener());
        int activityTheme = this.IlIllIlIIl.getActivityTheme();
        if (activityTheme != 0) {
            setTheme(activityTheme);
        }
        llIIlIlIIl();
        super.onCreate(bundle);
        setContentView(llIIllllIl.llIIlIlIIl);
        setVolumeControlStream(3);
        if (this.IlIllIlIIl.getUsingFlagSecure()) {
            getWindow().setFlags(8192, 8192);
        }
        findViewById(R.id.content).getRootView().setFilterTouchesWhenObscured(this.IlIllIlIIl.getFilterTouchesWhenObscured());
        if (bundle == null) {
            this.llIIlIlIIl = new RecognizerRunnerFragment();
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.replace(C3714R.id.recognizer_runner_view_container, this.llIIlIlIIl);
            fragmentTransactionBeginTransaction.commit();
        } else {
            this.llIIlIlIIl = (RecognizerRunnerFragment) getSupportFragmentManager().findFragmentById(C3714R.id.recognizer_runner_view_container);
        }
        TraceMachine.exitMethod();
    }

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

    void llIIlIlIIl() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(C0261R.attr.colorPrimary, typedValue, true);
        if (typedValue.data == 0) {
            setTheme(C3714R.style.MB_theme);
        }
    }
}
