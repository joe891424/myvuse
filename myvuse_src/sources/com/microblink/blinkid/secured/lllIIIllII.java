package com.microblink.blinkid.secured;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.jose4j.keys.AesKey;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class lllIIIllII {
    private static final Random IlIllIlIIl = new Random();
    public static final /* synthetic */ int IllIIIllII = 0;
    private static PublicKey llIIlIlIIl;

    static SecretKey llIIlIlIIl() throws GeneralSecurityException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AesKey.ALGORITHM);
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }

    static void llIIlIlIIl(InputStream inputStream, SecretKey secretKey, OutputStream outputStream) throws GeneralSecurityException, IOException {
        byte[] iv;
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKey);
        try {
            iv = ((IvParameterSpec) cipher.getParameters().getParameterSpec(IvParameterSpec.class)).getIV();
        } catch (NullPointerException unused) {
            iv = new byte[16];
            IlIllIlIIl.nextBytes(iv);
        }
        outputStream.write(iv);
        llIIlIlIIl(inputStream, new CipherOutputStream(outputStream, cipher));
    }

    static byte[] llIIlIlIIl(Context context, SecretKey secretKey) throws GeneralSecurityException, IOException {
        PublicKey publicKey;
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        synchronized (lllIIIllII.class) {
            if (llIIlIlIIl == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                llIIlIlIIl(context.getAssets().open("microblink/public.der"), byteArrayOutputStream);
                llIIlIlIIl = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(byteArrayOutputStream.toByteArray()));
            }
            publicKey = llIIlIlIIl;
        }
        cipher.init(1, publicKey);
        return cipher.doFinal(secretKey.getEncoded());
    }

    private static void llIIlIlIIl(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                } else {
                    try {
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } finally {
            }
        }
        outputStream.close();
        try {
            inputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
