package com.salesforce.marketingcloud.proximity;

import com.salesforce.marketingcloud.notifications.NotificationManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m5598d2 = {"Lcom/salesforce/marketingcloud/proximity/ProximityNotificationCustomizationOptions;", "", "smallIconResId", "", "channelIdProvider", "Lcom/salesforce/marketingcloud/notifications/NotificationManager$NotificationChannelIdProvider;", "(ILcom/salesforce/marketingcloud/notifications/NotificationManager$NotificationChannelIdProvider;)V", "getChannelIdProvider", "()Lcom/salesforce/marketingcloud/notifications/NotificationManager$NotificationChannelIdProvider;", "getSmallIconResId", "()I", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ProximityNotificationCustomizationOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ProximityNotificationCustomizationOptions instance;
    private final NotificationManager.NotificationChannelIdProvider channelIdProvider;
    private final int smallIconResId;

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/salesforce/marketingcloud/proximity/ProximityNotificationCustomizationOptions$Companion;", "", "()V", "instance", "Lcom/salesforce/marketingcloud/proximity/ProximityNotificationCustomizationOptions;", "create", "smallIconResId", "", "channelIdProvider", "Lcom/salesforce/marketingcloud/notifications/NotificationManager$NotificationChannelIdProvider;", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final ProximityNotificationCustomizationOptions create(int smallIconResId) {
            if (ProximityNotificationCustomizationOptions.instance == null) {
                ProximityNotificationCustomizationOptions.instance = new ProximityNotificationCustomizationOptions(smallIconResId, null, 0 == true ? 1 : 0);
            }
            ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions = ProximityNotificationCustomizationOptions.instance;
            Intrinsics.checkNotNull(proximityNotificationCustomizationOptions);
            return proximityNotificationCustomizationOptions;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ProximityNotificationCustomizationOptions create(int smallIconResId, NotificationManager.NotificationChannelIdProvider channelIdProvider) {
            Intrinsics.checkNotNullParameter(channelIdProvider, "channelIdProvider");
            if (ProximityNotificationCustomizationOptions.instance == null) {
                ProximityNotificationCustomizationOptions.instance = new ProximityNotificationCustomizationOptions(smallIconResId, channelIdProvider, null);
            }
            ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions = ProximityNotificationCustomizationOptions.instance;
            Intrinsics.checkNotNull(proximityNotificationCustomizationOptions);
            return proximityNotificationCustomizationOptions;
        }
    }

    private ProximityNotificationCustomizationOptions(int i, NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        this.smallIconResId = i;
        this.channelIdProvider = notificationChannelIdProvider;
    }

    @JvmStatic
    public static final ProximityNotificationCustomizationOptions create(int i) {
        return INSTANCE.create(i);
    }

    public final NotificationManager.NotificationChannelIdProvider getChannelIdProvider() {
        return this.channelIdProvider;
    }

    public final int getSmallIconResId() {
        return this.smallIconResId;
    }

    public /* synthetic */ ProximityNotificationCustomizationOptions(int i, NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, notificationChannelIdProvider);
    }

    @JvmStatic
    public static final ProximityNotificationCustomizationOptions create(int i, NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        return INSTANCE.create(i, notificationChannelIdProvider);
    }
}
