package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: loaded from: classes2.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* JADX INFO: renamed from: id */
    private final int f3836id;

    DeliveryMechanism(int i) {
        this.f3836id = i;
    }

    public int getId() {
        return this.f3836id;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f3836id);
    }

    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }
}
