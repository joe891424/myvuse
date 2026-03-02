package com.salesforce.marketingcloud.analytics;

import com.salesforce.marketingcloud.analytics.InterfaceC4117l;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.iam.C4259j;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.i */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4114i implements InterfaceC4115j, InterfaceC4116k, AnalyticsManager, InterfaceC4112g, InterfaceC4111f, InterfaceC4118m, InterfaceC4119n, InterfaceC4117l {
    /* JADX INFO: renamed from: a */
    public void mo2924a(long j) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4119n
    /* JADX INFO: renamed from: a */
    public void mo2944a(C4106e c4106e, Event... eventArr) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4117l
    /* JADX INFO: renamed from: a */
    public void mo2945a(InterfaceC4117l.a aVar, JSONObject jSONObject) {
    }

    /* JADX INFO: renamed from: a */
    public void mo2925a(Region region) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2934a(InAppMessage inAppMessage) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2935a(InAppMessage inAppMessage, C4259j c4259j) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2936a(InAppMessage inAppMessage, JSONObject jSONObject) {
    }

    /* JADX INFO: renamed from: a */
    public void mo2916a(InboxMessage inboxMessage) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4115j
    /* JADX INFO: renamed from: a */
    public void mo2926a(NotificationMessage notificationMessage) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4115j
    /* JADX INFO: renamed from: a */
    public void mo2917a(NotificationMessage notificationMessage, boolean z) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4118m
    /* JADX INFO: renamed from: a */
    public void mo2946a(String str, String str2, String str3, String str4) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2937a(String str, String str2, List<String> list) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4118m
    /* JADX INFO: renamed from: a */
    public void mo2947a(JSONObject jSONObject) {
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo2918a(boolean z);

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public boolean areAnalyticsEnabled() {
        return true;
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public boolean arePiAnalyticsEnabled() {
        return true;
    }

    /* JADX INFO: renamed from: b */
    public void mo2927b(long j) {
    }

    /* JADX INFO: renamed from: b */
    public void mo2928b(Region region) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: b */
    public void mo2938b(InAppMessage inAppMessage) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4115j
    /* JADX INFO: renamed from: b */
    public void mo2919b(NotificationMessage notificationMessage) {
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4118m
    /* JADX INFO: renamed from: b */
    public void mo2949b(JSONObject jSONObject) {
    }

    /* JADX INFO: renamed from: c */
    public void mo2929c(long j) {
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void disableAnalytics() {
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void disablePiAnalytics() {
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void enableAnalytics() {
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void enablePiAnalytics() {
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public String getPiIdentifier() {
        return null;
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void setPiIdentifier(String str) {
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackCartContents(PiCart piCart) {
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackCartConversion(PiOrder piOrder) {
    }

    public void trackInboxOpenEvent(InboxMessage inboxMessage) {
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public final void trackPageView(String str) {
        trackPageView(str, null, null, null);
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(String str, String str2, String str3, String str4) {
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public final void trackPageView(String str, String str2) {
        trackPageView(str, str2, null, null);
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public final void trackPageView(String str, String str2, String str3) {
        trackPageView(str, str2, str3, null);
    }
}
