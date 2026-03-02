package com.newrelic.agent.android.analytics;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public interface AnalyticsController {
    boolean addEvent(AnalyticsEvent analyticsEvent);

    boolean addEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, Set<AnalyticsAttribute> set);

    boolean addEvent(String str, Set<AnalyticsAttribute> set);

    AnalyticsAttribute getAttribute(String str);

    EventManager getEventManager();

    int getMaxEventBufferTime();

    int getMaxEventPoolSize();

    int getSessionAttributeCount();

    Set<AnalyticsAttribute> getSessionAttributes();

    int getSystemAttributeCount();

    Set<AnalyticsAttribute> getSystemAttributes();

    int getUserAttributeCount();

    Set<AnalyticsAttribute> getUserAttributes();

    boolean incrementAttribute(String str, double d);

    boolean incrementAttribute(String str, double d, boolean z);

    boolean recordCustomEvent(String str, Map<String, Object> map);

    boolean recordEvent(String str, Map<String, Object> map);

    boolean removeAllAttributes();

    boolean removeAttribute(String str);

    boolean setAttribute(String str, double d);

    boolean setAttribute(String str, double d, boolean z);

    boolean setAttribute(String str, String str2);

    boolean setAttribute(String str, String str2, boolean z);

    boolean setAttribute(String str, boolean z);

    boolean setAttribute(String str, boolean z, boolean z2);

    void setMaxEventBufferTime(int i);

    void setMaxEventPoolSize(int i);
}
