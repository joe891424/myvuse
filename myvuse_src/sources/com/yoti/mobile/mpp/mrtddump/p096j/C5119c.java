package com.yoti.mobile.mpp.mrtddump.p096j;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.PrintStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.j.c */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0001\u001a$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0001\u001a*\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\u001a$\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\u001a$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\u001a$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"isRunningInJvm", "", "logDebug", "", HeaderParameterNames.AUTHENTICATION_TAG, "", "message", "logError", "error", "", "logForJvm", "printStream", "Ljava/io/PrintStream;", "logIntoJvmErrorOutput", "logIntoJvmNormalOutput", "logWarning", "mrtddump_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C5119c {

    /* JADX INFO: renamed from: a */
    private static final boolean f8136a;

    static {
        boolean zContainsMatchIn;
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            zContainsMatchIn = false;
        } else {
            String lowerCase = property.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            zContainsMatchIn = new Regex("jdk|java.* se").containsMatchIn(lowerCase);
        }
        f8136a = zContainsMatchIn;
    }

    /* JADX INFO: renamed from: a */
    private static final void m5530a(PrintStream printStream, String str, String str2, Throwable th) {
        printStream.println(str + '\t' + str2);
        if (th == null) {
            return;
        }
        th.printStackTrace();
    }

    /* JADX INFO: renamed from: a */
    public static final void m5531a(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (f8136a) {
            m5535b(tag, message, null, 4, null);
        } else {
            LogInstrumentation.m2726d(tag, message);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m5532a(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (f8136a) {
            m5534b(tag, message, th);
        } else {
            LogInstrumentation.m2729e(tag, message, th);
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m5533a(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        m5532a(str, str2, th);
    }

    /* JADX INFO: renamed from: b */
    private static final void m5534b(String str, String str2, Throwable th) {
        PrintStream err = System.err;
        Intrinsics.checkNotNullExpressionValue(err, "err");
        m5530a(err, str, str2, th);
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m5535b(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        m5536c(str, str2, th);
    }

    /* JADX INFO: renamed from: c */
    private static final void m5536c(String str, String str2, Throwable th) {
        PrintStream out = System.out;
        Intrinsics.checkNotNullExpressionValue(out, "out");
        m5530a(out, str, str2, th);
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ void m5537c(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        m5538d(str, str2, th);
    }

    /* JADX INFO: renamed from: d */
    public static final void m5538d(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (f8136a) {
            m5534b(tag, message, th);
        } else {
            LogInstrumentation.m2735w(tag, message, th);
        }
    }
}
