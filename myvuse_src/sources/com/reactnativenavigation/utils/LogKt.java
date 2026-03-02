package com.reactnativenavigation.utils;

import androidx.core.app.NotificationCompat;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: Log.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m5598d2 = {"MAIN_LIB_TAG", "", "logd", "", NotificationCompat.CATEGORY_MESSAGE, HeaderParameterNames.AUTHENTICATION_TAG, "wran", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class LogKt {
    public static final String MAIN_LIB_TAG = "RNN";

    public static final void logd(String str, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public static /* synthetic */ void logd$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = MAIN_LIB_TAG;
        }
        logd(str, str2);
    }

    public static /* synthetic */ void wran$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = MAIN_LIB_TAG;
        }
        wran(str, str2);
    }

    public static final void wran(String str, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (str != null) {
            LogInstrumentation.m2734w(tag, str);
        } else {
            LogInstrumentation.m2734w(tag, "Cannot log null msg: " + str);
        }
    }
}
