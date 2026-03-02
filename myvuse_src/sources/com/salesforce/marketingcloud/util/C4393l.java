package com.salesforce.marketingcloud.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;
import org.jose4j.lang.HashUtil;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.l */
/* JADX INFO: loaded from: classes6.dex */
public final class C4393l {

    /* JADX INFO: renamed from: d */
    private static final String f5820d = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /* JADX INFO: renamed from: e */
    private static final String f5821e = "^|^";

    /* JADX INFO: renamed from: f */
    private static final String f5822f = "\\^\\|\\^";

    /* JADX INFO: renamed from: i */
    private static Boolean f5825i;

    /* JADX INFO: renamed from: a */
    public static final Locale f5817a = Locale.US;

    /* JADX INFO: renamed from: b */
    public static final Charset f5818b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c */
    static final String f5819c = C4170g.m3197a("Utils");

    /* JADX INFO: renamed from: g */
    private static final char[] f5823g = BinTools.hex.toCharArray();

    /* JADX INFO: renamed from: h */
    private static final TimeZone f5824h = TimeZone.getTimeZone("UTC");

    private C4393l() {
    }

    /* JADX INFO: renamed from: a */
    public static int m4333a(int i) {
        return Build.VERSION.SDK_INT >= 31 ? i | 67108864 : i;
    }

    /* JADX INFO: renamed from: b */
    public static int m4345b(int i) {
        return Build.VERSION.SDK_INT >= 31 ? i | 33554432 : i;
    }

    /* JADX INFO: renamed from: c */
    public static Map<String, String> m4348c(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split(f5822f);
            for (int i = 0; i < strArrSplit.length; i += 2) {
                int i2 = i + 1;
                map.put(strArrSplit[i], i2 < strArrSplit.length ? strArrSplit[i2] : "");
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4349c() {
        return true;
    }

    /* JADX INFO: renamed from: d */
    public static Set<String> m4351d(String str) {
        TreeSet treeSet = new TreeSet();
        if (str != null && !TextUtils.isEmpty(str)) {
            for (String str2 : str.split(f5822f)) {
                if (str2 != null && !str2.isEmpty()) {
                    treeSet.add(str2);
                }
            }
        }
        return treeSet;
    }

    /* JADX INFO: renamed from: e */
    public static String m4352e(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(f5818b);
            messageDigest.update(bytes, 0, bytes.length);
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Throwable th) {
            C4170g.m3207b(f5819c, th, "md5 failed", new Object[0]);
            return "";
        }
    }

    /* JADX INFO: renamed from: f */
    public static Date m4353f(String str) throws ParseException {
        if (str == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f5820d, f5817a);
        simpleDateFormat.setTimeZone(f5824h);
        return simpleDateFormat.parse(str);
    }

    /* JADX INFO: renamed from: g */
    public static String m4354g(String str) {
        try {
            StringBuilder sb = new StringBuilder(new BigInteger(1, MessageDigest.getInstance(HashUtil.SHA_256).digest(str.getBytes(f5818b))).toString(16));
            while (sb.length() < 64) {
                sb.insert(0, '0');
            }
            return sb.toString();
        } catch (Throwable th) {
            C4170g.m3207b(f5819c, th, "sha-256 failed", new Object[0]);
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m4340a(StringBuilder sb, String str, String str2) {
        sb.append(str).append(f5821e).append(str2).append(f5821e);
    }

    /* JADX INFO: renamed from: b */
    public static String m4346b(String str) {
        return m4335a(str, HashUtil.SHA_256, "UTF-8");
    }

    /* JADX INFO: renamed from: a */
    private static String m4339a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = f5823g;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.f3756SI];
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: b */
    public static int m4344b() {
        return TimeZone.getDefault().getOffset(new Date().getTime()) / 1000;
    }

    /* JADX INFO: renamed from: c */
    private static boolean m4350c(Context context) {
        try {
            Class<?> cls = Class.forName(context.getApplicationContext().getClass().getName().replace("." + context.getApplicationContext().getClass().getSimpleName(), "") + ".BuildConfig");
            Field field = cls.getField("DEBUG");
            field.setAccessible(true);
            boolean z = field.getBoolean(null);
            C4170g.m3210c(f5819c, "isDebugBuild set to %s for clazz %s", Boolean.valueOf(z), cls.getCanonicalName());
            return z;
        } catch (Exception e) {
            boolean zM4347b = m4347b(context);
            C4170g.m3202a(f5819c, "isDebugBuild determination failed with Exception [%s].  isDebugBuild set to: %s", e.getMessage(), Boolean.valueOf(zM4347b));
            return zM4347b;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4341a() {
        return MarketingCloudSdk.isReady() || MarketingCloudSdk.isInitializing();
    }

    /* JADX INFO: renamed from: b */
    private static boolean m4347b(Context context) {
        try {
        } catch (PackageManager.NameNotFoundException unused) {
            C4170g.m3216e(f5819c, "Failed to determine if app was in debug mode.", new Object[0]);
        }
        return (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.flags & 2) != 0;
    }

    /* JADX INFO: renamed from: a */
    static String m4334a(String str) {
        return m4335a(str, HashUtil.SHA_256, "UTF-8");
    }

    /* JADX INFO: renamed from: a */
    private static String m4335a(String str, String str2, String str3) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            byte[] bytes = str.getBytes(str3);
            messageDigest.update(bytes, 0, bytes.length);
            return m4339a(messageDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m4336a(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f5820d, f5817a);
        simpleDateFormat.setTimeZone(f5824h);
        return simpleDateFormat.format(date);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4343a(Context context) {
        if (f5825i == null) {
            f5825i = Boolean.valueOf(m4350c(context));
        }
        return f5825i.booleanValue();
    }

    /* JADX INFO: renamed from: a */
    public static String m4337a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return "";
        }
        HashMap map2 = new HashMap(map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map2.entrySet()) {
            m4340a(sb, (String) entry.getKey(), (String) entry.getValue());
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized String m4338a(Set<String> set) {
        if (set == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it2 = set.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            sb.append(f5821e);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4342a(long j, long j2) {
        if (j > 0) {
            long jMin = Math.min(j2, j);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jCurrentTimeMillis2 = jCurrentTimeMillis;
            boolean z = false;
            while (true) {
                long j3 = jCurrentTimeMillis + j;
                if (j3 <= jCurrentTimeMillis2 || z || m4341a()) {
                    break;
                }
                long j4 = jCurrentTimeMillis2 + jMin > j3 ? j3 - jCurrentTimeMillis2 : jMin;
                try {
                    C4170g.m3213d(f5819c, "Marketing Cloud SDK is not yet initializing.  Trying again in %sms. %s", Long.valueOf(j4), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis));
                    Thread.sleep(j4);
                } catch (Exception e) {
                    C4170g.m3207b(f5819c, e, "Encountered exception while waiting for SDK initialization to be triggered by the application.", new Object[0]);
                    z = true;
                }
                jCurrentTimeMillis2 = System.currentTimeMillis();
            }
        }
        return m4341a();
    }
}
