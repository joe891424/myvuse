package org.jose4j.keys;

import javax.crypto.spec.SecretKeySpec;
import org.jose4j.lang.ByteUtil;

/* JADX INFO: loaded from: classes6.dex */
public class AesKey extends SecretKeySpec {
    public static final String ALGORITHM = "AES";

    public AesKey(byte[] bArr) {
        super(bArr, ALGORITHM);
    }

    public String toString() {
        return ByteUtil.bitLength(getEncoded().length) + " bit AES key";
    }
}
