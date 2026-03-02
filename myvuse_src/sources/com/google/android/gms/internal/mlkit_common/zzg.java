package com.google.android.gms.internal.mlkit_common;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzg {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    private static final String[] zzc;

    static {
        String[] strArr = new String[4];
        strArr[0] = "media";
        strArr[1] = "";
        strArr[2] = "";
        strArr[3] = (Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("ranchu")) ? "com.google.android.apps.common.testing.services.storage.runfiles" : "";
        zzc = strArr;
    }

    public static AssetFileDescriptor zza(Context context, Uri uri, String str) throws FileNotFoundException {
        zzf zzfVar = zzf.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri2 = Uri.parse(uri.toString());
        String scheme = uri2.getScheme();
        if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
            return contentResolver.openAssetFileDescriptor(uri2, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
        }
        if ("content".equals(scheme)) {
            if (!zzc(context, uri2, 1, zzfVar)) {
                throw new FileNotFoundException("Can't open content uri.");
            }
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri2, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
            zzi(assetFileDescriptorOpenAssetFileDescriptor);
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        if (!"file".equals(scheme)) {
            throw new FileNotFoundException("Not implemented. Contact tiktok-users@");
        }
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(uri2, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
        zzi(assetFileDescriptorOpenAssetFileDescriptor2);
        try {
            zzd(context, assetFileDescriptorOpenAssetFileDescriptor2.getParcelFileDescriptor(), uri2, zzfVar);
            return assetFileDescriptorOpenAssetFileDescriptor2;
        } catch (FileNotFoundException e) {
            zzf(assetFileDescriptorOpenAssetFileDescriptor2, e);
            throw e;
        } catch (IOException e2) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
            fileNotFoundException.initCause(e2);
            zzf(assetFileDescriptorOpenAssetFileDescriptor2, fileNotFoundException);
            throw fileNotFoundException;
        }
    }

    public static InputStream zzb(Context context, Uri uri) throws FileNotFoundException {
        zzf zzfVar = zzf.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri2 = Uri.parse(uri.toString());
        String scheme = uri2.getScheme();
        if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
            return contentResolver.openInputStream(uri2);
        }
        if ("content".equals(scheme)) {
            if (!zzc(context, uri2, 1, zzfVar)) {
                throw new FileNotFoundException("Can't open content uri.");
            }
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri2);
            zzi(inputStreamOpenInputStream);
            return inputStreamOpenInputStream;
        }
        if (!"file".equals(scheme)) {
            throw new FileNotFoundException("Not implemented. Contact tiktok-users@");
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(Uri.fromFile(new File(uri2.getPath()).getCanonicalFile()), RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
            try {
                zzd(context, parcelFileDescriptorOpenFileDescriptor, uri2, zzfVar);
                return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorOpenFileDescriptor);
            } catch (FileNotFoundException e) {
                zzg(parcelFileDescriptorOpenFileDescriptor, e);
                throw e;
            } catch (IOException e2) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                fileNotFoundException.initCause(e2);
                zzg(parcelFileDescriptorOpenFileDescriptor, fileNotFoundException);
                throw fileNotFoundException;
            }
        } catch (IOException e3) {
            FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Canonicalization failed.");
            fileNotFoundException2.initCause(e3);
            throw fileNotFoundException2;
        }
    }

    private static boolean zzc(Context context, Uri uri, int i, zzf zzfVar) {
        String authority = uri.getAuthority();
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
        if (providerInfoResolveContentProvider == null) {
            int iLastIndexOf = authority.lastIndexOf(64);
            if (iLastIndexOf >= 0) {
                authority = authority.substring(iLastIndexOf + 1);
                providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            }
            if (providerInfoResolveContentProvider == null) {
                return !zzfVar.zzc;
            }
        }
        int iZzc = zzf.zzc(zzfVar, context, new zzo(uri, providerInfoResolveContentProvider, authority)) - 1;
        if (iZzc == 0) {
            return true;
        }
        if (iZzc == 1) {
            return false;
        }
        if (context.getPackageName().equals(providerInfoResolveContentProvider.packageName)) {
            return zzfVar.zzc;
        }
        if (zzfVar.zzc) {
            return false;
        }
        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), 1) == 0) {
            return true;
        }
        String[] strArr = zzc;
        int length = strArr.length;
        for (int i2 = 0; i2 < 4; i2++) {
            if (strArr[i2].equals(authority)) {
                return true;
            }
        }
        if (providerInfoResolveContentProvider.exported) {
            String[] strArr2 = zzb;
            int length2 = strArr2.length;
            for (int i3 = 0; i3 < 6; i3++) {
                String str = strArr2[i3];
                if (str.charAt(str.length() - 1) == '.') {
                    if (providerInfoResolveContentProvider.packageName.startsWith(str)) {
                        return false;
                    }
                } else if (providerInfoResolveContentProvider.packageName.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void zzd(final Context context, ParcelFileDescriptor parcelFileDescriptor, Uri uri, zzf zzfVar) throws IOException {
        File dataDir;
        String canonicalPath = new File(uri.getPath()).getCanonicalPath();
        zzn zznVarZza = zzn.zza(parcelFileDescriptor.getFileDescriptor());
        zzn zznVarZzb = zzn.zzb(canonicalPath);
        if (zznVarZzb.zzc) {
            String strValueOf = String.valueOf(canonicalPath);
            throw new FileNotFoundException(strValueOf.length() != 0 ? "Can't open file: ".concat(strValueOf) : new String("Can't open file: "));
        }
        if (zznVarZza.zza != zznVarZzb.zza || zznVarZza.zzb != zznVarZzb.zzb) {
            String strValueOf2 = String.valueOf(canonicalPath);
            throw new FileNotFoundException(strValueOf2.length() != 0 ? "Can't open file: ".concat(strValueOf2) : new String("Can't open file: "));
        }
        if (!canonicalPath.startsWith("/proc/") && !canonicalPath.startsWith("/data/misc/")) {
            zzf.zzb(zzfVar);
            File dataDir2 = ContextCompat.getDataDir(context);
            boolean z = true;
            if (dataDir2 == null ? !canonicalPath.startsWith(Environment.getDataDirectory().getCanonicalPath()) : !canonicalPath.startsWith(dataDir2.getCanonicalPath())) {
                Context contextCreateDeviceProtectedStorageContext = ContextCompat.createDeviceProtectedStorageContext(context);
                if (contextCreateDeviceProtectedStorageContext == null || (dataDir = ContextCompat.getDataDir(contextCreateDeviceProtectedStorageContext)) == null || !canonicalPath.startsWith(dataDir.getCanonicalPath())) {
                    File[] fileArrZze = zze(new Callable(context) { // from class: com.google.android.gms.internal.mlkit_common.zzb
                        private final Context zza;

                        {
                            this.zza = context;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Context context2 = this.zza;
                            int i = zzg.zza;
                            return ContextCompat.getExternalFilesDirs(context2, null);
                        }
                    });
                    int length = fileArrZze.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            File file = fileArrZze[i];
                            if (file != null && canonicalPath.startsWith(file.getCanonicalPath())) {
                                break;
                            } else {
                                i++;
                            }
                        } else {
                            File[] fileArrZze2 = zze(new Callable(context) { // from class: com.google.android.gms.internal.mlkit_common.zzc
                                private final Context zza;

                                {
                                    this.zza = context;
                                }

                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    Context context2 = this.zza;
                                    int i2 = zzg.zza;
                                    return ContextCompat.getExternalCacheDirs(context2);
                                }
                            });
                            int length2 = fileArrZze2.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 < length2) {
                                    File file2 = fileArrZze2[i2];
                                    if (file2 != null && canonicalPath.startsWith(file2.getCanonicalPath())) {
                                        break;
                                    } else {
                                        i2++;
                                    }
                                } else {
                                    z = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (z == zzfVar.zzc) {
                return;
            }
        }
        String strValueOf3 = String.valueOf(canonicalPath);
        throw new FileNotFoundException(strValueOf3.length() != 0 ? "Can't open file: ".concat(strValueOf3) : new String("Can't open file: "));
    }

    private static File[] zze(Callable<File[]> callable) {
        try {
            return callable.call();
        } catch (NullPointerException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void zzf(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            assetFileDescriptor.close();
        } catch (IOException e) {
            zzh(fileNotFoundException, e);
        }
    }

    private static void zzg(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            parcelFileDescriptor.close();
        } catch (IOException e) {
            zzh(fileNotFoundException, e);
        }
    }

    private static void zzh(Exception exc, Exception exc2) {
        zzaw.zza(exc, exc2);
    }

    private static <T> T zzi(T t) throws FileNotFoundException {
        if (t != null) {
            return t;
        }
        throw new FileNotFoundException("Content resolver returned null value.");
    }
}
