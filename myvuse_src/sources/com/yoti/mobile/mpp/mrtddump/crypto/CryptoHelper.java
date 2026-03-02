package com.yoti.mobile.mpp.mrtddump.crypto;

import java.security.SecureRandom;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/crypto/CryptoHelper;", "", "()V", "secureRandom", "Ljava/security/SecureRandom;", "generateRandomBytes", "", "numBytes", "", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CryptoHelper {

    /* JADX INFO: renamed from: a */
    private final SecureRandom f8061a = new SecureRandom();

    /* JADX INFO: renamed from: a */
    public final byte[] m5478a(int i) {
        byte[] bArr = new byte[i];
        this.f8061a.nextBytes(bArr);
        return bArr;
    }
}
