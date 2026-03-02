package org.jose4j.jwe.kdf;

import org.jose4j.base64url.Base64Url;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.StringUtil;

/* JADX INFO: loaded from: classes6.dex */
public class KdfUtil {
    private Base64Url base64Url;
    private ConcatenationKeyDerivationFunctionWithSha256 kdf;

    public KdfUtil() {
        this(null);
    }

    public KdfUtil(String str) {
        this.base64Url = new Base64Url();
        this.kdf = ConcatKeyDerivationFunctionFactory.make(str);
    }

    public byte[] kdf(byte[] bArr, int i, String str, String str2, String str3) {
        return this.kdf.kdf(bArr, i, ByteUtil.concat(prependDatalen(StringUtil.getBytesUtf8(str)), getDatalenDataFormat(str2), getDatalenDataFormat(str3), ByteUtil.getBytes(i), ByteUtil.EMPTY_BYTES));
    }

    byte[] prependDatalen(byte[] bArr) {
        if (bArr == null) {
            bArr = ByteUtil.EMPTY_BYTES;
        }
        return ByteUtil.concat(ByteUtil.getBytes(bArr.length), bArr);
    }

    byte[] getDatalenDataFormat(String str) {
        return prependDatalen(this.base64Url.base64UrlDecode(str));
    }
}
