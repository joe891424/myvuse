package com.masteratul.exceptionhandler;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultErrorScreen extends Activity implements TraceFieldInterface {
    private static String TAG = "RN_ERROR_HANDLER";
    public Trace _nr_trace;
    private Button quitButton;
    private Button relaunchButton;
    private Button showDetailsButton;
    private TextView stackTraceView;

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
    protected void onCreate(Bundle bundle) {
        String string;
        TraceMachine.startTracing("DefaultErrorScreen");
        try {
            TraceMachine.enterMethod(this._nr_trace, "DefaultErrorScreen#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "DefaultErrorScreen#onCreate", null);
        }
        super.onCreate(bundle);
        try {
            string = getIntent().getExtras().getString("stack_trace_string");
        } catch (Exception e) {
            LogInstrumentation.m2728e(TAG, String.format("Was not able to get StackTrace: %s", e.getMessage()));
            string = "StackTrace unavailable";
        }
        setContentView(C3607R.layout.default_error_screen);
        this.quitButton = (Button) findViewById(C3607R.id.eh_quit_button);
        this.relaunchButton = (Button) findViewById(C3607R.id.eh_restart_button);
        this.showDetailsButton = (Button) findViewById(C3607R.id.eh_show_details_button);
        TextView textView = (TextView) findViewById(C3607R.id.eh_stack_trace_text_view);
        this.stackTraceView = textView;
        textView.setText(string);
        this.showDetailsButton.setOnClickListener(new View.OnClickListener() { // from class: com.masteratul.exceptionhandler.DefaultErrorScreen.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DefaultErrorScreen.this.stackTraceView.getVisibility() == 0) {
                    DefaultErrorScreen.this.stackTraceView.setVisibility(8);
                    DefaultErrorScreen.this.showDetailsButton.setText("SHOW DETAILS");
                } else {
                    DefaultErrorScreen.this.stackTraceView.setVisibility(0);
                    DefaultErrorScreen.this.showDetailsButton.setText("HIDE DETAILS");
                }
            }
        });
        this.relaunchButton.setOnClickListener(new View.OnClickListener() { // from class: com.masteratul.exceptionhandler.DefaultErrorScreen.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DefaultErrorScreen.doRestart(DefaultErrorScreen.this.getApplicationContext());
            }
        });
        this.quitButton.setOnClickListener(new View.OnClickListener() { // from class: com.masteratul.exceptionhandler.DefaultErrorScreen.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                System.exit(0);
            }
        });
        TraceMachine.exitMethod();
    }

    public static void doRestart(Context context) {
        try {
            if (context != null) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(context.getPackageName());
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.addFlags(67108864);
                        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(context, 654311, launchIntentForPackage, 268435456));
                        System.exit(0);
                        return;
                    }
                    throw new Exception("Was not able to restart application, mStartActivity null");
                }
                throw new Exception("Was not able to restart application, PM null");
            }
            throw new Exception("Was not able to restart application, Context null");
        } catch (Exception unused) {
            LogInstrumentation.m2728e(TAG, "Was not able to restart application");
        }
    }
}
