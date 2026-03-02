package com.google.mlkit.common.internal.model;

import android.content.Context;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzaa;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jose4j.lang.HashUtil;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class ModelUtils {
    private static final GmsLogger zza = new GmsLogger("ModelUtils", "");

    /* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
    public static abstract class AutoMLManifest {
        public abstract String getLabelsFile();

        public abstract String getModelFile();

        public abstract String getModelType();
    }

    /* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
    public static abstract class ModelLoggingInfo {
        static ModelLoggingInfo zza(long j, String str, boolean z) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j, zzaa.zza(str), z);
        }

        public abstract String getHash();

        public abstract long getSize();

        public abstract boolean isManifestModel();
    }

    private ModelUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo getModelLoggingInfo(android.content.Context r11, com.google.mlkit.common.model.LocalModel r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.getModelLoggingInfo(android.content.Context, com.google.mlkit.common.model.LocalModel):com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo");
    }

    public static String getSHA256(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String strZzc = zzc(fileInputStream);
                fileInputStream.close();
                return strZzc;
            } finally {
            }
        } catch (IOException e) {
            GmsLogger gmsLogger = zza;
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 44);
            sb.append("Failed to create FileInputStream for model: ");
            sb.append(strValueOf);
            gmsLogger.m2359e("ModelUtils", sb.toString());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (new java.io.File(r5).exists() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest parseManifestFile(java.lang.String r5, boolean r6, android.content.Context r7) {
        /*
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r2 = r1.length()
            java.lang.String r3 = "Manifest file path: "
            if (r2 == 0) goto L13
            java.lang.String r1 = r3.concat(r1)
            goto L18
        L13:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L18:
            java.lang.String r2 = "ModelUtils"
            r0.m2357d(r2, r1)
            r1 = 0
            if (r6 == 0) goto L2e
            android.content.res.AssetManager r3 = r7.getAssets()     // Catch: java.io.IOException -> L39
            java.io.InputStream r3 = r3.open(r5)     // Catch: java.io.IOException -> L39
            if (r3 == 0) goto L41
            r3.close()     // Catch: java.io.IOException -> L39
            goto L41
        L2e:
            java.io.File r3 = new java.io.File
            r3.<init>(r5)
            boolean r3 = r3.exists()
            if (r3 != 0) goto L41
        L39:
            com.google.android.gms.common.internal.GmsLogger r5 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r6 = "Manifest file does not exist."
            r5.m2359e(r2, r6)
            return r1
        L41:
            boolean r3 = r5.isEmpty()     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            r4 = 0
            if (r3 == 0) goto L4b
            byte[] r5 = new byte[r4]     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            goto L70
        L4b:
            if (r6 == 0) goto L56
            android.content.res.AssetManager r6 = r7.getAssets()     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            java.io.InputStream r5 = r6.open(r5)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            goto L61
        L56:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            java.io.File r7 = new java.io.File     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            r7.<init>(r5)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            r6.<init>(r7)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            r5 = r6
        L61:
            int r6 = r5.available()     // Catch: java.lang.Throwable -> Laa
            byte[] r7 = new byte[r6]     // Catch: java.lang.Throwable -> Laa
            r5.read(r7, r4, r6)     // Catch: java.lang.Throwable -> Laa
            if (r5 == 0) goto L6f
            r5.close()     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
        L6f:
            r5 = r7
        L70:
            java.lang.String r6 = new java.lang.String     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            java.lang.String r7 = "UTF-8"
            r6.<init>(r5, r7)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            java.lang.String r5 = "Json string from the manifest file: "
            int r7 = r6.length()     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            if (r7 == 0) goto L84
            java.lang.String r5 = r5.concat(r6)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            goto L8a
        L84:
            java.lang.String r7 = new java.lang.String     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            r7.<init>(r5)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            r5 = r7
        L8a:
            r0.m2357d(r2, r5)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            r5.<init>(r6)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            java.lang.String r6 = "modelType"
            java.lang.String r6 = r5.getString(r6)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            java.lang.String r7 = "modelFile"
            java.lang.String r7 = r5.getString(r7)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            java.lang.String r0 = "labelsFile"
            java.lang.String r5 = r5.getString(r0)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest r0 = new com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            r0.<init>(r6, r7, r5)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
            return r0
        Laa:
            r6 = move-exception
            if (r5 == 0) goto Lb5
            r5.close()     // Catch: java.lang.Throwable -> Lb1
            goto Lb5
        Lb1:
            r5 = move-exception
            com.google.android.gms.internal.mlkit_common.zzaw.zza(r6, r5)     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
        Lb5:
            throw r6     // Catch: java.io.IOException -> Lb6 org.json.JSONException -> Lb8
        Lb6:
            r5 = move-exception
            goto Lb9
        Lb8:
            r5 = move-exception
        Lb9:
            com.google.android.gms.common.internal.GmsLogger r6 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r7 = "Error parsing the manifest file."
            r6.m2360e(r2, r7, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.parseManifestFile(java.lang.String, boolean, android.content.Context):com.google.mlkit.common.internal.model.ModelUtils$AutoMLManifest");
    }

    public static boolean zza(File file, String str) {
        String sha256 = getSHA256(file);
        GmsLogger gmsLogger = zza;
        String strValueOf = String.valueOf(sha256);
        gmsLogger.m2357d("ModelUtils", strValueOf.length() != 0 ? "Calculated hash value is: ".concat(strValueOf) : new String("Calculated hash value is: "));
        return str.equals(sha256);
    }

    private static String zzb(String str, boolean z, Context context) {
        AutoMLManifest manifestFile = parseManifestFile(str, z, context);
        if (manifestFile != null) {
            return new File(new File(str).getParent(), manifestFile.getModelFile()).toString();
        }
        zza.m2359e("ModelUtils", "Failed to parse manifest file.");
        return null;
    }

    private static String zzc(InputStream inputStream) {
        int i;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(HashUtil.SHA_256);
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            zza.m2359e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            zza.m2359e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }
}
