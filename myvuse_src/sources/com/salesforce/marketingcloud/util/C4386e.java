package com.salesforce.marketingcloud.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.salesforce.marketingcloud.C4170g;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.e */
/* JADX INFO: loaded from: classes6.dex */
public final class C4386e {

    /* JADX INFO: renamed from: a */
    private static final String f5755a = C4170g.m3197a("DeviceData");

    /* JADX INFO: renamed from: b */
    private static final String f5756b = "SFMCDeviceUUID";

    /* JADX INFO: renamed from: c */
    static volatile String f5757c;

    private C4386e() {
    }

    /* JADX INFO: renamed from: a */
    private static String m4264a() {
        return C4393l.m4334a(String.format(Locale.ENGLISH, "%s%d", UUID.randomUUID().toString(), Long.valueOf(System.currentTimeMillis())));
    }

    /* JADX INFO: renamed from: b */
    private static String m4269b(Context context, String str) throws Throwable {
        File file = new File(context.getNoBackupFilesDir(), f5756b);
        String strM4267a = file.exists() ? m4267a(file) : null;
        if (!TextUtils.isEmpty(strM4267a)) {
            return strM4267a;
        }
        String str2 = f5755a;
        C4170g.m3202a(str2, "Checking SharedPreferences for deviceId", new Object[0]);
        String strM4265a = m4265a(context);
        if (TextUtils.isEmpty(strM4265a)) {
            C4170g.m3202a(str2, "Checking pre-lollipop location for deviceId", new Object[0]);
            File file2 = new File(context.getFilesDir(), f5756b);
            if (file2.exists()) {
                strM4265a = m4267a(file2);
                C4388g.m4318b(file2);
            }
        }
        if (TextUtils.isEmpty(strM4265a)) {
            Object[] objArr = new Object[0];
            if (str != null) {
                C4170g.m3202a(str2, "Using registrationId as deviceId", objArr);
            } else {
                C4170g.m3202a(str2, "Generating/Storing new deviceId", objArr);
                str = m4264a();
            }
        } else {
            str = strM4265a;
        }
        m4268a(file, str);
        return str;
    }

    /* JADX INFO: renamed from: a */
    public static String m4266a(Context context, String str) {
        if (f5757c == null) {
            synchronized (C4386e.class) {
                f5757c = m4269b(context, str);
            }
        }
        return f5757c;
    }

    /* JADX INFO: renamed from: a */
    private static String m4267a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String line = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                line = new BufferedReader(new InputStreamReader(fileInputStream, C4393l.f5818b)).readLine();
            } catch (Exception unused) {
                try {
                    C4170g.m3206b(f5755a, "Failed to read device id from file: ", file.getAbsolutePath());
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    fileInputStream = fileInputStream2;
                    C4388g.m4312a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C4388g.m4312a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            C4388g.m4312a((Closeable) fileInputStream);
            throw th;
        }
        C4388g.m4312a((Closeable) fileInputStream);
        return line;
    }

    /* JADX INFO: renamed from: a */
    private static String m4265a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("_et_default_shared_preferences", 0);
        String string = sharedPreferences.getString("id", null);
        if (string != null) {
            sharedPreferences.edit().remove("id").apply();
        }
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX INFO: renamed from: a */
    private static void m4268a(File file, String str) throws Throwable {
        ?? fileOutputStream;
        ?? r1;
        ?? r0 = 0;
        ?? r02 = 0;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = r0;
            }
        } catch (Exception unused) {
        }
        try {
            Charset charset = C4393l.f5818b;
            fileOutputStream.write(str.getBytes(charset));
            r0 = charset;
            r1 = fileOutputStream;
        } catch (Exception unused2) {
            r02 = fileOutputStream;
            C4170g.m3206b(f5755a, "Failed to write device id to file: ", file.getAbsolutePath());
            r1 = r02;
            r0 = r02;
        } catch (Throwable th2) {
            th = th2;
            C4388g.m4312a((Closeable) fileOutputStream);
            throw th;
        }
        C4388g.m4312a((Closeable) r1);
    }
}
