package com.facebook.common.logging;

/* JADX INFO: loaded from: classes3.dex */
public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate == null) {
            throw new IllegalArgumentException();
        }
        sHandler = loggingDelegate;
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    /* JADX INFO: renamed from: v */
    public static void m1305v(String str, String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(str, str2);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1306v(String str, String str2, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(str, formatString(str2, obj));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1307v(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(str, formatString(str2, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1308v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1309v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1297v(Class<?> cls, String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(getTag(cls), str);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1298v(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(getTag(cls), formatString(str, obj));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1299v(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1300v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            m1297v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1301v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1311v(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(str, formatString(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1312v(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1328v(str, formatString(str2, objArr), th);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1303v(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1327v(getTag(cls), formatString(str, objArr));
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1304v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1328v(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1310v(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1328v(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m1302v(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1328v(getTag(cls), str, th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1265d(String str, String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(str, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1266d(String str, String str2, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(str, formatString(str2, obj));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1267d(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(str, formatString(str2, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1268d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1269d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1257d(Class<?> cls, String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(getTag(cls), str);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1258d(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(getTag(cls), formatString(str, obj));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1259d(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1260d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1261d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1271d(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m1265d(str, formatString(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1272d(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m1270d(str, formatString(str2, objArr), th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1263d(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1321d(getTag(cls), formatString(str, objArr));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1264d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1322d(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1270d(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1322d(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1262d(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1322d(getTag(cls), str, th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1289i(String str, String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(str, str2);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1290i(String str, String str2, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(str, formatString(str2, obj));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1291i(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(str, formatString(str2, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1292i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1293i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1281i(Class<?> cls, String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(getTag(cls), str);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1282i(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(getTag(cls), formatString(str, obj));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1283i(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1284i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1285i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1295i(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(str, formatString(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1296i(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1326i(str, formatString(str2, objArr), th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1287i(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1325i(getTag(cls), formatString(str, objArr));
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1288i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            sHandler.mo1326i(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1294i(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1326i(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m1286i(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1326i(getTag(cls), str, th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1317w(String str, String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1329w(str, str2);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1313w(Class<?> cls, String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1329w(getTag(cls), str);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1319w(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1329w(str, formatString(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1320w(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1330w(str, formatString(str2, objArr), th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1315w(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1329w(getTag(cls), formatString(str, objArr));
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1316w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            m1314w(cls, formatString(str, objArr), th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1318w(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1330w(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m1314w(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1330w(getTag(cls), str, th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1277e(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1323e(str, str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1273e(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1323e(getTag(cls), str);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1279e(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1323e(str, formatString(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1280e(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1324e(str, formatString(str2, objArr), th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1275e(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1323e(getTag(cls), formatString(str, objArr));
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1276e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1324e(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1278e(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1324e(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1274e(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1324e(getTag(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String getTag(Class<?> cls) {
        return cls.getSimpleName();
    }
}
