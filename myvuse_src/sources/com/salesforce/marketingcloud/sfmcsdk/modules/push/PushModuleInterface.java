package com.salesforce.marketingcloud.sfmcsdk.modules.push;

import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.analytics.AnalyticsManager;
import com.salesforce.marketingcloud.events.EventManager;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.iam.InAppMessageManager;
import com.salesforce.marketingcloud.messages.inbox.InboxMessageManager;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: PushModuleInterface.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006'"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/modules/push/PushModuleInterface;", "Lcom/salesforce/marketingcloud/sfmcsdk/modules/ModuleInterface;", "()V", "analyticsManager", "Lcom/salesforce/marketingcloud/analytics/AnalyticsManager;", "getAnalyticsManager", "()Lcom/salesforce/marketingcloud/analytics/AnalyticsManager;", "eventManager", "Lcom/salesforce/marketingcloud/events/EventManager;", "getEventManager", "()Lcom/salesforce/marketingcloud/events/EventManager;", "inAppMessageManager", "Lcom/salesforce/marketingcloud/messages/iam/InAppMessageManager;", "getInAppMessageManager", "()Lcom/salesforce/marketingcloud/messages/iam/InAppMessageManager;", "inboxMessageManager", "Lcom/salesforce/marketingcloud/messages/inbox/InboxMessageManager;", "getInboxMessageManager", "()Lcom/salesforce/marketingcloud/messages/inbox/InboxMessageManager;", "initializationStatus", "Lcom/salesforce/marketingcloud/InitializationStatus;", "getInitializationStatus", "()Lcom/salesforce/marketingcloud/InitializationStatus;", "notificationManager", "Lcom/salesforce/marketingcloud/notifications/NotificationManager;", "getNotificationManager", "()Lcom/salesforce/marketingcloud/notifications/NotificationManager;", "pushMessageManager", "Lcom/salesforce/marketingcloud/messages/push/PushMessageManager;", "getPushMessageManager", "()Lcom/salesforce/marketingcloud/messages/push/PushMessageManager;", "regionMessageManager", "Lcom/salesforce/marketingcloud/messages/RegionMessageManager;", "getRegionMessageManager", "()Lcom/salesforce/marketingcloud/messages/RegionMessageManager;", "registrationManager", "Lcom/salesforce/marketingcloud/registration/RegistrationManager;", "getRegistrationManager", "()Lcom/salesforce/marketingcloud/registration/RegistrationManager;", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class PushModuleInterface implements ModuleInterface {
    public abstract AnalyticsManager getAnalyticsManager();

    public abstract EventManager getEventManager();

    public abstract InAppMessageManager getInAppMessageManager();

    public abstract InboxMessageManager getInboxMessageManager();

    public abstract InitializationStatus getInitializationStatus();

    public abstract NotificationManager getNotificationManager();

    public abstract PushMessageManager getPushMessageManager();

    public abstract RegionMessageManager getRegionMessageManager();

    public abstract RegistrationManager getRegistrationManager();
}
