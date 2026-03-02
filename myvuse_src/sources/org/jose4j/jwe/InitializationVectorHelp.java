package org.jose4j.jwe;

import java.security.SecureRandom;
import org.jose4j.lang.ByteUtil;

/* JADX INFO: loaded from: classes6.dex */
public class InitializationVectorHelp {
    /* JADX INFO: renamed from: iv */
    static byte[] m5642iv(int i, byte[] bArr, SecureRandom secureRandom) {
        return bArr == null ? ByteUtil.randomBytes(i, secureRandom) : bArr;
    }
}
