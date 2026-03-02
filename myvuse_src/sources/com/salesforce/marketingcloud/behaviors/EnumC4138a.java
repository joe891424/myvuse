package com.salesforce.marketingcloud.behaviors;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.behaviors.a */
/* JADX INFO: loaded from: classes6.dex */
public enum EnumC4138a {
    BEHAVIOR_DEVICE_SHUTDOWN("android.intent.action.ACTION_SHUTDOWN"),
    BEHAVIOR_DEVICE_BOOT_COMPLETE("android.intent.action.BOOT_COMPLETED"),
    BEHAVIOR_DEVICE_TIME_ZONE_CHANGED("android.intent.action.TIMEZONE_CHANGED"),
    BEHAVIOR_APP_PACKAGE_REPLACED("android.intent.action.MY_PACKAGE_REPLACED"),
    BEHAVIOR_APP_FOREGROUNDED("com.salesforce.marketingcloud.APP_FOREGROUNDED", true),
    BEHAVIOR_APP_BACKGROUNDED("com.salesforce.marketingcloud.APP_BACKGROUNDED", BEHAVIOR_APP_FOREGROUNDED),
    BEHAVIOR_SDK_REGISTRATION_SEND("com.salesforce.marketingcloud.REGISTRATION_SEND"),
    BEHAVIOR_SDK_PUSH_RECEIVED("com.salesforce.marketingcloud.PUSH_RECEIVED"),
    BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED("com.salesforce.marketingcloud.FENCE_MESSAGING_TOGGLED"),
    BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED("com.salesforce.marketingcloud.PROXIMITY_MESSAGING_TOGGLED"),
    BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED("com.salesforce.marketingcloud.PUSH_MESSAGING_TOGGLED"),
    BEHAVIOR_SDK_NOTIFICATION_OPENED("com.salesforce.marketingcloud.NOTIFICATION_OPENED"),
    BEHAVIOR_SDK_TOKEN_REFRESHED("com.salesforce.marketingcloud.TOKEN_REFRESHED");


    /* JADX INFO: renamed from: a */
    public final String f4590a;

    /* JADX INFO: renamed from: b */
    public final boolean f4591b;

    /* JADX INFO: renamed from: c */
    public final EnumC4138a f4592c;

    EnumC4138a(String str) {
        this(str, false);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f4590a;
    }

    EnumC4138a(String str, EnumC4138a enumC4138a) {
        this.f4590a = str;
        this.f4591b = false;
        this.f4592c = enumC4138a;
    }

    /* JADX INFO: renamed from: a */
    public static EnumC4138a m3033a(String str) {
        if (str == null) {
            return null;
        }
        for (EnumC4138a enumC4138a : values()) {
            if (str.equals(enumC4138a.f4590a)) {
                return enumC4138a;
            }
        }
        return null;
    }

    EnumC4138a(String str, boolean z) {
        this.f4590a = str;
        this.f4591b = z;
        this.f4592c = null;
    }
}
