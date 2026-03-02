package com.microblink.view.recognition;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.microblink.recognition.Right;
import com.microblink.recognition.RightsManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.p099io.encoding.Base64;
import org.jose4j.lang.HashUtil;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class llIIlIlIIl {
    private static final byte[] llIIlIlIIl = {-75, -11, 17, -104, 102, -99, -52, -52, -36, -45, -96, 110, 102, 125, -78, 35, 39, -34, -18, 57, 65, Ascii.f3751GS, 49, 75, 66, 62, 34, -69, -74, 109, -60, 97};
    private static final byte[] IlIllIlIIl = {0, -117, -106, -91, 116, -30, -29, 67, -67, 92, -81, 103, -73, -100, SignedBytes.MAX_POWER_OF_TWO, 84, Ascii.f3756SI, Ascii.DC4, -32, 113, 57, 51, -55, Ascii.DC2, -28, 121, 37, Ascii.DLE, -38, Ascii.f3760VT, -108, Base64.padSymbol};
    private static final byte[] IllIIIllII = {-5, 19, -46, -120, -61, Ascii.CAN, 79, -113, 79, Ascii.f3747CR, -80, -23, 92, Ascii.f3750FS, -92, -127, -4, -127, -87, 8, 38, -123, -48, -20, 99, 35, 39, 33, Ascii.f3760VT, 10, 85, -121};
    private static final byte[] llIIIlllll = {89, -13, Ascii.f3760VT, Ascii.f3755RS, 86, -82, 117, 120, -8, -59, -18, 107, 42, -49, -92, 36, -21, -22, -95, -118, -78, -100, -76, -110, 93, 33, 7, -46, Ascii.SUB, -26, -108, -86};
    private static final byte[] IllIIIIllI = {-66, -108, -115, 82, 122, 106, -101, -100, -74, 82, Ascii.f3759US, -97, -121, Ascii.CAN, 101, -99, -19, -37, 97, -125, -65, -55, 114, 57, -56, 110, 120, -62, 77, Ascii.DC4, 70, -126};
    private static final byte[] lIlIIIIlIl = {-89, -80, 9, 32, 77, 46, 52, -19, -20, -16, 111, 111, 126, -58, 78, 89, 65, -33, -16, 81, -122, 6, SignedBytes.MAX_POWER_OF_TWO, -41, 99, -68, -2, 47, 74, -125, -23, 62};
    private static final byte[] llIIlIIlll = {-39, 113, -10, 8, 83, -109, 98, -77, 117, 71, 67, 100, -8, -109, -103, -75, 60, Ascii.f3759US, 79, Base64.padSymbol, 99, -23, -27, 75, 121, 35, 8, Ascii.SYN, 93, -63, Ascii.f3756SI, -38};
    private static final byte[] IIlIIIllIl = {96, 45, -85, -78, Ascii.DLE, -70, -40, 112, -72, -20, -87, 49, 96, 69, -104, Ascii.ETB, Ascii.f3756SI, -25, -46, 94, -22, 124, -90, -90, 9, 67, 68, 106, 108, -55, -106, Ascii.f3748EM};
    private static final byte[] lIIIIIllll = {-106, -14, 17, 60, -9, -47, 51, 7, 37, 111, -89, 120, -86, 71, Ascii.DLE, -24, 8, -19, 110, -22, 37, -81, -79, -18, -80, 66, 82, -60, -121, 123, -52, -118};
    private static final byte[] lllIIIlIlI = {-20, 103, -12, -113, -14, -92, -78, -28, -53, -48, 104, -13, 10, 93, -67, 6, 110, 70, 79, -51, -9, -32, 94, 46, -18, -115, 123, 9, -40, 81, 42, -86};
    private static final byte[] IlIllIlllI = {-113, 33, -4, -48, -120, 106, -52, 5, Ascii.f3757SO, -126, -94, 0, -39, 96, -57, 86, 17, -46, -56, 71, -78, 38, -95, Ascii.f3749FF, -70, 82, -5, 110, -109, -25, -67, 50};

    static boolean llIIlIlIIl(Object obj) {
        if (RightsManager.llIIIlllll() && RightsManager.llIIlIlIIl(Right.ALLOW_CUSTOM_UI)) {
            return true;
        }
        String name = obj.getClass().getName();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(HashUtil.SHA_256);
            messageDigest.update(name.getBytes("iso-8859-1"), 0, name.length());
            byte[] bArrDigest = messageDigest.digest();
            if (llIIlIlIIl(bArrDigest, llIIlIlIIl) || llIIlIlIIl(bArrDigest, IlIllIlIIl) || llIIlIlIIl(bArrDigest, IllIIIllII) || llIIlIlIIl(bArrDigest, llIIIlllll) || llIIlIlIIl(bArrDigest, IllIIIIllI) || llIIlIlIIl(bArrDigest, lIlIIIIlIl) || llIIlIlIIl(bArrDigest, llIIlIIlll) || llIIlIlIIl(bArrDigest, IIlIIIllIl) || llIIlIlIIl(bArrDigest, lIIIIIllll) || llIIlIlIIl(bArrDigest, lllIIIlIlI)) {
                return true;
            }
            if (llIIlIlIIl(bArrDigest, IlIllIlllI)) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private static boolean llIIlIlIIl(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
