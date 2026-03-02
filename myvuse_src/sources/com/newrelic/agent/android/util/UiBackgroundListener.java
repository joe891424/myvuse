package com.newrelic.agent.android.util;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes6.dex */
public class UiBackgroundListener implements ComponentCallbacks2 {
    protected final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("UiBackgroundListener"));

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i != 20) {
            return;
        }
        this.executor.submit(new Runnable() { // from class: com.newrelic.agent.android.util.UiBackgroundListener.1
            @Override // java.lang.Runnable
            public void run() {
                ApplicationStateMonitor.getInstance().uiHidden();
            }
        });
    }
}
