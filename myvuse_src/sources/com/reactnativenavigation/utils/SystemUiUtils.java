package com.reactnativenavigation.utils;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.reactnativenavigation.react.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemUiUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u001a\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u001a\u0010\u0018\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J\"\u0010\u001d\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001aH\u0007J$\u0010 \u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001aH\u0007J\"\u0010\"\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001aH\u0007J\u0012\u0010$\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010%\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u001a\u0010&\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m5598d2 = {"Lcom/reactnativenavigation/utils/SystemUiUtils;", "", "()V", "STATUS_BAR_HEIGHT_L", "", "STATUS_BAR_HEIGHT_M", "STATUS_BAR_HEIGHT_TRANSLUCENCY", "", "<set-?>", "navigationBarDefaultColor", "getNavigationBarDefaultColor", "()I", Constants.STATUS_BAR_HEIGHT_KEY, "clearStatusBarTranslucency", "", "window", "Landroid/view/Window;", "getStatusBarHeight", "activity", "Landroid/app/Activity;", "getStatusBarHeightDp", "hideNavigationBar", "view", "Landroid/view/View;", "hideStatusBar", "isTranslucent", "", "saveStatusBarHeight", "height", "setNavigationBarBackgroundColor", "color", "lightColor", "setStatusBarColor", "translucent", "setStatusBarColorScheme", "isDark", "setStatusBarTranslucent", "showNavigationBar", "showStatusBar", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class SystemUiUtils {
    private static final int STATUS_BAR_HEIGHT_L = 25;
    private static final int STATUS_BAR_HEIGHT_M = 24;
    public static final float STATUS_BAR_HEIGHT_TRANSLUCENCY = 0.65f;
    public static final SystemUiUtils INSTANCE = new SystemUiUtils();
    private static int statusBarHeight = -1;
    private static int navigationBarDefaultColor = -1;

    private SystemUiUtils() {
    }

    public final int getNavigationBarDefaultColor() {
        return navigationBarDefaultColor;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int getStatusBarHeight(android.app.Activity r2) {
        /*
            int r0 = com.reactnativenavigation.utils.SystemUiUtils.statusBarHeight
            if (r0 <= 0) goto L5
            goto L45
        L5:
            if (r2 == 0) goto L40
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.view.Window r2 = r2.getWindow()
            java.lang.String r1 = "getWindow(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            android.view.View r1 = r2.getDecorView()
            r1.getWindowVisibleDisplayFrame(r0)
            int r0 = r0.top
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r2 = r2.findViewById(r1)
            if (r2 == 0) goto L38
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.getTop()
            int r2 = r2 - r0
            int r2 = java.lang.Math.abs(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L39
        L38:
            r2 = 0
        L39:
            if (r2 == 0) goto L40
            int r2 = r2.intValue()
            goto L42
        L40:
            r2 = 24
        L42:
            r0 = r2
            com.reactnativenavigation.utils.SystemUiUtils.statusBarHeight = r0
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativenavigation.utils.SystemUiUtils.getStatusBarHeight(android.app.Activity):int");
    }

    @JvmStatic
    public static final void saveStatusBarHeight(int height) {
        statusBarHeight = height;
    }

    @JvmStatic
    public static final int getStatusBarHeightDp(Activity activity) {
        return (int) UiUtils.pxToDp(activity, getStatusBarHeight(activity));
    }

    @JvmStatic
    public static final void hideNavigationBar(Window window, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (window != null) {
            WindowCompat.setDecorFitsSystemWindows(window, false);
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, view);
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.navigationBars());
            windowInsetsControllerCompat.setSystemBarsBehavior(2);
        }
    }

    @JvmStatic
    public static final void showNavigationBar(Window window, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (window != null) {
            WindowCompat.setDecorFitsSystemWindows(window, true);
            new WindowInsetsControllerCompat(window, view).show(WindowInsetsCompat.Type.navigationBars());
        }
    }

    @JvmStatic
    public static final void setStatusBarColorScheme(Window window, View view, boolean isDark) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (window != null) {
            new WindowInsetsControllerCompat(window, view).setAppearanceLightStatusBars(isDark);
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(isDark ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    @JvmStatic
    public static final void setStatusBarTranslucent(Window window) {
        if (window != null) {
            setStatusBarColor(window, window.getStatusBarColor(), true);
        }
    }

    @JvmStatic
    public static final boolean isTranslucent(Window window) {
        return window != null && Color.alpha(window.getStatusBarColor()) < 255;
    }

    @JvmStatic
    public static final void clearStatusBarTranslucency(Window window) {
        if (window != null) {
            setStatusBarColor(window, window.getStatusBarColor(), false);
        }
    }

    @JvmStatic
    public static final void setStatusBarColor(Window window, int color, boolean translucent) {
        int iArgb = Color.argb((int) Math.ceil(((translucent && Color.alpha(color) == 255) ? 0.65f : r0 / 255.0f) * 255), Color.red(color), Color.green(color), Color.blue(color));
        if (window == null) {
            return;
        }
        window.setStatusBarColor(iArgb);
    }

    @JvmStatic
    public static final void hideStatusBar(Window window, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (window != null) {
            WindowCompat.setDecorFitsSystemWindows(window, false);
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, view);
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.statusBars());
            windowInsetsControllerCompat.setSystemBarsBehavior(2);
        }
    }

    @JvmStatic
    public static final void showStatusBar(Window window, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (window != null) {
            WindowCompat.setDecorFitsSystemWindows(window, true);
            new WindowInsetsControllerCompat(window, view).show(WindowInsetsCompat.Type.statusBars());
        }
    }

    @JvmStatic
    public static final void setNavigationBarBackgroundColor(Window window, int color, boolean lightColor) {
        if (window != null) {
            if (navigationBarDefaultColor == -1) {
                navigationBarDefaultColor = window.getNavigationBarColor();
            }
            new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightNavigationBars(lightColor);
            window.setNavigationBarColor(color);
        }
    }
}
