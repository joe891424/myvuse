package com.newrelic.agent.android.analytics;

import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes6.dex */
public enum AnalyticsEventCategory {
    Session,
    Interaction,
    Crash,
    Custom,
    NetworkRequest,
    RequestError,
    Breadcrumb,
    UserAction,
    ApplicationExit;

    public static AnalyticsEventCategory fromString(String str) {
        AnalyticsEventCategory analyticsEventCategory = Custom;
        if (str == null) {
            return analyticsEventCategory;
        }
        if (str.equalsIgnoreCase("session")) {
            return Session;
        }
        if (str.equalsIgnoreCase("interaction")) {
            return Interaction;
        }
        if (str.equalsIgnoreCase(AppMeasurement.CRASH_ORIGIN)) {
            return Crash;
        }
        if (str.equalsIgnoreCase("requesterror")) {
            return RequestError;
        }
        if (str.equalsIgnoreCase("breadcrumb")) {
            return Breadcrumb;
        }
        if (str.equalsIgnoreCase("networkrequest")) {
            return NetworkRequest;
        }
        if (str.equalsIgnoreCase("useraction")) {
            return UserAction;
        }
        return str.equalsIgnoreCase("applicationexit") ? ApplicationExit : analyticsEventCategory;
    }
}
