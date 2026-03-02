package com.yoti.mobile.android.commons.util;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.PrintStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: renamed from: com.yoti.mobile.android.commons.util.L */
/* JADX INFO: compiled from: Log.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\n\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\n\u0010\t\u001a+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\t\u001a+\u0010\f\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\t\u001a1\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\u000f\"\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011¨\u0006\u0013"}, m5598d2 = {"", HeaderParameterNames.AUTHENTICATION_TAG, "message", "", "logDebug", "(Ljava/lang/String;Ljava/lang/String;)V", "", "error", "logWarning", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "logError", "b", "a", "Ljava/io/PrintStream;", "printStream", "(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "", "Z", "isRunningInJvm", "commons-utils_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class C4588L {

    /* JADX INFO: renamed from: a */
    private static final boolean f6598a;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    static {
        /*
            java.lang.String r0 = "java.runtime.name"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L29
            if (r0 == 0) goto L21
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            if (r0 == 0) goto L29
            kotlin.text.Regex r1 = new kotlin.text.Regex
            java.lang.String r2 = "jdk|java.* se"
            r1.<init>(r2)
            boolean r0 = r1.containsMatchIn(r0)
            goto L2a
        L21:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        L29:
            r0 = 0
        L2a:
            com.yoti.mobile.android.commons.util.C4588L.f6598a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.commons.util.C4588L.<clinit>():void");
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m4700a(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        m4701b(str, str2, th);
    }

    /* JADX INFO: renamed from: b */
    private static final void m4701b(String str, String str2, Throwable th) {
        PrintStream printStream = System.out;
        Intrinsics.checkNotNullExpressionValue(printStream, "System.out");
        m4698a(printStream, str, str2, th);
    }

    public static final void logDebug(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (f6598a) {
            m4700a(tag, message, null, 4, null);
        } else if (Debug.isDebugBuild) {
            LogInstrumentation.m2726d(tag, message);
        }
    }

    public static final void logError(String str, String str2) {
        logError$default(str, str2, null, 4, null);
    }

    public static final void logError(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (f6598a) {
            m4699a(tag, message, th);
        } else if (Debug.isDebugBuild) {
            LogInstrumentation.m2729e(tag, message, th);
        }
    }

    public static /* synthetic */ void logError$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logError(str, str2, th);
    }

    public static final void logWarning(String str, String str2) {
        logWarning$default(str, str2, null, 4, null);
    }

    public static final void logWarning(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (f6598a) {
            m4699a(tag, message, th);
        } else if (Debug.isDebugBuild) {
            LogInstrumentation.m2735w(tag, message, th);
        }
    }

    public static /* synthetic */ void logWarning$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logWarning(str, str2, th);
    }

    /* JADX INFO: renamed from: a */
    private static final void m4699a(String str, String str2, Throwable th) {
        PrintStream printStream = System.err;
        Intrinsics.checkNotNullExpressionValue(printStream, "System.err");
        m4698a(printStream, str, str2, th);
    }

    /* JADX INFO: renamed from: a */
    private static final void m4698a(PrintStream printStream, String str, String str2, Throwable th) {
        printStream.println(str + '\t' + str2);
        if (th != null) {
            th.printStackTrace();
        }
    }
}
