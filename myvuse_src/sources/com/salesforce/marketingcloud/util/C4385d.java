package com.salesforce.marketingcloud.util;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.d */
/* JADX INFO: loaded from: classes6.dex */
public class C4385d {

    /* JADX INFO: renamed from: a */
    private static Boolean f5753a;

    /* JADX INFO: renamed from: b */
    private static Boolean f5754b;

    private C4385d() {
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4262a() {
        if (f5754b == null) {
            try {
                Class.forName("org.altbeacon.beacon.BeaconManager");
                f5754b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f5754b = Boolean.FALSE;
            }
        }
        return f5754b.booleanValue();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4263b() {
        if (f5753a == null) {
            try {
                Class.forName("com.google.android.gms.location.LocationServices");
                f5753a = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f5753a = Boolean.FALSE;
            }
        }
        return f5753a.booleanValue();
    }
}
