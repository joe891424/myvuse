package com.newrelic.agent.android.rum;

import android.app.Application;
import android.content.Intent;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class AppTracer {
    private static final AtomicReference<AppTracer> instance = new AtomicReference<>(new AppTracer());
    private static Long contentProviderStartedTime = 0L;
    private static Long appOnCreateTime = 0L;
    private static Long appOnCreateEndTime = 0L;
    private static Long firstDrawTime = 0L;
    private static Long firstActivityCreatedTime = 0L;
    private static Long firstActivityStartTime = 0L;
    private static Long firstActivityResumeTime = 0L;
    private static Long lastAppPauseTime = 0L;
    private static String firstActivityName = null;
    private static String firstActivityReferrer = null;
    private static Intent firstActivityIntent = null;
    private static Boolean isColdStart = null;
    private static Boolean currentAppLaunchProcessed = true;
    private static Boolean isFirstPostExecuted = false;

    public static AppTracer getInstance() {
        return instance.get();
    }

    public void start() {
        appOnCreateTime = Long.valueOf(SystemClock.uptimeMillis());
    }

    public void onAppLaunchListener(Application application) {
        appOnCreateEndTime = Long.valueOf(SystemClock.uptimeMillis());
    }

    public Long getContentProviderStartedTime() {
        return contentProviderStartedTime;
    }

    public void setContentProviderStartedTime(Long l) {
        contentProviderStartedTime = l;
    }

    public Long getAppOnCreateTime() {
        return appOnCreateTime;
    }

    public void setAppOnCreateTime(Long l) {
        appOnCreateTime = l;
    }

    public Long getAppOnCreateEndTime() {
        return appOnCreateEndTime;
    }

    public void setAppOnCreateEndTime(Long l) {
        appOnCreateEndTime = l;
    }

    public Long getFirstDrawTime() {
        return firstDrawTime;
    }

    public void setFirstDrawTime(Long l) {
        firstDrawTime = l;
    }

    public Long getFirstActivityCreatedTime() {
        return firstActivityCreatedTime;
    }

    public void setFirstActivityCreatedTime(Long l) {
        firstActivityCreatedTime = l;
    }

    public String getFirstActivityName() {
        return firstActivityName;
    }

    public void setFirstActivityName(String str) {
        firstActivityName = str;
    }

    public Long getFirstActivityStartTime() {
        return firstActivityStartTime;
    }

    public void setFirstActivityStartTime(Long l) {
        firstActivityStartTime = l;
    }

    public Long getFirstActivityResumeTime() {
        return firstActivityResumeTime;
    }

    public void setFirstActivityResumeTime(Long l) {
        firstActivityResumeTime = l;
    }

    public Long getLastAppPauseTime() {
        return lastAppPauseTime;
    }

    public void setLastAppPauseTime(Long l) {
        lastAppPauseTime = l;
    }

    public boolean isColdStart() {
        return isColdStart.booleanValue();
    }

    public void setIsColdStart(boolean z) {
        isColdStart = Boolean.valueOf(z);
    }

    public Boolean getCurrentAppLaunchProcessed() {
        return currentAppLaunchProcessed;
    }

    public void setCurrentAppLaunchProcessed(Boolean bool) {
        currentAppLaunchProcessed = bool;
    }

    public Boolean getFirstPostExecuted() {
        return isFirstPostExecuted;
    }

    public void setFirstPostExecuted(Boolean bool) {
        isFirstPostExecuted = bool;
    }

    public String getFirstActivityReferrer() {
        return firstActivityReferrer;
    }

    public void setFirstActivityReferrer(String str) {
        firstActivityReferrer = str;
    }

    public Intent getFirstActivityIntent() {
        return firstActivityIntent;
    }

    public void setFirstActivityIntent(Intent intent) {
        firstActivityIntent = intent;
    }
}
