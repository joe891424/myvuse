package com.facetec.sdk;

import java.util.Locale;

/* JADX INFO: renamed from: com.facetec.sdk.bg */
/* JADX INFO: loaded from: classes3.dex */
final class C2167bg extends Exception {
    C2167bg(B b) {
        this(b, "");
    }

    C2167bg(B b, String str) {
        super(m1848B(b, str));
    }

    C2167bg(Throwable th) {
        super(m1848B(B.UNKNOWN, ""), th);
    }

    C2167bg(B b, Throwable th) {
        super(m1848B(b, ""), th);
    }

    /* JADX INFO: renamed from: B */
    private static String m1848B(B b, String str) {
        String str2 = String.format(Locale.US, "Camera error (%d)", Integer.valueOf(b.f2802D));
        return !str.isEmpty() ? new StringBuilder().append(str2).append(": ").append(str).toString() : str2;
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bg$B */
    enum B {
        UNKNOWN(0),
        PERMISSION_DENIED(1),
        OPEN_TIMEOUT(2),
        LOCK_OPEN_TIMEOUT(3),
        CLOSE_ERROR(4),
        FRONT_FACING_NOT_FOUND(5),
        NO_OUTPUT_SIZES(6),
        ACCESS_ERROR(7);


        /* JADX INFO: renamed from: D */
        final int f2802D;

        B(int i) {
            this.f2802D = i;
        }
    }
}
