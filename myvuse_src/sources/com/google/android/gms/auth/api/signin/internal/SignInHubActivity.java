package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class SignInHubActivity extends FragmentActivity implements TraceFieldInterface {
    private static boolean zba = false;
    public Trace _nr_trace;
    private boolean zbb = false;
    private SignInConfiguration zbc;
    private boolean zbd;
    private int zbe;
    private Intent zbf;

    private final void zbc() {
        getSupportLoaderManager().initLoader(0, null, new zbw(this, null));
        zba = false;
    }

    private final void zbd(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zba = false;
    }

    private final void zbe(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.zbc);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.zbb = true;
            LogInstrumentation.m2734w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            zbd(17);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        if (this.zbb) {
            return;
        }
        setResult(0);
        if (i != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
            if (signInAccount != null && signInAccount.zba() != null) {
                GoogleSignInAccount googleSignInAccountZba = signInAccount.zba();
                zbn zbnVarZbc = zbn.zbc(this);
                GoogleSignInOptions googleSignInOptionsZba = this.zbc.zba();
                googleSignInAccountZba.getClass();
                zbnVarZbc.zbe(googleSignInOptionsZba, googleSignInAccountZba);
                intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                intent.putExtra("googleSignInAccount", googleSignInAccountZba);
                this.zbd = true;
                this.zbe = i2;
                this.zbf = intent;
                zbc();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = GoogleSignInStatusCodes.SIGN_IN_CANCELLED;
                }
                zbd(intExtra);
                return;
            }
        }
        zbd(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        TraceMachine.startTracing("SignInHubActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SignInHubActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "SignInHubActivity#onCreate", null);
        }
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null) {
            TraceMachine.exitMethod();
            throw null;
        }
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zbd(GoogleSignInStatusCodes.SIGN_IN_FAILED);
            TraceMachine.exitMethod();
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            LogInstrumentation.m2728e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
            TraceMachine.exitMethod();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("config");
        if (bundleExtra == null) {
            TraceMachine.exitMethod();
            throw null;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
        if (signInConfiguration == null) {
            LogInstrumentation.m2728e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            TraceMachine.exitMethod();
            return;
        }
        this.zbc = signInConfiguration;
        if (bundle == null) {
            if (zba) {
                setResult(0);
                zbd(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
                TraceMachine.exitMethod();
                return;
            } else {
                zba = true;
                zbe(action);
                TraceMachine.exitMethod();
                return;
            }
        }
        boolean z = bundle.getBoolean("signingInGoogleApiClients");
        this.zbd = z;
        if (!z) {
            TraceMachine.exitMethod();
            return;
        }
        this.zbe = bundle.getInt("signInResultCode");
        Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
        if (intent2 == null) {
            TraceMachine.exitMethod();
            throw null;
        }
        this.zbf = intent2;
        zbc();
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        zba = false;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zbd);
        if (this.zbd) {
            bundle.putInt("signInResultCode", this.zbe);
            bundle.putParcelable("signInResultData", this.zbf);
        }
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
}
