package com.newrelic.agent.android.rum;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.background.ApplicationStateEvent;
import com.newrelic.agent.android.background.ApplicationStateListener;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import java.io.Closeable;
import java.io.IOException;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class AppApplicationLifeCycle implements Application.ActivityLifecycleCallbacks, Closeable, ApplicationStateListener {
    private static int activityReferences = 0;
    private static boolean firstActivityCreated = false;
    private static boolean firstActivityResumed = false;
    private static boolean firstDrawInvoked = false;
    private static boolean isActivityChangingConfig = false;
    private static boolean isBackgrounded = false;
    private static boolean isForegrounded = false;
    private Context context;
    private static AgentConfiguration agentConfiguration = new AgentConfiguration();
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public void onColdStartInitiated(Context context) {
        this.context = context.getApplicationContext();
        ((Application) context).registerActivityLifecycleCallbacks(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((Application) this.context).unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            AppTracer appTracer = AppTracer.getInstance();
            appTracer.setIsColdStart(bundle == null);
            if (!firstActivityCreated) {
                firstActivityCreated = true;
                appTracer.setFirstActivityCreatedTime(Long.valueOf(SystemClock.uptimeMillis()));
                appTracer.setFirstActivityName(activity.getLocalClassName());
                appTracer.setFirstActivityReferrer(activity.getReferrer() + "");
                appTracer.setFirstActivityIntent(activity.getIntent());
            }
            log.debug("App launch time onActivityCreated " + new Date().getTime());
        } catch (Exception e) {
            log.error("App launch time exception: " + e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        log.debug("App launch time onActivityStarted " + new Date().getTime());
        AppTracer appTracer = AppTracer.getInstance();
        int i = activityReferences + 1;
        activityReferences = i;
        if (i == 1 && !isActivityChangingConfig && isBackgrounded) {
            isForegrounded = true;
            isBackgrounded = false;
            appTracer.setFirstActivityStartTime(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            if (!FeatureFlag.featureEnabled(FeatureFlag.AppStartMetrics)) {
                log.verbose("App launch time feature is not enabled.");
                return;
            }
            AgentLog agentLog = log;
            agentLog.debug(activity.getLocalClassName());
            AppTracer appTracer = AppTracer.getInstance();
            appTracer.setFirstActivityResumeTime(Long.valueOf(SystemClock.uptimeMillis()));
            AppStartUpMetrics appStartUpMetrics = new AppStartUpMetrics();
            if (!firstActivityResumed && (agentConfiguration.getLaunchActivityClassName() == null || agentConfiguration.getLaunchActivityClassName().equalsIgnoreCase(activity.getLocalClassName()))) {
                firstActivityResumed = true;
                if (appTracer.isColdStart()) {
                    StatsEngine.get().sample(MetricNames.APP_LAUNCH_COLD, appStartUpMetrics.getColdStartTime().longValue() / 1000.0f);
                }
            } else if (isForegrounded) {
                isForegrounded = false;
                StatsEngine.get().sample(MetricNames.APP_LAUNCH_HOT, appStartUpMetrics.getHotStartTime().longValue() / 1000.0f);
            }
            agentLog.debug("App launch time " + appStartUpMetrics.toString());
        } catch (Exception e) {
            log.error("App launch time exception: " + e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        log.debug("App launch time onActivityPaused" + new Date().getTime());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        log.debug("App launch time onActivityStopped" + new Date().getTime());
        boolean zIsChangingConfigurations = activity.isChangingConfigurations();
        isActivityChangingConfig = zIsChangingConfigurations;
        int i = activityReferences - 1;
        activityReferences = i;
        if (i != 0 || zIsChangingConfigurations) {
            return;
        }
        isBackgrounded = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        log.debug("App launch time onActivitySaveInstanceState" + new Date().getTime());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        log.debug("App launch time onActivityDestroyed" + new Date().getTime());
    }

    @Override // com.newrelic.agent.android.background.ApplicationStateListener
    public void applicationForegrounded(ApplicationStateEvent applicationStateEvent) {
        log.debug("App launch time applicationForegrounded" + new Date().getTime());
    }

    @Override // com.newrelic.agent.android.background.ApplicationStateListener
    public void applicationBackgrounded(ApplicationStateEvent applicationStateEvent) {
        log.debug("App launch time applicationBackgrounded" + new Date().getTime());
    }

    private String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static AgentConfiguration getAgentConfiguration() {
        return agentConfiguration;
    }

    public static void setAgentConfiguration(AgentConfiguration agentConfiguration2) {
        agentConfiguration = agentConfiguration2;
    }
}
