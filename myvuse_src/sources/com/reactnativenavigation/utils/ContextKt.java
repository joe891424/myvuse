package com.reactnativenavigation.utils;

import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.ReactApplication;
import com.reactnativenavigation.NavigationApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Context.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0005"}, m5598d2 = {"isDarkMode", "", "Landroid/content/Context;", "Landroid/content/res/Configuration;", "isDebug", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ContextKt {
    public static final boolean isDebug(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
        return ((ReactApplication) applicationContext).getReactNativeHost().getUseDeveloperSupport();
    }

    public static final boolean isDarkMode() {
        NavigationApplication instance = NavigationApplication.instance;
        Intrinsics.checkNotNullExpressionValue(instance, "instance");
        return isDarkMode(instance);
    }

    public static final boolean isDarkMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final boolean isDarkMode(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        return (configuration.uiMode & 48) == 32;
    }
}
