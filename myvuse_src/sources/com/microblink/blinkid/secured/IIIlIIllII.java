package com.microblink.blinkid.secured;

import android.content.Context;
import android.util.Base64;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.microblink.blinkid.secured.IIIlIIlIll;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IIIlIIllII extends IllIlIIIll {
    private final Context lIlIIIIlIl;

    public IIIlIIllII(Context context, IIIIIIllIl iIIIIIllIl, llIllIlIll llillilill, IIIlIIIIlI iIIlIIIIlI, llIllIlIII llilliliii) {
        super(llillilill, iIIIIIllIl, iIIlIIIIlI, llilliliii);
        this.lIlIIIIlIl = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.io.InputStream IlIllIlIIl(com.microblink.blinkid.secured.lllIIIlIlI r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = "tmp_image"
            java.lang.String r2 = ".jpg"
            java.io.File r1 = java.io.File.createTempFile(r1, r2)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r3.<init>(r1)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r2.<init>(r3)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            android.graphics.Bitmap r3 = r7.llIIlIlIIl     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            com.microblink.blinkid.secured.IIIIIIllIl r5 = r6.IllIIIllII     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r5.getClass()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r5 = 95
            r3.compress(r4, r5, r2)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r2.close()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            android.media.ExifInterface r2 = new android.media.ExifInterface     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            java.lang.String r3 = r1.getAbsolutePath()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r2.<init>(r3)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            java.lang.String r3 = "Orientation"
            int r7 = r7.IlIllIlIIl     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r2.setAttribute(r3, r7)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r2.saveAttributes()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r2.<init>(r1)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r7.<init>(r2)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L58
            r1.delete()
            return r7
        L49:
            r7 = move-exception
            goto L4f
        L4b:
            r7 = move-exception
            goto L5a
        L4d:
            r7 = move-exception
            r1 = r0
        L4f:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L57
            r1.delete()
        L57:
            return r0
        L58:
            r7 = move-exception
            r0 = r1
        L5a:
            if (r0 == 0) goto L5f
            r0.delete()
        L5f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkid.secured.IIIlIIllII.IlIllIlIIl(com.microblink.blinkid.secured.lllIIIlIlI):java.io.InputStream");
    }

    @Override // com.microblink.blinkid.secured.IllIlIIIll
    boolean llIIlIlIIl(lllIIIlIlI llliiilili) {
        try {
            InputStream inputStreamIlIllIlIIl = IlIllIlIIl(llliiilili);
            final SecretKey secretKeyLlIIlIlIIl = lllIIIllII.llIIlIlIIl();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            lllIIIllII.llIIlIlIIl(inputStreamIlIllIlIIl, secretKeyLlIIlIlIIl, byteArrayOutputStream);
            String strEncodeToString = Base64.encodeToString(lllIIIllII.llIIlIlIIl(this.lIlIIIIlIl, secretKeyLlIIlIlIIl), 2);
            this.IllIIIIllI.llIIlIlIIl(new lIIIIIllIl() { // from class: com.microblink.blinkid.secured.IIIlIIllII$$ExternalSyntheticLambda0
                @Override // com.microblink.blinkid.secured.lIIIIIllIl
                public final String llIIlIlIIl(String str) {
                    return this.f$0.llIIlIlIIl(secretKeyLlIIlIlIIl, str);
                }
            });
            IIIlIIlIll iIIlIIlIllLlIIlIlIIl = IIIlIIlIll.llIIlIlIIl("https://data.microblink.com/enc");
            iIIlIIlIllLlIIlIlIIl.llIIlIlIIl(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
            iIIlIIlIllLlIIlIlIIl.llIIlIlIIl(strEncodeToString, byteArrayOutputStream.toByteArray(), this.IllIIIIllI.llIIlIlIIl(llliiilili.IllIIIllII).entrySet());
            if (this.IlIllIlIIl != null) {
                return false;
            }
            return iIIlIIlIllLlIIlIlIIl.IlIllIlIIl() == 201;
        } catch (IIIlIIlIll.llIIlIlIIl | IOException | GeneralSecurityException e) {
            this.IlIllIlIIl = e;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String llIIlIlIIl(SecretKey secretKey, String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int i = lllIIIllII.IllIIIllII;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            lllIIIllII.llIIlIlIIl(new ByteArrayInputStream(bytes), secretKey, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (IOException | GeneralSecurityException e) {
            this.IlIllIlIIl = e;
            return "";
        }
    }
}
