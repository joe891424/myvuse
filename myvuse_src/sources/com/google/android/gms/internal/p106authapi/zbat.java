package com.google.android.gms.internal.p106authapi;

import android.util.Base64;
import java.security.SecureRandom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zbat {
    private static final SecureRandom zba = new SecureRandom();

    public static String zba() {
        byte[] bArr = new byte[16];
        zba.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
