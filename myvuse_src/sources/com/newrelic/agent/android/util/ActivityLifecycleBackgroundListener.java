package com.newrelic.agent.android.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityLifecycleBackgroundListener extends UiBackgroundListener implements Application.ActivityLifecycleCallbacks {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private AtomicBoolean isInBackground = new AtomicBoolean(false);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        log.info("ActivityLifecycleBackgroundListener.onActivityResumed");
        if (this.isInBackground.getAndSet(false)) {
            this.executor.submit(new Runnable() { // from class: com.newrelic.agent.android.util.ActivityLifecycleBackgroundListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ApplicationStateMonitor.getInstance().activityStarted();
                }
            });
        }
    }

    @Override // com.newrelic.agent.android.util.UiBackgroundListener, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        log.info("ActivityLifecycleBackgroundListener.onTrimMemory level: " + i);
        if (20 == i) {
            this.isInBackground.set(true);
        }
        super.onTrimMemory(i);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        log.info("ActivityLifecycleBackgroundListener.onActivityCreated");
        this.isInBackground.set(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        log.info("ActivityLifecycleBackgroundListener.onActivityDestroyed");
        this.isInBackground.set(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.isInBackground.compareAndSet(true, false)) {
            this.executor.submit(new Runnable() { // from class: com.newrelic.agent.android.util.ActivityLifecycleBackgroundListener.2
                @Override // java.lang.Runnable
                public void run() {
                    ActivityLifecycleBackgroundListener.log.debug("ActivityLifecycleBackgroundListener.onActivityStarted - notifying ApplicationStateMonitor");
                    ApplicationStateMonitor.getInstance().activityStarted();
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.isInBackground.compareAndSet(false, true)) {
            this.executor.submit(new Runnable() { // from class: com.newrelic.agent.android.util.ActivityLifecycleBackgroundListener.3
                @Override // java.lang.Runnable
                public void run() {
                    ActivityLifecycleBackgroundListener.log.debug("ActivityLifecycleBackgroundListener.onActivityPaused - notifying ApplicationStateMonitor");
                    ApplicationStateMonitor.getInstance().uiHidden();
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.isInBackground.getAndSet(true)) {
            this.executor.submit(new Runnable() { // from class: com.newrelic.agent.android.util.ActivityLifecycleBackgroundListener.4
                @Override // java.lang.Runnable
                public void run() {
                    ActivityLifecycleBackgroundListener.log.debug("ActivityLifecycleBackgroundListener.onActivityStopped - notifying ApplicationStateMonitor");
                    ApplicationStateMonitor.getInstance().activityStopped();
                }
            });
        }
    }
}
