package com.proyecto26.inappbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes6.dex */
public class ChromeTabsManagerActivity extends Activity implements TraceFieldInterface {
    static final String BROWSER_RESULT_TYPE = "browserResultType";
    static final String DEFAULT_RESULT_TYPE = "dismiss";
    static final String KEY_BROWSER_INTENT = "browserIntent";
    public Trace _nr_trace;
    private boolean mOpened = false;
    private String resultType = null;
    private boolean isError = false;

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

    public static Intent createStartIntent(Context context, Intent intent) {
        Intent intentCreateBaseIntent = createBaseIntent(context);
        intentCreateBaseIntent.putExtra(KEY_BROWSER_INTENT, intent);
        return intentCreateBaseIntent;
    }

    public static Intent createDismissIntent(Context context) {
        Intent intentCreateBaseIntent = createBaseIntent(context);
        intentCreateBaseIntent.addFlags(67108864);
        return intentCreateBaseIntent;
    }

    private static Intent createBaseIntent(Context context) {
        return new Intent(context, (Class<?>) ChromeTabsManagerActivity.class);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        TraceMachine.startTracing("ChromeTabsManagerActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "ChromeTabsManagerActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "ChromeTabsManagerActivity#onCreate", null);
        }
        try {
            super.onCreate(bundle);
            if (getIntent().hasExtra(KEY_BROWSER_INTENT) && (bundle == null || bundle.getString(BROWSER_RESULT_TYPE) == null)) {
                Intent intent = (Intent) getIntent().getParcelableExtra(KEY_BROWSER_INTENT);
                intent.addFlags(67108864);
                startActivity(intent);
                this.resultType = DEFAULT_RESULT_TYPE;
            } else {
                finish();
            }
        } catch (Exception e) {
            this.isError = true;
            EventBus.getDefault().post(new ChromeTabsDismissedEvent("Unable to open url.", this.resultType, Boolean.valueOf(this.isError)));
            finish();
            e.printStackTrace();
        }
        TraceMachine.exitMethod();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.mOpened) {
            this.mOpened = true;
        } else {
            this.resultType = "cancel";
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        String str = this.resultType;
        if (str != null) {
            str.hashCode();
            if (str.equals("cancel")) {
                EventBus.getDefault().post(new ChromeTabsDismissedEvent("chrome tabs activity closed", this.resultType, Boolean.valueOf(this.isError)));
            } else {
                EventBus.getDefault().post(new ChromeTabsDismissedEvent("chrome tabs activity destroyed", DEFAULT_RESULT_TYPE, Boolean.valueOf(this.isError)));
            }
            this.resultType = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.resultType = bundle.getString(BROWSER_RESULT_TYPE);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString(BROWSER_RESULT_TYPE, DEFAULT_RESULT_TYPE);
        super.onSaveInstanceState(bundle);
    }
}
