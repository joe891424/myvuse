package com.transistorsoft.tsbackgroundfetch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes6.dex */
public class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        LogInstrumentation.m2726d(BackgroundFetch.TAG, "BootReceiver: " + intent.getAction());
        BackgroundFetch.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.tsbackgroundfetch.BootReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                BackgroundFetch.getInstance(context.getApplicationContext()).onBoot();
            }
        });
    }
}
