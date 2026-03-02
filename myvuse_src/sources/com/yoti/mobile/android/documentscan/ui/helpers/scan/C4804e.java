package com.yoti.mobile.android.documentscan.ui.helpers.scan;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.helpers.scan.e */
/* JADX INFO: loaded from: classes5.dex */
final class C4804e {

    /* JADX INFO: renamed from: a */
    private final String f7116a;

    /* JADX INFO: renamed from: b */
    private final String f7117b;

    public C4804e(String manufacturer, String model) {
        Intrinsics.checkParameterIsNotNull(manufacturer, "manufacturer");
        Intrinsics.checkParameterIsNotNull(model, "model");
        this.f7116a = manufacturer;
        this.f7117b = model;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4804e)) {
            return false;
        }
        C4804e c4804e = (C4804e) obj;
        return Intrinsics.areEqual(this.f7116a, c4804e.f7116a) && Intrinsics.areEqual(this.f7117b, c4804e.f7117b);
    }

    public int hashCode() {
        String str = this.f7116a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f7117b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Device(manufacturer=" + this.f7116a + ", model=" + this.f7117b + ")";
    }
}
