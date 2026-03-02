package com.onetrust.otpublishers.headless.Internal.Log;

import android.os.Build;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: loaded from: classes6.dex */
public class OTLogger {

    /* JADX INFO: renamed from: a */
    public static int f4050a = 4;

    /* JADX INFO: renamed from: b */
    public static String f4051b;

    /* JADX INFO: renamed from: c */
    public static File f4052c;

    /* JADX INFO: renamed from: d */
    public static BufferedWriter f4053d;

    /* JADX INFO: renamed from: e */
    public static int f4054e;

    /* JADX INFO: renamed from: f */
    public static int f4055f;

    /* JADX INFO: renamed from: g */
    public static boolean f4056g;

    /* JADX INFO: renamed from: h */
    public static boolean f4057h;

    /* JADX INFO: renamed from: a */
    public static int m2744a(String str, String str2) {
        if (!C0048h.m305b(str2)) {
            m2743a(4, "OTLogger", "device : " + str + " - " + str2);
        }
        m2746a(4, str, str2, null);
        return LogInstrumentation.m2732v(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static void m2746a(int i, String str, String str2, Throwable th) {
        if (i >= f4054e && f4053d != null) {
            try {
                if (m2747a()) {
                    f4053d = new BufferedWriter(new FileWriter(f4052c, true));
                }
                f4053d.write(m2745a(i == 2 ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : i == 3 ? "D" : i == 4 ? "I" : i == 5 ? ExifInterface.LONGITUDE_WEST : i == 6 ? ExifInterface.LONGITUDE_EAST : i == 7 ? ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : "", str, str2));
                f4053d.newLine();
                f4053d.flush();
            } catch (IOException e) {
                LogInstrumentation.m2728e("OTLogger", "Error : " + e.getMessage());
            }
        }
        if (f4053d == null) {
            LogInstrumentation.m2728e("OTLogger", "You have to call OTLogger.open(...) before starting to log");
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2747a() {
        try {
            if (f4052c.length() > f4055f) {
                File file = new File(f4051b + ".old");
                if (file.exists()) {
                    LogInstrumentation.m2732v("OTLogger", "file deleted : " + file.delete());
                }
                LogInstrumentation.m2732v("OTLogger", "file renamed : " + f4052c.renameTo(file));
                File file2 = new File(f4051b);
                f4052c = file2;
                LogInstrumentation.m2732v("OTLogger", "file created  : " + file2.createNewFile());
                return true;
            }
        } catch (IOException e) {
            LogInstrumentation.m2728e("OTLogger", "Error : " + e.getMessage());
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static int m2748b(String str, String str2) {
        return m2743a(6, str, str2);
    }

    /* JADX INFO: renamed from: c */
    public static int m2749c(String str, String str2) {
        return m2743a(4, str, str2);
    }

    public static void open(String str, int i, int i2) {
        f4051b = str;
        f4054e = i;
        f4055f = i2;
        File file = new File(f4051b);
        f4052c = file;
        if (!file.exists()) {
            try {
                LogInstrumentation.m2732v("OTLogger", "file deleted in open method : " + f4052c.createNewFile());
                f4053d = new BufferedWriter(new FileWriter(f4052c, true));
                m2744a("***********************************", "DEVICE LOGS -***********************************");
                m2744a("MODEL", Build.MODEL);
                m2744a("Manufacture", Build.MANUFACTURER);
                m2744a("SDK", Build.VERSION.SDK);
                m2744a("BRAND", Build.BRAND);
                m2744a("Version Code", Build.VERSION.RELEASE);
                m2744a("***********************************", "SDK LOGS -***********************************");
            } catch (IOException e) {
                LogInstrumentation.m2728e("OTLogger", "Error : " + e.getMessage());
            }
        }
        m2747a();
        try {
            f4053d = new BufferedWriter(new FileWriter(f4052c, true));
        } catch (IOException e2) {
            LogInstrumentation.m2728e("OTLogger", Log.getStackTraceString(e2));
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m2745a(String str, String str2, String str3) {
        String str4;
        try {
            str4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        } catch (Exception e) {
            LogInstrumentation.m2728e("OTLogger", "Error : " + e.getMessage());
            str4 = null;
        }
        return String.format("%s: /%s %s - %s", str4, str, str2, str3);
    }

    /* JADX INFO: renamed from: a */
    public static int m2743a(int i, String str, String str2) {
        int i2 = f4050a;
        int iM2732v = -1;
        if (i2 != -1 && i2 <= i) {
            switch (i) {
                case 2:
                    iM2732v = LogInstrumentation.m2732v(str, str2);
                    break;
                case 3:
                    iM2732v = LogInstrumentation.m2726d(str, str2);
                    break;
                case 4:
                    iM2732v = LogInstrumentation.m2730i(str, str2);
                    break;
                case 5:
                    iM2732v = LogInstrumentation.m2734w(str, str2);
                    break;
                case 6:
                    iM2732v = LogInstrumentation.m2728e(str, str2);
                    break;
                case 7:
                    iM2732v = Log.wtf(str, str2);
                    break;
            }
        }
        if ((f4057h && f4056g) || (f4056g && i > 3)) {
            m2746a(i, str, str2, null);
        }
        return iM2732v;
    }
}
