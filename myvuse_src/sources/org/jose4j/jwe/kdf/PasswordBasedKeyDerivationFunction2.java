package org.jose4j.jwe.kdf;

import java.io.ByteArrayOutputStream;
import javax.crypto.Mac;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jose4j.keys.HmacKey;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UncheckedJoseException;
import org.jose4j.mac.MacUtil;

/* JADX INFO: loaded from: classes6.dex */
public class PasswordBasedKeyDerivationFunction2 {
    private String hmacAlgorithm;

    public PasswordBasedKeyDerivationFunction2(String str) {
        this.hmacAlgorithm = str;
    }

    public byte[] derive(byte[] bArr, byte[] bArr2, int i, int i2) throws JoseException {
        return derive(bArr, bArr2, i, i2, null);
    }

    public byte[] derive(byte[] bArr, byte[] bArr2, int i, int i2, String str) throws JoseException {
        Mac initializedMac = MacUtil.getInitializedMac(this.hmacAlgorithm, new HmacKey(bArr), str);
        int macLength = initializedMac.getMacLength();
        if (i2 > InternalZipConstants.ZIP_64_SIZE_LIMIT) {
            throw new UncheckedJoseException("derived key too long " + i2);
        }
        int iCeil = (int) Math.ceil(((double) i2) / ((double) macLength));
        int i3 = iCeil - 1;
        int i4 = i2 - (macLength * i3);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        while (i5 < iCeil) {
            int i6 = i5 + 1;
            byte[] bArrM5643f = m5643f(bArr2, i, i6, initializedMac);
            if (i5 == i3) {
                bArrM5643f = ByteUtil.subArray(bArrM5643f, 0, i4);
            }
            byteArrayOutputStream.write(bArrM5643f, 0, bArrM5643f.length);
            i5 = i6;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: renamed from: f */
    byte[] m5643f(byte[] bArr, int i, int i2, Mac mac) {
        byte[] bArrDoFinal = null;
        byte[] bArrDoFinal2 = null;
        for (int i3 = 1; i3 <= i; i3++) {
            if (i3 == 1) {
                bArrDoFinal = mac.doFinal(ByteUtil.concat(bArr, ByteUtil.getBytes(i2)));
                bArrDoFinal2 = bArrDoFinal;
            } else {
                bArrDoFinal2 = mac.doFinal(bArrDoFinal2);
                for (int i4 = 0; i4 < bArrDoFinal2.length; i4++) {
                    bArrDoFinal[i4] = (byte) (bArrDoFinal2[i4] ^ bArrDoFinal[i4]);
                }
            }
        }
        return bArrDoFinal;
    }
}
