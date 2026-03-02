package io.branch.referral;

import com.facebook.common.callercontext.ContextChain;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: BranchLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, m5598d2 = {"Lio/branch/referral/BranchLogger;", "", "()V", "TAG", "", "loggingEnabled", "", "getLoggingEnabled$annotations", "getLoggingEnabled", "()Z", "setLoggingEnabled", "(Z)V", "d", "", "message", RsaJsonWebKey.EXPONENT_MEMBER_NAME, ContextChain.TAG_INFRA, "logAlways", "logException", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, "Ljava/lang/Exception;", "Lkotlin/Exception;", "v", "w", "Branch-SDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BranchLogger {
    public static final BranchLogger INSTANCE = new BranchLogger();
    private static final String TAG = "BranchSDK";
    private static boolean loggingEnabled;

    @JvmStatic
    public static /* synthetic */ void getLoggingEnabled$annotations() {
    }

    private BranchLogger() {
    }

    public static final boolean getLoggingEnabled() {
        return loggingEnabled;
    }

    public static final void setLoggingEnabled(boolean z) {
        loggingEnabled = z;
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m5576e(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!loggingEnabled || message.length() <= 0) {
            return;
        }
        LogInstrumentation.m2728e(TAG, message);
    }

    @JvmStatic
    /* JADX INFO: renamed from: w */
    public static final void m5579w(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!loggingEnabled || message.length() <= 0) {
            return;
        }
        LogInstrumentation.m2734w(TAG, message);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m5577i(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!loggingEnabled || message.length() <= 0) {
            return;
        }
        LogInstrumentation.m2730i(TAG, message);
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m5575d(String message) {
        if (!loggingEnabled || message == null || message.length() <= 0) {
            return;
        }
        LogInstrumentation.m2726d(TAG, message);
    }

    @JvmStatic
    /* JADX INFO: renamed from: v */
    public static final void m5578v(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!loggingEnabled || message.length() <= 0) {
            return;
        }
        LogInstrumentation.m2732v(TAG, message);
    }

    @JvmStatic
    public static final void logAlways(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.length() > 0) {
            LogInstrumentation.m2730i(TAG, message);
        }
    }

    @JvmStatic
    public static final void logException(String message, Exception t) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.length() > 0) {
            LogInstrumentation.m2729e(TAG, message, t);
        }
    }
}
