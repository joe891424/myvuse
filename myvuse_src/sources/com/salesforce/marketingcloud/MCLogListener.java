package com.salesforce.marketingcloud;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bg\u0018\u0000 \f2\u00020\u0001:\u0003\u000b\f\rJ,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, m5598d2 = {"Lcom/salesforce/marketingcloud/MCLogListener;", "", "out", "", FirebaseAnalytics.Param.LEVEL, "", HeaderParameterNames.AUTHENTICATION_TAG, "", "message", "throwable", "", "AndroidLogListener", "Companion", "LogLevel", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public interface MCLogListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, m5598d2 = {"Lcom/salesforce/marketingcloud/MCLogListener$AndroidLogListener;", "Lcom/salesforce/marketingcloud/MCLogListener;", "()V", "out", "", FirebaseAnalytics.Param.LEVEL, "", HeaderParameterNames.AUTHENTICATION_TAG, "", "message", "throwable", "", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static class AndroidLogListener implements MCLogListener {
        @Override // com.salesforce.marketingcloud.MCLogListener
        public void out(int level, String tag, String message, Throwable throwable) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            if (level == 2) {
                if (throwable == null) {
                    LogInstrumentation.m2732v(tag, message);
                    return;
                } else {
                    LogInstrumentation.m2733v(tag, message, throwable);
                    return;
                }
            }
            if (level == 3) {
                if (throwable == null) {
                    LogInstrumentation.m2726d(tag, message);
                    return;
                } else {
                    LogInstrumentation.m2727d(tag, message, throwable);
                    return;
                }
            }
            if (level == 4) {
                if (throwable == null) {
                    LogInstrumentation.m2730i(tag, message);
                    return;
                } else {
                    LogInstrumentation.m2731i(tag, message, throwable);
                    return;
                }
            }
            if (level == 5) {
                if (throwable == null) {
                    LogInstrumentation.m2734w(tag, message);
                    return;
                } else {
                    LogInstrumentation.m2735w(tag, message, throwable);
                    return;
                }
            }
            if (level != 6) {
                return;
            }
            if (throwable == null) {
                LogInstrumentation.m2728e(tag, message);
            } else {
                LogInstrumentation.m2729e(tag, message, throwable);
            }
        }
    }

    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/salesforce/marketingcloud/MCLogListener$Companion;", "", "()V", "DEBUG", "", RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_ERROR, "INFO", "VERBOSE", "WARN", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DEBUG = 3;
        public static final int ERROR = 6;
        public static final int INFO = 4;
        public static final int VERBOSE = 2;
        public static final int WARN = 5;

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(m5597d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m5598d2 = {"Lcom/salesforce/marketingcloud/MCLogListener$LogLevel;", "", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public @interface LogLevel {
    }

    void out(@LogLevel int level, String tag, String message, Throwable throwable);
}
