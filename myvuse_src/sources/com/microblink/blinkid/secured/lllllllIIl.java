package com.microblink.blinkid.secured;

import android.os.Build;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lllllllIIl {
    public static boolean llIIlIlIIl() {
        String str;
        String str2 = Build.BRAND;
        return (str2 == null || (str = Build.MANUFACTURER) == null || (str2.compareToIgnoreCase("Samsung") != 0 && str.compareToIgnoreCase("Samsung") != 0)) ? false : true;
    }
}
