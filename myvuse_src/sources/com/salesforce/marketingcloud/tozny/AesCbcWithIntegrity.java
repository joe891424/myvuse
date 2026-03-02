package com.salesforce.marketingcloud.tozny;

import android.os.Build;
import android.os.Process;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class AesCbcWithIntegrity {
    private static final int AES_KEY_LENGTH_BITS = 128;
    private static final boolean ALLOW_BROKEN_PRNG = false;
    public static final int BASE64_FLAGS = 2;
    private static final String CIPHER = "AES";
    private static final String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final int HMAC_KEY_LENGTH_BITS = 256;
    private static final int IV_LENGTH_BYTES = 16;
    private static final String PBE_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int PBE_SALT_LENGTH_BITS = 128;
    static final AtomicBoolean prngFixed = new AtomicBoolean(false);

    public static class CipherTextIvMac {
        private final byte[] cipherText;

        /* JADX INFO: renamed from: iv */
        private final byte[] f5743iv;
        private final byte[] mac;

        public CipherTextIvMac(String str) {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length != 3) {
                throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
            }
            this.f5743iv = Base64.decode(strArrSplit[0], 2);
            this.mac = Base64.decode(strArrSplit[1], 2);
            this.cipherText = Base64.decode(strArrSplit[2], 2);
        }

        public static byte[] ivCipherConcat(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CipherTextIvMac cipherTextIvMac = (CipherTextIvMac) obj;
            return Arrays.equals(this.cipherText, cipherTextIvMac.cipherText) && Arrays.equals(this.f5743iv, cipherTextIvMac.f5743iv) && Arrays.equals(this.mac, cipherTextIvMac.mac);
        }

        public byte[] getCipherText() {
            return this.cipherText;
        }

        public byte[] getIv() {
            return this.f5743iv;
        }

        public byte[] getMac() {
            return this.mac;
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.cipherText) + 31) * 31) + Arrays.hashCode(this.f5743iv)) * 31) + Arrays.hashCode(this.mac);
        }

        public String toString() {
            return String.format(Base64.encodeToString(this.f5743iv, 2) + ":" + Base64.encodeToString(this.mac, 2) + ":" + Base64.encodeToString(this.cipherText, 2), new Object[0]);
        }

        public CipherTextIvMac(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            byte[] bArr4 = new byte[bArr.length];
            this.cipherText = bArr4;
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
            byte[] bArr5 = new byte[bArr2.length];
            this.f5743iv = bArr5;
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
            byte[] bArr6 = new byte[bArr3.length];
            this.mac = bArr6;
            System.arraycopy(bArr3, 0, bArr6, 0, bArr3.length);
        }
    }

    public static final class PrngFixes {

        /* JADX INFO: renamed from: a */
        private static final int f5744a = 16;

        /* JADX INFO: renamed from: b */
        private static final int f5745b = 18;

        /* JADX INFO: renamed from: c */
        private static final byte[] f5746c = m4253e();

        public static class LinuxPRNGSecureRandom extends SecureRandomSpi {
            private static final File URANDOM_FILE = new File("/dev/urandom");
            private static final Object sLock = new Object();
            private static DataInputStream sUrandomIn;
            private static OutputStream sUrandomOut;
            private boolean mSeeded;

            private DataInputStream getUrandomInputStream() {
                DataInputStream dataInputStream;
                synchronized (sLock) {
                    if (sUrandomIn == null) {
                        try {
                            sUrandomIn = new DataInputStream(new FileInputStream(URANDOM_FILE));
                        } catch (IOException e) {
                            throw new SecurityException("Failed to open " + URANDOM_FILE + " for reading", e);
                        }
                    }
                    dataInputStream = sUrandomIn;
                }
                return dataInputStream;
            }

            private OutputStream getUrandomOutputStream() throws IOException {
                OutputStream outputStream;
                synchronized (sLock) {
                    if (sUrandomOut == null) {
                        sUrandomOut = new FileOutputStream(URANDOM_FILE);
                    }
                    outputStream = sUrandomOut;
                }
                return outputStream;
            }

            @Override // java.security.SecureRandomSpi
            protected byte[] engineGenerateSeed(int i) {
                byte[] bArr = new byte[i];
                engineNextBytes(bArr);
                return bArr;
            }

            @Override // java.security.SecureRandomSpi
            protected void engineNextBytes(byte[] bArr) {
                DataInputStream urandomInputStream;
                if (!this.mSeeded) {
                    engineSetSeed(PrngFixes.m4252d());
                }
                try {
                    synchronized (sLock) {
                        urandomInputStream = getUrandomInputStream();
                    }
                    synchronized (urandomInputStream) {
                        urandomInputStream.readFully(bArr);
                    }
                } catch (IOException e) {
                    throw new SecurityException("Failed to read from " + URANDOM_FILE, e);
                }
            }

            @Override // java.security.SecureRandomSpi
            protected void engineSetSeed(byte[] bArr) {
                OutputStream urandomOutputStream;
                try {
                    try {
                        synchronized (sLock) {
                            urandomOutputStream = getUrandomOutputStream();
                        }
                        urandomOutputStream.write(bArr);
                        urandomOutputStream.flush();
                    } catch (IOException unused) {
                        LogInstrumentation.m2734w(PrngFixes.class.getSimpleName(), "Failed to mix seed into " + URANDOM_FILE);
                    }
                } finally {
                    this.mSeeded = true;
                }
            }
        }

        private static class LinuxPRNGSecureRandomProvider extends Provider {
            public LinuxPRNGSecureRandomProvider() {
                super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
                put("SecureRandom.SHA1PRNG", LinuxPRNGSecureRandom.class.getName());
                put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
            }
        }

        private PrngFixes() {
        }

        /* JADX INFO: renamed from: b */
        public static void m4250b() {
            m4251c();
            m4255g();
        }

        /* JADX INFO: renamed from: c */
        private static void m4251c() throws SecurityException {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: d */
        public static byte[] m4252d() {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeLong(System.currentTimeMillis());
                dataOutputStream.writeLong(System.nanoTime());
                dataOutputStream.writeInt(Process.myPid());
                dataOutputStream.writeInt(Process.myUid());
                dataOutputStream.write(f5746c);
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new SecurityException("Failed to generate seed", e);
            }
        }

        /* JADX INFO: renamed from: e */
        private static byte[] m4253e() {
            StringBuilder sb = new StringBuilder();
            String str = Build.FINGERPRINT;
            if (str != null) {
                sb.append(str);
            }
            String strM4254f = m4254f();
            if (strM4254f != null) {
                sb.append(strM4254f);
            }
            try {
                return sb.toString().getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException("UTF-8 encoding not supported");
            }
        }

        /* JADX INFO: renamed from: f */
        private static String m4254f() {
            try {
                return (String) Build.class.getField("SERIAL").get(null);
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX INFO: renamed from: g */
        private static void m4255g() throws SecurityException {
        }
    }

    public static class SecretKeys {
        private SecretKey confidentialityKey;
        private SecretKey integrityKey;

        public SecretKeys(SecretKey secretKey, SecretKey secretKey2) {
            setConfidentialityKey(secretKey);
            setIntegrityKey(secretKey2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SecretKeys secretKeys = (SecretKeys) obj;
            return this.integrityKey.equals(secretKeys.integrityKey) && this.confidentialityKey.equals(secretKeys.confidentialityKey);
        }

        public SecretKey getConfidentialityKey() {
            return this.confidentialityKey;
        }

        public SecretKey getIntegrityKey() {
            return this.integrityKey;
        }

        public int hashCode() {
            return ((this.confidentialityKey.hashCode() + 31) * 31) + this.integrityKey.hashCode();
        }

        public void setConfidentialityKey(SecretKey secretKey) {
            this.confidentialityKey = secretKey;
        }

        public void setIntegrityKey(SecretKey secretKey) {
            this.integrityKey = secretKey;
        }

        public String toString() {
            return Base64.encodeToString(getConfidentialityKey().getEncoded(), 2) + ":" + Base64.encodeToString(getIntegrityKey().getEncoded(), 2);
        }
    }

    public static boolean constantTimeEq(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0;
    }

    private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }

    public static byte[] decrypt(CipherTextIvMac cipherTextIvMac, SecretKeys secretKeys) throws GeneralSecurityException {
        if (!constantTimeEq(generateMac(CipherTextIvMac.ivCipherConcat(cipherTextIvMac.getIv(), cipherTextIvMac.getCipherText()), secretKeys.getIntegrityKey()), cipherTextIvMac.getMac())) {
            throw new GeneralSecurityException("MAC stored in civ does not match computed MAC.");
        }
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(2, secretKeys.getConfidentialityKey(), new IvParameterSpec(cipherTextIvMac.getIv()));
        return cipher.doFinal(cipherTextIvMac.getCipherText());
    }

    public static String decryptString(CipherTextIvMac cipherTextIvMac, SecretKeys secretKeys) throws GeneralSecurityException, UnsupportedEncodingException {
        return decryptString(cipherTextIvMac, secretKeys, "UTF-8");
    }

    public static CipherTextIvMac encrypt(String str, SecretKeys secretKeys) throws GeneralSecurityException, UnsupportedEncodingException {
        return encrypt(str, secretKeys, "UTF-8");
    }

    private static void fixPrng() {
        AtomicBoolean atomicBoolean = prngFixed;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (PrngFixes.class) {
            if (!atomicBoolean.get()) {
                PrngFixes.m4250b();
                atomicBoolean.set(true);
            }
        }
    }

    public static byte[] generateIv() throws GeneralSecurityException {
        return randomBytes(16);
    }

    public static SecretKeys generateKey() throws GeneralSecurityException {
        fixPrng();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return new SecretKeys(keyGenerator.generateKey(), new SecretKeySpec(randomBytes(32), "HmacSHA256"));
    }

    public static SecretKeys generateKeyFromPassword(String str, String str2, int i) throws GeneralSecurityException {
        return generateKeyFromPassword(str, Base64.decode(str2, 2), i);
    }

    public static byte[] generateMac(byte[] bArr, SecretKey secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        return mac.doFinal(bArr);
    }

    public static byte[] generateSalt() throws GeneralSecurityException {
        return randomBytes(128);
    }

    public static String keyString(SecretKeys secretKeys) {
        return secretKeys.toString();
    }

    public static SecretKeys keys(String str) throws InvalidKeyException {
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Cannot parse aesKey:hmacKey");
        }
        byte[] bArrDecode = Base64.decode(strArrSplit[0], 2);
        if (bArrDecode.length != 16) {
            throw new InvalidKeyException("Base64 decoded key is not 128 bytes");
        }
        byte[] bArrDecode2 = Base64.decode(strArrSplit[1], 2);
        if (bArrDecode2.length == 32) {
            return new SecretKeys(new SecretKeySpec(bArrDecode, 0, bArrDecode.length, "AES"), new SecretKeySpec(bArrDecode2, "HmacSHA256"));
        }
        throw new InvalidKeyException("Base64 decoded key is not 256 bytes");
    }

    private static byte[] randomBytes(int i) throws GeneralSecurityException {
        fixPrng();
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static String saltString(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static String decryptString(CipherTextIvMac cipherTextIvMac, SecretKeys secretKeys, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        return new String(decrypt(cipherTextIvMac, secretKeys), str);
    }

    public static CipherTextIvMac encrypt(String str, SecretKeys secretKeys, String str2) throws GeneralSecurityException, UnsupportedEncodingException {
        return encrypt(str.getBytes(str2), secretKeys);
    }

    public static SecretKeys generateKeyFromPassword(String str, byte[] bArr, int i) throws GeneralSecurityException {
        fixPrng();
        byte[] encoded = SecretKeyFactory.getInstance(PBE_ALGORITHM).generateSecret(new PBEKeySpec(str.toCharArray(), bArr, i, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT)).getEncoded();
        return new SecretKeys(new SecretKeySpec(copyOfRange(encoded, 0, 16), "AES"), new SecretKeySpec(copyOfRange(encoded, 16, 48), "HmacSHA256"));
    }

    public static CipherTextIvMac encrypt(byte[] bArr, SecretKeys secretKeys) throws GeneralSecurityException {
        byte[] bArrGenerateIv = generateIv();
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(1, secretKeys.getConfidentialityKey(), new IvParameterSpec(bArrGenerateIv));
        byte[] iv = cipher.getIV();
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        return new CipherTextIvMac(bArrDoFinal, iv, generateMac(CipherTextIvMac.ivCipherConcat(iv, bArrDoFinal), secretKeys.getIntegrityKey()));
    }
}
