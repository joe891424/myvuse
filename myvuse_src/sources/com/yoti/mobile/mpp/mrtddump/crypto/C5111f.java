package com.yoti.mobile.mpp.mrtddump.crypto;

import com.yoti.mobile.mpp.mrtddump.EncryptionKey;
import com.yoti.mobile.mpp.mrtddump.MrtdCryptoException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.f */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0004H\u0000\u001a \u0010\u0005\u001a\u00060\u0001j\u0002`\u00042\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a \u0010\t\u001a\u00060\u0001j\u0002`\u00042\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a \u0010\n\u001a\u00060\u0001j\u0002`\u00062\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a \u0010\u000b\u001a\u00060\u0001j\u0002`\u00062\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\f"}, m5598d2 = {"computeSha1", "", "Lcom/yoti/mobile/mpp/mrtddump/Hash;", "data", "Lcom/yoti/mobile/mpp/mrtddump/GenericData;", "decryptDes", "Lcom/yoti/mobile/mpp/mrtddump/EncryptedData;", "key", "Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;", "decryptTripleDes", "encryptDes", "encryptTripleDes", "mrtddump_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C5111f {
    /* JADX INFO: renamed from: a */
    public static final byte[] m5492a(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(data);
            byte[] bArrDigest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "messageDigest.digest()");
            return bArrDigest;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-1 not available", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final byte[] m5493a(byte[] data, EncryptionKey key) throws MrtdCryptoException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getF8010a(), "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            byte[] bArrDoFinal = cipher.doFinal(data);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(data)");
            return bArrDoFinal;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("DES not available", e);
        } catch (GeneralSecurityException e2) {
            throw new MrtdCryptoException("Decryption error", e2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static final byte[] m5494b(byte[] data, EncryptionKey key) throws MrtdCryptoException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getF8010a(), "DESede");
            Cipher cipher = Cipher.getInstance("DESede/CBC/NoPadding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[8]));
            byte[] bArrDoFinal = cipher.doFinal(data);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(data)");
            return bArrDoFinal;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Triple-DES not available", e);
        } catch (GeneralSecurityException e2) {
            throw new MrtdCryptoException("Decryption error", e2);
        }
    }

    /* JADX INFO: renamed from: c */
    public static final byte[] m5495c(byte[] data, EncryptionKey key) throws MrtdCryptoException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getF8010a(), "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, secretKeySpec);
            byte[] bArrDoFinal = cipher.doFinal(data);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(data)");
            return bArrDoFinal;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("DES not available", e);
        } catch (GeneralSecurityException e2) {
            throw new MrtdCryptoException("Encryption error", e2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static final byte[] m5496d(byte[] data, EncryptionKey key) throws MrtdCryptoException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getF8010a(), "DESede");
            Cipher cipher = Cipher.getInstance("DESede/CBC/NoPadding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[8]));
            byte[] bArrDoFinal = cipher.doFinal(data);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(data)");
            return bArrDoFinal;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Triple-DES not available", e);
        } catch (GeneralSecurityException e2) {
            throw new MrtdCryptoException("Encryption error", e2);
        }
    }
}
